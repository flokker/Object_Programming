package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.event.*;

import Operation.ExcelManager;

import javax.sound.sampled.*;

/**
 * A class that lets the user select run or close button.
 * 
 * <br>
 * If user select run button, viewing MainFrame. Or if user select close button,
 * Closing StartFrame.
 *
 * @author Myungho Bae
 * @version 1.5
 **/
public class StartFrame extends JFrame {

	private String audioFile;
	private Clip clip;
	private AudioInputStream audioInputStream;
	public static Calendar now = Calendar.getInstance();
	JScrollPane scrollPane;
	JButton startBtn;
	JButton closeBtn;
	
	ExcelManager ex;

	public StartFrame() {
		
		ex = new ExcelManager();

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

		URL imglocker = getClass().getClassLoader().getResource("LockerImg.png");
		JLabel lockerImg = new JLabel(new ImageIcon(imglocker));
		lockerImg.setBounds(12, 10, 476, 415);
		full_Panel.add(lockerImg);

		URL imgstartBtn = getClass().getClassLoader().getResource("StartBtn.png");
		startBtn = new JButton(new ImageIcon(imgstartBtn));
		startBtn.setBounds(60, 500, 160, 50);
		startBtn.addActionListener(new StartFrm_ActionListener());
		btnStyle.deleteButtonFormat(startBtn);
		full_Panel.add(startBtn);

		URL imgcloseBtn = getClass().getClassLoader().getResource("CloseBtn.png");
		closeBtn = new JButton(new ImageIcon(imgcloseBtn));
		closeBtn.setBounds(280, 500, 160, 50);
		closeBtn.addActionListener(new StartFrm_ActionListener());
		btnStyle.deleteButtonFormat(closeBtn);
		full_Panel.add(closeBtn);

		setVisible(true);
		PlayMusic();

	}

	/**
	 * Plays background music on the StartFrame.
	 * 
	 * <br>
	 * 
	 * @param void
	 * @return void
	 **/
	private void PlayMusic() {
		try {
			URL sound = getClass().getClassLoader().getResource("jazzrock.wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
			clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();
		} catch (Exception ex) {
		}
	}

	/**
	 * Stops playing background music on the StartFrame.
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
			if (e.getSource().equals(startBtn)) {
				StopMusic();
				new MainFrame();
				
				// JOptionPane.showConfirmDialog(getContentPane(),System.getProperty("user.dir"), "�˻� ����",JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, null);
				
				dispose();
			} else {
				System.exit(0);

			}
			StopMusic();
		}
	}
	public static void main(String[] args) {
		now = Calendar.getInstance();
		new StartFrame();
	}
}