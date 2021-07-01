package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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

public class XLHandlerold {

	public XSSFWorkbook excelWorkbook;
	public XSSFSheet excelSheet;
	public XSSFCell Cell;
	public DataFormatter df;

	public File TestDatafile;

	@SuppressWarnings("unused")
	public static String[] readexcel(String sheetname, int row1, String filename) {
		String[] value = null; // 0 = value, 1 = value, 2 = value
		//File fileDir = new File("D:\\Sopan\\Project\\Automation\\PlatformTesting\\platform\\TestData\\NewTestData.xlsx");
		try {

			Workbook workbook = WorkbookFactory
					.create(new File(new File(".", "\\TestData\\" + filename).getAbsolutePath()));

			Sheet sheet = workbook.getSheet(sheetname);
			DataFormatter dataFormatter = new DataFormatter();
			int count = 0;
			for (Cell cell : sheet.getRow(row1)) {
				count++;
			}
			value = new String[count];
			for (Cell cell : sheet.getRow(row1)) {
				value[cell.getColumnIndex()] = dataFormatter.formatCellValue(cell);					
				System.out.println(value[cell.getColumnIndex()]);
				
				
				
			}

//			BufferedReader in = new BufferedReader(
//					new InputStreamReader(new FileInputStream(fileDir), StandardCharsets.UTF_8));
//			String str;
//			while ((str = in.readLine()) != null) {
//                System.out.println(str);
//                
//            }
//			System.out.println(in.readLine());

			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;
	}

}
