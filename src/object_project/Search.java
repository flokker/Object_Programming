package object_project;

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
* this class is for searching some locker information what user want from excel DB
* 
* @author Myungho Bae
* @version 1.0
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
	public void SearchLocker(List<data_set> list, int enterCnt) {
		try {
			FileInputStream fis = new FileInputStream("D:\\db.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			int SearchArray[] = new int[rows];
			int ArrayNum = 0;
			int searchedCnt = 0;
			for (int rowIndex = 1; rowIndex <= rows; rowIndex++) {
				searchedCnt = 0;
				XSSFRow row = sheet.getRow(rowIndex);
				if (row != null) {
					int cells = row.getPhysicalNumberOfCells();
					for (int columnIndex = 0; columnIndex < cells; columnIndex++) {
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
			System.out.println("�˻� ��� :");
			for(int i=0; i<ArrayNum; i++) {
				System.out.println(SearchArray[i]);				
			}
			�̰��� draw method�� �߰��ؾ���
			*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}

