package utiliti;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {
		Object[][] tabArray = null;
		try {
			FileInputStream ExcelFile = new FileInputStream(FilePath);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int startRow = 1;
			int startCol = 1;
			int ci, cj;
			int totalRows = ExcelWSheet.getLastRowNum();
			int totalCols =2 ;
			tabArray = new Object[totalRows][totalCols];
			ci = 0;
			for (int i = startRow; i <= totalRows; i++, ci++) {
				cj = 0;
				for (int j = startCol; j <= totalCols; j++, cj++) {
					tabArray[ci][cj] =getCellValue(i, j);
					System.out.println(tabArray[ci][cj]);
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		return (tabArray);
	}
	
	public static Object getCellValue(int RowNum, int ColNum) {
		Cell cell=ExcelWSheet.getRow(RowNum).getCell(ColNum);
        switch (cell.getCellTypeEnum()) {
        case STRING:
            return cell.getStringCellValue();
        case BOOLEAN:
            return cell.getBooleanCellValue();
        case NUMERIC:
            return (int) cell.getNumericCellValue();
        case BLANK:
        	return "";
        default:
            break;
        }
        return null;
    }
	
}

