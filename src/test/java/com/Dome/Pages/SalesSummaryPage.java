package com.Dome.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesSummaryPage {
	
	WebDriver ldriver;
	public static WebDriverWait wait;
	
	public SalesSummaryPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[6]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtTargetSalePrice;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[6]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
	@CacheLookup
	WebElement targetListingDate;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div/div/div[1]/div[1]/div/div")
	@CacheLookup
	WebElement txtMonthYear;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div/div/div[1]/div[2]/button[2]")
	@CacheLookup
	WebElement btnNextMonth;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[6]/div[1]/div[1]/div[3]/div[1]/div[1]/button[1]")
	@CacheLookup
	WebElement ddEstimatedClosingDateAfterRehab;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[6]/div[1]/div[1]/div[3]/div[1]/ul[1]/div[1]/li[contains(text(), '2 months')]")
	@CacheLookup
	WebElement optMonths;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[6]/div[1]/div[2]/button[2]")
	@CacheLookup
	WebElement btnSubmitProposal;
	
	@FindBy(xpath="//div[contains(text(),'Dashboard')]")
	@CacheLookup
	WebElement lnkDashboard;
	
	public void enterTargetSalePrice(String salePrice) throws InterruptedException {
		txtTargetSalePrice.sendKeys(salePrice);
	}
	public void selectTargetListingDate(String month, String day) throws InterruptedException {
		
		wait=new WebDriverWait(ldriver, 10);
		targetListingDate.click();
		String[] month_Year = txtMonthYear.getText().split(" ");
		String c_Month = month_Year[0].trim();
		String c_Year = month_Year[1].trim();
		for(int i = 0; i < 12; i++){
			if(!c_Month.equalsIgnoreCase(month)){
				btnNextMonth.click();
				break;
			}
		};
		String paramDay = "//button[contains(text(),'"+day+"')]";
		WebElement selectDay = ldriver.findElement(By.xpath(paramDay));
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(selectDay));
		selectDay.click();
	}
	public void clockOnEstimatedClosingDateAfterRehabDropdown() throws InterruptedException {
		ddEstimatedClosingDateAfterRehab.click();
	}
	public void setTimeInMonths() throws InterruptedException {
		optMonths.click();
	}
	public void navigatesToDashboard() throws InterruptedException {
		lnkDashboard.click();
	}

}
