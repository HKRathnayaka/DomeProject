package com.Dome.TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Dome.Base.BaseClass;
import com.Dome.Pages.FlipDetailsPage;
import com.Dome.Pages.FlipperHomePage;
import com.Dome.Pages.PropertyDetailsPage;
import com.Dome.Pages.ProposalBudgetSummaryPage;
import com.Dome.Pages.Propose_a_PropertyPage;
import com.Dome.Pages.RehabDetailsPage;
import com.Dome.Pages.SalesSummaryPage;
import com.Dome.TestCases.tc_001_FlipperLoginWithValidCredentials;
import com.Dome.Utilities.ExcelDataProvider;

public class tc_002_SubmitAPropertyProposal extends BaseClass {
	
	public static String imgPath = "C:/Users/itsre/Desktop/test.webp";
	public static String taskName = "Task 1";
	public static String taskDetails = "Task Details";
	public static String laborCost = "500";
	public static String materialsCost = "750";
	public static ExcelDataProvider testData;
	
	
	@Test(priority = 1)
	public void flipperLogin() throws InterruptedException, IOException{
		
		tc_001_FlipperLoginWithValidCredentials login = new tc_001_FlipperLoginWithValidCredentials();
		login.flipperLoginWithValidCredentials();
		
	}
	
	@DataProvider(name = "data")
	public Object[][] getTestData() throws IOException{
		
		testData = new ExcelDataProvider();
		Object data[][] = testData.getTestData(excelName, sheetName);
		return data;
		
	}
	
