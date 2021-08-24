package utils;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	private FileInputStream fis;
	private FileOutputStream fileOut;
	private Workbook wb;
	private Sheet sh;
	private Cell cell;
	private Row row;
	private CellStyle cellstyle;
	private Color mycolor;
	private String excelFilePath;
	private Map<String, Integer> columns = new HashMap<>();

	public void setExcelFile(String FileName, String SheetName) throws Exception {
		
	

			//fis = new FileInputStream(FileName);

		excelFilePath = System.getProperty("user.dir") + File.separator + "TestData" + File.separator + FileName;// "NewTestData.xlsx";
			FileInputStream fis = new FileInputStream(excelFilePath);

		//	Workbook wb = WorkbookFactory.create(new File(new File(".", "\\TestData\\" + fis).getAbsolutePath()));
			
			wb = WorkbookFactory.create(fis);
			sh = wb.getSheet(SheetName);
			// sh = wb.getSheetAt(0); //0 - index of 1st sheet
			if (sh == null) {
				sh = wb.createSheet(SheetName);
			}

			

			// adding all the column header names to the map 'columns'
			sh.getRow(0).forEach(cell -> {
				columns.put(cell.getStringCellValue(), cell.getColumnIndex());
			});

		
	}

	public String getCellData(int rownum, int colnum) throws Exception {
		try {
			cell = sh.getRow(rownum).getCell(colnum);
			String CellData = null;
			switch (cell.getCellTypeEnum()) {
			case STRING:
				CellData = cell.getStringCellValue();
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					CellData = String.valueOf(cell.getDateCellValue());
				} else {
					CellData = String.valueOf((long) cell.getNumericCellValue());
				}
				break;
			case BOOLEAN:
				CellData = Boolean.toString(cell.getBooleanCellValue());
				break;
			case BLANK:
				CellData = "";
				break;
			default:
				break;
			}
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	public String getCellData(String columnName, int rownum) throws Exception {
		return getCellData(rownum, columns.get(columnName));
	}

	public int getRows() {
		return sh.getPhysicalNumberOfRows();
	}

	public void setCellData(String text, int rownum, int colnum) throws Exception {
		try {
			row = sh.getRow(rownum);
			if (row == null) {
				row = sh.createRow(rownum);
			}
			cell = row.getCell(colnum);

			if (cell == null) {
				cell = row.createCell(colnum);
			}
			cell.setCellValue(text);

			fileOut = new FileOutputStream(excelFilePath);
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
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

		rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		for (int i = 1; i < rowCount + 1; i++) {

			Row row = sheet.getRow(i);
			Cell cellValue = row.getCell(coloumn);

			if (cellValue.getCellType() != Cell.CELL_TYPE_BLANK) {
				DataFormatter formatter = new DataFormatter();
				String text = formatter.formatCellValue(cellValue);

				value.add(i - 1, text);
			}

		}

		// log.info("value :"+value);

		fis.close();
		workBook.close();

		return value;
	}

	/**
	 * @throws IOException
	 * @Author : Chetan Sonparote
	 * @Date : 5 Aug 2021
	 * @Description:Added excel write method
	 */

	private static Logger log = LogManager.getLogger(XLHandler.class.getName());

	// public static void writeToExcel(String sheetName, String fileName, int
	// cellNumber,String cellData) throws IOException {
	public static void writeToExcel(String sheetName, String fileName, ArrayList<String> cellData) throws IOException {

		String excelPath = System.getProperty("user.dir") + File.separator + "TestData" + File.separator + fileName;// "NewTestData.xlsx";
		FileInputStream fis = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.createRow(1);

		// Create a loop over the cell of newly created Row

		for (int i = 0; i < cellData.size(); i++) {

			// Fill data in row

			Cell cell = row.createCell(i);
			// log.info("cellData[i] :"+cellData.get(i));

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
	 * @Date :11 Aug 2021
	 * @Description: Overloaded read excel to read specific row value
	 */
	public static ArrayList<String> readexcel(String fileName, String sheetName, String columnName, String rowName)
			throws IOException {
		ArrayList<String> value = new ArrayList<String>();
		// String value;

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
				while (cv.hasNext()) {

					Cell c = cv.next();
					if (c.getCellType() == Cell.CELL_TYPE_STRING) {

						value.add(c.getStringCellValue());
						// value.add(cv.next().getStringCellValue());
					} else {

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