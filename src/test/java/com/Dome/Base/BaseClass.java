package com.Dome.Base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.Dome.Utilities.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	
	static ReadConfig readconfig = new ReadConfig();
	public static String url = readconfig.getDomeUrl();
	public String email = readconfig.getEmail();
	public String password = readconfig.getPassword();
	public String excelName = readconfig.getExcelName();
	public String sheetName = readconfig.getSheetName();
	public static WebDriver driver;
	public static Logger logger;
	public static WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	@BeforeSuite
	public static void startReporting(){
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());
		String reportName = "TestReport"+timeStamp+".html";
		extent = new ExtentReports();
		//spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/TestReports/"+reportName);
		spark = new ExtentSparkReporter("index.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Dome Test Automation Report");
		spark.config().setReportName("Functional Test Report");
		spark.config().setTimeStampFormat("yyyy.MM.dd : HH.mm.ss");
		
		extent.attachReporter(spark);
		
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		extent.setSystemInfo("Browser Name", "Chrome");
		extent.setSystemInfo("Application URL", url);
		
	}
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) throws MalformedURLException {
		
		if (browser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		} else if (browser.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		wait=new WebDriverWait(driver, 10);
		logger = Logger.getLogger("Dome Project");
		PropertyConfigurator.configure("Log4j.properties");
		
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
		
	if (result.getStatus() == ITestResult.FAILURE) {
		test.log(Status.FAIL, result.getName()+" Got Failed");
		test.log(Status.INFO, result.getThrowable());
		String imagePath;
		try {
			imagePath = captureScreen(driver, result.getName());
			test.addScreenCaptureFromPath(imagePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName()+" Successfully executed");
		} else {
			test.log(Status.SKIP, result.getName()+" Skipped");
			test.log(Status.INFO, result.getThrowable());
		}
	
	}
	
//	@AfterTest
//	public void endReport() {
//		extent.flush();
//	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@AfterSuite
	public void openReport() {
		extent.flush();
		String pathOfTheReport = System.getProperty("user.dir")+"/index.html";
		File report = new File(pathOfTheReport);
		try {
			Desktop.getDesktop().browse(report.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		return target.toString();
	}

}
