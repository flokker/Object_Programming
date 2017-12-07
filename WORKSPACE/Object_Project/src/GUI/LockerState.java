package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

import Operation.*;

public class LockerState extends JPanel{
	private Image image;
	private int period1;
	private int period2;
	private data_set d;
	Calendar now;
	private ExcelManager excel;
	private MainFrame main;

	public LockerState(int index,  boolean selected) {
		excel = new ExcelManager();
		now = Calendar.getInstance();
		if(selected) {
			image = Toolkit.getDefaultToolkit().getImage("./Img/Yellow Border_1.png");
		}
		else {
			period1 = Integer.parseInt(excel.getLeftPeriod(excel.getRowID(getLockID(index))));


			if(period1 > 15) {
				image = Toolkit.getDefaultToolkit().getImage("./Img/Red Border_1.png");
			}

			else if(period1 > 0) {
				image = Toolkit.getDefaultToolkit().getImage("./Img/Orange Boerder_1.png");
			}

			else{
				image = Toolkit.getDefaultToolkit().getImage("./Img/Green Border_1.png");
			}
		}
		MediaTracker tracker = new MediaTracker(this);
		tracker.addImage(image, 0);
		try {
			tracker.waitForID(0);
		}
		catch(InterruptedException exception) {}
	}

	public LockerState(int index, boolean selected, int i) {
		excel = new ExcelManager();
		now = Calendar.getInstance();
		if(selected) {
			image = Toolkit.getDefaultToolkit().getImage("./Img/Yellow Border_2.png");
		}
		else {
			i = getLockID(index);
			period1 = Integer.parseInt(excel.getLeftPeriod(excel.getRowID(i)));

			period2 = Integer.parseInt(excel.getLeftPeriod(excel.getRowID(i)+1));

			if(period1 > 15 && period2 > 15) {
				image = Toolkit.getDefaultToolkit().getImage("./Img/Red Border_2.png");

			}

			else if(period1 > 0 && period2 > 0) {
				image = Toolkit.getDefaultToolkit().getImage("./Img/Orange Border_2.png");
			}

			else{
				image = Toolkit.getDefaultToolkit().getImage("./Img/Green Border_2.png");
			}
		}
		MediaTracker tracker = new MediaTracker(this);
		tracker.addImage(image, 0);
		try {
			tracker.waitForID(0);
		}
		catch(InterruptedException exception) {}
	}
	
	private int getLockID(int i) {
		int num = Current.current;
		if (num > 0) {
			num += 4;
		} else {
			num = (num * -1) - 1;
		}
		return ((num + 1) / 2) * 12 + (num / 2) * 16 + 1 + i;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(image == null) return;

		g.drawImage(image, 0, 0, null);
	}
}
