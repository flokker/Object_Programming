package Operation;

import java.util.ArrayList;
import java.util.List; //import to use list 

import Operation.data_set; //data_set class import
import Operation.ExcelWriter; //ExcelWriter class import

/**
<<<<<<< HEAD
 * Writing data in GUI & Writing in Excelsheet with Creats Excelwriter objects
 * history : June hyuk, 1.0 2017.10.14 initiate version
 * @author June hyuk, Myungho Bae
 * @since 2017.10.14 
 * @version 1.1 - 2017.11.08 add CustLock variable 
=======
 * GUI ȯ�濡�� �����͸� �ۼ��ϰ�, Excelwriter ��ü�� �����Ͽ� ���� ��Ʈ�� �ۼ�
 * history : June hyuk, 1.0 2017.10.14 �ʱ� �ۼ�
 * @author June hyuk, Myungho Bae
 * @since 2017.10.14 
 * @version 1.2
>>>>>>> eddad522829d2553a99ffb87f9e82d61f0e86519
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
	 * Operate program with create startApp object
	 * @param args
	 */
	public static void main(String[] args) {
		GUI.StartFrame startApp = new GUI.StartFrame();
	}
}