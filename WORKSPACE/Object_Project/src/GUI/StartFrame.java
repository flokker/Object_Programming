package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/** Class Description of StartFrame.
* 
* <br>
* this class is Start Frame for run 'Lock `n` Roll' Program.
* it extends JFrame to show some component and implements ActionListener to activate buttons.
*
* @author Myungho Bae
* @version 1.5
**/
public class StartFrame extends JFrame implements ActionListener {
	
	ImageIcon lockerImg;
	JScrollPane scrollPane;
	JButton startBtn;
	JButton closeBtn;
	
	public StartFrame() {		
		setTitle("Start Frame");
		setSize(500,500);	
		makeGUI();
		setUndecorated(true);		// 타이틀 바 없애는 함수
		setLocationRelativeTo(null); // 프로그램 화면 중앙에서 실행	
		setVisible(true);
	}
	
	/** This method is for Making a GUI environment. it contains a picture and two buttons.
	* two buttons have ActionListener to go next frame or exit program.
	* 
	* <br>
	* 
	* @param void
	* @return void
	**/	
	void makeGUI() {
		setLayout(new BorderLayout());
		
		lockerImg = new ImageIcon("H:\\LockerImg.png");
		JPanel imgPanel = new JPanel() {	// 익명클래스
			   public void paintComponent(Graphics g) {
				    g.drawImage(lockerImg.getImage(), -28, -80, null);
				    setOpaque(false);
				    super.paintComponent(g);
			   }
		};
		JPanel btnPanel = new JPanel();
		
		startBtn = new JButton(new ImageIcon("H:\\StartBtn.png"));	
		deleteButtonFormat(startBtn);		
		startBtn.addActionListener(this);
			
		closeBtn = new JButton(new ImageIcon("H:\\CloseBtn.png"));
		deleteButtonFormat(closeBtn);
		closeBtn.addActionListener(this);
			
		btnPanel.setLayout(new FlowLayout(1,20,30));
		btnPanel.setBackground(Color.white);
		btnPanel.add(startBtn);
		btnPanel.add(closeBtn);
		
		add(imgPanel,BorderLayout.CENTER);
		add(btnPanel,BorderLayout.SOUTH);		
	}
	
	/** This method is for ActionListener.
	* when you click start button or close button, it will occur some event.
	* 
	* <br>
	* 
	* @param ActionEvent e
	* @return void
	**/	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(startBtn)) { // 실행버튼 눌렀을 때
			new MainFrame();
			dispose();
		}
		else {								  // 종료버튼 눌렀을 때 
			System.exit(0);
		}
	}
	
	/** This method is for delete basic format of buttons.
	* It will help you can see appearance of image button without basic button format. 
	* 
	* <br>
	* 
	* @param JButton btn
	* @return void
	**/		
	private void deleteButtonFormat(JButton btn) {	// 버튼의 기본 모습들을 없애 주기 위한 함수를 포함한 메소드
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setDefaultCapable(false);
		btn.setFocusPainted(false);
		btn.setOpaque(false);
	}
}