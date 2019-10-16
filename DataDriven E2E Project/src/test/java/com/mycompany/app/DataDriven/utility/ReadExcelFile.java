package com.mycompany.app.DataDriven.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	XSSFWorkbook book;
	XSSFSheet sheet;

	public ReadExcelFile() {
		try {
			File src = new
			 File("./src/test/resources/com/mycompany/app/DataDriven/resources/App_testData.xlsx");
			FileInputStream fis = new FileInputStream(src);
			book = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public String getStringData(int sheetnumber, int row, int column) {
		sheet = book.getSheetAt(sheetnumber);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}

	public String getNumericData(int sheetnumber, int row, int column) {
		sheet = book.getSheetAt(sheetnumber);
		double n = sheet.getRow(row).getCell(column).getNumericCellValue();
		String data = String.valueOf(n);
		return data;
	}

	public String getStringData(String sheetName, int row, int column) {

		sheet = book.getSheet(sheetName);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		System.out.println(data);
		return data;
	}

	public String getNumericData(String sheetName, int row, int column) {
		sheet = book.getSheet(sheetName);
		double n = sheet.getRow(row).getCell(column).getNumericCellValue();
		String data = String.valueOf(n);
		return data;
	}

	public int getRowCount(int sheetIndex) {
		int row = book.getSheetAt(sheetIndex).getLastRowNum();
		row = row + 1;
		return row;
	}
}