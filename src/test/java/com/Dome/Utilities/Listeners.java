package com.Dome.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners implements ITestListener {
	
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	public static WebDriver driver = null;

	@Override
	public void onStart(ITestContext context) {
		
		extent = new ExtentReports();
		//spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/TestReports/"+reportName);
		spark = new ExtentSparkReporter("index.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Test Automation Report");
		spark.config().setReportName("Functional Test Report");
		spark.config().setTimeStampFormat("yyyy.MM.dd - HH.mm.ss");
		
		extent.attachReporter(spark);
		
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		extent.setSystemInfo("Browser Name", "browser");
		extent.setSystemInfo("Application URL", "url");
		extent.setSystemInfo("User", "Hashan");
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.INFO, result.getName()+" Started excuting");
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, result.getName()+" Successfully executed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL, result.getName()+" Failed");
		test.log(Status.INFO, result.getThrowable());
		
//		try {
//			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (NoSuchFieldException e) {
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		}
//		
//		String imagePath;
//		try {
//			imagePath = ExtentReporter.captureScreen(driver, result.getName());
//			test.addScreenCaptureFromPath(imagePath);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP, result.getName()+" Skipped");
		test.log(Status.INFO, result.getThrowable());
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
		//Desktop.getDesktop().browse(uri);
		
	}

}
