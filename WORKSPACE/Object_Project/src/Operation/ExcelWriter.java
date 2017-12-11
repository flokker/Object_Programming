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
	
	public String path;

	public ExcelWriter() {
		path = ExcelManager.class.getResource("").getPath();

	}

	public void xlsxWriter(List<data_set> list, int rowid) {

		File file = new File(System.getProperty("user.dir")+"/db.xlsx");
		FileOutputStream fos = null;
		FileInputStream fis = null;
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		XSSFCell cell;
		XSSFRow row;
		int rows = 0;
			
		try {
	        fis = new FileInputStream(file);
	        workbook = new XSSFWorkbook(fis);
	        sheet = workbook.getSheetAt(0);
			rows = sheet.getPhysicalNumberOfRows();
			System.out.println(rows);
		} catch (IOException e) {
			e.printStackTrace();
		}

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
		
		data_set ds;
		ds = list.get(0);
		row = sheet.createRow(rowid);

		cell = row.createCell(0);
		cell.setCellValue(ds.getCustLock());
		
		cell = row.createCell(1);
		cell.setCellValue(ds.getCustId());

		cell = row.createCell(2);
		cell.setCellValue(ds.getCustName());

		cell = row.createCell(3);
		cell.setCellValue(ds.getCustNum());

		cell = row.createCell(4);
		cell.setCellValue(ds.getCustPeriod());

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
	
}
