package GUI;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class MainFrame extends JFrame {

   private JButton[] Lock_num;
   private JPanel[] Lock_card;
   private JPanel contentPane, Lockpanel;
   private JButton BackButton, NextButton, SearchButton;
   private CardLayout cards;

   // main 함수
   public static void main(String[] args) {
      MainFrame frame = new MainFrame();
   }

   /**
    * Create the frame.
    */
   public MainFrame() {

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
      mainpanel.setBackground(Color.white);
      // back button
      BackButton = new JButton(new ImageIcon("img/back.png"));
      BackButton.setBounds(0, 124, 97, 130);
      BackButton.setContentAreaFilled(false);
      mainpanel.add(BackButton);

      // next button
      NextButton = new JButton(new ImageIcon("img/next.png"));
      NextButton.setBounds(800, 124, 97, 130);
      mainpanel.add(NextButton);
      NextButton.setContentAreaFilled(false);
      // Lockpanel (카드 레이아웃)

      cards = new CardLayout();
      Lockpanel = new JPanel();
      Lockpanel.setLayout(cards);
      Lockpanel.setBounds(109, 30, 679, 357);

      // 사물함 구역 별로 Lockpanel 카드 갯수
      for (int i = 0; i < 10; i++) {
         Lock_card[i] = new JPanel();
         Lock_card[i].setLayout(new GridLayout(3, 3));
         Lockpanel.add(Lock_card[i]);
      }

      mainpanel.add(Lockpanel);

      // 버튼 3x3생성
      Lock_num = new JButton[9];
      for (int i = 0; i < Lock_card.length; i++) {
         for (int j = 0; j < 9; j++) {
            Lock_num[j] = new JButton("" + (j + 1));

            Lock_num[j].setContentAreaFilled(false);
            Lock_num[j].setOpaque(false);
            Lock_card[i].add(Lock_num[j]);
         }

      }

      // 검색버튼
      SearchButton = new JButton(new ImageIcon("img/magnifier.png"));
      getContentPane().add(SearchButton);
      setVisible(true);

      SearchButton.setBorderPainted(false);
      SearchButton.setContentAreaFilled(false);

      // search 버튼 action listener

      SearchButton.setBounds(108, 471, 127, 131);
      contentPane.add(SearchButton);

      // Mini Map 붙일 패널
      JPanel Map_panel = new JPanel();
      Map_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
      Map_panel.setBounds(314, 436, 478, 166);
      contentPane.add(Map_panel);
      setVisible(true);
      
      BackButton.addActionListener(new MyActionListener());
      NextButton.addActionListener(new MyActionListener());
      SearchButton.addActionListener(new MyActionListener());
   }
   public void addListener() {
      /*
       * for (int i = 0; i < 10; i++) for (int j = 0; j < 9; j++) {
       * Lock_num[j].addMouseListener(addMouseListener()); }
       */
   }
   class MyActionListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         JButton temp = (JButton)e.getSource();
         if (temp == NextButton)
            goNextCard();     
         else if (temp == BackButton) 
            goBackCard();
         else if (temp == SearchButton) {
           
         }
      }
   }
   
   public void goNextCard() {
      cards.next(Lockpanel);
   
   }
   
   public void goBackCard() {
      cards.previous(Lockpanel);
   }
}