package object_project;

import java.util.List;

import object_project.data_set;
import object_project.ExcelReader;

public class ReaderApplication {

	public static void main(String[] args) {
		ExcelReader excelreader = new ExcelReader();

		System.out.println("¿˙¿Âµ» list");
		List<data_set> xlsxList = excelreader.xlsxTodata_setList("D:\\project\\db.xlsx");
		printList(xlsxList);

	}

	public static void printList(List<data_set> list) {
		data_set set;

		for (int i = 0; i < list.size(); i++) {
			set = list.get(i);
			System.out.println(set.toString());
		}
	}
}
