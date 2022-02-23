package ThaoMT8_Assigment_Day09.exer2;

/*import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIworkbook {

	/*public static void main(String[] args) {
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Calculate simple interset");
		CellStyle style = workbook.createCellStyle(); 
		style = workbook.createCellStyle();  
        style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());  
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        CellStyle style1 = workbook.createCellStyle(); 
		style1 = workbook.createCellStyle();  
        style1.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());  
        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
		
		Row header =sheet.createRow(0);
		header.createCell(0).setCellValue("Students");
		Cell cell00=header.createCell(1);
		cell00.setCellValue("Paper1");
		cell00.setCellStyle(style);
		Cell cell001=header.createCell(2);
		cell001.setCellValue("Paper2");
		cell001.setCellStyle(style);
		Cell cell002=header.createCell(3);
		cell002.setCellValue("Paper3");
		cell002.setCellStyle(style);
		Cell cell003=header.createCell(4);
		cell003.setCellValue("Paper4");
		cell003.setCellStyle(style);
		Cell cell004=header.createCell(5);
		cell004.setCellValue("Paper5");
		cell004.setCellStyle(style);
		Cell cell005=header.createCell(6);
		cell005.setCellValue("Paper6");
		cell005.setCellStyle(style);
		Cell cell006=header.createCell(7);
		cell006.setCellValue("Paper7");
		cell006.setCellStyle(style);
		Cell cell007=header.createCell(8);
		cell007.setCellValue("Total");
		cell007.setCellStyle(style);
		
		
		Row dataRow =sheet.createRow(1);
		Cell cell0=dataRow.createCell(0);
		cell0.setCellValue("Student 1");
		cell0.setCellStyle(style);
		dataRow.createCell(1).setCellValue(1);
		dataRow.createCell(2).setCellValue(7);
		dataRow.createCell(3).setCellValue(74);
		dataRow.createCell(4).setCellValue(23);
		dataRow.createCell(5).setCellValue(75);
		dataRow.createCell(6).setCellValue(55);
		dataRow.createCell(7).setCellValue(51);
		Cell cell000=dataRow.createCell(8);
		cell000.setCellStyle(style1);
        cell000.setCellFormula("SUM(B2:H2)");
		
		
		
		Row dataRow1 =sheet.createRow(2);
		Cell cell01=dataRow1.createCell(0);
		cell01.setCellValue("Student 2");
		cell01.setCellStyle(style);
		dataRow1.createCell(1).setCellValue(73);
		dataRow1.createCell(2).setCellValue(17);
		dataRow1.createCell(3).setCellValue(5);
		dataRow1.createCell(4).setCellValue(52);
		dataRow1.createCell(5).setCellValue(18);
		dataRow1.createCell(6).setCellValue(26);
		dataRow1.createCell(7).setCellValue(26);
		Cell cell0001=dataRow1.createCell(8);
		cell0001.setCellStyle(style1);
		cell0001.setCellFormula("SUM(B3:H3)");
		
		Row dataRow2 =sheet.createRow(3);
		Cell cell02=dataRow2.createCell(0);
		cell02.setCellValue("Student 3");
		cell02.setCellStyle(style);
		dataRow2.createCell(1).setCellValue(27);
		dataRow2.createCell(2).setCellValue(29);
		dataRow2.createCell(3).setCellValue(29);
		dataRow2.createCell(4).setCellValue(35);
		dataRow2.createCell(5).setCellValue(96);
		dataRow2.createCell(6).setCellValue(17);
		dataRow2.createCell(7).setCellValue(45);
		Cell cell0002=dataRow2.createCell(8);
		cell0002.setCellStyle(style1);
		cell0002.setCellFormula("SUM(B4:H4)");
		
		Row dataRow3 =sheet.createRow(4);
		Cell cell03=dataRow3.createCell(0);
		cell03.setCellValue("Student 4");
		cell03.setCellStyle(style);
		dataRow3.createCell(1).setCellValue(4);
		dataRow3.createCell(2).setCellValue(4);
		dataRow3.createCell(3).setCellValue(56);
		dataRow3.createCell(4).setCellValue(32);
		dataRow3.createCell(5).setCellValue(12);
		dataRow3.createCell(6).setCellValue(22);
		dataRow3.createCell(7).setCellValue(14);
		Cell cell0003=dataRow3.createCell(8);
		cell0003.setCellStyle(style1);
		cell0003.setCellFormula("SUM(B5:H5)");
		try {
			FileOutputStream out=new FileOutputStream(new File("student.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("Create file xlsx sucessfull, please click student.xlsx to read more");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	

}*/
