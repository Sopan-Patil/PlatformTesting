package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLHandler {
<<<<<<< Updated upstream
	/**
	 * @Author : Sopan Patil
	 * @Date : 02 Jul 2021
	 * @Description: Added Excel read utility
	 */
=======
	
	/**
	*@author Sopan patil
	*@Date : 01 Jul 21
	*@Description : Read Excel sheet
	*
	 */
	
>>>>>>> Stashed changes
	@SuppressWarnings("null")
	public static String[] readexcel(String sheetname, String filename)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String[] value = null; // 0 = value, 1 = value, 2 = value
		Object result;
		Workbook workbook = WorkbookFactory
				.create(new File(new File(".", "\\TestData\\" + filename).getAbsolutePath()));
		Sheet sheet = workbook.getSheet(sheetname);	
		int lastRow = sheet.getLastRowNum();
		//System.out.println("Last row- " + lastRow);
		for (int i = 0; i <= lastRow; i++) {
			Row row = sheet.getRow(i);
			int lastCell = row.getLastCellNum();
			value = new String[lastCell];
			for (int j = 0; j < lastCell; j++) {
				Cell cell = row.getCell(j);
				DataFormatter formatter = new DataFormatter();
				String text = formatter.formatCellValue(cell);
				//System.out.println(text);
<<<<<<< Updated upstream
				// value[cell.getRowIndex()] = formatter.formatCellValue(cell);
				value[cell.getColumnIndex()] = formatter.formatCellValue(cell);
				//return value;
=======
				//value[cell.getRowIndex()] = formatter.formatCellValue(cell);
				value[cell.getColumnIndex()] = formatter.formatCellValue(cell);
				
>>>>>>> Stashed changes
			}
			//System.out.println();
		}
		return value;		
	}
}
