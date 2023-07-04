package com.Dome.Utilities;

import java.io.IOException;

import com.Dome.Utilities.ExcelUtil;

public class ExcelDataProvider {
	
	public Object[][] getTestData(String excelName, String sheetName) throws IOException {
		
		ExcelUtil excel = new ExcelUtil(excelName,sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		Object[][] data = new Object[rowCount-1][colCount];
		
		for(int i = 1; i < rowCount; i++){
			for(int j = 0; j < colCount; j++){
				
				String cellData = excel.getStringCellData(i, j);
				data[i-1][j] = cellData;
				
			}
		}
		return data;
		
	}

}
