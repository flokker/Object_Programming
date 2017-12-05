package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

/**
 * This class has some buttons are used to switch slots in the mini-map.
 * <br>
 * It assigns a position to each button and assigns a number corresponding to the position.
 * <p> The number corresponding to the position is the clockwise direction in which the upper left corner of each floor is set as the reference number 1.
 * At the end of the list, the number on the bottom left is 9, and this number is associated with the number corresponding to each number 1.
 * The first floor uses negative numbers, the second floor uses positive numbers, and the 0 is not used.
 * 
 * In case of version 1, two layers were displayed on one screen.
 * In version 2, one floor is represented on one screen, a button on the right is created to enable floor-to-floor movement, and a new variable floor(boolean) is added to express this movement.
 * </p>
 * 
 * @author Yongho Kim
 * @since 2017-11-14
 * @version 2.0
 * 
 * 
 */
public class Mini_Map extends JPanel {
	/** Lockers correspond to a block of lockers and are implemented as JButton for free movement. It is also implemented as public because it is expected to be used in other classes as well */
	public Location [][] lockers;
	/** Since 'man' is a JPanel that represents the current location, it is appropriate to have this panel in which all the panels related to the mini-map are collected*/
	private Current man;
	/** Simple reuse with many values*/
	private static final int space1 = 1;
	private static final int space2 = 8;
	private static final int space3 = 4;
	private static final int button_width = 60;
	private static final int button_height = 20;

	/** Initialize each array and specify its position.*/
	public Mini_Map() {
		int i, j;
		man = new Current();
		lockers = new Location[2][];
		for(i = 0; i < 2; i++) {
			lockers[i] = new Location[10];
			for(j = 0; j < 9; j++) 
				lockers[i][j] = new Location();

		}
		setLayout(null);
		for(i = 0; i < 2; i++) {
			for(j = 0; j < 9; j++) {
				lockers[i][j].setSize(button_width, button_height);
				if(i == 0) {
					if(j < 6) {
						lockers[i][j].setLocation(space3+(button_width+space2)*j, space3+83);
					}
					else {
						lockers[i][j].setLocation(space3+(button_width+space2)*(j%6), space3+(button_height*3)+83);
					}
				}
				else {
					if(j < 7) {
						lockers[i][j].setLocation(space3+(button_width+space2)*j, space1);
					}
					else {
						lockers[i][j].setLocation(space3+(button_width+space2)*(j%7), space1+(button_height*3));
					}
				}
				add(lockers[i][j]);
				lockers[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b = (JButton)e.getSource();
						System.out.println(b.getLocation().x + " " + b.getLocation().y);
						man.setPosition(b.getLocation());
						System.out.println(man.current);
						add(man);
					}
				}
						);
			}
		}
		man.current = -1;
	}
	/** The part of the current panel
	 * <br>
	 * Divide the mini-map into two floors.
	 * 
	 * @param Graphics g input value
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		double width = 476;
		double height = 82;

		Rectangle2D rect1 = new Rectangle2D.Double(space1, space1, width, height);
		g2.setPaint(Color.WHITE);
		g2.fill(rect1);
		g2.draw(rect1);

		Rectangle2D rect2 = new Rectangle2D.Double(space1, 3*space1 + height, width, height);
		g2.setPaint(Color.WHITE);
		g2.fill(rect2);
		g2.draw(rect2);

	}
}


/**
 * @author Yongho Kim
 * @since 2017-11-14
 * @version 1.0
 * @description
 * key push - up -> if you are on first floor, you displace to second floor.
 * key push - down -> if you are on second floor, you displace to first floor.
 * key push - left -> left move
 * key push - right -> right move
 **/

class KeyHandler extends KeyAdapter
{
	Current p;
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();

		switch(keyCode) {
		case KeyEvent.VK_UP:
			if(p.current < 0) p.current = 1; break;
		case KeyEvent.VK_DOWN:
			if(p.current > 0) p.current = -1; break;
		case KeyEvent.VK_LEFT:
			if(p.current > 0) if(--p.current == 0) p.current = 9;
			else if(p.current < 0) if(++p.current == 0) p.current = -9;
			break;
		case KeyEvent.VK_RIGHT:
			if(p.current > 0) if(++p.current == 10)   p.current = 1;
			else if(p.current < 0) if(--p.current == -10) p.current = -1;
			break;
		}
//		System.out.println(p.current);
	}
}