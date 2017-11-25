package Operation;

import java.util.ArrayList;
import java.util.List; //import to use list 

import Operation.data_set; //data_set class import
import Operation.ExcelWriter; //ExcelWriter class import

/**
 * GUI 환경에서 데이터를 작성하고, Excelwriter 객체를 생성하여 엑셀 시트로 작성
 * history : June hyuk, 1.0 2017.10.14 초기 작성
 * @author June hyuk, Myungho Bae
 * @since 2017.10.14 
 * @version 1.2
 */
public class MainApplication {

	public void excelWriting(data_set ds) {
		List<data_set> list = new ArrayList<data_set>();
		list.add(ds);

		ExcelWriter excelwriter = new ExcelWriter();

		excelwriter.xlsxWriter(list);
	}
	
	/** Operating SearchLocker method in ExcelSearcher class.
	* 
	* <br>
	* 
	* @param List<data_set> list
	* @param int enterCnt
	* @return void
	* @author Myungho Bae
	**/	
	public void excelSearhing(data_set ds, int count) {
		List<data_set> list = new ArrayList<data_set>();
		list.add(ds);

		ExcelSearcher excelsearcher = new ExcelSearcher();

		excelsearcher.SearchLocker(list, count);		
	}

	/**
	 * startApp객체를 생성하여 프로그램 구동 
	 * @param args
	 */
	public static void main(String[] args) {
		GUI.StartFrame startApp = new GUI.StartFrame();
	}
}