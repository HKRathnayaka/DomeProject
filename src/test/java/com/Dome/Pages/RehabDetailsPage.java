package com.Dome.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RehabDetailsPage {
	
	WebDriver ldriver;
	
	public RehabDetailsPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")
	@CacheLookup
	public WebElement ddChooseTaskType;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[4]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]//li[contains(text(), 'Mechanical')]")
	@CacheLookup
	WebElement optTaskType;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[4]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtNameofTask;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[4]/div[1]/div[1]/div[1]/div[3]/div[1]/textarea[1]")
	@CacheLookup
	WebElement txtTaskDetails;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[4]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtExpectedCostofLabor;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[4]/div[1]/div[1]/div[1]/div[5]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtExpectedCostofMaterials;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]")
	@CacheLookup
	WebElement ddTaskStatus;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[4]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/div[1]/li[contains(text(), 'In Progress')]")
	@CacheLookup
	WebElement optStatus;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[4]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/input[1]")
	@CacheLookup
	WebElement EstimatedStartDate;
	
	@FindBy(xpath="//button[contains(text(),'11')]")
	@CacheLookup
	WebElement btnStartDate;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[4]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/input[1]")
	@CacheLookup
	WebElement EstimatedCompletionDate;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/button[7]")
	@CacheLookup
	WebElement btnCompletionDate;
	
	@FindBy(xpath="//*[@id=\"__next\"]/div/div[1]/div/div/div/section[4]/div/div[1]/div[2]/div[5]/button")
	@CacheLookup
	WebElement btnAddTask;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[4]/div[1]/div[3]/button[2]")
	@CacheLookup
	WebElement btnCountinue4;
	
	public void clockOnChooseTaskTypeDropdown() throws InterruptedException {
		ddChooseTaskType.click();
	}
	public void selectTaskType() throws InterruptedException {
		optTaskType.click();
	}
	public void enterNameofTask(String tName) throws InterruptedException {
		txtNameofTask.sendKeys(tName);
	}
	public void enterTaskDetails(String tDetails) throws InterruptedException {
		txtTaskDetails.sendKeys(tDetails);
	}
	public void enterExpectedCostofLabor(String laborCost) throws InterruptedException {
		txtExpectedCostofLabor.sendKeys(laborCost);
	}
	public void enterExpectedCostofMaterials(String materialsCost) throws InterruptedException {
		txtExpectedCostofMaterials.sendKeys(materialsCost);
	}
	public void clockOnTaskStatusDropdown() throws InterruptedException {
		ddTaskStatus.click();
	}
	public void selectTaskStatus() throws InterruptedException {
		optStatus.click();
	}
	public void selectEstimatedStartDate() throws InterruptedException {
		EstimatedStartDate.click();
		Thread.sleep(1000);
		btnStartDate.click();
	}
	public void selectEstimatedCompletionDate() throws InterruptedException {
		EstimatedCompletionDate.click();
		Thread.sleep(1000);
		btnCompletionDate.click();
	}
	public void clockOnAddTaskButton() throws InterruptedException {
		btnAddTask.click();
	}
	public void clickOnContinueButton() throws InterruptedException {
		btnCountinue4.click();
	}

}
