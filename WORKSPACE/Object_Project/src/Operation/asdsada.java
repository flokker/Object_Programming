package Operation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class asdsada {

	public static void main(String[] args) {
		// ��ũ�� ����
		XSSFWorkbook workbook = new XSSFWorkbook();
		// ��ũ��Ʈ ����
		XSSFSheet sheet = workbook.createSheet();
		// �� ����
		XSSFRow row = sheet.createRow(0);
		// �� ����
		XSSFCell cell;

		// ��� ���� ����
		cell = row.createCell(0);
		cell.setCellValue("���̵�");

		cell = row.createCell(1);
		cell.setCellValue("�̸�");

		cell = row.createCell(2);
		cell.setCellValue("����");

		cell = row.createCell(3);
		cell.setCellValue("�̸���");

		// ����Ʈ�� size ��ŭ row�� ����

		for(int rowIdx=0; rowIdx < 140; rowIdx++) {
			row = sheet.createRow((rowIdx)*2+1);
		
			cell = row.createCell(0);
			cell.setCellValue(Integer.toString(rowIdx+1));

			cell = row.createCell(1);
			cell.setCellValue(" ");

			cell = row.createCell(2);
			cell.setCellValue(" ");

			cell = row.createCell(3);
			cell.setCellValue(" ");

			cell = row.createCell(4);
			cell.setCellValue(" ");			
		}

		// �Էµ� ���� ���Ϸ� ����
		File file = new File("./ExcelSheet/db.xlsx");
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(workbook!=null) workbook.close();
				if(fos!=null) fos.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}
