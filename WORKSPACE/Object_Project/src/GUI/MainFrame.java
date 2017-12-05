package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
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

	int userNumber; // userNumber에 유저가 선택한 사물함이 몇인용인지 저장
	
	ButtonStyle btnStyle = new ButtonStyle();

	private JButton[] Lock_num1,Lock_num2;
	private JPanel[] Lock_card;
	private JPanel Lockpanel;
	private MainBackgroundPanel fullPanel;
	private JButton BackButton, NextButton, SearchButton, InformationButton;
	private CardLayout cards;
	JScrollPane scrollPane;
	ImageIcon icon;

	/**
	 * this method from Mainframe
	 * 
	 */
	protected MainFrame() {

		Lock_card = new JPanel[2];

		setTitle("Main Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 913, 693);
		fullPanel = new MainBackgroundPanel();
		fullPanel.setLayout(null);
		setContentPane(fullPanel);

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
			Lock_num1[j] = new JButton(new ImageIcon("./Img/forone.png"));
			Lock_num1[j].addActionListener(new MyActionListener());
			Lock_num1[j].setContentAreaFilled(false);
			Lock_num1[j].setOpaque(false);
			Lock_card[1].add(Lock_num1[j]);
		}

		Lock_num2 = new JButton[12]; // 버튼 3x4생성

		for (int j = 0; j < 12; j++) {
			Lock_num2[j] = new JButton(new ImageIcon("./Img/fortwo.png"));
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
		setVisible(true);

		// back button
		BackButton = new JButton(new ImageIcon("./Img/prev.png"));
		BackButton.setBounds(0, 124, 97, 178);
		mainpanel.add(BackButton);
		btnStyle.deleteButtonFormat(BackButton);

		// next button
		NextButton = new JButton(new ImageIcon("./Img/next.png"));
		NextButton.setBounds(800, 124, 97, 178);
		mainpanel.add(NextButton);

		btnStyle.deleteButtonFormat(NextButton);

		// 인포메이션 버튼
		InformationButton = new JButton(new ImageIcon("./Img/information.png"));
		getContentPane().add(InformationButton);
		setVisible(true);
		btnStyle.deleteButtonFormat(InformationButton);
		InformationButton.setBounds(0, 471, 127, 131);

		// 검색버튼
		SearchButton = new JButton(new ImageIcon("./Img/Search.png"));
		getContentPane().add(SearchButton);
		setVisible(true);
		btnStyle.deleteButtonFormat(SearchButton);

		// search 버튼 action listener

		SearchButton.setBounds(80, 471, 127, 131);
		fullPanel.add(SearchButton);

		fullPanel.addKeyListener(new KeyHandler());

		BackButton.addActionListener(new MyActionListener());
		NextButton.addActionListener(new MyActionListener());
		SearchButton.addActionListener(new MyActionListener());
		InformationButton.addActionListener(new MyActionListener());
	}

	/**
	 * This class implements for ActionListener, if click conditional button then
	 * events for that button occur
	 * 
	 * @param ActionEvent
	 * 
	 * @return void
	 **/
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton temp = (JButton) e.getSource();
			if (temp == NextButton)
				goNextCard();

			else if (temp == BackButton)
				goBackCard();
			else if (temp == SearchButton) {
				SearchFrame frame = new SearchFrame();
			} else if (temp == InformationButton) {
				Information Info = new Information();
			} else {
				DataFrame daframe = new DataFrame(userNumber); 
			}
		}
	}

	/**
	 * This method acts as function to the next card in Cardlayout
	 * 
	 * @param void
	 * @return void
	 **/
	public void goNextCard() {
		cards.next(Lockpanel);
		
		// userNumber = 0/1;   
	}

	/**
	 * This method acts as function to the previous card in Cardlayout
	 * 
	 * @param void
	 * @return void
	 **/
	public void goBackCard() {
		cards.previous(Lockpanel);
	}
}

class MainBackgroundPanel extends JPanel {

	Image image;

	MainBackgroundPanel() {
		image = new ImageIcon("./Img/학교 배경.png").getImage();
	}

	/**
	 * Painting a background image on panel to override
	 * javax.swing.JComponent.paint.
	 * 
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