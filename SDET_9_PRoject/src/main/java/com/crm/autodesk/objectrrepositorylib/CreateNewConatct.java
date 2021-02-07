package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.autodesk.genericlib.WebDriverUtiles;

public class CreateNewConatct extends WebDriverUtiles{
	
	WebDriver driver;
	public CreateNewConatct(WebDriver driver) {  
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
	  private WebElement organizationLookUpImage;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	/**
	 * 
	 * @param lastName
	 * @param orgName
	 * @param serachDropOtp
	 */
	public  void createConatct(String lastName , String orgName , String serachDropOtp) {
		waitforElementToBeClickable(driver, lastNameEdt);
		lastNameEdt.sendKeys(lastName);
		organizationLookUpImage.click();
		//swicth to Child
		swicthToWindow(driver, "Accounts&action");
		Organizations orgPage = new Organizations(driver);
		select(orgPage.getInDropDown(),serachDropOtp);
		orgPage.getSearchEdt().sendKeys(orgName);
		orgPage.getSearchNow().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		//swicth to Parent
		swicthToWindow(driver, "Contacts");
		saveBtn.click();
	}
	
	public  void createConatct(String lastName , String orgName ) {
		lastNameEdt.sendKeys(lastName);
		organizationLookUpImage.click();
		//swicth to Child
		swicthToWindow(driver, "Accounts&action");
		Organizations orgPage = new Organizations(driver);

		orgPage.getSearchEdt().sendKeys(orgName);
		orgPage.getSearchNow().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		//swict to Parent
		swicthToWindow(driver, "Contacts");
		saveBtn.click();
	}
	
	public void createContact(String lastName) {
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
}
