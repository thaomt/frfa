package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	public static Object[][] getValue06_07(String FilePath,String sheets) throws IOException{
		FileInputStream ExcelFile = new FileInputStream(FilePath);
		// Access the required test data sheet
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(sheets);
		Object[][] data = new Object[2][8];
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(FilePath));
			Sheet sheet = workbook.getSheet(sheets);
			int j=1;
			for (int i = 0; i < 2; i++) {
				int n=1;
				for(int m=0;m<8;m++,n++) {
					if(sheet.getRow(j).getCell(n)==null) {
						data[i][m]="";
					}else {
						data[i][m] = sheet.getRow(j).getCell(n);
					}
					System.out.println(data[i][m] );
				}				
				j++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	public static Object[][] getValue03_04(String FilePath,String sheets) throws IOException{
		FileInputStream ExcelFile = new FileInputStream(FilePath);
		// Access the required test data sheet
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(sheets);
		Object[][] data = new Object[3][5];
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(FilePath));
			Sheet sheet = workbook.getSheet(sheets);
			int j=1;
			for (int i = 0; i < 3; i++) {
				int n=1;
				for(int m=0;m<5;m++,n++) {
					if(sheet.getRow(j).getCell(n)==null) {
						data[i][m]="";
					}else {
						data[i][m] = sheet.getRow(j).getCell(n);
					}
					System.out.println(data[i][m] );
				}				
				j++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	public void setCellValue(int rowNum,int cellNum,String cellValue,String excelFilePath) throws IOException {
    	//creating a new cell in row and setting value to it      
		ExcelWSheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);    
    	FileOutputStream outputStream = new FileOutputStream(excelFilePath);
    	ExcelWBook.write(outputStream);
    }


}
