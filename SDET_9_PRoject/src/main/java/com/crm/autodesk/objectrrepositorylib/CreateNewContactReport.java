package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;

public class CreateNewContactReport extends WebDriverUtiles{
	WebDriver driver;
	public CreateNewContactReport(WebDriver driver) {  
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "firstname")
	private WebElement firstNameEdt;
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@name='contact_name']/following-sibling::img[@alt='Select']")
	  private WebElement reportLookUpImage;
	
	@FindBy(xpath = "(//input[@alt='Clear'])[2]")
	private WebElement clearBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param orgName
	 * @param serachDropOtp
	 * @param report
	 */
	
	public void createContact(String firstName, String lastName) {
		firstNameEdt.sendKeys(firstName);
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void clearContact(String firstName, String lastName) {
		reportLookUpImage.click();
		//switch to child
		swicthToWindow(driver, "Contacts&action");
		Contacts contPage=new Contacts(driver);
		contPage.getSearchEdt().sendKeys(lastName);
		contPage.getSearchNow().click();
		driver.findElement(By.xpath("//a[contains(@onclick,'"+lastName+"')]")).click();
		//swicth to Parent
		swicthToWindow(driver, "Contacts");
		clearBtn.click();
		
	}

}
