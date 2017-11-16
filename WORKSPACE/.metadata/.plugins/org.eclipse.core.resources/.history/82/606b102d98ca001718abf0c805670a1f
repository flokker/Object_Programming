package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

/**
 * 미니맵 상에서 존재하는 버튼을 종합하는 클래스
 * <br>
 * 각 버튼들에게 위치를 부여하고 위치에 해당하는 번호를 부여한다.
 * <p> 위치에 해당하는 번호는 각 층에서 좌측 상단을 1번으로 기준을 잡고 시계 방향으로 증가하는 순이다.
 * 맨 마지막 즉 좌측 하단에 해당하는 번호는 9번이며 이 번호는 각 1번에 해당하는 번호와 연결시킨다.
 * 1층은 음수를 사용하고 2층은 양수를 사용하며, 0은 사용하지 않는다.
 * </p>
 * 
 * @author Yongho Kim
 * @since 2017-11-14
 * @version 1.0
 * 
 * 
 */
public class Mini_Map extends JPanel {
	/** lockers는 사물함 한 블록에 해당하며, 자유로운 이동을 위해 JButton으로 구현되어 있다. 또한, 다른 클래스에서도 사용될 것으로 기대되기 때문에 public으로 구현한다. */
	public Location [][] lockers;
	/** man은 현재 위치를 나타내는 JPanel이므로 미니맵에 관한 모든 Panel을 모아놓은 이 Panel에 있는 것이 적절하며, 이 패널 내에서만 연산이 이루어지므로 private로 구현한다.*/
	private Current man;
	/** 단순 재사용이 많은 값*/
	private static final int space1 = 1;
	private static final int space2 = 8;
	private static final int space3 = 4;
	private static final int button_width = 60;
	private static final int button_height = 20;

	/** 각 배열들을 초기화 하며, 위치를 지정한다.*/
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
	/** 현 Panel의 틀을 잡는 부분
	 * <br>
	 * 이곳에서 미니맵을 2층으로 나눈다.
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