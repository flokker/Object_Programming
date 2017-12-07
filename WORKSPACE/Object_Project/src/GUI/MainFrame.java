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

	private JButton[] Lock_num1, Lock_num2;
	private JPanel[] Lock_card;
	private JPanel Lockpanel;
	private MainBackgroundPanel fullPanel;
	private JButton BackButton, NextButton, SearchButton, InformationButton;
	private CardLayout cards;
	JScrollPane scrollPane;
	ImageIcon icon;

	DataFrame daframe;
	SearchFrame searchFrame;
	Information infoFrame;

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
		// Mini Map 붙일 패널
		Mini_Map Map_panel = new Mini_Map();
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
		BackButton.addActionListener(new MyActionListener());
		NextButton.addActionListener(new MyActionListener());
		SearchButton.addActionListener(new MyActionListener());
		InformationButton.addActionListener(new MyActionListener());

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
			}

			else if (temp == BackButton) {
				goBackCard();
			}

			else if (temp == SearchButton) {
				searchFrame.setVisible(true);
			}

			else if (temp == InformationButton) {
				infoFrame.setVisible(true);
			}

			else {
				int num = getLockerNumOfZero(Current.current);
				System.out.println(getLockerNumOfZero(-1));
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
				daframe.setVisible(true);
			}
		}
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
	 * This method acts as function to the next card in Cardlayout <br>
	 * 
	 * @param void
	 * @return void
	 * @author june hyeock
	 **/
	public void goNextCard() {
		cards.next(Lockpanel);

		if (Current.current < 0) {
			Current.current = (Math.abs(Current.current) + 1) * -1;
			if (Current.current < -5)
				Current.current = 1;
		} else if (Current.current > 0) {
			Current.current = Current.current + 1;
			if (Current.current > 5)
				Current.current = -1;
		}
	}

	/**
	 * This method acts as function to the previous card in Cardlayout <br>
	 * 
	 * @param void
	 * @return void
	 * @author june hyeock
	 **/
	public void goBackCard() {
		cards.previous(Lockpanel);

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
	}
}

class MainBackgroundPanel extends JPanel {

	Image image;

	MainBackgroundPanel() {
		URL imgbackground = getClass().getClassLoader().getResource("학교 배경.png");
		image = new ImageIcon(imgbackground).getImage();
	}

	/**
	 * Painting a background image on panel to override
	 * javax.swing.JComponent.paint. <br>
	 * 
	 * @param void
	 * @return boolean
	 **/
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
}