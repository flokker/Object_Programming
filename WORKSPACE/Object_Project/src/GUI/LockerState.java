package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

import Operation.*;
/**
 * This is a class to let you know if the Locker is present or not.
 * <br>
 * If the boolean is false, the state of the locker is represented by red, orange, and green.
 * If the selected boolean is true, it is represented in yellow.
 * 
 * @author Yongho Kim
 * @since 2017-12-07
 * @version 1.0
 */
public class LockerState extends JPanel{
	/**	Variable that receives the image */
	private Image image;
	/**	Variables receiving the remaining time */
	private int period1;
	private int period2;
	/**	Variable that receives data_set */
	private data_set d;
	/**	Variable to receive the current date */
	Calendar now;
	private ExcelManager excel;
	/**
	 * index tells you how many of these lockers are on the screen, and if the boolean is true, the color is yellow; if it is false, the red, orange, or green color is displayed.
	 * @param index
	 * @param selected
	 */
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
	/**
	 * 
	 * index tells you how many of these lockers are on the screen, and if the boolean is true, the color is yellow; if it is false, the red, orange, or green color is displayed.
	 * In this case, we added an int value that is not used for overloading because we need to compare the two data because there is two periods in one data.
	 * @param int index
	 * @param boolean selected
	 * @param int i
	 */
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
	/**
	 * The method that returns the actual locker number
	 * when you insert the number of the locker on the screen.
	 * 
	 * @param int i
	 * @return int
	 */
	private int getLockID(int i) {
		int num = Current.current;
		if (num > 0) {
			num += 4;
		} else {
			num = (num * -1) - 1;
		}
		return ((num + 1) / 2) * 12 + (num / 2) * 16 + 1 + i;
	}
	/**
	 * The implementation part of the abstract to implement JButton
	 * @param Graphics g
	 * @return void;
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(image == null) return;

		g.drawImage(image, 0, 0, null);
	}
}
