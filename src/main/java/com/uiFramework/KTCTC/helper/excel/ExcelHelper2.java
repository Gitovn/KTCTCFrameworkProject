package com.uiFramework.KTCTC.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.uiFramework.KTCTC.helper.logger.LoggerHelper;
import com.uiFramework.KTCTC.helper.resource.ResourceHelper;

public class ExcelHelper2 {

	private Logger log = LoggerHelper.getLogger(ExcelHelper2.class);

	public Object[][] getExcelData(String excelLocation, String sheetName) {

		try {
			Object dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(excelLocation));
			// Create Workbook instance
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get sheet Name from Workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);

			// count number of active rows in excel sheet
			int totalRow = sheet.getLastRowNum();
			System.out.println(totalRow);
			// count active columns in row
			int totalColumn = sheet.getRow(0).getLastCellNum();

			dataSets = new Object[totalRow][totalColumn];

			// Iterate Through each Rows one by one.
			/*
			 * Iterator<Row> rowIterator = sheet.iterator(); int i = 0; while
			 * (rowIterator.hasNext()) { i++; // for Every row , we need to iterator over
			 * columns Row row = rowIterator.next(); Iterator<Cell> cellIterator =
			 * row.cellIterator(); int j = 0; while (cellIterator.hasNext()) { //j++; Cell
			 * cell = cellIterator.next();
			 */

			for (int i = 1; i < totalRow; i++) {

				for (int j = 0; j < totalColumn; j++) {

					XSSFRow row = sheet.getRow(i);

					XSSFCell cell = row.getCell(j);

					switch (cell.getCellType()) {
					case STRING:
						dataSets[i-1][j] = cell.getStringCellValue();
						break;
					case NUMERIC:
						dataSets[i-1][j] = cell.getNumericCellValue();
						break;
					case BOOLEAN:
						dataSets[i-1][j] = cell.getBooleanCellValue();
					case FORMULA:
						dataSets[i-1][j] = cell.getCellFormula();
						break;

					default:
						System.out.println("no matching enum date type found");
						break;
					}
				}
			}
			return dataSets;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
