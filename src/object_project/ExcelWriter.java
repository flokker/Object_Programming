package object_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List; // import for list use

import org.apache.poi.xssf.usermodel.XSSFCell; //9~12 apache poi import
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import object_project.data_set;

public class ExcelWriter {
	
	public void xlsxWriter(List<data_set> list) {
		// create object for return
		XSSFWorkbook workbook = new XSSFWorkbook(); // create xssfworkbook object include whole data

		XSSFSheet sheet = workbook.createSheet(); // create (sheet,row,cell) object for search
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell;
		
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
		// "for roop" for search row  
		for (int rowIdx = 0; rowIdx < list.size(); rowIdx++) {
			ds = list.get(rowIdx);

			row = sheet.createRow(rowIdx + 1);

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

			//  write in file with input data
			File file = new File("D:\\project\\db.xlsx");
			FileOutputStream fos = null;

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
					if (workbook != null) // finally���� ����
						workbook.close();
					if (fos != null)
						fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}
}
