package GUI;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import Operation.MainApplication;
import Operation.data_set;

/** A class that lets the user fill out personal information to apply locker.
* 
* <br>
* The class contains forms which is Name, ID, Phone Number, Period.
* All of component should be filled out by each format.
* If the user select next button, list that user filled out will be written in excel DB.
*
* @author Myungho Bae
* @version 1.5
**/
public class DataFrame extends JFrame {
	
	/** Stored end of term as integer variable **/
	static int semesterValue = 171219;
	
	String[] labelText = {"사물함 번호", "이름", "학번", "핸드폰 번호", "기간"};
	String Locker;
	String Name;
	String ID;
	String PhoneNumber;
	String Period;
	
	
	JFrame frame;	
	JButton doneBtn;
	JButton closeBtn;
	JLabel[] Label = new JLabel[5];	
	JTextField[] Text = new JTextField[5];
		
	public DataFrame() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 550, 600);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.setUndecorated(true);		// 타이틀 바 없애는 함수
		frame.setLocationRelativeTo(null); // 프로그램 화면 중앙에서 실행
		
		// 상단 텍스트 라벨 판넬
		JPanel full_Panel = new JPanel();
		full_Panel.setBackground(Color.BLACK);
		full_Panel.setBounds(0, 0, 534, 561);
		frame.getContentPane().add(full_Panel);
		full_Panel.setLayout(null);
		
		JPanel info_Panel = new JPanel();
		info_Panel.setBackground(Color.BLACK);
		info_Panel.setBounds(12, 10, 510, 90);
		full_Panel.add(info_Panel);
		info_Panel.setLayout(null);
		
		JLabel info1_Label = new JLabel("사물함 신청하기");
		info1_Label.setBounds(12, 10, 293, 47);
		info_Panel.add(info1_Label);
		info1_Label.setForeground(Color.LIGHT_GRAY);
		info1_Label.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 40));
		
		JLabel info2_Label = new JLabel("아래의 빈칸을 모두 채우면 사물함을 사용할 수 있습니다!");
		info2_Label.setBounds(12, 58, 465, 22);
		info_Panel.add(info2_Label);
		info2_Label.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 18));
		info2_Label.setForeground(Color.LIGHT_GRAY);
		
		//LabelPanel 라벨이 들어있는 판넬
		JPanel form_Panel = new JPanel();
		form_Panel.setBackground(Color.BLACK);
		form_Panel.setBounds(23, 125, 488, 338);
		full_Panel.add(form_Panel);
		form_Panel.setLayout(new GridLayout(10, 1, 0, 0));
		
		
		for(int i=0; i<5; i++) {
			Label[i] = new JLabel(labelText[i]);
			Label[i].setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
			Label[i].setForeground(Color.WHITE);
			
			Text[i] = new JTextField(10);
										
			form_Panel.add(Label[i]);
			form_Panel.add(Text[i]);
		}
		Text[0].setEditable(false);
		Text[0].setText(Locker);
	

		//BtnPanel 버튼이 들어있는 판넬
		ButtonStyle buttonstyle = new ButtonStyle();
		JPanel btn_Panel = new JPanel();
		btn_Panel.setBackground(Color.BLACK);
		btn_Panel.setBounds(12, 480, 510, 78);
		full_Panel.add(btn_Panel);
		
		doneBtn = new JButton(new ImageIcon("./Img/dataFrame_Done.png"));
		doneBtn.setBackground(Color.BLACK);
		doneBtn.setOpaque(true);
		doneBtn.addActionListener(new DataFrm_ActionListener());
		buttonstyle.deleteButtonFormat(doneBtn);
		btn_Panel.add(doneBtn);
		
		closeBtn = new JButton(new ImageIcon("./Img/dataFrame_Close.png"));
		closeBtn.setBackground(Color.BLACK);
		closeBtn.setOpaque(true);
		closeBtn.addActionListener(new DataFrm_ActionListener());
		buttonstyle.deleteButtonFormat(closeBtn);
		btn_Panel.add(closeBtn);
		
		frame.setVisible(true);
	}

	private class DataFrm_ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(doneBtn)) {
				ID = Text[1].getText();
				Name = Text[2].getText();
				PhoneNumber = Text[3].getText();
				Period = Text[4].getText();
				data_set ds = new data_set(Locker,ID,Name,PhoneNumber,Period);
				MainApplication MA = new MainApplication();
				MA.excelWriting(ds);
				frame.dispose();
			}
			else {
				frame.dispose();
			}
		}		
	}
}