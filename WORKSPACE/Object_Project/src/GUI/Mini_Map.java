package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

/**
 * This class has some buttons are used to switch slots in the mini-map. <br>
 * It assigns a position to each button and assigns a number corresponding to
 * the position.
 * <p>
 * The number corresponding to the position is the clockwise direction in which
 * the upper left corner of each floor is set as the reference number 1. At the
 * end of the list, the number on the bottom left is 9, and this number is
 * associated with the number corresponding to each number 1. The first floor
 * uses negative numbers, the second floor uses positive numbers, and the 0 is
 * not used.
 * 
 * In case of version 1, two layers were displayed on one screen. In version 2,
 * one floor is represented on one screen, a button on the right is created to
 * enable floor-to-floor movement, and a new variable floor(boolean) is added to
 * express this movement.
 * </p>
 * 
 * @author Yongho Kim
 * @since 2017-11-14
 * @version 2.0
 * 
 * 
 */
public class Mini_Map extends JPanel {
	/**
	 * Lockers correspond to a block of lockers and are implemented as JButton for
	 * free movement. It is also implemented as public because it is expected to be
	 * used in other classes as well
	 */
	public Location[][] lockers;
	/**
	 * Since 'man' is a JPanel that represents the current location, it is
	 * appropriate to have this panel in which all the panels related to the
	 * mini-map are collected
	 */
	private Current man;
	private LockState State = new LockState();
	/** Simple reuse with many values */
	static public JLabel floortxt;
	private JButton[][] btn = new JButton[2][];
	
	private static final int space1 = 1;
	private static final int space2 = 8;
	private static final int space3 = 4;
	private static final int button_width = 150;
	private static final int button_height = 50;
	
	public static boolean floor = false;

	/**
	 * Initialize each array and specify its position.
	 * @param btn1 - this param means btn1 declare of JButton type
	 * @param btn2 - this param means btn2 declare of JButton type
	 */
	public Mini_Map(JButton[] btn1, JButton[] btn2) {
		int i, j;
		man = new Current();
		lockers = new Location[2][];
		for(i = 0; i < 2; i++) {
			lockers[i] = new Location[5];
			for(j = 0; j < 5; j++) 
				lockers[i][j] = new Location();
			
		}
		
		this.btn[0] = btn1;
		this.btn[1] = btn2;
		
		man.current = -1;
		man.setSize(20, 20);
		man.setLocation(man.getPosition());
		add(man);
		floortxt = new JLabel(1 + "F");
		floortxt.setFont(new Font("Serif", Font.BOLD, 60));
		floortxt.setForeground(Color.BLACK);
		floortxt.setBounds(350, 80, 150, 100);
		add(floortxt);
		rePainting(floor);
	}
	
	/**
	 * The part of the current panel
	 * <br>
	 * Divide the mini-map into two floors.
	 * @param b - this param means value of be declare boolean type
	 */
	public void rePainting(boolean b) {
		
		int i, j;
		setLayout(null);
		if(floor) {
			i = 1;
		}
		else {
			i = 0;
		}
		for(j = 0; j < 5; j++) {
			lockers[i][j].setSize(button_width, button_height);
			if(j < 3) {
				lockers[i][j].setLocation(space3+(button_width+space2)*j, space3);
			}
			else {
				lockers[i][j].setLocation(space3+(button_width+space2)*(j%3), space3*3+(button_height*2));
			}


			add(lockers[i][j]);
			lockers[i][j].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					System.out.println(b.getLocation().x + " " + b.getLocation().y);
					man.preCurrent = man.current;
					man.setPosition(b.getLocation());
					System.out.println(man.current);
					man.setLocation(man.getPosition());
					man.repaint();
					
					boolean temp_one, temp_two;
					if(man.current < 0) {
						if(Math.abs(man.preCurrent)%2 == 1)
							temp_one = true;
						else
							temp_one = false;
						
						if(Math.abs(man.current)%2 == 1)
							temp_two = true;
						else
							temp_two = false;
							
						if(temp_one == temp_two) {
							if(man.preCurrent > 0)
								MainFrame.goNextCard();					
							if(!MainFrame.divide)
								State.drawButtonBorder(btn[1]);
							else
								State.drawButtonBorder(btn[0]);							
						}
						else {
							MainFrame.goNextCard();
							if(!MainFrame.divide)
								State.drawButtonBorder(btn[1]);
							else
								State.drawButtonBorder(btn[0]);								
						}
					}

					if(man.current > 0) {
						if(Math.abs(man.preCurrent)%2 == 1)
							temp_one = false;
						else
							temp_one = true;
						
						if(Math.abs(man.current)%2 == 1)
							temp_two = false;
						else
							temp_two = true;
							
						if(temp_one == temp_two) {
							if(man.preCurrent < 0)
								MainFrame.goNextCard();
							if(!MainFrame.divide)
								State.drawButtonBorder(btn[1]);
							else
								State.drawButtonBorder(btn[0]);							
						}
						else {
							MainFrame.goNextCard();
							if(!MainFrame.divide)
								State.drawButtonBorder(btn[1]);
							else
								State.drawButtonBorder(btn[0]);								
						}
					}
					
				}	
			});

		}
		floortxt.setText(i+1 + "F");
		floortxt.repaint();
		repaint();
	}

	/**
	 * The part of the current panel 
	 * <br>
	 * Divide the mini-map into two floors.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		double width = 476;
		double height = 168;

		Rectangle2D rect1 = new Rectangle2D.Double(space1, space1, width, height);
		g2.setPaint(Color.WHITE);
		g2.fill(rect1);
		g2.draw(rect1);
		
		
	}
}

///**
// * @author Yongho Kim
// * @since 2017-11-14
// * @version 1.0
// * @description key push - up -> if you are on first floor, you displace to
// *              second floor. key push - down -> if you are on second floor, you
// *              displace to first floor. key push - left -> left move key push -
// *              right -> right move
// **/
//
//class KeyHandler extends KeyAdapter {
//	Current p;
//
//	public void keyReleased(KeyEvent e) {
//		int keyCode = e.getKeyCode();
//
//		switch (keyCode) {
//		case KeyEvent.VK_UP:
//			if (p.current < 0)
//				p.current = 1;
//			break;
//		case KeyEvent.VK_DOWN:
//			if (p.current > 0)
//				p.current = -1;
//			break;
//		case KeyEvent.VK_LEFT:
//			if (p.current > 0)
//				if (--p.current == 0)
//					p.current = 5;
//				else if (p.current < 0)
//					if (++p.current == 0)
//						p.current = -5;
//			break;
//		case KeyEvent.VK_RIGHT:
//			if (p.current > 0)
//				if (++p.current == 6)
//					p.current = 1;
//				else if (p.current < 0)
//					if (--p.current == -6)
//						p.current = -1;
//			break;
//		}
//		// System.out.println(p.current);
//	}
//}