	@Test(priority = 2, dataProvider = "data")
	public void enterPropertyDetails(String ProjectName,String ProjectType,String ProjectKind,String Ownership,String Type,String AdditionalDetails,
			String Addressline1,String Addressline2,String City,String State,String ZipCode,String Numberofbedrooms,String Numberofbathrooms,String SquareFeet
			,String LotSize,String Description,String ImagePath,String PurchasePrice,String PurchaseClosingDate,String EstimatedClosingCosts,String EstimatedRehabTime,String AnnualTaxes
			,String MonthlyUtilities,String MonthlyHOA,String MonthlyAlarmorSurveillance,String OtherMonthlyExpenses,String Tasks,String FlipperInvestment,String TargetSalePrice,String TargetListingDate,String EstimatedClosingDateAfterRehab) throws InterruptedException{
		
		FlipperHomePage fhp = new FlipperHomePage(driver);
		test = extent.createTest("enterPropertyDetails");
		fhp.clickOnPropose_a_Property();
		test.info("Propose a Property Link Clicked");
		Propose_a_PropertyPage prop = new Propose_a_PropertyPage(driver);
		wait.until(ExpectedConditions.visibilityOf(prop.txtProjectName));
		test.info("Successfully navigates to Propose a Property page");
		
		prop.enterProjectName(ProjectName);
		test.info("Project Name entered as : "+ProjectName);
		prop.clickOnProjectTypeDropdown();
		prop.selectProjectType(ProjectType);
		test.info("Project Type selected as : "+ProjectType);
		prop.selectProjectKind(ProjectKind);
		test.info("Project Kind selected as : "+ProjectKind);
		prop.selectOwnership(Ownership);
		test.info("Ownership selected as : "+Ownership);
		prop.clickOnContinueButton();
		test.info("Continue Button Clicked");
		//
		PropertyDetailsPage pdp = new PropertyDetailsPage(driver);
		WebElement status = wait.until(ExpectedConditions.visibilityOf(pdp.ddPropertyType));
		test.info("Successfully navigates to Property Details page");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		pdp.clickOnTypeDropdown();
		
		WebElement typeLocator = driver.findElement(By.xpath("//li[contains(text(), '"+Type+"')]"));
		try {
			typeLocator.click();
		} catch (Exception e) {
			executor.executeScript("arguments[0].click();", typeLocator);
		}
		
		String[] addDetails = AdditionalDetails.split(",");
		int addDetailsCount = addDetails.length;
		for(int i = 0; i < addDetailsCount; i++){
			String detail = addDetails[i];
			WebElement addDetailsLocator = driver.findElement(By.xpath("//p[contains(text(), '"+detail+"')]/..//input[1]"));
			try {
				addDetailsLocator.click();
			} catch (Exception e) {
				//JavascriptExecutor executor = (JavascriptExecutor) driver;
				//executor.executeScript("arguments[0].click();", pdp.cbFencedPro);
				executor.executeScript("arguments[0].click();", addDetailsLocator);
			}
		}
		
		pdp.enterAddressLine1(Addressline1);
		pdp.enterAddressLine2(Addressline2);
		pdp.enterCity(City);
		pdp.enterState(State);
		pdp.enterZipCode(ZipCode);
		Actions builder = new Actions(driver);
		builder.moveToElement(pdp.txtLatitude).clickAndHold().moveByOffset(300, 0).release().perform();
		pdp.enterNumberOfBedrooms(Numberofbedrooms);
		pdp.enterNumberOfBathrooms(Numberofbathrooms);
		pdp.enterSquareFeets(SquareFeet);
		pdp.enterLotSize(LotSize);
		pdp.enterDescription(Description);
		pdp.uploadAnImage(imgPath);
		Thread.sleep(5000);
		pdp.clickOnContinueButton();
		//
		FlipDetailsPage fdp = new FlipDetailsPage(driver);
		fdp.enterPurchasePrice(PurchasePrice);
		String[] dateSeperator = PurchaseClosingDate.split("/");
		String f_Year = dateSeperator[2].trim();
		String f_Month = dateSeperator[1].trim();
		String f_Day = dateSeperator[0].trim();
		fdp.enterPurchaseClosingDate(f_Month, f_Day);
		fdp.enterEstimatedClosingCosts(EstimatedClosingCosts);
		fdp.clickOnEstimatedRehabTimeDropDown();
		
		String rehabTime = EstimatedRehabTime.trim();
		WebElement rehabTimeLocator = driver.findElement(By.xpath("//li[contains(text(), '"+rehabTime+"')]"));
		try {
			rehabTimeLocator.click();
		  } catch (Exception e) {
		     executor.executeScript("arguments[0].click();", rehabTimeLocator);
		  }
		
		fdp.enterAnualTaxes(AnnualTaxes);
		fdp.enterMonthlyUtilities(MonthlyUtilities);
		fdp.enterMonthlyHOA(MonthlyHOA);
		fdp.enterMonthlyAlarmorSurveillance(MonthlyAlarmorSurveillance);
		fdp.enterOtherMonthlyExpenses(OtherMonthlyExpenses);
		fdp.clickOnContinueButton();
		//
		RehabDetailsPage rdp = new RehabDetailsPage(driver);
		wait.until(ExpectedConditions.visibilityOf(rdp.ddChooseTaskType));
		rdp.clockOnChooseTaskTypeDropdown();
		String taskType = "Mechanical";
		WebElement taskTypeLocator = driver.findElement(By.xpath("//li[contains(text(), '"+taskType+"')]"));
		try {
			taskTypeLocator.click();
		  } catch (Exception e) {
		     executor.executeScript("arguments[0].click();", taskTypeLocator);
		  }
		rdp.enterNameofTask(taskName);
		rdp.enterTaskDetails(taskDetails);
		rdp.enterExpectedCostofLabor(laborCost);
		rdp.enterExpectedCostofMaterials(materialsCost);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		rdp.clockOnTaskStatusDropdown();
		String taskStatus = "In Progress";
		WebElement taskStatusLocator = driver.findElement(By.xpath("//li[contains(text(), '"+taskStatus+"')]"));
		try {
			taskStatusLocator.click();
		  } catch (Exception e) {
		     executor.executeScript("arguments[0].click();", taskStatusLocator);
		  }
		js.executeScript("window.scrollBy(0,250)");
		rdp.clockOnAddTaskButton();
		rdp.clickOnContinueButton();
		//
		ProposalBudgetSummaryPage pbs = new ProposalBudgetSummaryPage(driver);
		pbs.enterExpectedCostofMaterials(FlipperInvestment);
		pbs.clickOnContinueButton();
		//
		SalesSummaryPage ssp = new SalesSummaryPage(driver);
		ssp.enterTargetSalePrice(TargetSalePrice);
		String targetListingDate = TargetListingDate;
		String[] dateSeperator2 = targetListingDate.split("/");
		String f_Year2 = dateSeperator2[2].trim();
		String f_Month2 = dateSeperator2[1].trim();
		String f_Day2 = dateSeperator2[0].trim();
		ssp.selectTargetListingDate(f_Month2, f_Day2);
		ssp.clockOnEstimatedClosingDateAfterRehabDropdown();
		String timeInMonths = EstimatedClosingDateAfterRehab;
		WebElement timeInMonthsLocator = driver.findElement(By.xpath("//li[contains(text(), '"+timeInMonths+"')]"));
		try {
			timeInMonthsLocator.click();
		  } catch (Exception e) {
		     executor.executeScript("arguments[0].click();", timeInMonthsLocator);
		  }
		
		//Go back to dashboard
		ssp.navigatesToDashboard();
		
	}

}
