package Operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List; //import to use list 

import javax.swing.JOptionPane;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import GUI.StartFrame;
import Operation.data_set; //data_set class import
import Operation.ExcelWriter; //ExcelWriter class import

/**
 * Writing data in GUI and Writing in Excelsheet with Creats Excelwriter objects
 * <br>
 * history : June hyuk, 1.0 2017.10.14 initiate version
 * 
 * @author June hyuk, Myungho Bae
 * @since 2017.10.14
 * @version 1.1 - 2017.11.08 add CustLock variable
 * 
 *
 */
public class ExcelManager {

	public String path;
	
	public ExcelManager() {
		path = ExcelManager.class.getResource("").getPath();

	}

	public void excelWriting(data_set ds, int rowid) {
		List<data_set> list = new ArrayList<data_set>();
		list.add(ds);

		ExcelWriter excelwriter = new ExcelWriter();

		excelwriter.xlsxWriter(list, rowid);
	}

	/**
	 * Operating SearchLocker method in ExcelSearcher class.
	 * @author Myungho Bae
	 * @param ds - ds is data_set's object 
	 * @param count - number's of category that user's select
	 * @return - search's result
	 */
	public int[] excelSearhing(data_set ds, int count) {
		List<data_set> list = new ArrayList<data_set>();
		list.add(ds);

		ExcelSearcher excelsearcher = new ExcelSearcher();

		return excelsearcher.SearchLocker(list, count);
	}


	/**
	 * Returns row ID with locker number in Excel DB.
	 * This class find row ID by using excelSearching method.
	 * <br>
	 * @author Myungho Bae
	 * @param locknumber - this param means locknumber
	 * @return - this means result of return excelsearching
	 */
	public int getRowID(int locknumber) {
		data_set ds = new data_set(Integer.toString(locknumber),"","","","");
		
		return excelSearhing(ds, 1)[0];
	}

	/**
	 * Returns locker ID from row ID in Excel DB.
	 * @author Myungho Bae
	 * @param rowid - this param means rowid value
	 * @return - return LockerId
	 */
	public String getLockerID(int rowid) {
		String LockerID = "";
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/db.xlsx");
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
	 * @author Myungho Bae
	 * @param rowid - this param means rowid value
	 * @return - return leftperiod for rowid
	 */
	public int getLeftPeriod(int rowid) {
		String Period;
		int leftPeriod = 0;
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/db.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(rowid);
			XSSFCell cell = row.getCell(4);
			Period = cell.getStringCellValue();
			if(Period.equals("deleted") || Period.equals("0"))
				leftPeriod = 0;
			else {
				Calendar now = Calendar.getInstance();		
				int nowday = ((now.get(Calendar.YEAR) % 100)*100+now.get(Calendar.MONTH)+1)*100 +now.get(Calendar.DATE);	
				leftPeriod = Integer.parseInt(Period.trim());
				leftPeriod -= nowday;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return leftPeriod;
	}
}