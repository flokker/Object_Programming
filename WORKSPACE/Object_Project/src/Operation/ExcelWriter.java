package Operation;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List; // import for list use

import org.apache.poi.xssf.usermodel.XSSFCell; //9~12 apache poi import
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Operation.data_set;

/** 
* 엑셀을 이용하여 데이터 값들을 리스트 형태로 작성하기 위한 클래스
* This class = Using Excel for write data in list form
* @since 2017-10-14
* @author June hyuk, Myungho Bae
* @version 1.1 
**/
public class ExcelWriter {
	private File file;
	private FileOutputStream fos;
	private FileInputStream fis;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFCell cell;
	private XSSFRow row;
	private int rows;
	final static int total_rows = 136;

	public ExcelWriter() {
		file = new File("./ExcelSheet/db.xlsx");
		fos = null;
		fis = null;
		
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet();
		
		rows = 0;
		
		try {
	        fis = new FileInputStream(file);
	        workbook = new XSSFWorkbook(fis);
	        sheet = workbook.getSheetAt(0);
			rows = sheet.getPhysicalNumberOfRows();
			System.out.println(rows);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void xlsxWriter(List<data_set> list, int i) {

//		row = sheet.createRow(0);
//
//		cell = row.createCell(0);
//		cell.setCellValue("사물함번호");
//		
//		cell = row.createCell(1);
//		cell.setCellValue("학번");
//
//		cell = row.createCell(2);
//		cell.setCellValue("이름");
//
//		cell = row.createCell(3);
//		cell.setCellValue("연락처");
//
//		cell = row.createCell(4);
//		cell.setCellValue("사용기한");
//		
//		data_set ds;
//		ds = list.get(0);
//		row = sheet.createRow(rowid);
//
//		cell = row.createCell(0);
//		cell.setCellValue(ds.getCustLock());
//		
//		cell = row.createCell(1);
//		cell.setCellValue(ds.getCustId());
//
//		cell = row.createCell(2);
//		cell.setCellValue(ds.getCustName());
//
//		cell = row.createCell(3);
//		cell.setCellValue(ds.getCustNum());
//
//		cell = row.createCell(4);
//		cell.setCellValue(ds.getCustPeriod());

		
		rows = excelSearch(list.get(0).getCustLock(), 0, total_rows);
		excelDelete(rows+i);
		excelInsert(list.get(0), rows+i);
		
		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null)
					workbook.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	public void excelDelete(int rows) {
		this.row = sheet.getRow(rows);
		for(int i = 1; i < 6; i++)
			cell = row.createCell(i);
	}
	
	public int excelSearch(String num, int left, int right) {
		if(left > right) return -1;
		int m = (left + right)/2;
		String s = sheet.getRow(m*2).getCell(0).getStringCellValue();
		int id = Integer.parseInt(s); 
		int numid = Integer.parseInt(num);
		if(id == numid) return m;
		if(id > numid) return excelSearch(num, m+1, right);
		return excelSearch(num, left, m-1);
	}//2진검색 writer전용
	
	public void excelInsert(data_set ds, int rows) {
		row = sheet.createRow(rows);
		if(ds.getCustName().equals("삭제 됨")){
			for(int i = 1; i < 6; i++)
				cell = row.createCell(i);
			return;
		}
		cell = row.createCell(1);
		cell.setCellValue(ds.getCustId());
		
		cell = row.createCell(2);
		cell.setCellValue(ds.getCustName());
		
		cell = row.createCell(3);
		cell.setCellValue(ds.getCustNum());
		
		cell = row.createCell(4);
		cell.setCellValue(ds.getCustPeriod());
	}
}
