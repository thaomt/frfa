package com.ThaoMT8_Assigment_Day.exercise1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WirteWorkbook {
	public static void main(String [] args) {
		final String file="exercise1.xlsx";
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Exercise 1");
		
		Row header =sheet.createRow(0);
		header.createCell(0).setCellValue("ID");
		header.createCell(1).setCellValue("NAME");
		header.createCell(2).setCellValue("LASTNAME");
		
		Row dataRow1 =sheet.createRow(1);
		dataRow1.createCell(0).setCellValue(1);
		dataRow1.createCell(1).setCellValue("Amit");
		dataRow1.createCell(2).setCellValue("Shukla");
		
		Row dataRow2 =sheet.createRow(2);
		dataRow2.createCell(0).setCellValue(2);
		dataRow2.createCell(1).setCellValue("Lokesh");
		dataRow2.createCell(2).setCellValue("Gupta");
		
		Row dataRow3 =sheet.createRow(3);
		dataRow3.createCell(0).setCellValue(3);
		dataRow3.createCell(1).setCellValue("John");
		dataRow3.createCell(2).setCellValue("Adwards");
		
		Row dataRow4 =sheet.createRow(4);
		dataRow4.createCell(0).setCellValue(4);
		dataRow4.createCell(1).setCellValue("Brian");
		dataRow4.createCell(2).setCellValue("Schultz");		
		try {
			FileOutputStream out=new FileOutputStream(new File(file));
			workbook.write(out);
			out.close();
			System.out.println("Create file xlsx sucessfull, please click on file exercise1.xlsx to read more");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}


	
}
