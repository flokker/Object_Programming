package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/** This class consists of method that painting background image on the panel. 
* 
* 
* @author Myungho Bae
* @version 1.0
**/
public class MainBackgroundPanel extends JPanel {
	
	Image image;
	
	MainBackgroundPanel() {
		image = new ImageIcon("./Img/main_background.png").getImage();
	}

	/** Painting a background image on panel to override javax.swing.JComponent.paint.
	* 
	* 
	* @param void
	* @return boolean
	**/	
	public void paint(Graphics g){
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);   
	}
}

