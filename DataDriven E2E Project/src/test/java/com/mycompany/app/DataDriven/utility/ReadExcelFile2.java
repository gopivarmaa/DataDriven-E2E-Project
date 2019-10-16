package com.mycompany.app.DataDriven.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
// import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile2 {

	public ArrayList<String> getData(String testCase) throws IOException {
		ArrayList<String> testData = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("D:\\Selenium\\DataDriven-testdata.xlsx");
		
		// Access test data sheet
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int n_sheets = workbook.getNumberOfSheets();
		if (n_sheets > 0) {
			// Access first sheet in the workbbok
			XSSFSheet sheet = workbook.getSheetAt(0);
			// Read all the ros in the sheet
			Iterator<Row> rows = sheet.iterator();
			if (rows.hasNext()) {
				Row row = rows.next();
				// Read all the cells in the first row
				Iterator<Cell> cells = row.cellIterator();
				int column = 0;
				int i = 0;
				// identify the test case column
				while (cells.hasNext()) {
					if (cells.next().getStringCellValue().equalsIgnoreCase("TestCase")) {
						column = i;
					}
					i++;
				}
				while (rows.hasNext()) {
					row = rows.next();
					// identify the required test case
					if (row.getCell(column).getStringCellValue().equalsIgnoreCase(testCase)) {
						cells = row.cellIterator();
						// read all the data of the test case
						while (cells.hasNext()) {
							Cell cell = cells.next();
						//	if (cell.getCellType() == CellType.STRING) {
							//	testData.add(cell.getStringCellValue());
							//} else {
							//	testData.add(String.valueOf(cell.getNumericCellValue()));
						//	}
						}
					}
				}
			} else {
				System.out.println("Sheet does not have rows");
			}
		} else {
			System.out.println("workbook does not have sheets");
		}
		workbook.close();
		// return test data to the caller
		return testData;
	}
}
