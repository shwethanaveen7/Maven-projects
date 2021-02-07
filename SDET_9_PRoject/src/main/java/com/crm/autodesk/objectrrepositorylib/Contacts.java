package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts {
	public Contacts(WebDriver driver) {             
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createOrgImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchNow;
	
	

	public WebElement getSearchEdt() {
		return searchEdt;
	}



	public WebElement getSearchNow() {
		return searchNow;
	}



	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}
	
	

}
