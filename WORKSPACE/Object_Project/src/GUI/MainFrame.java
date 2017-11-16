package GUI;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

/**
 * GUI환경에서 메인 프레임 역할을 하게 될 프레임
 * history : June hyuk, 1.0 2017.11.14 초기 작성
 * @author June hyuk
 * @since 2017.11.14 
 * @version 1.0 
 */


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

/**
 * GUI환경에서 메인 프레임 역할을 하게 될 프레임
 * history : June hyuk, 1.0 2017.11.14 초기 작성
 * @author June hyuk
 * @since 2017.11.14 
 * @version 1.0 
 */


public class MainFrame extends JFrame {

	private JButton[] Lock_num;
	private JPanel[] Lock_card;
	private JPanel contentPane, Lockpanel;
	private JButton BackButton, NextButton, SearchButton;
	private CardLayout cards;
	JScrollPane scrollPane;
	ImageIcon icon;

	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
	}

	/**
	 * 메인프레임에 대한 메소드
	 * 
	 */
	protected MainFrame() {

		
		Lock_card = new JPanel[10];

		setTitle("Main Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 913, 693);
		contentPane = new JPanel();
		contentPane.setLayout(null);		
		setContentPane(contentPane);		
		contentPane.setBackground(Color.white);

		// MainPanel
		JPanel mainpanel = new JPanel();
		mainpanel.setBounds(0, 10, 897, 416);
		contentPane.add(mainpanel);
		mainpanel.setLayout(null);	
		mainpanel.setBackground(Color.black);
		
		// Lockpanel (카드 레이아웃)

		cards = new CardLayout();
		Lockpanel = new JPanel();
		Lockpanel.setLayout(cards);
		Lockpanel.setBounds(250, 50, 400, 300);

		// 사물함 구역 별로 Lockpanel 카드 갯수
		for (int i = 0; i < 10; i++) {
			Lock_card[i] = new JPanel();
			Lock_card[i].setLayout(new GridLayout(3, 3));
			Lockpanel.add(Lock_card[i]);
		}

		mainpanel.add(Lockpanel);
		
		// Mini Map 붙일 패널
		Mini_Map Map_panel = new Mini_Map();
		Map_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		Map_panel.setBounds(314, 436, 478, 166);
		contentPane.add(Map_panel);
		setVisible(true);
		
		// back button
		BackButton = new JButton(new ImageIcon("./Img/back.png"));
		BackButton.setBounds(0, 124, 97, 130);
		mainpanel.add(BackButton);
		BackButton.setBorderPainted(false);
		BackButton.setContentAreaFilled(false);
		

		// next button
		NextButton = new JButton(new ImageIcon("./Img/next.png"));
		NextButton.setBounds(800, 124, 97, 130);
		mainpanel.add(NextButton);

		NextButton.setBorderPainted(false);
		NextButton.setContentAreaFilled(false);
		// 버튼 3x3생성
		Lock_num = new JButton[9];
		for (int i = 0; i < Lock_card.length; i++) {
			for (int j = 0; j < 9; j++) {
				Lock_num[j] = new JButton(new ImageIcon("./Img/locker.png"));
				Lock_num[j].addActionListener(new MyActionListener());
				Lock_num[j].setContentAreaFilled(false);
				Lock_num[j].setOpaque(false);
				Lock_card[i].add(Lock_num[j]);
			}

		}

		// 검색버튼
		SearchButton = new JButton(new ImageIcon("./Img/Search.png"));
		getContentPane().add(SearchButton);
		setVisible(true);

		SearchButton.setBorderPainted(false);
		SearchButton.setContentAreaFilled(false);

		// search 버튼 action listener

		SearchButton.setBounds(108, 471, 127, 131);
		contentPane.add(SearchButton);
		contentPane.addKeyListener(new KeyHandler());
		
		
		BackButton.addActionListener(new MyActionListener());
		NextButton.addActionListener(new MyActionListener());
		SearchButton.addActionListener(new MyActionListener());
	}
	
	/** 
	* 액션리스너를 구현하기 위한 클래스, 조건에 맞는 버튼을 클릭시 그에 맞는 처리를 한다.
	* @param ActionEvent e
	* @return void
	**/		
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton temp = (JButton)e.getSource();
			if (temp == NextButton) 
				goNextCard();
			
			else if (temp == BackButton) 
				goBackCard();
			else if (temp == SearchButton) {
				SearchFrame frame = new SearchFrame();
		}
			else {
				DataFrame daframe = new DataFrame();
			}
		}
	}
	
	/** 
	* 카드레이아웃 환경에서 다음 카드로 전환하기 위한 메소드
	* @param void
	* @return void
	**/		
	public void goNextCard() {
		cards.next(Lockpanel);
	
	}

	/** 
	* 카드레이아웃 환경에서 전의 카드로 전환하기 위한 메소드
	* @param void
	* @return void
	**/	
	public void goBackCard() {
		cards.previous(Lockpanel);
	}
}