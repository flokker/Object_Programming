package Operation;

import java.util.ArrayList;
import java.util.List; //import to use list 

import Operation.ExcelWriter;
import Operation.data_set;

/** Class Description of MainApplication.
* 
* <br>
* this class is for run program firstly.
* if you run this program, this class make StartFrame instance, 
* and the instance show you start frame.
*
* @author Junhyuk Jang, Myungho Bae
* @version 2.0
**/
public class MainApplication {

	public void excelWriting(data_set ds) {
		List<data_set> list = new ArrayList<data_set>();
		list.add(ds);

		ExcelWriter excelwriter = new ExcelWriter();

		excelwriter.xlsxWriter(list);
	}

	public static void main(String[] args) {
		GUI.StartFrame startApp = new GUI.StartFrame();
	}
}