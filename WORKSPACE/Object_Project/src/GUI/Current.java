package GUI;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.color.*;
import java.awt.*;

/**
 * ���� ��ġ�� �ð������� �����ֱ� ���ؼ� ������ Ŭ����
 * <br>
 * ���� ��ġ�� ǥ���ϱ� ���ؼ� static������ ���� �����鼭 �̸� �м��Ͽ� ���� ��������� �˾Ƴ��ų� Ŭ���� ���� �޾� ������� �˰� �Ѵ�.
 *  
 * @author Yongho Kim
 * @since 2017-11-16
 * @version 0.5
 */
public class Current extends JPanel{
	/** ���� ��ġ�� ���³��� �����̸�, �� ������ �� Ŭ���� �������� �̷�����Ƿ� private���� ����*/
	private Point p;
	/** ���� �繰���� ��ȣ�� �������� �Ƹ� ���ؼ� �ʿ��� �����̸�, �� ��ġ�� �����ϹǷ� static���� �����Ͽ�����, -9~9�� ǥ���ϰ�(��, 0�� ����)��� Ŭ������ �� �� �־�� �ϹǷ� public���� ����*/
	public static int current;      // 1st floor < 0, 2nd floor > 0 and not use 0
	/** Point �ʱ�ȭ*/
	Current(){
		p = new Point();
	}
	/** JPanel�� �����ϱ� ���ؼ� �ʿ��� �κ�
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
	/** private�� p�� ��ȭ�ϱ� ���� �޼ҵ� �̸� ��ġ�� ��ȭ�� �����Ƿ� �翬�� current�� ��ȭ�� �ֱ� ���ؼ� current�� ��ȭ�� �ִ� �޼ҵ� ȣ��
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
	
	/** current�� point�� ���̸� ���ֱ� ���� �޼ҵ�
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