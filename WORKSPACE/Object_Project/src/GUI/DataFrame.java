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
* @version 1.0
**/
public class DataFrame extends JFrame {
	
	/** Stored end of term as integer variable **/
	static int semesterValue = 171219;
	
	String Locker;
	String Name;
	String ID;
	String PhoneNumber;
	String Period;
	
	JButton doneBtn;
	JButton closeBtn;
	
	JTextField lockText = new JTextField(Locker,20);
	JTextField idText = new JTextField(20);
	JTextField nameText = new JTextField(20);
	JTextField phoneText = new JTextField(20);
	JTextField periodText = new JTextField(Integer.toString(semesterValue),20);
	
	// 라디오버튼 선언
	JRadioButton normalApply;
	JRadioButton periodApply;
			
	protected DataFrame() {		
		setTitle("InputForm Frame");
		setSize(400,500);	

		setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		//LabelPanel 라벨이 들어있는 판넬
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(6,1,0,25));

		JLabel lockLabel = new JLabel("사물함 번호");
		lockLabel.setHorizontalAlignment(JLabel.RIGHT);
		JLabel idLabel = new JLabel("학번");
		idLabel.setHorizontalAlignment(JLabel.RIGHT);
		JLabel nameLabel = new JLabel("이름");
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		JLabel phoneLabel = new JLabel("핸드폰 번호");
		phoneLabel.setHorizontalAlignment(JLabel.RIGHT);
		JLabel applyLabel = new JLabel("구분");
		applyLabel.setHorizontalAlignment(JLabel.RIGHT);
		JLabel periodLabel = new JLabel("기간");
		periodLabel.setHorizontalAlignment(JLabel.RIGHT);	
		
		//formPanel 텍스트필드, 라디오버튼이 들어있는 판넬
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(6,1,0,6));
      
		//RadioPanel 라디오버튼이 들어있는 판넬
		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new FlowLayout());
		normalApply = new JRadioButton("일반신청",true);
		normalApply.addItemListener(new DataFrm_ItemListener());
		periodApply = new JRadioButton("기간신청");
		periodApply.addItemListener(new DataFrm_ItemListener());
        ButtonGroup buttonGrp = new ButtonGroup();
        buttonGrp.add(normalApply);
        buttonGrp.add(periodApply);
        
		//BtnPanel 버튼이 들어있는 판넬
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER,100,100));
		
		doneBtn = new JButton("완료");
		doneBtn.addActionListener(new DataFrm_ActionListener());
		closeBtn = new JButton("종료");
		closeBtn.addActionListener(new DataFrm_ActionListener());
		
		//각 판넬과 컴포넌트들 추가
		labelPanel.add(lockLabel);
		labelPanel.add(idLabel);
		labelPanel.add(nameLabel);
		labelPanel.add(phoneLabel);
		labelPanel.add(applyLabel);
		labelPanel.add(periodLabel);
		
		radioPanel.add(normalApply);
		radioPanel.add(periodApply);

		// 사물함 번호 자동 입력 부분 수정 필요
		lockText.setText("00");
		lockText.setEnabled(false);
		formPanel.add(lockText);
		formPanel.add(idText);
		formPanel.add(nameText);
		formPanel.add(phoneText);		
		formPanel.add(radioPanel);		
		formPanel.add(periodText);
		
		btnPanel.add(doneBtn);
		btnPanel.add(closeBtn);
		
		add(labelPanel);
		add(formPanel);
		add(btnPanel);
		
		//setUndecorated(true);		// 타이틀 바 없애는 함수
		setLocationRelativeTo(null); // 프로그램 화면 중앙에서 실행
		setVisible(true);
	}

	private class DataFrm_ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if (btn.getText().equals("완료")) {
				ID = idText.getText();
				Name = nameText.getText();
				PhoneNumber = phoneText.getText();
				Period = periodText.getText();
				data_set ds = new data_set(Locker,ID,Name,PhoneNumber,Period);
				MainApplication MA = new MainApplication();
				MA.excelWriting(ds);
				dispose();
			}
			else {
				dispose();
			}
		}		
	}

	private class DataFrm_ItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			AbstractButton sel = (AbstractButton)e.getItemSelectable();
			if(e.getStateChange() == ItemEvent.SELECTED) {
				if ( sel.getText().equals("일반신청") ) {
					periodText.setText(Integer.toString(semesterValue));
				}
				else {
					periodText.setText( "기간을 입력하세요." );
				}
			}
		}		
	}
}