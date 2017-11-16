package GUI;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

import GUI.MainBackgroundPanel;


/**
 * GUIȯ�濡�� ���� ������ ������ �ϰ� �� ������
 * history : June hyuk, 1.0 2017.11.14 �ʱ� �ۼ�
 * @author June hyuk
 * @since 2017.11.14 
 * @version 1.0 
 */


public class MainFrame extends JFrame {
	
	ButtonStyle btnStyle = new ButtonStyle();
	
	private JButton[] Lock_num;
	private JPanel[] Lock_card;
	private JPanel Lockpanel;
	private MainBackgroundPanel fullPanel;
	private JButton BackButton, NextButton, SearchButton;
	private CardLayout cards;
	JScrollPane scrollPane;
	ImageIcon icon;

	/**
	 * ���������ӿ� ���� �޼ҵ�
	 * 
	 */
	protected MainFrame() {

		
		Lock_card = new JPanel[10];

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
		
		// Lockpanel (ī�� ���̾ƿ�)
		cards = new CardLayout();
		Lockpanel = new JPanel();
		Lockpanel.setLayout(cards);
		Lockpanel.setBounds(250, 50, 400, 300);

		// �繰�� ���� ���� Lockpanel ī�� ����
		for (int i = 0; i < 10; i++) {
			Lock_card[i] = new JPanel();
			Lock_card[i].setLayout(new GridLayout(3, 3));
			Lockpanel.add(Lock_card[i]);
		}

		mainpanel.add(Lockpanel);
		
		// Mini Map ���� �г�
		Mini_Map Map_panel = new Mini_Map();
		Map_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		Map_panel.setBounds(217, 436, 478, 166);
		fullPanel.add(Map_panel);
		setVisible(true);
		
		// back button
		BackButton = new JButton(new ImageIcon("./Img/back.png"));
		BackButton.setBounds(0, 124, 97, 178);
		mainpanel.add(BackButton);
		btnStyle.deleteButtonFormat(BackButton);
		

		// next button
		NextButton = new JButton(new ImageIcon("./Img/next.png"));
		NextButton.setBounds(800, 124, 97, 178);
		mainpanel.add(NextButton);

		btnStyle.deleteButtonFormat(NextButton);
		// ��ư 3x3����
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

		// �˻���ư
		SearchButton = new JButton(new ImageIcon("./Img/Search.png"));
		getContentPane().add(SearchButton);
		setVisible(true);

		btnStyle.deleteButtonFormat(SearchButton);

		// search ��ư action listener

		SearchButton.setBounds(48, 471, 127, 131);
		fullPanel.add(SearchButton);
		fullPanel.addKeyListener(new KeyHandler());
		
		
		BackButton.addActionListener(new MyActionListener());
		NextButton.addActionListener(new MyActionListener());
		SearchButton.addActionListener(new MyActionListener());
	}
	
	/** 
	* �׼Ǹ����ʸ� �����ϱ� ���� Ŭ����, ���ǿ� �´� ��ư�� Ŭ���� �׿� �´� ó���� �Ѵ�.
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
	* ī�巹�̾ƿ� ȯ�濡�� ���� ī��� ��ȯ�ϱ� ���� �޼ҵ�
	* @param void
	* @return void
	**/		
	public void goNextCard() {
		cards.next(Lockpanel);
	
	}

	/** 
	* ī�巹�̾ƿ� ȯ�濡�� ���� ī��� ��ȯ�ϱ� ���� �޼ҵ�
	* @param void
	* @return void
	**/	
	public void goBackCard() {
		cards.previous(Lockpanel);
	}
}