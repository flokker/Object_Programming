/*
** 정리 후에 커멘트 작성할 예정 **

	* 프로그램 흐름 *
		1. 유저가 입력한 조건 검색어 만큼 searcheed 변수의 값이 1 증가. (searcheed = 검색할 조건의 갯수)
		2. 엑셀시트를 InputStream으로 열고 각 행마다 열의 내용과 사용자가 입력한 검색어를 비교
		3. 각 열의 내용이 일치할때마다 nowSearch 변수의 값이 1 증가 (nowSearch = 일치한 검색어의 갯수)
		4. 따라서 nowSearch 와 searcheed가 일치할 경우 그 행은 사용자가 원하는 검색결과
		5. 엑셀시트의 최대 행만큼 배열을 만들고 그 배열안에는 검색결과와 일치하는 행의 번호를 저장

*/
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


public class Search {
	static int searcheed = 0;
	static String[] Cust = new String[4];

	Search(List<data_set> list) {
		
		try {
			FileInputStream fis = new FileInputStream("D:\\db.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			data_set ds = list.get(0);			
			int SearchArray[] = new int[rows];
			int ArrayNum = 0;
			int nowSearch = 0;
			for (int rowIndex = 1; rowIndex < rows; rowIndex++) {
				nowSearch = 0;
				XSSFRow row = sheet.getRow(rowIndex); // 각 행을 읽어온다
				if (row != null) {
					int cells = row.getPhysicalNumberOfCells();
					for (int columnIndex = 0; columnIndex < cells; columnIndex++) {
						XSSFCell cell = row.getCell(columnIndex); // 셀에 담겨있는 값을 읽는다.
						
						if(columnIndex == 0) {
							if(ds.getCustId().equals(String.valueOf(new Double(cell.getNumericCellValue()).intValue()))) {
								nowSearch ++;
							}
						}
						else if(columnIndex == 1) {
							if(ds.getCustName().equals(cell.getStringCellValue())) {
								nowSearch ++;
							}
						}
						else if(columnIndex == 2) {
			
							if(ds.getCustNum().equals(String.valueOf(new Double(cell.getNumericCellValue()).intValue()))) {
								nowSearch ++;
							}
						}	
						else if(columnIndex == 3) {
							if(ds.getCustPeriod().equals(String.valueOf(new Double(cell.getNumericCellValue()).intValue()))) {
								nowSearch ++;
							}
						}
						if(nowSearch == searcheed) {
							SearchArray[ArrayNum] = rowIndex;
							ArrayNum ++;
							nowSearch = 0;
						}
					}
				}
			}
			System.out.println("검색 결과 :");
			for(int i=0; i<ArrayNum; i++) {
				System.out.println(SearchArray[i]);				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("학번을 입력해주세요");
		Cust[0] = sc.next(); 
		if(!Cust[0].equals("0")) {
			searcheed ++;
		}
		System.out.println("이름을 입력해주세요");
		Cust[1] = sc.next(); 
		if(!Cust[1].equals("0")) {
			searcheed ++;
		}		
		System.out.println("연락처를 입력해주세요 (- 없이)");
		Cust[2] = sc.next(); 
		if(!Cust[2].equals("0")) {
			searcheed ++;
		}				
		System.out.println("사용 기한을 입력해주세요 (yymmdd 형식으로)");
		Cust[3] = sc.next(); 
		if(!Cust[3].equals("0")) {
			searcheed ++;
		}

		List<data_set> list = new ArrayList<data_set>(); // create list object
		list.add(new data_set(Cust[0],Cust[1], Cust[2],Cust[3])); // add in list id,name,num,peroid 
		
		Search ser = new Search(list);
	}
}