package GUI;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

/**
 * This is class about how to use this program <br>
 * this class consist of PNG image files about information <br>
 * 
 * @author june hyeock
 * @version 1.0
 *
 */
public class Information extends JFrame {

	ImageIcon icon;

	/**
	 *this method role of draw image on the background
	 * @author june hyeock
	 */
	public Information() {

		setTitle("information");
		setSize(675, 540);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setResizable(false);

		URL imginfoback = getClass().getClassLoader().getResource("인포메이션.png");
		icon = new ImageIcon(imginfoback);

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		add(panel);
	}

}