package com.Dome.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;

	public ReadConfig() {
		File src = new File("./Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}

	}

	public String getChromePath() {
		String ch = pro.getProperty("chromepath");
		return ch;
	}

	public String getFirefoxPath() {
		String ff = pro.getProperty("firefoxpath");
		return ff;
	}
	
	public String getDomeUrl() {
		String url = pro.getProperty("domeUrl");
		return url;
	}

	public String getEmail() {
		String email = pro.getProperty("email");
		return email;
	}

	public String getPassword() {
		String un = pro.getProperty("password");
		return un;
	}
	
	public String getExcelName() {
		String excel = pro.getProperty("excelname");
		return excel;
	}
	
	public String getSheetName() {
		String sheet = pro.getProperty("sheetname");
		return sheet;
	}

}
