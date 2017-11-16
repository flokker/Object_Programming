package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * �̴ϸ� �� �����ϴ� ���� �繰���� ������ ǥ���� JButton
 * <br>
 * button�� ������ �ش��ϴ� �繰�� ������ ������, ���� ��ġ�� ���ŵǰ� ������ �ִ� ��ư.
 * 
 * @author Yongho Kim
 * @since 2017-11-14
 * @version 1.0
 */

public class Location extends JButton   //15*5 rectangle
{
	/** Location�� �̹����� ������ ���� ����, ���� private�� ���� */
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
	 * JButton�� �����ϱ� ���ؼ� �߻�޼ҵ带 ������ �κ�
	 * 
	 * @param Graphics g input value
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(image == null) return;

		g.drawImage(image, 0, 0, null);
	}


}