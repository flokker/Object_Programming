package GUI;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import Operation.ExcelManager;
import Operation.data_set;
import GUI.ButtonStyle;

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
		
	String[] labelText = {"�繰�� ��ȣ", "�й�", "�̸�", "�ڵ��� ��ȣ", "�Ⱓ"};
	static final String SemesterPeriod = "171219";
	int userNumber;
	int lockerNumber;
	int rowid;
	
	CardLayout cards = new CardLayout();
	JPanel card_Panel;
	JButton doneBtn;
	JButton closeBtn;
	JButton nextBtn;
	JButton deleteBtn;
	JLabel[] Label = new JLabel[5];	
	JTextField[][] Text = new JTextField[2][5];
		
	public DataFrame(int[] value) {
		ExcelManager EM = new ExcelManager();
		this.userNumber = value[0];
		this.lockerNumber = value[1];
		this.rowid = EM.getRowID(lockerNumber);
		
		
		setAlwaysOnTop(true);
		setBounds(100, 100, 530, 611);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);	
		// ��� �ؽ�Ʈ �� �ǳ�
		JPanel full_Panel = new JPanel();
		full_Panel.setBackground(Color.BLACK);
		full_Panel.setBounds(0, 0, 534, 611);
		getContentPane().add(full_Panel);
		full_Panel.setLayout(null);
		
		JPanel info_Panel = new JPanel();
		info_Panel.setBackground(Color.BLACK);
		info_Panel.setBounds(12, 10, 510, 90);
		full_Panel.add(info_Panel);
		info_Panel.setLayout(null);
		
		JLabel info1_Label = new JLabel("�繰�� ��û�ϱ�");
		info1_Label.setBounds(12, 10, 293, 47);
		info_Panel.add(info1_Label);
		info1_Label.setForeground(Color.LIGHT_GRAY);
		info1_Label.setFont(new Font("������� ExtraBold", Font.PLAIN, 40));
		
		JLabel info2_Label = new JLabel("�Ʒ��� ��ĭ�� ��� ä��� �繰���� ����� �� �ֽ��ϴ�!");
		info2_Label.setBounds(12, 58, 500, 22);
		info_Panel.add(info2_Label);
		info2_Label.setFont(new Font("������� ExtraBold", Font.BOLD, 18));
		info2_Label.setForeground(Color.LIGHT_GRAY);
		
		//LabelPanel ���� ����ִ� �ǳ�
			// CardLayout Main Panel
		card_Panel = new JPanel();
		card_Panel.setBackground(Color.BLACK);
		card_Panel.setBounds(23, 125, 488, 338);
		full_Panel.add(card_Panel);
		card_Panel.setLayout(cards);
		
		JPanel[] form_Panel = new JPanel[2];
		for(int j=0; j<2; j++) {
			form_Panel[j] = new JPanel();
			form_Panel[j].setBackground(Color.BLACK);
			form_Panel[j].setBounds(23, 125, 488, 338);
			card_Panel.add(form_Panel[j]);
			form_Panel[j].setLayout(new GridLayout(10, 1, 0, 0));
			
			for(int i=0; i<5; i++) {
				Label[i] = new JLabel(labelText[i]);
				Label[i].setFont(new Font("������� ExtraBold", Font.PLAIN, 18));
				Label[i].setForeground(Color.WHITE);
				
				Text[j][i] = new JTextField(10);
											
				form_Panel[j].add(Label[i]);
				form_Panel[j].add(Text[j][i]);
			}	
			Text[j][0].setEditable(false);
			Text[j][0].setText(Integer.toString(this.lockerNumber));
			Text[j][4].setText(SemesterPeriod);
		}
		

		
		//BtnPanel ��ư�� ����ִ� �ǳ�
		ButtonStyle buttonstyle = new ButtonStyle();
		JPanel btn_Panel = new JPanel();
		btn_Panel.setBackground(Color.BLACK);
		btn_Panel.setBounds(12, 523, 510, 78);
		full_Panel.add(btn_Panel);
		
		doneBtn = new JButton(new ImageIcon("./Img/dataFrame_Done.png"));
		doneBtn.addActionListener(new DataFrm_ActionListener());
		buttonstyle.deleteButtonFormat(doneBtn);
		btn_Panel.add(doneBtn);
		
		closeBtn = new JButton(new ImageIcon("./Img/dataFrame_Close.png"));
		closeBtn.addActionListener(new DataFrm_ActionListener());
		buttonstyle.deleteButtonFormat(closeBtn);
		btn_Panel.add(closeBtn);

		deleteBtn = new JButton(new ImageIcon("./Img/dataFrame_Delete.png"));
		deleteBtn.setBounds(344, 473, 80, 40);
		deleteBtn.addActionListener(new DataFrm_ActionListener());
		buttonstyle.deleteButtonFormat(deleteBtn);
		full_Panel.add(deleteBtn);
		
		nextBtn = new JButton(new ImageIcon("./Img/dataFrame_Next.png"));
		nextBtn.setBounds(421, 473, 80, 40);
		nextBtn.addActionListener(new DataFrm_ActionListener());
		buttonstyle.deleteButtonFormat(nextBtn);
		if(this.userNumber == 1)
			full_Panel.add(nextBtn);

		setVisible(true);
	}

	private class DataFrm_ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(doneBtn)) {		
				int temp = -1;
				ExcelManager MA = new ExcelManager();	
				data_set[] userInfo = new data_set[2];
				for(int i=0; i<2; i++) {
					if((i == 0 && userNumber >= 0) || (i == 1 && userNumber == 1)) {					
						userInfo[i] = new data_set(Text[i][0].getText(),
													Text[i][1].getText(),
													Text[i][2].getText(),
													Text[i][3].getText(),
													Text[i][4].getText());
						
						if(CheckFormat(userInfo[i]) == false)
						{
							System.out.println(i);
							JOptionPane.showConfirmDialog(getContentPane(), "�Է� ������ �߸��Ǿ����ϴ�.  �ٽ� �ѹ� Ȯ�����ּ���.", "�Է� ����",
									JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, null);							
							break;
						}
						else
							temp ++;
					}
				}
				if(temp == userNumber) {
					MA.excelWriting(userInfo[0],0);
					if(userNumber == 1)
						MA.excelWriting(userInfo[1],1);
					dispose();							
				}				
			}
			
			else if(e.getSource().equals(closeBtn)) {
				dispose();
			}
			
			else if(e.getSource().equals(nextBtn)) {
				cards.next(card_Panel);
			}
			
			else if(e.getSource().equals(deleteBtn)) {
				int result = JOptionPane.showConfirmDialog(getContentPane(), "�� �繰���� ������ �����Ͻðڽ��ϱ�?", "�繰�� ���� ����", 
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					ExcelManager MA = new ExcelManager();	
					data_set[] userInfo = new data_set[2];	
					for(int i=0; i<2; i++) {				
						userInfo[i] = new data_set(Integer.toString(lockerNumber),"���� ��","���� ��","���� ��","���� ��");	
						MA.excelWriting(userInfo[i], i);
					}
					dispose();
				}
			}
			
		}		
	}
	// �繰�Թ�ȣ, �̸�, �й�, �ڵ�����ȣ, ����
	private boolean CheckFormat(data_set ds) {
		boolean result = true;
		if(ds.getCustName().length() < 2 || ds.getCustName().length() > 6)
			result = false; // �̸� 2~6��

		if(ds.getCustId().length() < 5 || ds.getCustName().length() > 7)
			result = false; // �й� 5~7��
		
		if(ds.getCustNum().length() < 10 || ds.getCustName().length() > 11)
			result = false;	 // ���� 10~11�ڸ�

		if(ds.getCustPeriod().length() != 6)
			result = false; // �Ⱓ 6�ڸ�
		return result;
	}
}