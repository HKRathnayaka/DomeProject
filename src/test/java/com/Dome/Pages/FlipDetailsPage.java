package com.Dome.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipDetailsPage {
	
	WebDriver ldriver;
	public static WebDriverWait wait;
	
	public FlipDetailsPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtPurchasePrice;
	/*/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]*/
	@FindBy(xpath="//label[contains(text(),'Purchase Closing Date')]/../div[1]/div/input")
	@CacheLookup
	WebElement purchaseClosingDate;
	/*/html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[5]/button[5]*/
	@FindBy(xpath="/html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[5]/button[5]")
	@CacheLookup
	WebElement btnDay;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div/div/div[1]/div[1]/div/div")
	@CacheLookup
	WebElement txtMonthYear;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div/div/div[1]/div[1]/button/svg")
	@CacheLookup
	WebElement btnYears;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")
	@CacheLookup
	List<WebElement> lstYears;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div/div/div[1]/div[2]/button[2]")
	@CacheLookup
	WebElement btnNextMonth;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[3]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtEstimatedClosingCosts;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[3]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/button[1]")
	@CacheLookup
	WebElement ddEstimatedRehabTime;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[3]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]//li[contains(text(), '2')]")
	@CacheLookup
	WebElement optTime;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[3]/div[1]/div[1]/div[1]/div[5]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtAnualTaxes;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtMonthlyUtilities;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtMonthlyHOA;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[3]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtMonthlyAlarmorSurveillance;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[3]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtOtherMonthlyExpenses;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[3]/div[1]/div[3]/button[2]")
	@CacheLookup
	WebElement btnContinue3;
	
	public void enterPurchasePrice(String pPrice) throws InterruptedException {
		txtPurchasePrice.sendKeys(pPrice);
	}
	public void enterPurchaseClosingDate(String month, String day) throws InterruptedException {
		
		wait=new WebDriverWait(ldriver, 10);
		purchaseClosingDate.click();
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(txtMonthYear));
		String[] month_Year = txtMonthYear.getText().split(" ");
		String c_Month = month_Year[0].trim();
		String c_Year = month_Year[1].trim();
		for(int i = 0; i < 12; i++){
			if(!c_Month.equalsIgnoreCase(month)){
				btnNextMonth.click();
				break;
			}
		}
		String paramDay = "//button[contains(text(),'"+day+"')]";
		WebElement selectDay = ldriver.findElement(By.xpath(paramDay));
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(selectDay));
		selectDay.click();
	}
//	public void enterPurchaseClosingDate(WebDriver driver) throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		purchaseClosingDate.click();
//		wait.until(ExpectedConditions.visibilityOf(btnDay)).click();
//	}
	public void enterEstimatedClosingCosts(String closingCosts) throws InterruptedException {
		txtEstimatedClosingCosts.sendKeys(closingCosts);
	}
	public void clickOnEstimatedRehabTimeDropDown() throws InterruptedException {
		ddEstimatedRehabTime.click();
	}
	public void selectTime() throws InterruptedException {
		optTime.click();
	}
	public void enterAnualTaxes(String taxes) throws InterruptedException {
		txtAnualTaxes.clear();
		txtAnualTaxes.sendKeys(taxes);
	}
	public void enterMonthlyUtilities(String utilities) throws InterruptedException {
		txtMonthlyUtilities.clear();
		txtMonthlyUtilities.sendKeys(utilities);
	}
	public void enterMonthlyHOA(String hoa) throws InterruptedException {
		txtMonthlyHOA.clear();
		txtMonthlyHOA.sendKeys(hoa);
	}
	public void enterMonthlyAlarmorSurveillance(String alarm) throws InterruptedException {
		txtMonthlyAlarmorSurveillance.clear();
		txtMonthlyAlarmorSurveillance.sendKeys(alarm);
	}
	public void enterOtherMonthlyExpenses(String other) throws InterruptedException {
		txtOtherMonthlyExpenses.clear();
		txtOtherMonthlyExpenses.sendKeys(other);
	}
	public void clickOnContinueButton() throws InterruptedException {
		btnContinue3.click();
	}

}
