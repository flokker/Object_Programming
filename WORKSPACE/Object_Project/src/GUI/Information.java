package GUI;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This is class about how to use this program
 * <br>
 * this class consist of PNG image files about information
 * <br>
 * 
 * @author june hyeock
 *@version 1.0
 *
 */
public class Information extends JFrame {

	JFrame frame;
	JScrollPane scrollPane;
	ImageIcon icon;

	public Information() {

		frame = new JFrame();
		frame.setTitle("information");
		frame.setSize(680, 550);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		icon = new ImageIcon("./Img/인포메이션.png");

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