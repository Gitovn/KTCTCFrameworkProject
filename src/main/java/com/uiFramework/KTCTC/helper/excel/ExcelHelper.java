package com.uiFramework.KTCTC.helper.excel;

import java.io.*;
import java.util.*;
import org.apache.poi.xssf.usermodel.*;

import com.uiFramework.KTCTC.helper.resource.ResourceHelper;

public class ExcelHelper {

	XSSFSheet sh;

	public ExcelHelper(String fileName, String sheetName) {
		try {
			File f = new File(ResourceHelper.getResourcePath("\\src\\main\\resources\\ExcelFile\\" + fileName));

			FileInputStream fis = new FileInputStream(f);

			XSSFWorkbook wb = new XSSFWorkbook(fis);

			sh = wb.getSheet(sheetName);
		} catch (Exception e) {

		}
	}

	public ArrayList<String> getKeysListFromExcel() {
		ArrayList<String> keys = new ArrayList<>();
		int rowNum = sh.getLastRowNum();

		for (int i = 1; i <= rowNum; i++) {
			XSSFRow rw = sh.getRow(i);
			XSSFCell cel = rw.getCell(0);

			String eachKey = getCellValueAsStringFromProvidedCell(cel);
			keys.add(eachKey);
		}

		return keys;
	}

	public ArrayList<String> getValuesListFromExcel() {
		ArrayList<String> values = new ArrayList<>();
		int rowNum = sh.getLastRowNum();

		for (int i = 1; i <= rowNum; i++) {
			XSSFRow rw = sh.getRow(i);
			XSSFCell cel = rw.getCell(1);

			String eachKey = getCellValueAsStringFromProvidedCell(cel);
			values.add(eachKey);
		}

		return values;
	}

	public HashMap<String, String> getKeyValuePairFromExcel() {

		HashMap<String, String> data = new HashMap<>();
		ArrayList<String> keys = getKeysListFromExcel();
		ArrayList<String> values = getValuesListFromExcel();

		for (int i = 0; i < keys.size(); i++) {
			data.put(keys.get(i), values.get(i));
		}
		return data;
	}

	public static String getCellValueAsStringFromProvidedCell(XSSFCell cel) {
		String data = null;
		switch (cel.getCellType()) {

		case STRING:
			data = cel.getStringCellValue();
			break;

		case BOOLEAN:
			data = String.valueOf(cel.getBooleanCellValue());
			break;

		case NUMERIC:
			data = String.valueOf(cel.getNumericCellValue());
			break;

		case FORMULA:
			data = String.valueOf(cel.getCellFormula());
			break;

		case BLANK:
			System.out.println("Cell does not have any value");
			break;

		default:
			break;
		}

		return data;
	}

}
