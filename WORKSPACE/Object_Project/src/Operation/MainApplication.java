package Operation;


import java.util.Scanner; // Console�� �Է� �ޱ� ���� import, ���� GUI������� ����Ǹ� ���� ���
import java.util.ArrayList;
import java.util.List; //import to use list 

import Operation.data_set; //data_set class import
import Operation.ExcelWriter; //ExcelWriter class import

/**
 * GUI ȯ�濡�� �����͸� �ۼ��ϰ�, Excelwriter ��ü�� �����Ͽ� ���� ��Ʈ�� �ۼ�
 * history : June hyuk, 1.0 2017.10.14 �ʱ� �ۼ�
 * @author June hyuk Myungho Bae
 * @since 2017.10.14 
 * @version 1.1 - 2017.11.08 CustLock���� �߰� 
 */
public class MainApplication {

	public void excelWriting(data_set ds) {
		List<data_set> list = new ArrayList<data_set>();
		list.add(ds);

		ExcelWriter excelwriter = new ExcelWriter();

		excelwriter.xlsxWriter(list);
	}

	/**
	 * startApp��ü�� �����Ͽ� ���α׷� ���� 
	 * @param args
	 */
	public static void main(String[] args) {
		GUI.StartFrame startApp = new GUI.StartFrame();
	}
}