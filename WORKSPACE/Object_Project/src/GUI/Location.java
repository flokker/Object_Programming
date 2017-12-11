package GUI;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * JButton that represents a set of small lockers that reside on the mini-map
 * <br>
 * Clicking this button will bring up the corresponding locker area and help you update your current location.
 * 
 * @author Yongho Kim
 * @since 2017-11-14
 * @version 1.0
 */

public class Location extends JButton   //15*5 rectangle
{
	/** Variable for applying image to location, so it is implemented as private */
	private Image image;
	public Location() {
		URL imgSlat = getClass().getClassLoader().getResource("Slat.png");
		image = Toolkit.getDefaultToolkit().getImage(imgSlat);
		MediaTracker tracker = new MediaTracker(this);
		tracker.addImage(image, 0);
		try {
			tracker.waitForID(0);
		}
		catch(InterruptedException exception) {}
	}
	/**
	 * The implementation part of the abstract to implement JButton
	 * 
	 * @param g input value
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(image == null) return;

		g.drawImage(image, 0, 0, null);
	}


}