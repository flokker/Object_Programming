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
	private Point point;
	Calendar now;
	private ExcelManager excel;
	private MainFrame main;
	
	public LockerState(data_set data, int i, Point p) {
		excel = new ExcelManager();
		now = Calendar.getInstance();
		d = data;
		period1 = new Integer(excel.getLockerID(excel.getRowID(main.lockerInfo[1]))).intValue();
		point = p;

		
		if(period1 > 15) {
			image = Toolkit.getDefaultToolkit().getImage("./Img/Red Border_1.png");
		}

		else if(period1 > 0) {
			image = Toolkit.getDefaultToolkit().getImage("./Img/Orange Boerder_1.png");
		}

		else{
			image = Toolkit.getDefaultToolkit().getImage("./Img/Green Border_1.png");
		}
		MediaTracker tracker = new MediaTracker(this);
		tracker.addImage(image, 0);
		try {
			tracker.waitForID(0);
		}
		catch(InterruptedException exception) {}
	}
	
	public LockerState(data_set data1, data_set data2, int i, Point p) {
		excel = new ExcelManager();
		now = Calendar.getInstance();
		
		d = data1;
		period1 = new Integer(excel.getLockerID(excel.getRowID(main.lockerInfo[1]))).intValue();
		
		d = data2;
		period2 = new Integer(excel.getLockerID(excel.getRowID(main.lockerInfo[1]))).intValue();
		
		point = p;

		if(period1 > 15 && period2 > 15) {
			image = Toolkit.getDefaultToolkit().getImage("./Img/Red Border_2.png");

		}

		else if(period1 > 0 && period2 > 0) {
			image = Toolkit.getDefaultToolkit().getImage("./Img/Orange Border_2.png");
		}

		else{
			image = Toolkit.getDefaultToolkit().getImage("./Img/Green Border_2.png");
		}
		MediaTracker tracker = new MediaTracker(this);
		tracker.addImage(image, 0);
		try {
			tracker.waitForID(0);
		}
		catch(InterruptedException exception) {}
	}
	
	public void searchedLocker(Point p, int i) {
		if(i == 0)
		image = Toolkit.getDefaultToolkit().getImage("./Img/Yellow Border_1.png");
		else
		image = Toolkit.getDefaultToolkit().getImage("./Img/Yellow Border_2.png");
		MediaTracker tracker = new MediaTracker(this);
		tracker.addImage(image, 0);
		try {
			tracker.waitForID(0);
		}
		catch(InterruptedException exception) {}
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(image == null) return;

		g.drawImage(image, point.x, point.y, null);
	}
}
