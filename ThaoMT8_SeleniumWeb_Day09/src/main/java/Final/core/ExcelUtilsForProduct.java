package Final.core;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsForProduct {
	static XSSFSheet ExcelWSheet;
    static XSSFWorkbook ExcelWBook;
	public static Object[][] getValue06(String FilePath, String sheets) throws IOException {
		FileInputStream ExcelFile = new FileInputStream(FilePath);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		Object[][] data = new Object[1][7];
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(FilePath));
			Sheet sheet = workbook.getSheet(sheets);			
				data[0][0] = sheet.getRow(1).getCell(2);
				data[0][1] = sheet.getRow(1).getCell(3);
				data[0][2] = sheet.getRow(1).getCell(4);
				data[0][3] = sheet.getRow(1).getCell(5);
				data[0][4] = sheet.getRow(1).getCell(6);
				data[0][5] = sheet.getRow(1).getCell(7);
				data[0][6] = sheet.getRow(1).getCell(8);
	} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	public static Object[][] getValue07(String FilePath, String sheets) throws IOException {
		FileInputStream ExcelFile = new FileInputStream(FilePath);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		Object[][] data = new Object[1][6];
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(FilePath));
			Sheet sheet = workbook.getSheet(sheets);			
				data[0][0] = sheet.getRow(2).getCell(1);
				data[0][1] = sheet.getRow(2).getCell(3);
				data[0][2] = sheet.getRow(2).getCell(4);
				data[0][3] = sheet.getRow(2).getCell(5);
				data[0][4] = sheet.getRow(2).getCell(6);
				data[0][5] = sheet.getRow(2).getCell(8);
			
	} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	


}
