package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.autodesk.genericlib.WebDriverUtiles;

public class CreateNewContactLead extends WebDriverUtiles{
	
	WebDriver driver;
	public CreateNewContactLead(WebDriver driver) {  
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "firstname")
	private WebElement firstNameEdt;
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name = "leadsource")
	private WebElement LeadSourceDpn;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param LeadSource
	 */
	public  void createConatct(String firstName, String lastName, String Lead) {
		waitforElementToBeClickable(driver, firstNameEdt);
		firstNameEdt.sendKeys(firstName);
		lastNameEdt.sendKeys(lastName);
		select(LeadSourceDpn, Lead);
		saveBtn.click();
	}
	
	public void createContact(String firstName, String lastName) {
		firstNameEdt.sendKeys(firstName);
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
}
