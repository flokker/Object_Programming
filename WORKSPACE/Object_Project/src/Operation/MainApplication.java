package Operation;


import java.util.Scanner; // Console로 입력 받기 위해 import, 추후 GUI기반으로 적용되면 삭제 요망
import java.util.ArrayList;
import java.util.List; //import to use list 

import Operation.data_set; //data_set class import
import Operation.ExcelWriter; //ExcelWriter class import

/**
 * GUI 환경에서 데이터를 작성하고, Excelwriter 객체를 생성하여 엑셀 시트로 작성
 * history : June hyuk, 1.0 2017.10.14 초기 작성
 * @author June hyuk Myungho Bae
 * @since 2017.10.14 
 * @version 1.1 - 2017.11.08 CustLock변수 추가 
 */
public class MainApplication {

	public void excelWriting(data_set ds) {
		List<data_set> list = new ArrayList<data_set>();
		list.add(ds);

		ExcelWriter excelwriter = new ExcelWriter();

		excelwriter.xlsxWriter(list);
	}

	/**
	 * startApp객체를 생성하여 프로그램 구동 
	 * @param args
	 */
	public static void main(String[] args) {
		GUI.StartFrame startApp = new GUI.StartFrame();
	}
}