package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.border.LineBorder;

import GUI.MainBackgroundPanel;

/**
 * This class acts as MainFrame in this program with GUI in this class, all
 * panels and buttons are implemented in this class <br>
 * history : June hyeock, 1.0 2017.11.14 initiate version <br>
 * 
 * @author June hyeock
 * @since 2017.11.14
 * @version 1.0
 */

public class MainFrame extends JFrame {

	static int[] lockerInfo = new int[2]; // userNumber에 유저가 선택한 사물함이 몇인용인지 저장

	ButtonStyle btnStyle = new ButtonStyle();
	LockState State = new LockState();
	static Mini_Map Map_panel;
	protected JButton[] Lock_num1, Lock_num2;
	private JPanel[] Lock_card;
	private static JPanel Lockpanel;
	private MainBackgroundPanel fullPanel;
	private JButton BackButton, NextButton, UpButton, DownButton, SearchButton, InformationButton;
	private static CardLayout cards;
	public static boolean divide;
	ImageIcon icon;

	DataFrame daframe;
	SearchFrame searchFrame;
	Information infoFrame;

	private static Point p;
	/**
	 * this is method of MainFrame that detail implemented. <br>
	 * it has many button and panel, if you click each button, different events
	 * occur in program <br>
	 * 
	 * @author june hyeock
	 * @param void
	 */
	
	protected MainFrame() {

		searchFrame = new SearchFrame();
		infoFrame = new Information();
		Lock_card = new JPanel[2];
		
		setTitle("Lock N Roll");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 913, 693);
		fullPanel = new MainBackgroundPanel();
		fullPanel.setLayout(null);
		setContentPane(fullPanel);
		setResizable(false);

		// MainPanel
		JPanel mainpanel = new JPanel();
		mainpanel.setBounds(0, 10, 897, 416);
		fullPanel.add(mainpanel);
		mainpanel.setLayout(null);
		mainpanel.setOpaque(false);

		// Lockpanel (카드 레이아웃)
		cards = new CardLayout();
		Lockpanel = new JPanel();
		Lockpanel.setLayout(cards);
		Lockpanel.setBounds(250, 20, 400, 400);

		for (int i = 0; i < 2; i++) {
			Lock_card[i] = new JPanel();
		}
		Lock_card[0].setLayout(new GridLayout(3, 4));
		Lockpanel.add(Lock_card[0]);

		Lock_card[1].setLayout(new GridLayout(4, 4));
		Lockpanel.add(Lock_card[1]);
		mainpanel.add(Lockpanel);

		// 버튼 4x4생성
		Lock_num1 = new JButton[16];
		Point p = new Point();
		for (int j = 0; j < 16; j++) {
			URL imgforone = getClass().getClassLoader().getResource("forone.png");
			Lock_num1[j] = new JButton(new ImageIcon(imgforone));
			Lock_num1[j].addActionListener(new MyActionListener());
			Lock_num1[j].setContentAreaFilled(false);
			Lock_num1[j].setOpaque(false);
			Lock_card[1].add(Lock_num1[j]);

		}

		Lock_num2 = new JButton[12]; // 버튼 3x4생성
		for (int j = 0; j < 12; j++) {
			URL imgfortwo = getClass().getClassLoader().getResource("fortwo.png");
			Lock_num2[j] = new JButton(new ImageIcon(imgfortwo));
			Lock_num2[j].addActionListener(new MyActionListener());
			Lock_num2[j].setContentAreaFilled(false);
			Lock_num2[j].setOpaque(false);
			Lock_card[0].add(Lock_num2[j]);

		}
		State.drawButtonBorder(Lock_num2);
		State.drawButtonBorder(Lock_num1);
		
		// Mini Map 붙일 패널
		Map_panel = new Mini_Map(Lock_num1,Lock_num2);
		Map_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		Map_panel.setBounds(217, 436, 478, 166);
		fullPanel.add(Map_panel);

		// back button
		URL imgprev = getClass().getClassLoader().getResource("prev.png");
		BackButton = new JButton(new ImageIcon(imgprev));
		BackButton.setBounds(0, 124, 97, 178);
		mainpanel.add(BackButton);
		btnStyle.deleteButtonFormat(BackButton);

		// next button
		URL imgnext = getClass().getClassLoader().getResource("next.png");
		NextButton = new JButton(new ImageIcon(imgnext));
		NextButton.setBounds(800, 124, 97, 178);
		mainpanel.add(NextButton);
		btnStyle.deleteButtonFormat(NextButton);

		URL imgup = getClass().getClassLoader().getResource("upPoint.png");
		UpButton = new JButton(new ImageIcon(imgup));
		UpButton.setBounds(700, 440, 50, 50);
		btnStyle.deleteButtonFormat(UpButton);
		fullPanel.add(UpButton);
		
		URL imgdown = getClass().getClassLoader().getResource("downPoint.png");
		DownButton = new JButton(new ImageIcon(imgdown));
		DownButton.setBounds(700, 550, 50, 50);
		btnStyle.deleteButtonFormat(DownButton);
		fullPanel.add(DownButton);
		

