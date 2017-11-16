package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainBackgroundPanel extends JPanel {
	
	Image image;
	
	MainBackgroundPanel() {
		image = new ImageIcon("./Img/main_background.png").getImage();
	}

	public void paint(Graphics g){
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);   
	}
}

