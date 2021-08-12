package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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
import org.apache.poi.ss.util.NumberToTextConverter;
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
	
	/**
	 * @Author : Chetan Sonparote
	 * @Date : 9 Aug 2021
	 * @Description: method to read localization data with parameters
	 *               file,sheet,coloumn
	 */
	public static ArrayList<String> readexcel(String fileName, String sheetName, String columnName) throws IOException {
		ArrayList<String> value = new ArrayList<String>();

		String excelPath = System.getProperty("user.dir") + File.separator + "TestData" + File.separator + fileName;// "NewTestData.xlsx";
		FileInputStream fis = new FileInputStream(excelPath);

	
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		Sheet sheet = workBook.getSheet(sheetName);


		Iterator<Row> rows = sheet.iterator();
		Row firstRow = rows.next();
		Iterator<Cell> ce = firstRow.cellIterator();
		// ce.next();

		int k = 0;
		int coloumn = 0;
		while (ce.hasNext()) {
			Cell cellValue = ce.next();
			if (cellValue.getStringCellValue().equalsIgnoreCase(columnName)) {
				coloumn = k;

			}


			k++;

		}
	

		 int rowCount;
		 
		 rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	
		    for (int i = 1; i < rowCount+1; i++) {

		  
		    	Row row = sheet.getRow(i);
		        Cell cellValue = row.getCell(coloumn);
		      
		        if(cellValue.getCellType()!=Cell.CELL_TYPE_BLANK)
				{
					DataFormatter formatter = new DataFormatter();
					String text = formatter.formatCellValue(cellValue);
					
					value.add(i-1, text);
				}

		
		    } 
		    
			
		    //log.info("value :"+value);
		    
		fis.close();
		workBook.close();
		return value;
	}
	
	
	/**
	 * @Author : Chetan Sonparote
	 * @Date :11 Aug 2021
	 * @Description: Overloaded read excel to read specific row value
	 */
	public static ArrayList<String> readexcel(String fileName, String sheetName, String columnName, String rowName) throws IOException {
		ArrayList<String> value = new ArrayList<String>();
		//String value;

		String excelPath = System.getProperty("user.dir") + File.separator + "TestData" + File.separator + fileName;// "NewTestData.xlsx";
		FileInputStream fis = new FileInputStream(excelPath);

	
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		Sheet sheet = workBook.getSheet(sheetName);


		Iterator<Row> rows = sheet.iterator();
		Row firstRow = rows.next();
		Iterator<Cell> ce = firstRow.cellIterator();
		// ce.next();

		int k = 0;
		int coloumn = 0;
		while (ce.hasNext()) {
			Cell cellValue = ce.next();
			if (cellValue.getStringCellValue().equalsIgnoreCase(columnName)) {
				coloumn = k;

			}


			k++;

		}
	

		
		System.out.println(coloumn);
		
		while (rows.hasNext()) {
			Row r = rows.next();
			if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(rowName)) {
				Iterator<Cell> cv = r.cellIterator();
				while (cv.hasNext()) 
				{
					
					Cell c =  cv.next();
					if(c.getCellType()==Cell.CELL_TYPE_STRING)
					{
						
						value.add(cv.next().getStringCellValue());
					}
					else
					{
						
						value.add(NumberToTextConverter.toText(c.getNumericCellValue()));
					}
					
				}
			}

			
		}

		    
		fis.close();
		workBook.close();
		return value;
	}

}