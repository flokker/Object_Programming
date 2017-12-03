package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.*;
import javax.swing.event.*;
import javax.sound.sampled.*;

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

	private String audioFile;
	private Clip clip;
	private AudioInputStream audioInputStream;

	JScrollPane scrollPane;
	JButton startBtn;
	JButton closeBtn;

	public StartFrame() {
		ButtonStyle btnStyle = new ButtonStyle();
		setTitle("Lock N Roll");
		setBounds(100, 100, 500, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		JPanel full_Panel = new JPanel();
		full_Panel.setBackground(Color.BLACK);
		full_Panel.setBounds(0, 0, 500, 600);
		getContentPane().add(full_Panel);
		full_Panel.setLayout(null);
		
		JLabel lockerImg = new JLabel(new ImageIcon("./Img/LockerImg.png"));
		lockerImg.setBounds(12, 10, 476, 415);
		full_Panel.add(lockerImg);

		startBtn = new JButton(new ImageIcon("./Img/StartBtn.png"));
		startBtn.setBounds(60, 500, 160, 50);
		startBtn.addActionListener(new StartFrm_ActionListener());
		btnStyle.deleteButtonFormat(startBtn);
		full_Panel.add(startBtn);
		
		closeBtn = new JButton(new ImageIcon("./Img/CloseBtn.png"));
		closeBtn.setBounds(280, 500, 160, 50);
		closeBtn.addActionListener(new StartFrm_ActionListener());
		btnStyle.deleteButtonFormat(closeBtn);
		full_Panel.add(closeBtn);

		setVisible(true);
		PlayMusic();
	}

	/** Plays background music on the StartFrame.
	* 
	* <br>
	* 
	* @param void
	* @return void
	**/	
	private void PlayMusic() {
		try
		{
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("./sound/jazzrock.wav"));
			clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();
		}
		catch (Exception ex){ }
	}

	/** Stops playing background music on the StartFrame.
	* 
	* <br>
	* 
	* @param void
	* @return void
	**/
	private void StopMusic() {
		clip.stop();
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
			StopMusic();
		}	
	}
	public static void main(String[] args) {
		GUI.StartFrame startApp = new GUI.StartFrame();
	}
}