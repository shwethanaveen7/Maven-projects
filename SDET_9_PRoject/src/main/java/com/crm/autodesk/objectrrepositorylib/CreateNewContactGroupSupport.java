package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.autodesk.genericlib.WebDriverUtiles;

public class CreateNewContactGroupSupport extends WebDriverUtiles{
	
	WebDriver driver;
	public CreateNewContactGroupSupport(WebDriver driver) {  
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "firstname")
	private WebElement firstNameEdt;
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
	  private WebElement organizationLookUpImage;
	
	@FindBy(xpath = "(//input[@name='assigntype'])[2]")
	private WebElement groupRBtn;
	
	@FindBy(name = "assigned_group_id")
	private WebElement AssigngDpn;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param orgName
	 * @param Assigned
	 * @param serachDropOtp
	 */
	public  void createConatct(String firstName, String lastName , String orgName , String Assigned, String serachDropOtp) {
		waitforElementToBeClickable(driver, firstNameEdt);
		firstNameEdt.sendKeys(firstName);
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
		/*Click use radio button*/
		groupRBtn.click();
		select(AssigngDpn, Assigned);
		saveBtn.click();
	}
	
	public  void createConatct(String firstName, String lastName , String orgName, String Assigned) {
		firstNameEdt.sendKeys(firstName);
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
		/*Click use radio button*/
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