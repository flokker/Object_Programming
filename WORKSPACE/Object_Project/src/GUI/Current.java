package GUI;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.color.*;
import java.awt.*;

/**
 * A JPanel class created to visually present the current location
 * <br>
 * This class has a static variable to represent the current location, and analyzes it to find out where it is, or to get the value of the click.
 *  
 * @author Yongho Kim
 * @since 2017-11-16
 * @version 0.5
 */
public class Current extends JPanel{
	/** This is a variable that delimits the current location, and this operation is private to this class*/
	private Point p;
	/** this variable is needed to know what the current lockers area is, and since it is unique, it is declared static. Variables represent a range of -9 to 9(except for 0), so they should be public so that all classes must be visible.*/
	public static int current;      // 1st floor < 0, 2nd floor > 0 and not use 0
	/** Initialize Point*/
	Current(){
		p = new Point(4, 4);
	}
	/** The implementation part of the abstract to implement JPanel
	 * 
	 * @param Graphics g input value
	 */
	public void paintComponent(Graphics g){
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D)g;
		double radius = 10;
		
		Ellipse2D circle = new Ellipse2D.Double();
		circle.setFrameFromCenter(p.x+30, p.y+20, p.x + radius, p.y + radius);
		g2.setPaint(new Color(255, 238, 219));
		g2.fill(circle);
		g2.draw(circle);
	}
	/** It is a method to convert a private p that takes a location. This method invokes a method that changes the current to change the currnet.
	 * 
	 * @param Point p input value
	 */
	public void setPosition(Point p){
		this.p = p;
		setCurrent();
	}
	
	/** Return the value of Point
	 * 
	 * @return value of Point
	 */
	
	public Point getPosition(){
		return p;
	}
	
	/** Methods to eliminate the difference between current and point
	 * 
	 */
	
	public void setCurrent(){
		int x, y, z;
		x = p.x;
		y = p.y;
		z = x/160;
		if(y < 20) current = z+1;
		else {
			switch(z){
			case 0:
				current = 5; break;
			case 1:
				current = 4; break;
			}
		}
		if(y > 61)
			current *= -1;
	}
	
}
