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
* ������ �̿��Ͽ� ������ ������ ����Ʈ ���·� �ۼ��ϱ� ���� Ŭ����
* @since 
* @author June hyuk, Myungho Bae
* @version 1.1
**/
public class ExcelWriter {

	public void xlsxWriter(List<data_set> list) {

		File file = new File("./ExcelSheet/db.xlsx");
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
		cell.setCellValue("�繰�Թ�ȣ");
		
		cell = row.createCell(1);
		cell.setCellValue("�й�");

		cell = row.createCell(2);
		cell.setCellValue("�̸�");

		cell = row.createCell(3);
		cell.setCellValue("����ó");

		cell = row.createCell(4);
		cell.setCellValue("������");
		
		data_set ds;
		ds = list.get(0);
		if(rows == 0) rows = 1;
		row = sheet.createRow(rows);

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
