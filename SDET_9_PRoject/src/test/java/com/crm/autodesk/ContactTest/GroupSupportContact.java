package com.crm.autodesk.ContactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.BaseClass;
import com.crm.autodesk.genericlib.ExcelUtility;
import com.crm.autodesk.genericlib.FileUtility;
import com.crm.autodesk.genericlib.JavaUtils;
import com.crm.autodesk.genericlib.WebDriverUtiles;
import com.crm.autodesk.objectrrepositorylib.Contacts;
import com.crm.autodesk.objectrrepositorylib.CreateNewContactGroupMarketing;

import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Login;

public class GroupSupportContact extends BaseClass{
	/* object  Creation*/
	JavaUtils jLib = new JavaUtils();
	WebDriverUtiles wLib = new WebDriverUtiles();
	FileUtility flib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	@Test
	public void createContactWitORgTest() throws Throwable {
		int randomNum = jLib.generateRandomNum();
	    
		/* test data*/
		String AssignDpn = eLib.getExcelData("contact", "tc_01", "AssignDpn2");
		
		String contfirstNAme = eLib.getExcelData("contact", "tc_01", "contFirstName") + randomNum;
		String contLastNAme = eLib.getExcelData("contact", "tc_01", "contLastName") + randomNum;
		
				    
		/* step 1 : place mouse on contact and then click */
		  Home hp = new Home(driver);
		  WebElement contactBtn = hp.getContactLnk();
		   wLib.moveToExpectedElemnet(driver, contactBtn);
		   contactBtn.click();
		   
		 /* step 2 : navigate to create new Contact page */
		    Contacts cp = new Contacts(driver);
		    cp.getCreateOrgImg().click();
		    
		 /* step 3 : create new contact with selecting marketing group in group  */
		    CreateNewContactGroupMarketing cngm=new CreateNewContactGroupMarketing(driver);
		    cngm.createConatct(contfirstNAme, contLastNAme, AssignDpn);
		    
		 /* step 4 : logout & close */
            hp.logout();
            driver.close();
	}
}
