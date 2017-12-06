package GUI;

import java.util.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.AWTException;
import Operation.ExcelSearcher;
import Operation.ExcelManager;
import Operation.data_set;

/**
 * A class that lets the user fill out personal information to search locker.
 * 
 * <br>
 * The class contains groups of JComboBox and JTextField to fill out personal
 * information. the Groups can added or deleted by selecting add/delete button.
 * 
 * <br>
 * User should select one condition per one JComboBox. for example, each two
 * JComboBox can not indicate Name Field at the same time.
 *
 * @author Myungho Bae
 * @version 1.5
 **/
public class SearchFrame extends JFrame {

	private JPanel text_Panel;
	private JPanel lab_Panel;
	private JPanel entireForm_Panel;
	private JTextField[] Item_tf = new JTextField[5];
	private JComboBox[] Item_cb = new JComboBox[5];
	private JButton btn_add;
	private JButton btn_del;
	private JButton doneBtn;
	private JButton closeBtn;
	private int count = 0;
	private int[] comboCnt = new int[5];
	private int[] result = new int[200];
	String Cust[] = new String[5];

	protected SearchFrame() {

		URL imgadd = getClass().getClassLoader().getResource("searchFrame_Add.png");
		URL imgdel = getClass().getClassLoader().getResource("searchFrame_del.png");
		URL imgdone = getClass().getClassLoader().getResource("searchFrame_Done.png");
		URL imgclose = getClass().getClassLoader().getResource("searchFrame_Close.png");

		ImageIcon addImg = new ImageIcon(imgadd);
		ImageIcon delImg = new ImageIcon(imgdel);
		ImageIcon doneImg = new ImageIcon(imgdone);
		ImageIcon closeImg = new ImageIcon(imgclose);

		setAlwaysOnTop(true);
		setBounds(100, 100, 530, 561);
		getContentPane().setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		// 전체를 포함하는 판넬
		JPanel full_Panel = new JPanel();
		full_Panel.setBackground(Color.BLACK);
		full_Panel.setBounds(0, 0, 534, 561);
		getContentPane().add(full_Panel);
		full_Panel.setLayout(null);

		// 상단 텍스트 라벨 판넬
		JPanel info_Panel = new JPanel();
		info_Panel.setBounds(12, 10, 510, 86);
		info_Panel.setBackground(Color.BLACK);
		full_Panel.add(info_Panel);
		info_Panel.setLayout(null);

		JLabel info1_Label = new JLabel("사물함 검색하기");
		info1_Label.setBounds(12, 10, 300, 47);
		info_Panel.add(info1_Label);
		info1_Label.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 40));
		info1_Label.setForeground(Color.LIGHT_GRAY);

		JLabel info2_Label = new JLabel("어떤 사물함을 원하세요? 무엇이든지 다 찾아드릴게요!");
		info2_Label.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 18));
		info2_Label.setForeground(Color.LIGHT_GRAY);
		info2_Label.setBounds(12, 58, 491, 22);
		info_Panel.add(info2_Label);

		// 메인 판넬 (라벨 판넬과 텍스트 판넬을 포함)
		entireForm_Panel = new JPanel();
		entireForm_Panel.setBounds(23, 125, 488, 338);
		full_Panel.add(entireForm_Panel);
		entireForm_Panel.setLayout(null);

		// 라벨 판넬
		lab_Panel = new JPanel();
		lab_Panel.setBounds(0, 0, 151, 338);
		lab_Panel.setBackground(Color.BLACK);
		entireForm_Panel.add(lab_Panel);
		lab_Panel.setLayout(null);

		JLabel lbl_Item = new JLabel("항목");
		lbl_Item.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 18));
		lbl_Item.setForeground(Color.LIGHT_GRAY);
		lbl_Item.setBounds(70, 0, 57, 30);
		lab_Panel.add(lbl_Item);

		btn_add = new JButton(addImg);
		btn_add.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		btn_add.setBounds(56, 80, 94, 24);
		btn_add.addActionListener(new SearchFrm_ActionListener());
		lab_Panel.add(btn_add);

		// 텍스트 판넬
		text_Panel = new JPanel();
		text_Panel.setBounds(151, 0, 337, 338);
		text_Panel.setBackground(Color.BLACK);
		entireForm_Panel.add(text_Panel);
		text_Panel.setLayout(null);

		JLabel lbl_Word = new JLabel("내용");
		lbl_Word.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 18));
		lbl_Word.setForeground(Color.LIGHT_GRAY);
		lbl_Word.setBounds(125, 0, 42, 28);
		text_Panel.add(lbl_Word);

		addSearchPanel();

		btn_del = new JButton(delImg);
		btn_del.setBounds(12, 80, 94, 24);
		btn_del.addActionListener(new SearchFrm_ActionListener());
		btn_del.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		text_Panel.add(btn_del);

		// 하단 버튼 판넬
		ButtonStyle buttonstyle = new ButtonStyle();
		JPanel btn_Panel = new JPanel();
		btn_Panel.setBackground(Color.BLACK);
		btn_Panel.setBounds(12, 480, 510, 78);
		full_Panel.add(btn_Panel);

		doneBtn = new JButton(doneImg);
		buttonstyle.deleteButtonFormat(doneBtn);
		doneBtn.setBackground(Color.BLACK);
		doneBtn.setOpaque(true);
		doneBtn.addActionListener(new SearchFrm_ActionListener());
		btn_Panel.add(doneBtn);

		closeBtn = new JButton(closeImg);
		buttonstyle.deleteButtonFormat(closeBtn);
		closeBtn.setBackground(Color.BLACK);
		closeBtn.setOpaque(true);
		closeBtn.addActionListener(new SearchFrm_ActionListener());
		btn_Panel.add(closeBtn);

		resetVariable();
	}

	class SearchFrm_ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();

			if (e.getSource().equals(btn_add)) {
				if (count < 5) {
					btn_add.setBounds(56, 80 + (40 * count), 94, 24);
					btn_del.setBounds(12, 80 + (40 * count), 94, 24);
					addSearchPanel();
				}
			} else if (e.getSource().equals(btn_del)) {
				if (count > 1) {
					delSearchPanel();
					btn_add.setBounds(56, 80 + (40 * (count - 1)), 94, 24);
					btn_del.setBounds(12, 80 + (40 * (count - 1)), 94, 24);
				}
			} else if (e.getSource().equals(doneBtn)) {
				if (checkCondition() == false) {
					for (int i = 0; i < count; i++) {
						int index = Item_cb[i].getSelectedIndex();
						if (comboCnt[index] == 1) {
							Cust[index] = Item_tf[i].getText();
						}
					}

					data_set ds = new data_set(Cust[0], Cust[1], Cust[2], Cust[3], Cust[4]);
					ExcelManager MA = new ExcelManager();
					result = MA.excelSearhing(ds, count);

					dispose();
				} else {
					JOptionPane.showConfirmDialog(getContentPane(), "동일한 조건이 2개 이상 있습니다.", "검색 오류",
							JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, null);
				}
			} else {
				dispose();
			}
		}
	}

	static class ColorArrowUI extends BasicComboBoxUI {

		public static ComboBoxUI createUI(JComponent c) {
			return new ColorArrowUI();
		}

		protected JButton createArrowButton() {
			return new BasicArrowButton(BasicArrowButton.SOUTH, Color.GRAY, Color.GRAY, Color.WHITE, Color.WHITE);
		}
	}

	/**
	 * Returns true if two or more JComboBox condition indicate same field at the
	 * same time.
	 * 
	 * <br>
	 * 
	 * @param void
	 * @return boolean
	 **/
	private boolean checkCondition() {

		boolean value = false;

		for (int i = 0; i < 5; i++)
			comboCnt[i] = 0;

		for (int i = 0; i < count; i++) {
			comboCnt[Item_cb[i].getSelectedIndex()]++;
			if (comboCnt[Item_cb[i].getSelectedIndex()] > 1) {
				value = true;
				break;
			}
		}
		return value;
	}

	/**
	 * Sets the value for the field comboCnt, and Cust to 0
	 * 
	 * <br>
	 * 
	 * @param void
	 * @return boolean
	 **/
	private void resetVariable() {
		for (int i = 0; i < 5; i++) {
			comboCnt[i] = 0;
			Cust[i] = "NULL";
		}
	}

	/**
	 * Appends the group of JComboBox and JTextfield to fill in to the end of the
	 * current group.
	 * 
	 * <br>
	 * 
	 * @param void
	 * @return void
	 **/
	private void addSearchPanel() {
		Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
		int height = 40 * (count + 1);

		Item_cb[count] = new JComboBox(new String[] { "사물함 번호", "이름", "학번", "핸드폰 번호", "만료기간" });
		Item_cb[count].setRenderer(new DefaultListCellRenderer() {
			public void paint(Graphics g) {
				setBackground(Color.GRAY);
				setForeground(Color.WHITE);
				super.paint(g);
			}
		});
		Item_cb[count].setUI(ColorArrowUI.createUI(Item_cb[count]));
		Item_cb[count].setBorder(border);
		Item_cb[count].setOpaque(true);
		Item_cb[count].setFont(new Font("나눔고딕", Font.BOLD, 16));
		Item_cb[count].setBounds(30, height, 120, 30);
		lab_Panel.add(Item_cb[count]);

		Item_tf[count] = new JTextField(10);
		Item_tf[count].setFont(new Font("나눔고딕", Font.BOLD, 16));
		Item_tf[count].setBounds(12, height, 267, 30);
		Item_tf[count].setBorder(border);
		Item_tf[count].setBackground(Color.GRAY);
		Item_tf[count].setForeground(Color.WHITE);
		Item_tf[count].setOpaque(true);
		text_Panel.add(Item_tf[count]);

		count++;
		entireForm_Panel.revalidate();
		entireForm_Panel.repaint();
	}

	/**
	 * Removes the group of JComboBox and JTextField from container.
	 * 
	 * <br>
	 * 
	 * @param void
	 * @return void
	 **/
	private void delSearchPanel() {
		count--;
		lab_Panel.remove(Item_cb[count]);
		text_Panel.remove(Item_tf[count]);

		entireForm_Panel.revalidate();
		entireForm_Panel.repaint();
	}
}
