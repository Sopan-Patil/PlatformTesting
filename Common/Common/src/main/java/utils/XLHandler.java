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
		
		
		// Create an object of File class to open xls file
		/*
		 * File file = new File("E:\\TestData\\TestData.xls");
		 * 
		 * //Create an object of FileInputStream class to read excel file
		 * FileInputStream inputStream = new FileInputStream(file);
		 * 
		 * //creating workbook instance that refers to .xls file HSSFWorkbook wb=new
		 * HSSFWorkbook(inputStream);
		 * 
		 * //creating a Sheet object HSSFSheet sheet=wb.getSheet("STUDENT_DATA");
		 * 
		 * //get all rows in the sheet int
		 * rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		 * 
		 * //Get the first row from the sheet
		 * 
		 * Row row = sheet.getRow(0);
		 * 
		 * //Create a new row and append it at last of sheet
		 * 
		 * Row newRow = sheet.createRow(rowCount+1);
		 * 
		 * //Create a loop over the cell of newly created Row
		 * 
		 * 
		 * for(int j = 0; j < row.getLastCellNum(); j++){
		 * 
		 * //Fill data in row
		 * 
		 * Cell cell = newRow.createCell(j);
		 * 
		 * cell.setCellValue(dataToWrite[j]);
		 * 
		 * }
		 * 
		 * //Close input stream
		 * 
		 * inputStream.close();
		 * 
		 * //Create an object of FileOutputStream class to create write data in excel
		 * file
		 * 
		 * FileOutputStream outputStream = new FileOutputStream(file);
		 * 
		 * //write data in the excel file
		 * 
		 * guru99Workbook.write(outputStream);
		 * 
		 * //close output stream
		 * 
		 * outputStream.close();
		 * 
		 * 
		 * Row row = sheet.createRow(1); Cell cell = row.createCell(1); //Now we need to
		 * find out the type of the value we want to enter. //If it is a string, we need
		 * to set the cell type as string //if it is numeric, we need to set the cell
		 * type as number //cell.setCellType(cell.CELL_TYPE_STRING);
		 * cell.setCellValue("SoftwareTestingMaterial.com"); FileOutputStream fos = new
		 * FileOutputStream("D:\\Test.xlsx"); workbook.write(fos); fos.close();
		 */
		String excelPath = System.getProperty("user.dir") + File.separator
				+ "TestData" +  File.separator
				+ fileName;//"NewTestData.xlsx";
		FileInputStream fis = new FileInputStream(excelPath);
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 //call the getSheet() method of Workbook and pass the Sheet Name here. 
		 //In this case I have given the sheet name as “TestData” 
		                //or if you use the method getSheetAt(), you can pass sheet number starting from 0. Index starts with 0.
		 XSSFSheet sheet = workbook.getSheet(sheetName);
		 //XSSFSheet sheet = workbook.getSheetAt(0);
		 //Now create a row number and a cell where we want to enter a value. 
		 //Here im about to write my test data in the cell B2. It reads Column B as 1 and Row 2 as 1. Column and Row values start from 0.
		 //The below line of code will search for row number 2 and column number 2 (i.e., B) and will create a space. 
		                //The createCell() method is present inside Row class.
		 
		// int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		
		// Row row = sheet.getRow(0);
		 Row    row = sheet.createRow(1);
		 
		    //Create a loop over the cell of newly created Row

		    for(int i = 0; i < cellData.size(); i++){

		        //Fill data in row

		        Cell cell = row.createCell(i);
		      //  log.info("cellData[i] :"+cellData.get(i));

		        cell.setCellValue(cellData.get(i));

		    }

		    //Close input stream

		  //  inputStream.close();

		// Cell cell = row.createCell(cellNumber);
		 //Now we need to find out the type of the value we want to enter. 
		                //If it is a string, we need to set the cell type as string 
		                //if it is numeric, we need to set the cell type as number
		// cell.setCellType(cell.CELL_TYPE_STRING);
	//	 cell.setCellValue(cellData);
		 fis.close();
		 FileOutputStream fos = new FileOutputStream(excelPath);
		 workbook.write(fos);
		 fos.close();
		 workbook.close();
		// System.out.println("END OF WRITING DATA IN EXCEL");
	}

}
