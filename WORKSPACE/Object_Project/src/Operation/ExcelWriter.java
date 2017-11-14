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

public class ExcelWriter {
	/*
	 * return list<data_set> object return to xlsx file. 
	 */
	public void xlsxWriter(List<data_set> list) {
		// create object for return		
		//  write in file with input data
		File file = new File("D:\\db.xlsx");
		FileOutputStream fos = null;
		FileInputStream fis = null;
		
		XSSFWorkbook workbook = new XSSFWorkbook(); // create xssfworkbook object include whole data
		XSSFSheet sheet = workbook.createSheet(); // create (sheet,row,cell) object for search
		XSSFCell cell;
		XSSFRow row;
		int rows = 0;
			
		// 엑셀파일 읽기
		try {
	        fis = new FileInputStream(file);
	        workbook = new XSSFWorkbook(fis);
	        sheet = workbook.getSheetAt(0);
			rows = sheet.getPhysicalNumberOfRows();
			System.out.println(rows);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 엑셀파일 쓰기
		
		// 헤더 작성
		row = sheet.createRow(0);

		cell = row.createCell(0);
		cell.setCellValue("사물함번호");
		
		cell = row.createCell(1);
		cell.setCellValue("학번");

		cell = row.createCell(2);
		cell.setCellValue("이름");

		cell = row.createCell(3);
		cell.setCellValue("연락처");

		cell = row.createCell(4);
		cell.setCellValue("사용기한");
		
		// 새 정보 작성
		data_set ds;
		ds = list.get(0);
		if(rows == 0) rows = 1;
		row = sheet.createRow(rows);

		cell = row.createCell(0);
		cell.setCellValue(ds.getCustRock());
		
		cell = row.createCell(1);
		cell.setCellValue(ds.getCustId());

		cell = row.createCell(2);
		cell.setCellValue(ds.getCustName());

		cell = row.createCell(3);
		cell.setCellValue(ds.getCustNum());

		cell = row.createCell(4);
		cell.setCellValue(ds.getCustPeriod());

		// try-catch structure
		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null) // finally에서 해제
					workbook.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
