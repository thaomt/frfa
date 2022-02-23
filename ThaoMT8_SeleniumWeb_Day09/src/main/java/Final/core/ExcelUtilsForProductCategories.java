package Final.core;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsForProductCategories {
	static XSSFWorkbook ExcelWBook;
	public static Object[][] getValueForTest03_2(String FilePath,String sheets) throws IOException{
		FileInputStream ExcelFile = new FileInputStream(FilePath);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		Object[][] data = new Object[1][4];
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(FilePath));
			Sheet sheet = workbook.getSheet(sheets);			
				data[0][0] = sheet.getRow(1).getCell(2);
				data[0][1] = sheet.getRow(1).getCell(3);
				data[0][2] = sheet.getRow(1).getCell(4);
				data[0][3] = sheet.getRow(1).getCell(5);			
	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	public static Object[][] getValueForTest03_3(String FilePath,String sheets) throws IOException{
		FileInputStream ExcelFile = new FileInputStream(FilePath);
		// Access the required test data sheet
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		Object[][] data = new Object[1][4];
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(FilePath));
			Sheet sheet = workbook.getSheet(sheets);			
				data[0][0] = sheet.getRow(2).getCell(1);
				data[0][1] = sheet.getRow(2).getCell(2);
				data[0][2] = sheet.getRow(2).getCell(3);
				data[0][3] = sheet.getRow(2).getCell(5);			
	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	public static Object[][] getValueForTest04(String FilePath,String sheets) throws IOException{
		FileInputStream ExcelFile = new FileInputStream(FilePath);
		// Access the required test data sheet
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		Object[][] data = new Object[1][4];
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(FilePath));
			Sheet sheet = workbook.getSheet(sheets);			
				data[0][0] = sheet.getRow(3).getCell(1);
				data[0][1] = sheet.getRow(3).getCell(2);
				data[0][2] = sheet.getRow(3).getCell(4);
				data[0][3] = sheet.getRow(3).getCell(5);			
	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
