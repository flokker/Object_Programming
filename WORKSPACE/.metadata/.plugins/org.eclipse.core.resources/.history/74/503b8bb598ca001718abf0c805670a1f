package Operation;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/** Class Description of Search.
* 
* <br>
* this class is for searching some locker information what user want from excel DB.
* this class get some data that input from SearchFrame, and find row number of that equals to data.
* 
* @author Myungho Bae
* @version 1.1
**/
public class Search {
	/** Stored information of data_set from SearchFrame Class **/
	String Cust[] = new String[5];
	
	/** Searching some locker information what user want
	* 
	* <br>
	* 
	* @param List<data_set> list
	* @param int enterCnt
	* @return void
	**/
	public void SearchLocker(data_set ds, int enterCnt) {
		Cust[0] = ds.getCustLock();
		Cust[1] = ds.getCustId();
		Cust[2] = ds.getCustName();
		Cust[3] = ds.getCustNum();
		Cust[4] = ds.getCustPeriod();		
		try {
			FileInputStream fis = new FileInputStream("D:\\db.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			int SearchArray[] = new int[rows];
			int ArrayNum = 0;
			int searchedCnt = 0;
			for (int rowIndex = 1; rowIndex < rows; rowIndex++) {
				searchedCnt = 0;
				XSSFRow row = sheet.getRow(rowIndex);
				if (row != null) {
					int cells = row.getPhysicalNumberOfCells();
					for (int columnIndex = 0; columnIndex < 5; columnIndex++) {
						XSSFCell cell = row.getCell(columnIndex);
						if(Cust[columnIndex].equals(cell.getStringCellValue())) {
							searchedCnt ++;
						}
					}
					if(searchedCnt == enterCnt) {
						SearchArray[ArrayNum] = rowIndex;
						ArrayNum ++;
						searchedCnt = 0;
					}					
				}
			}
			/*
			System.out.println("검색 결과 :");
			for(int i=0; i<ArrayNum; i++) {
				System.out.println(SearchArray[i]);				
			}
			//이곳에 draw method를 추가해야함
			*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}

