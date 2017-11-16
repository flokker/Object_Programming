package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * 미니맵 상에 존재하는 작은 사물함의 집합을 표현한 JButton
 * <br>
 * button을 누르면 해당하는 사물함 구역이 나오며, 현재 위치가 갱신되게 도움을 주는 버튼.
 * 
 * @author Yongho Kim
 * @since 2017-11-14
 * @version 1.0
 */

public class Location extends JButton   //15*5 rectangle
{
	/** Location에 이미지를 입히기 위한 변수, 따라서 private로 구현 */
	private Image image;
	public Location() {
		image = Toolkit.getDefaultToolkit().getImage("./Img/Slat.png");
		MediaTracker tracker = new MediaTracker(this);
		tracker.addImage(image, 0);
		try {
			tracker.waitForID(0);
		}
		catch(InterruptedException exception) {}
	}
	/**
	 * JButton을 구현하기 위해서 추상메소드를 구현한 부분
	 * 
	 * @param Graphics g input value
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(image == null) return;

		g.drawImage(image, 0, 0, null);
	}


}