package object_project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import object_project.data_set;

public class ExcelReader {

	@SuppressWarnings("resource")
	public List<data_set> xlsxTodata_setList(String filePath) {
		List<data_set> list = new ArrayList<data_set>();

		FileInputStream fis = null;
		XSSFWorkbook workbook = null;

		try {
			fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);

			XSSFSheet curSheet;
			XSSFRow curRow;
			XSSFCell curCell;
			data_set ds;

			for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				curSheet = workbook.getSheetAt(sheetIndex);

				for (int rowIndex = 0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
					if (rowIndex != 0) {
						curRow = curSheet.getRow(rowIndex);
						ds = new data_set();
						String value;

						if (!"".equals(curRow.getCell(0).getStringCellValue())) {

							for (int cellIndex = 0; cellIndex < curRow.getPhysicalNumberOfCells(); cellIndex++) {
								curCell = curRow.getCell(cellIndex);

								if (true) {
									value = "";

									switch (curCell.getCellType()) {
									case XSSFCell.CELL_TYPE_FORMULA:
										value = curCell.getCellFormula();
										break;
									case XSSFCell.CELL_TYPE_NUMERIC:
										value = curCell.getNumericCellValue() + "";
										break;
									case XSSFCell.CELL_TYPE_STRING:
										value = curCell.getStringCellValue() + "";
										break;
									case XSSFCell.CELL_TYPE_BLANK:
										value = curCell.getBooleanCellValue() + "";
										break;
									case XSSFCell.CELL_TYPE_ERROR:
										value = curCell.getErrorCellValue() + "";
										break;
									default:
										value = new String();
										break;
									}

									switch (cellIndex) {
									case 0:
										ds.setCustId(value);
										break;

									case 1:
										ds.setCustName(value);
										break;
									case 2:
										ds.setCustNum(value);
										break;
									case 3:
										ds.setCustPeriod(value);
										break;

									default:
										break;
									}
								}
							}

							list.add(ds);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null)
					workbook.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
