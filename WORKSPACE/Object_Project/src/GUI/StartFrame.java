package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/** A class that lets the user select run or close button.
* 
* <br>
* If user select run button, viewing MainFrame.
* Or if user select close button, Closing StartFrame.
*
* @author Myungho Bae
* @version 1.5
**/
public class StartFrame extends JFrame {
	
	ImageIcon lockerImg;
	JScrollPane scrollPane;
	JButton startBtn;
	JButton closeBtn;
	
	public StartFrame() {		
		setTitle("Start Frame");
		setSize(500,500);	

		ButtonStyle btnStyle = new ButtonStyle();
		
		setLayout(new BorderLayout());
		
		lockerImg = new ImageIcon("./Img/LockerImg.png");
		JPanel imgPanel = new JPanel() {	// 익명클래스
			   public void paintComponent(Graphics g) {
				    g.drawImage(lockerImg.getImage(), -28, -80, null);
				    setOpaque(false);
				    super.paintComponent(g);
			   }
		};
		JPanel btnPanel = new JPanel();
		
		startBtn = new JButton(new ImageIcon("./Img/StartBtn.png"));	
		btnStyle.deleteButtonFormat(startBtn);		
		startBtn.addActionListener(new StartFrm_ActionListener());
			
		closeBtn = new JButton(new ImageIcon("./Img/CloseBtn.png"));
		btnStyle.deleteButtonFormat(closeBtn);
		closeBtn.addActionListener(new StartFrm_ActionListener());
			
		btnPanel.setLayout(new FlowLayout(1,20,30));
		btnPanel.setBackground(Color.white);
		btnPanel.add(startBtn);
		btnPanel.add(closeBtn);
		
		add(imgPanel,BorderLayout.CENTER);
		add(btnPanel,BorderLayout.SOUTH);		
		
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private class StartFrm_ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(startBtn)) {
				new MainFrame();
				dispose();
			}
			else {
				System.exit(0);
			}
		}		
	}
}
