package object_project;

import java.util.Scanner; // Console로 입력 받기 위해 import, 추후 GUI기반으로 적용되면 삭제 요망
import java.util.ArrayList;
import java.util.List; //import to use list 

import object_project.data_set; //data_set class import
import object_project.ExcelWriter; //ExcelWriter class import

public class MainApplication {

//main class for input and return to Excelwriter class
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		// Sysout창 역시 console기반으로 작성한 것이므로, 추후 GUI 적용되면 변경 요망
		System.out.println("사물함 번호를 입력해 주세요");
		String CustRock = sc.next();
		System.out.println("학번을 입력해주세요");
		String CustId = sc.next();
		System.out.println("이름을 입력해주세요");
		String CustName = sc.next();
		System.out.println("연락처를 입력해주세요 (- 없이)");
		String CustNum = sc.next();
		System.out.println("사용 기한을 입력해주세요 (yymmdd 형식으로)");
		String CustPeriod = sc.next();

		List<data_set> list = new ArrayList<data_set>(); // create list object
		list.add(new data_set(CustRock, CustId, CustName, CustNum, CustPeriod)); // add in list id,name,num,peroid

		ExcelWriter excelwriter = new ExcelWriter();

		excelwriter.xlsxWriter(list); // write the file with xlsx format
	}

}
