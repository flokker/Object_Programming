package object_project;

import java.util.Scanner; // Console�� �Է� �ޱ� ���� import, ���� GUI������� ����Ǹ� ���� ���
import java.util.ArrayList;
import java.util.List; //import to use list 

import object_project.data_set; //data_set class import
import object_project.ExcelWriter; //ExcelWriter class import

public class MainApplication {

//main class for input and return to Excelwriter class
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		// Sysoutâ ���� console������� �ۼ��� ���̹Ƿ�, ���� GUI ����Ǹ� ���� ���
		System.out.println("�繰�� ��ȣ�� �Է��� �ּ���");
		String CustRock = sc.next();
		System.out.println("�й��� �Է����ּ���");
		String CustId = sc.next();
		System.out.println("�̸��� �Է����ּ���");
		String CustName = sc.next();
		System.out.println("����ó�� �Է����ּ��� (- ����)");
		String CustNum = sc.next();
		System.out.println("��� ������ �Է����ּ��� (yymmdd ��������)");
		String CustPeriod = sc.next();

		List<data_set> list = new ArrayList<data_set>(); // create list object
		list.add(new data_set(CustRock, CustId, CustName, CustNum, CustPeriod)); // add in list id,name,num,peroid

		ExcelWriter excelwriter = new ExcelWriter();

		excelwriter.xlsxWriter(list); // write the file with xlsx format
	}

}
