package com.Dome.Utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	DataFormatter formatter;
	
	public ExcelUtil(String excelName, String sheetName) throws IOException {
		
		wb = new XSSFWorkbook(System.getProperty("user.dir")+"\\TestData\\"+excelName);
		sheet = wb.getSheet(sheetName);
		formatter = new DataFormatter();
	}
	
	public int getRowCount() {
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
		
	}
	
	public int getColCount() {
		
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		return colCount;
		
	}
	
	public String getStringCellData(int rowNum, int colNumm) {
		
		String cellData = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNumm));
		return cellData;
		
	}
	
	public Double getNumericCellData(int rowNum, int colNumm) {
		
		Double cellData = sheet.getRow(rowNum).getCell(colNumm).getNumericCellValue();
		return cellData;
		
	}

}
