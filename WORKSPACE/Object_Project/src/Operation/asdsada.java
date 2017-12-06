package Operation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class asdsada {

	public static void main(String[] args) {
		// 워크북 생성
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 워크시트 생성
		XSSFSheet sheet = workbook.createSheet();
		// 행 생성
		XSSFRow row = sheet.createRow(0);
		// 쎌 생성
		XSSFCell cell;

		// 헤더 정보 구성
		cell = row.createCell(0);
		cell.setCellValue("아이디");

		cell = row.createCell(1);
		cell.setCellValue("이름");

		cell = row.createCell(2);
		cell.setCellValue("나이");

		cell = row.createCell(3);
		cell.setCellValue("이메일");

		// 리스트의 size 만큼 row를 생성

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

		// 입력된 내용 파일로 쓰기
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
