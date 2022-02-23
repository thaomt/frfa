package exercise_1.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelUtils {
	public static Object[][] getValue(String FilePath){
		Object[][] data = new Object[3][2];
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(FilePath));
			Sheet sheet = workbook.getSheetAt(0);
			int j=1;
			for (int i = 0; i < 3; i++) {
				data[i][0] = sheet.getRow(j).getCell(2);
				data[i][1] = sheet.getRow(j).getCell(3);
				System.out.println(data[i][0]);
				System.out.println(data[i][1]);
				j++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	

}
