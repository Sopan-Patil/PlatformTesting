package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class XLHandler {

	/**
	 * @Author : Sopan Patil
	 * @Date : 02 Jul 2021
	 * @Description: Added Excel read utility
	 */

	/**
	 * @author Sopan patil
	 * @Date : 01 Jul 21
	 * @Description : Read Excel sheet
	 *
	 */

	@SuppressWarnings("null")
	public static String[] readexcel(String sheetname, String filename)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String[] value = null; // 0 = value, 1 = value, 2 = value
		Object result;
		Workbook workbook = WorkbookFactory
				.create(new File(new File(".", "\\TestData\\" + filename).getAbsolutePath()));
		Sheet sheet = workbook.getSheet(sheetname);
		int lastRow = sheet.getLastRowNum();
		// System.out.println("Last row- " + lastRow);
	//	for (int i = 0; i <= lastRow; i++) { //DO NOT REMOVE
		/**
		 * @throws IOException
		 * @Author : Chetan Sonparote
		 * @Date : 5 Aug 2021
		 * @Description:Changed i <= lastRow to i < lastRow to resolve initialization error
		 */
		for (int i = 0; i < lastRow; i++) {
			Row row = sheet.getRow(i);
			int lastCell = row.getLastCellNum();
			value = new String[lastCell];
			for (int j = 0; j < lastCell; j++) {
				Cell cell = row.getCell(j);
				DataFormatter formatter = new DataFormatter();
				String text = formatter.formatCellValue(cell);
				// System.out.println(text);

				// value[cell.getRowIndex()] = formatter.formatCellValue(cell);
				value[cell.getColumnIndex()] = formatter.formatCellValue(cell);
				// return value;

				// value[cell.getRowIndex()] = formatter.formatCellValue(cell);
				value[cell.getColumnIndex()] = formatter.formatCellValue(cell);

				// value[cell.getRowIndex()] = formatter.formatCellValue(cell);
				value[cell.getColumnIndex()] = formatter.formatCellValue(cell);

			}
			// System.out.println();
		}
		return value;
	}

	/**
	 * @throws IOException
	 * @Author : Chetan Sonparote
	 * @Date : 5 Aug 2021
	 * @Description:Added excel write method
	 */
	
	private static Logger log = LogManager.getLogger(XLHandler.class.getName());

	//public static void writeToExcel(String sheetName, String fileName, int cellNumber,String cellData) throws IOException {
	public static void writeToExcel(String sheetName, String fileName, ArrayList<String> cellData) throws IOException {
		
		
		
		String excelPath = System.getProperty("user.dir") + File.separator
				+ "TestData" +  File.separator
				+ fileName;//"NewTestData.xlsx";
		FileInputStream fis = new FileInputStream(excelPath);
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		 XSSFSheet sheet = workbook.getSheet(sheetName);
	
		 Row    row = sheet.createRow(1);
		 
		    //Create a loop over the cell of newly created Row

		    for(int i = 0; i < cellData.size(); i++){

		        //Fill data in row

		        Cell cell = row.createCell(i);
		      //  log.info("cellData[i] :"+cellData.get(i));

		        cell.setCellValue(cellData.get(i));

		    }

		  
		 fis.close();
		 FileOutputStream fos = new FileOutputStream(excelPath);
		 workbook.write(fos);
		 fos.close();
		 workbook.close();
		
	}

}
