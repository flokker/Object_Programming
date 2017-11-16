package GUI;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.color.*;
import java.awt.*;

/**
 * 현재 위치를 시각적으로 보여주기 위해서 생성된 클래스
 * <br>
 * 현재 위치를 표현하기 위해서 static변수를 갖고 있으면서 이를 분석하여 현재 어디인지를 알아내거나 클릭의 값을 받아 어디인지 알게 한다.
 *  
 * @author Yongho Kim
 * @since 2017-11-16
 * @version 0.5
 */
public class Current extends JPanel{
	/** 현재 위치를 나태내는 변수이며, 이 연산은 이 클래스 내에서만 이루어지므로 private으로 구현*/
	private Point p;
	/** 현재 사물함의 번호가 무엇인지 아릭 위해서 필요한 변수이며, 이 위치는 유일하므로 static으로 선언하였으며, -9~9를 표현하고(단, 0은 제외)모든 클래스가 볼 수 있어야 하므로 public으로 구현*/
	public static int current;      // 1st floor < 0, 2nd floor > 0 and not use 0
	/** Point 초기화*/
	Current(){
		p = new Point();
	}
	/** JPanel을 구현하기 위해서 필요한 부분
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
	/** private인 p를 변화하기 위한 메소드 이며 위치의 변화가 있으므로 당연히 current의 변화를 주기 위해서 current의 변화를 주는 메소드 호출
	 * @return void 
	 * @param Point p
	 */
	public void setPosition(Point p){
		this.p = p;
		setCurrent();
	}
	
	/** Return the value of Point
	 * @param void
	 * @return Point
	 */
	
	public Point getPosition(){
		return p;
	}
	
	/** current와 point의 차이를 없애기 위한 메소드
	 * @param void
	 * @return void
	 */
	
	public void setCurrent(){
		int x, y, z;
		x = p.x;
		y = p.y;
		z = x/68;
		if(y == 1 || y == 87) current = z+1;
		else {
			switch(z){
			case 0:
				current = 9; break;
			case 1:
				current = 8; break;
			case 2:
				current = 7; break;
			case 3:
				current = 6; break;
			}
		}
		if(y > 61)
			current *= -1;
	}
	
}