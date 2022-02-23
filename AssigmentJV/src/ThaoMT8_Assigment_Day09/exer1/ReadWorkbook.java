package ThaoMT8_Assigment_Day09.exer1;

/*import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWorkbook {
	public static void main(String [] args) {
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Calculate simple interset");
		
		Row header =sheet.createRow(0);
		header.createCell(0).setCellValue("Pricipal");
		header.createCell(1).setCellValue("Rol");
		header.createCell(2).setCellValue("T");
		header.createCell(3).setCellValue("Interest(P r t");
		
		Row dataRow =sheet.createRow(1);
		dataRow.createCell(0).setCellValue(14500d);
		dataRow.createCell(1).setCellValue(9.25);
		dataRow.createCell(2).setCellValue(3d);
		dataRow.createCell(3).setCellFormula("A2*B2*C2");
		try {
			FileOutputStream out=new FileOutputStream(new File("m.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("sucess");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	// bo sung red
	private static void read(String file) {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			while (rows.hasNext()) {
				Row row = rows.next();
				Iterator<Cell> cells = row.iterator();
				while (cells.hasNext()) {
					Cell cell = (Cell) cells.next();
					switch (cell.getCellType()) {
					case STRING:
						System.out.print(cell.getStringCellValue() + " ");
						break;
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + " ");
						break;
					default:
						break;
					}

				}
				System.out.println();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}*/
