package utils;


import java.io.BufferedReader;
import java.io.File;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.core.format.DataFormatDetector;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import com.graphbuilder.curve.ValueVectorListener;
import com.itextpdf.text.log.SysoCounter;

public class XLHandler {

	public XSSFWorkbook excelWorkbook;
	public XSSFSheet excelSheet;
	public XSSFCell Cell;
	public DataFormatter df;

	public File TestDatafile;

	@SuppressWarnings({ "unused", "null" })
	public static String[] readexcel(String sheetname,  String filename) throws EncryptedDocumentException, InvalidFormatException, IOException {
		String[] value = null; // 0 = value, 1 = value, 2 = value
		try {
			Workbook workbook = WorkbookFactory
					.create(new File(new File(".", "\\TestData\\" + filename).getAbsolutePath()));

			Sheet sheet = workbook.getSheet(sheetname);
			int lastRow = sheet.getLastRowNum();
			DataFormatter dataFormatter = new DataFormatter();
			int count = 0;
			int rowNum=0;
			for (Cell cell : sheet.getRow(rowNum)) {
				count++;
			}
			
			//for (int i = 0; i <= lastRow; i++) {
//				Row row = sheet.getRow(i);
//				System.out.println(row);
//				int lastCell = row.getLastCellNum();
//				System.out.println(lastCell);
				value = new String[count];
				//for (int j = 0; j < lastCell; j++) {
					//Cell cell = row.getCell(j);
				for (Cell cell : sheet.getRow(rowNum)) {
					String text = dataFormatter.formatCellValue(cell);
					System.out.println(text);
					System.out.println(cell.getColumnIndex());
					value[cell.getColumnIndex()] = dataFormatter.formatCellValue(cell);	
					
				}
				
				System.out.println();
			
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
			return value;
}
}
