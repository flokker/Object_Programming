package Operation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List; //import to use list 

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Operation.data_set; //data_set class import
import Operation.ExcelWriter; //ExcelWriter class import

/**
 * Writing data in GUI & Writing in Excelsheet with Creats Excelwriter objects
 * history : June hyuk, 1.0 2017.10.14 initiate version
 * 
 * @author June hyuk, Myungho Bae
 * @since 2017.10.14
 * @version 1.1 - 2017.11.08 add CustLock variable
 **/
public class ExcelManager {

	public void excelWriting(data_set ds, int rowid) {
		List<data_set> list = new ArrayList<data_set>();
		list.add(ds);

		ExcelWriter excelwriter = new ExcelWriter();

		excelwriter.xlsxWriter(list, rowid);
	}

	/**
	 * Operating SearchLocker method in ExcelSearcher class.
	 * 
	 * <br>
	 * 
	 * @param List<data_set>
	 *            list
	 * @param int
	 *            enterCnt
	 * @return void
	 * @author Myungho Bae
	 **/
	public int[] excelSearhing(data_set ds, int count) {
		List<data_set> list = new ArrayList<data_set>();
		list.add(ds);

		ExcelSearcher excelsearcher = new ExcelSearcher();

		return excelsearcher.SearchLocker(list, count);
	}

	/**
	 * Returns row ID with locker number in Excel DB.
	 * 
	 * <br>
	 * This class find row ID by using excelSearching method.
	 * 
	 * @param int rowid
	 * @return String
	 * @author Myungho Bae
	 **/
	public int getRowID(int locknumber) {
		data_set ds = new data_set(Integer.toString(locknumber),"","","","");
		
		return excelSearhing(ds, 1)[0];
	}

	/**
	 * Returns locker ID from row ID in Excel DB.
	 * 
	 * <br>
	 * 
	 * @param int rowid
	 * @return String
	 * @author Myungho Bae
	 **/
	public String getLockerID(int rowid) {
		String LockerID = "";
		try {
			FileInputStream fis = new FileInputStream("./ExcelSheet/db.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(rowid);
			XSSFCell cell = row.getCell(0);
			LockerID = cell.getStringCellValue();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return LockerID;
	}

	/**
	 * Returns left period of locker.
	 * 
	 * <br>
	 * 
	 * @param int rowid
	 * @return String
	 * @author Myungho Bae
	 **/
	public String getLeftPeriod(int rowid) {
		String Period = "0";
		int leftPeriod = 0;
		try {
			FileInputStream fis = new FileInputStream("./ExcelSheet/db.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(rowid);
			XSSFCell cell = row.getCell(4);
			Period = cell.getStringCellValue();
			if(Period.equals("ªË¡¶ µ "))
				return "0";			
			Calendar now = GUI.StartFrame.now;
			int nowday = ((now.getTime().getYear() % 100)*100+(now.getTime().getMonth()+1))*100 + now.getTime().getDate();
			leftPeriod = Integer.parseInt(Period);
			leftPeriod -= nowday;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return leftPeriod + "";
		
	}
}