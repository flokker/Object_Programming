package Operation;


import java.util.Scanner; // Console로 입력 받기 위해 import, 추후 GUI기반으로 적용되면 삭제 요망
import java.util.ArrayList;
import java.util.List; //import to use list 

import Operation.data_set; //data_set class import
import Operation.ExcelWriter; //ExcelWriter class import

/**
 * Writing data in GUI & Writing in Excelsheet with Creats Excelwriter objects
 * history : June hyuk, 1.0 2017.10.14 initiate version
 * @author June hyuk, Myungho Bae
 * @since 2017.10.14 
 * @version 1.1 - 2017.11.08 add CustLock variable 
 */
public class MainApplication {

	public void excelWriting(data_set ds) {
		List<data_set> list = new ArrayList<data_set>();
		list.add(ds);

		ExcelWriter excelwriter = new ExcelWriter();

		excelwriter.xlsxWriter(list);
	}

	/**
	 * Operate program with create startApp object
	 * @param args
	 */
	public static void main(String[] args) {
		GUI.StartFrame startApp = new GUI.StartFrame();
	}
}