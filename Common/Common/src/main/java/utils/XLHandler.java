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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLHandler {

	/**
	 * @Author : Sopan Patil
	 * @Date : 02 Jul 2021
	 * @Description: Added Excel read utility
	 */

	
	/**
	*@author Sopan patil
	*@Date : 01 Jul 21
	*@Description : Read Excel sheet
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

				// value[cell.getRowIndex()] = formatter.formatCellValue(cell);
				value[cell.getColumnIndex()] = formatter.formatCellValue(cell);
				//return value;

				//value[cell.getRowIndex()] = formatter.formatCellValue(cell);
				value[cell.getColumnIndex()] = formatter.formatCellValue(cell);

				//value[cell.getRowIndex()] = formatter.formatCellValue(cell);
				value[cell.getColumnIndex()] = formatter.formatCellValue(cell);
				

			}
			//System.out.println();
		}
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
	

//		 int rowCount;
//		 
//		 rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
//	
//		    for (int i = 1; i < rowCount+1; i++) {
//
//		  
//		    	Row row = sheet.getRow(i);
//		        Cell cellValue = row.getCell(coloumn);
//		      
//		        if(cellValue.getCellType()!=Cell.CELL_TYPE_BLANK)
//				{
//					DataFormatter formatter = new DataFormatter();
//					String text = formatter.formatCellValue(cellValue);
//					
//					//value.add(i-1, text);
//				}
//
//		
//		    } 
		
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

			// return arrList;
		}
		      
//		        if(cellValue.getCellType()!=Cell.CELL_TYPE_BLANK)
//				{
//					DataFormatter formatter = new DataFormatter();
//					String text = formatter.formatCellValue(cellValue);
//					
//					value.add(i-1, text);
//				}

		
//		    }

//		while (rows.hasNext()) {
//			Row r = rows.next();
//			if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(rowName)) {
//				Iterator<Cell> cv = r.cellIterator();
//				while (cv.hasNext()) 
//				{
//					
//					Cell c =  cv.next();
//					Cell cellValue = r.getCell(coloumn);
//					if(cellValue.getCellType() == Cell.)
//					{
//						
//						value.add(cv.next().getStringCellValue());
//					}
//					else
//					{
//						
//						value.add(NumberToTextConverter.toText(c.getNumericCellValue()));
//					}
//					
//				}
//			}
//
//			// return arrList;
//		}
		    
			
		    //log.info("value :"+value);
		    
		fis.close();
		workBook.close();
		return value;
	}
	
}
