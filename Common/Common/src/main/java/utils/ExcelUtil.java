package utils;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.*;

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

}