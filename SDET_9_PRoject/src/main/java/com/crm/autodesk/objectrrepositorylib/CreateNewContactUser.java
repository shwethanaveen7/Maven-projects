package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.autodesk.genericlib.WebDriverUtiles;

public class CreateNewContactUser extends WebDriverUtiles{
	
	WebDriver driver;
	public CreateNewContactUser(WebDriver driver) {  
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "firstname")
	private WebElement firstNameEdt;
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "(//input[@name='assigntype'])[1]")
	private WebElement userRBtn;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	/**
	 * @param firstName
	 * @param lastName
	 */
	public  void createConatct(String firstName, String lastName) {
		waitforElementToBeClickable(driver, firstNameEdt);
		firstNameEdt.sendKeys(firstName);
		lastNameEdt.sendKeys(lastName);
		/*Click use radio button*/
		userRBtn.click();
		saveBtn.click();
	}
	
}

