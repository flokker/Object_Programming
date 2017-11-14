package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

import Operation.Search;
import Operation.data_set;

/** Class Description of SearchFrame.
* 
* <br>
* this class is Frame for inserting data to user want to find from Excel DB.
* it extends JFrame to show some component.
* class has 5 TextFields, 5 Comboboxs, 4 buttons.
*
* @author Myungho Bae
* @version 1.0
**/
public class SearchFrame extends JFrame {

	private JPanel pan_content = new JPanel();
	private JTextField[] Item_tf = new JTextField[5];
	private JComboBox[] Item_cb = new JComboBox[5];
	private JButton btn_add;
	private JButton btn_del;
	private JButton btn_next;
	private JButton btn_exit;	
	private int count = 0;
	private int[] comboCnt = new int[5];
	String Cust[] = new String[5];
	
	protected SearchFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		getContentPane().setLayout(null);

		addSearchPanel();
		
		pan_content.setBounds(5, 5, 424, 250);
		getContentPane().add(pan_content);
		pan_content.setLayout(null);
		
		JLabel lbl_Item = new JLabel("분류");
		lbl_Item.setBounds(75, 0, 30, 21);
		lbl_Item.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pan_content.add(lbl_Item);
		
		JLabel lbl_Word = new JLabel("내용");
		lbl_Word.setBounds(260, 0, 30, 21);
		lbl_Word.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pan_content.add(lbl_Word);
		
		btn_add = new JButton("조건 추가");
		btn_add.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn_add.setBounds(45, 60, 90, 23);
		btn_add.addActionListener(new MyActionListener());
		pan_content.add(btn_add);
		
		btn_del = new JButton("조건 삭제");
		btn_del.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn_del.setBounds(147, 61, 90, 23);
		btn_del.addActionListener(new MyActionListener());
		pan_content.add(btn_del);
	
		JPanel pan_prog = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pan_prog.getLayout();
		flowLayout.setHgap(120);
		pan_prog.setBounds(5, 265, 424, 39);
		getContentPane().add(pan_prog);
		
		JButton btn_next = new JButton("확인");
		btn_next.addActionListener(new MyActionListener());
		pan_prog.add(btn_next);
		
		JButton btn_exit = new JButton("종료");
		btn_exit.addActionListener(new MyActionListener());
		pan_prog.add(btn_exit);
		
		resetVariable();
		setVisible(true);
	}
	
	/** This method is for ActionListener.
	* when user click add, del, next, or exit button, it will occur some event.
	* 
	* <br>
	* 
	* @param ActionEvent e
	* @return void
	**/		
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			
			if(btn.getText() == "조건 추가") {
				if(count < 5) {
					btn_add.setBounds(45, 65+(35*count), 90, 23);
					btn_del.setBounds(147, 65+(35*count), 90, 23);
					addSearchPanel();
				}
			}
			else if(btn.getText() == "조건 삭제") {
				if(count > 1) {		
					delSearchPanel();
					btn_add.setBounds(45, 65+(35*(count-1)), 90, 23);
					btn_del.setBounds(147, 65+(35*(count-1)), 90, 23);	
				}
			}			
			else if(btn.getText() == "확인") {
				if(CheckError() == false) {
					for(int i=0; i<count; i++) {
						int index = Item_cb[i].getSelectedIndex();
						if(comboCnt[index] == 1) {
							Cust[index] = Item_tf[i].getText();
						}
					}

					data_set ds = new data_set(Cust[0],Cust[1],Cust[2], Cust[3],Cust[4]);	
					Search ser = new Search();
					ser.SearchLocker(ds,count);
					
					dispose();
				}
				else {
	                JOptionPane.showConfirmDialog(getContentPane(), "동일한 조건이 2개 이상 있습니다.", "검색 오류", 
	                		JOptionPane.CLOSED_OPTION, 
	                			JOptionPane.WARNING_MESSAGE, null);				
				}
			}
			else {
				dispose();
			}
		}
	}

	/** This method is for checking whether user insert wrong data format.
	* If user inserts wrong data, if returns true.
	* 
	* <br>
	* 
	* @param void
	* @return boolean
	**/	
	private boolean CheckError() {
		
		boolean value = false;
		
		// 예외1		
		for(int i=0; i<5; i++)
			comboCnt[i] = 0;
		
		for(int i=0; i<count; i++) {
			comboCnt[Item_cb[i].getSelectedIndex()] ++;
			if(comboCnt[Item_cb[i].getSelectedIndex()] > 1) {
				value = true;
				break;
			}
		}
		
		// 예외2
		
		return value;
	}

	/** This method is reseting comboCnt and Cust variables to null value.
	* 
	* <br>
	* 
	* @param void
	* @return boolean
	**/	
	private void resetVariable() {
		for(int i=0; i<5; i++) {
			comboCnt[i] = 0;
			Cust[i] = "NULL";
		}
	}

	/** This method is for adding TextField and Combobox into new line when user click add button.
	* 
	* <br>
	* 
	* @param void
	* @return void
	**/	
	private void addSearchPanel() {
		int height = 35*count;
		Item_cb[count] = new JComboBox();
		Item_cb[count].setBounds(27, 30+height, 120, 21);
		Item_cb[count].addItem("사물함번호");
		Item_cb[count].addItem("학번");
		Item_cb[count].addItem("이름");
		Item_cb[count].addItem("핸드폰번호");
		Item_cb[count].addItem("만료기간");
		pan_content.add(Item_cb[count]);
		
		Item_tf[count] = new JTextField();
		Item_tf[count].setBounds(160, 30+height, 230, 21);
		pan_content.add(Item_tf[count]);	
		
		count++;
		pan_content.revalidate();
		pan_content.repaint();
	}

	/** This method is for deleting TextField and Combobox when user click del button.
	* 
	* <br>
	* 
	* @param void
	* @return void
	**/	
	private void delSearchPanel() {
		count --;
		pan_content.remove(Item_cb[count]);
		pan_content.remove(Item_tf[count]);
		
		pan_content.revalidate();
		pan_content.repaint();	
	}
}
