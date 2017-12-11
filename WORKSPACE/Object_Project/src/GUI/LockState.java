package GUI;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.util.Calendar;

import Operation.*;

public class LockState {
	ExcelManager excelManager = new ExcelManager();
	Border border;
	
	int getLockerState(int lockerNumber) {
		int result = 0; // 0=신청가능 1=기간조금남은 2=신청불가
		int period = excelManager.getLeftPeriod(excelManager.getRowID(lockerNumber));
		if(period > 15)
			result = 2;
		else if(period > 0)
			result = 1;
		else
			result = 0;
		
		System.out.println(excelManager.getRowID(lockerNumber));
		return result;
	}
	
	void drawSearchingResult(int[] rowid) {
		int lockernumber;
		for(int i=0; i<rowid.length; i++) {
			lockernumber = rowid[i];
			
		}
	}
	
	void drawButtonBorder(JButton[] btn) {
		int num = getLockerNumOfZero(Current.current);
		resetDrawingButtonBorder(btn);
		for(int i=0; i<btn.length; i++) {
			int state = getLockerState(((num + 1) / 2) * 12 + (num / 2) * 16 + 1 + i);
			if(state == 0)
				border = BorderFactory.createLineBorder(Color.GREEN, 3);	
			else if(state == 1)
				border = BorderFactory.createLineBorder(Color.ORANGE, 3);
			else if(state == 2)
				border = BorderFactory.createLineBorder(Color.RED, 3);

			btn[i].setBorder(border);
			btn[i].repaint();
		}
	}
	
	
	
	
	void resetDrawingButtonBorder(JButton[] btn) {
		for(int i=0; i<btn.length; i++) {
			border = BorderFactory.createLineBorder(Color.WHITE, 0);
			btn[i].setBorder(border);			
		}
	}
	
	private int getLockerNumOfZero(int areaNumber) {
		int result = 0;
		if (areaNumber > 0) {
			result = areaNumber + 4;
		} else {
			result = (areaNumber * -1) - 1;
		}
		return result;
	}
}
