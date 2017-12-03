package GUI;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Information extends JFrame {

	JFrame frame;
	JScrollPane scrollPane;
	ImageIcon icon;

	public Information() {

		frame = new JFrame();
		frame.setTitle("information");
		frame.setSize(680, 550);
		frame.setVisible(true);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		icon = new ImageIcon("./Img/�������̼�.png");

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		scrollPane = new JScrollPane(panel);
		setContentPane(scrollPane);
		frame.add(panel);
	}

}