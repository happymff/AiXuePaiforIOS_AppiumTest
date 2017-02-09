package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

/**
 * tedu.cn
 * @author zhengxj
 *
 */
public class ReadExcelJXL{
	
	  /* 
	   * ���Excel���ݣ���װΪ@DataProvider��Ҫ������Object[][]
	   * filePath:�ļ�·��
	   * fileName:�ļ�����
	   * sheetName:������
	   */
		public  Object[][] getTestData(String filePath, String fileName,
				String sheetName) throws IOException {
			try {
				String path = filePath + "\\" + fileName;
				InputStream inputStream = new FileInputStream(path);
				Workbook book = Workbook.getWorkbook(inputStream);
				Sheet sheet = book.getSheet(sheetName);
				int rowCount = sheet.getRows();
				//System.out.println("����="+rowCount);
				int columnCount = sheet.getRow(0).length;
				//System.out.println("����="+columnCount);
				String content[][] = new String[rowCount-1][columnCount];

				for(int i=0;i<rowCount-1;i++){
					Cell[] celli = sheet.getRow(i+1);
					for (int j = 0; j < columnCount; j++) {
						if(j>=celli.length  || celli[j].getType() == CellType.EMPTY){
							content[i][j] = "";
						}else{
							content[i][j] = celli[j].getContents();
						}
					}
				}
				return content;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}	
}