		// 인포메이션 버튼
		URL imginfobtn = getClass().getClassLoader().getResource("information.png");
		InformationButton = new JButton(new ImageIcon(imginfobtn));
		getContentPane().add(InformationButton);
		btnStyle.deleteButtonFormat(InformationButton);
		InformationButton.setBounds(0, 471, 127, 131);

		// 검색버튼
		URL imgSearchBtn = getClass().getClassLoader().getResource("Search.png");
		SearchButton = new JButton(new ImageIcon(imgSearchBtn));
		getContentPane().add(SearchButton);
		btnStyle.deleteButtonFormat(SearchButton);

		// search 버튼 action listener
		SearchButton.setBounds(80, 471, 127, 131);
		fullPanel.add(SearchButton);
//		fullPanel.addKeyListener(new KeyHandler());
		UpButton.addActionListener(new MyActionListener());
		DownButton.addActionListener(new MyActionListener());
		BackButton.addActionListener(new MyActionListener());
		NextButton.addActionListener(new MyActionListener());
		SearchButton.addActionListener(new MyActionListener());
		InformationButton.addActionListener(new MyActionListener());		
		
		// 버튼 테두리 그리기
		setVisible(true);
	}
	

	
	/**
	 * This class implements for ActionListener, if click conditional button then
	 * events for that button occur <br>
	 * 
	 * @param ActionEvent
	 * @return void
	 * @author june hyeock
	 **/
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {	
			JButton temp = (JButton) e.getSource();
			if (temp == NextButton) {
				goNextCard();
				if (Current.current < 0) {
					Current.current = (Math.abs(Current.current) + 1) * -1;
					if (Current.current < -5)
						Current.current = 1;
				} else if (Current.current > 0) {
					Current.current = Current.current + 1;
					if (Current.current > 5)
						Current.current = -1;
				}				
				if(!divide)
					State.drawButtonBorder(Lock_num2);
				else
					State.drawButtonBorder(Lock_num1);
			}

			else if (temp == BackButton) {
				goBackCard();
				if (Current.current < 0) {
					Current.current = (Math.abs(Current.current) - 1) * -1;
					if (Current.current > -1)
						Current.current = 5;
				}
				else if (Current.current > 0) {
					Current.current = Current.current - 1;
					if (Current.current < 1)
						Current.current = -5;
				}				
				if(!divide)
					State.drawButtonBorder(Lock_num2);
				else
					State.drawButtonBorder(Lock_num1);				
			}
			
			else if(temp == UpButton) {
				if(Current.current < 0) {
					Current.current *= -1;
					Map_panel.floor = true;
					Map_panel.rePainting(Map_panel.floor);
				}
			}
			else if(temp == DownButton) {
				if(Current.current > 0) {
					Current.current *= -1;
					Map_panel.floor = false;
					Map_panel.rePainting(Map_panel.floor);
				}
			}
			else if (temp == SearchButton) {
				searchFrame.setVisible(true);
			}
		
			else if (temp == InformationButton) {
				infoFrame.setVisible(true);
			}

			else {
				int num = getLockerNumOfZero(Current.current);
				for (int i = 0; i < 16; i++) {
					if (temp == Lock_num1[i]) {
						lockerInfo[0] = 0;
						lockerInfo[1] = ((num + 1) / 2) * 12 + (num / 2) * 16 + 1 + i;
						break;
					}
				}
				for (int i = 0; i < 12; i++) {
					if (temp == Lock_num2[i]) {
						lockerInfo[0] = 1;
						lockerInfo[1] = ((num + 1) / 2) * 12 + (num / 2) * 16 + 1 + i;
						break;
					}
				}
				daframe = new DataFrame(lockerInfo);
				daframe.mf = getSelf();						
				daframe.setVisible(true);
			}
		}
	}
	
	public MainFrame getSelf() {
		return this;
	}

	/**
	 * Returns number of locker area that is ranged from -5~5 to 0~9.
	 * 
	 * @param int
	 *            areaNumber
	 * @return int
	 **/
	private int getLockerNumOfZero(int areaNumber) {
		int result = 0;
		if (areaNumber > 0) {
			result = areaNumber + 4;
		} else {
			result = (areaNumber * -1) - 1;
		}
		return result;
	}

	
	/**
	 * This method acts as function to the next card in Cardlayout 
	 * <br>
	 * @author june hyeock
	 */
	// -1 -2 -3 -4 -5 1 2 3 4 5
	public static void goNextCard() {
		cards.next(Lockpanel);
		divide = !divide;
	}
		
	/**
	 * This method acts as function to the previous card in Cardlayout <br>
	 * @author june hyeock
	 */
	public static void goBackCard() {
		cards.previous(Lockpanel);
		divide = !divide;		
	}
}

class MainBackgroundPanel extends JPanel {

	Image image;

	MainBackgroundPanel() {
		URL imgbackground = getClass().getClassLoader().getResource("학교 배경.png");
		image = new ImageIcon(imgbackground).getImage();
	}

	
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
}