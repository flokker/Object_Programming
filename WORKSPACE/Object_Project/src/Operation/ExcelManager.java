package Operation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
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

	public void excelWriting(data_set ds, int i) {
		List<data_set> list = new ArrayList<data_set>();
		list.add(ds);

		ExcelWriter excelwriter = new ExcelWriter();

		excelwriter.xlsxWriter(list, i);
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
		data_set ds = new data_set(locknumber + "","","","","");
		
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
		String leftPeriod = "";
		try {
			FileInputStream fis = new FileInputStream("./ExcelSheet/db.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(rowid);
			XSSFCell cell = row.getCell(5);
			leftPeriod = cell.getStringCellValue();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return leftPeriod;
	}
}