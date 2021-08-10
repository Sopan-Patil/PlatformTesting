package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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
		for (int i = 0; i <= lastRow; i++) {
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
	 * @Author : Chetan Sonparote
	 * @Date : 9 Aug 2021
	 * @Description: method to read localization data with parameters
	 *               file,sheet,coloumn
	 */
	public static ArrayList<String> readExcelData(String fileName, String sheetName) throws IOException {
		ArrayList<String> value = new ArrayList<String>();

		String excelPath = System.getProperty("user.dir") + File.separator + "TestData" + File.separator + fileName;// "NewTestData.xlsx";
		FileInputStream fis = new FileInputStream(excelPath);

		// FileInputStream fis = new
		// FileInputStream("D:\\SeleniumPractice\\ExcelDemo.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		Sheet sheet = workBook.getSheet(sheetName);

//		int lastRow = sheet.getLastRowNum();
//		//System.out.println("Last row- " + lastRow);
//		for (int i = 0; i <= lastRow; i++) {
//			Row row = sheet.getRow(i);
//			int lastCell = row.getLastCellNum();
//			//value = new String[lastCell];
//			for (int j = 0; j < lastCell; j++) {
//				Cell cell = row.getCell(j);
//				DataFormatter formatter = new DataFormatter();
//				String text = formatter.formatCellValue(cell);
//				System.out.println("excel text : "+text);
//				//row.getCell(j).
//
//				// value[cell.getRowIndex()] = formatter.formatCellValue(cell);
//			//	value[cell.getColumnIndex()] = formatter.formatCellValue(cell);
//				//return value;
//
//				//value[cell.getRowIndex()] = formatter.formatCellValue(cell);
//			//	value[cell.getColumnIndex()] = formatter.formatCellValue(cell);
//
//				//value[cell.getRowIndex()] = formatter.formatCellValue(cell);
//			//	value[cell.getColumnIndex()] = formatter.formatCellValue(cell);
//				
//
//			} }

		Iterator<Row> rows = sheet.iterator();
		Row firstRow = rows.next();
		Iterator<Cell> ce = firstRow.cellIterator();
		// ce.next();

		int k = 0;
		int coloumn = 0;
		while (ce.hasNext()) {
			Cell cellValue = ce.next();
			if (cellValue.getStringCellValue().equalsIgnoreCase("Locator")) {
				coloumn = k;
				DataFormatter formatter = new DataFormatter();
				String text = formatter.formatCellValue(cellValue);
				System.out.println("excel text : " + text);
			}
//			DataFormatter formatter = new DataFormatter();
//			String text = formatter.formatCellValue(cellValue);
//			System.out.println("excel text : "+text);

			k++;

		}
		System.out.println(coloumn);

		while (rows.hasNext()) {
			Row r = rows.next();
			Cell cellValue = r.getCell(coloumn);
			
			if(cellValue.getCellType()!=Cell.CELL_TYPE_BLANK)
			{
				DataFormatter formatter = new DataFormatter();
				String text = formatter.formatCellValue(cellValue);
				System.out.println("excel text : " + text);
			}
		

//			if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testCase)) {
//				Iterator<Cell> cv = r.cellIterator();
//				while (cv.hasNext()) {
//
//					Cell cellValue = cv.next();
//
//				}
//			}

//			Cell cellValue = r.getCell(coloumn);
//		//	if (cellValue != null || cellValue.getCellType() != Cell.CELL_TYPE_BLANK) {
//				
//		//	}
//			if (r.getSheet()!=null)
//			{
//				DataFormatter formatter = new DataFormatter();
//				String text = formatter.formatCellValue(r.getCell(coloumn));
//				System.out.println("excel text : "+text);
//
//			}

			// return arrList;
		}

//		 int rowCount;
//		 
//		 rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
//		 System.out.print("rowCount:"+rowCount);
//
//		    //Create a loop over all the rows of excel file to read it
//
//		    for (int i = 0; i < rowCount+1; i++) {
//
//		    //	if(sheet.)
//		        Row row = sheet.getRow(i);
//
//		        //Create a loop to print cell values in a row
//
//		        for (int j = 0; j < row.getLastCellNum(); j++) {
//
//		            //Print Excel data in console
//
//		          //  System.out.print(row.getCell(j).getStringCellValue()+"|| ");
//
//		        }
//
//		       // System.out.println();
//		    } 

		fis.close();
		workBook.close();
		return value;
	}

}
