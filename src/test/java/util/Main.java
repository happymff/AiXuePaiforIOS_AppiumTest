package util;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * etiantian.com
 * @author mengfeifei
 *
 */
public class Main {

	public static void main(String args[]) throws  Exception {
//		ReadExcelPOI readExcelPOI = new ReadExcelPOI();
//		Object[][] s1 = readExcelPOI.getTestData("/Users/mengfeifei/Desktop/workspace","TestData.xlsx","data");

		ReadExcelJXL readExcelJXL = new ReadExcelJXL();
		Object[][] s1 = readExcelJXL.getTestData("/Users/mengfeifei/Desktop/workspace","TestData.xls","data");

		System.out.println(s1[0][0]);
	}

}
