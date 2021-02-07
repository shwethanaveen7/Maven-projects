package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.autodesk.genericlib.WebDriverUtiles;

public class CreateNewContactGroupMarketing extends WebDriverUtiles{
	
	WebDriver driver;
	public CreateNewContactGroupMarketing(WebDriver driver) {  
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "firstname")
	private WebElement firstNameEdt;
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "(//input[@name='assigntype'])[2]")
	private WebElement groupRBtn;
	
	@FindBy(name = "assigned_group_id")
	private WebElement AssigngDpn;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param Assigned
	 */
	public  void createConatct(String firstName, String lastName , String Assigned) {
		waitforElementToBeClickable(driver, firstNameEdt);
		firstNameEdt.sendKeys(firstName);
		lastNameEdt.sendKeys(lastName);
		groupRBtn.click();
		select(AssigngDpn, Assigned);
		saveBtn.click();
	}
	
	public void createContact(String firstName, String lastName) {
		firstNameEdt.sendKeys(firstName);
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
}

