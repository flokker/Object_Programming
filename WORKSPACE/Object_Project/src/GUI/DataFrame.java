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
	
	// ������ư ����
	JRadioButton normalApply;
	JRadioButton periodApply;
			
	protected DataFrame() {		
		setTitle("InputForm Frame");
		setSize(400,500);	

		setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		//LabelPanel ���� ����ִ� �ǳ�
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(6,1,0,25));

		JLabel lockLabel = new JLabel("�繰�� ��ȣ");
		lockLabel.setHorizontalAlignment(JLabel.RIGHT);
		JLabel idLabel = new JLabel("�й�");
		idLabel.setHorizontalAlignment(JLabel.RIGHT);
		JLabel nameLabel = new JLabel("�̸�");
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		JLabel phoneLabel = new JLabel("�ڵ��� ��ȣ");
		phoneLabel.setHorizontalAlignment(JLabel.RIGHT);
		JLabel applyLabel = new JLabel("����");
		applyLabel.setHorizontalAlignment(JLabel.RIGHT);
		JLabel periodLabel = new JLabel("�Ⱓ");
		periodLabel.setHorizontalAlignment(JLabel.RIGHT);	
		
		//formPanel �ؽ�Ʈ�ʵ�, ������ư�� ����ִ� �ǳ�
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(6,1,0,6));
      
		//RadioPanel ������ư�� ����ִ� �ǳ�
		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new FlowLayout());
		normalApply = new JRadioButton("�Ϲݽ�û",true);
		normalApply.addItemListener(new DataFrm_ItemListener());
		periodApply = new JRadioButton("�Ⱓ��û");
		periodApply.addItemListener(new DataFrm_ItemListener());
        ButtonGroup buttonGrp = new ButtonGroup();
        buttonGrp.add(normalApply);
        buttonGrp.add(periodApply);
        
		//BtnPanel ��ư�� ����ִ� �ǳ�
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER,100,100));
		
		doneBtn = new JButton("�Ϸ�");
		doneBtn.addActionListener(new DataFrm_ActionListener());
		closeBtn = new JButton("����");
		closeBtn.addActionListener(new DataFrm_ActionListener());
		
		//�� �ǳڰ� ������Ʈ�� �߰�
		labelPanel.add(lockLabel);
		labelPanel.add(idLabel);
		labelPanel.add(nameLabel);
		labelPanel.add(phoneLabel);
		labelPanel.add(applyLabel);
		labelPanel.add(periodLabel);
		
		radioPanel.add(normalApply);
		radioPanel.add(periodApply);

		// �繰�� ��ȣ �ڵ� �Է� �κ� ���� �ʿ�
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
		
		//setUndecorated(true);		// Ÿ��Ʋ �� ���ִ� �Լ�
		setLocationRelativeTo(null); // ���α׷� ȭ�� �߾ӿ��� ����
		setVisible(true);
	}

	private class DataFrm_ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if (btn.getText().equals("�Ϸ�")) {
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
				if ( sel.getText().equals("�Ϲݽ�û") ) {
					periodText.setText(Integer.toString(semesterValue));
				}
				else {
					periodText.setText( "�Ⱓ�� �Է��ϼ���." );
				}
			}
		}		
	}
}