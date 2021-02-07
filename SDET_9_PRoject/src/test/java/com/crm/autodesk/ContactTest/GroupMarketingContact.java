package com.crm.autodesk.ContactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.BaseClass;
import com.crm.autodesk.genericlib.ExcelUtility;
import com.crm.autodesk.genericlib.FileUtility;
import com.crm.autodesk.genericlib.JavaUtils;
import com.crm.autodesk.genericlib.WebDriverUtiles;
import com.crm.autodesk.objectrrepositorylib.ContactInfo;
import com.crm.autodesk.objectrrepositorylib.Contacts;
import com.crm.autodesk.objectrrepositorylib.CreateNewContactGroupMarketing;
import com.crm.autodesk.objectrrepositorylib.CreateNewContactReport;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Login;

public class GroupMarketingContact extends BaseClass{
	/*Group Marketing Contact*/
	@Test(groups= "smokeTest")
	public void createContactWitORgTest() throws Throwable {
		int randomNum = jLib.generateRandomNum();
		/* test data*/
		String AssignDpn = eLib.getExcelData("contact", "tc_01", "AssignDpn1");
		String contfirstNAme = eLib.getExcelData("contact", "tc_01", "contFirstName") + randomNum;
		String contLastNAme = eLib.getExcelData("contact", "tc_01", "contLastName") + randomNum;
		       
		/* step 1 : place mouse on contact and then click */
		  Home hp=new Home(driver);
		  WebElement contactBtn = hp.getContactLnk();
		   wLib.moveToExpectedElemnet(driver, contactBtn);
		   contactBtn.click();
		   
		 /* step 2 : navigate to create new Contact page */
		    Contacts cp = new Contacts(driver);
		    cp.getCreateOrgImg().click();
		    
		 /* step 3 : create new contact with selecting marketing group in group  */
		    CreateNewContactGroupMarketing cngm=new CreateNewContactGroupMarketing(driver);
		    cngm.createConatct(contfirstNAme, contLastNAme, AssignDpn);
		    
		  /*verify */
		    ContactInfo info1 = new ContactInfo(driver);
		    String actSuccessfullMsg1 = info1.getSuccessFullMSG().getText();
		    Assert.assertTrue(actSuccessfullMsg1.contains(contLastNAme));
	}
		    /*2)Clear Contact data*/
		    
		    @Test(groups = "regressionTest")
			public void createContactWitORgTest1() throws Throwable {
		    	int randomNum = jLib.generateRandomNum();
			    
				/* test data*/
				String contfirstNAme = eLib.getExcelData("contact", "tc_01", "contFirstName") + randomNum;
				String contLastNAme = eLib.getExcelData("contact", "tc_01", "contLastName") + randomNum;
				
				        
				       
				 /* step 1 : place mouse on contact and then click */
				 Home hp=new Home(driver);
				  WebElement contactBtn = hp.getContactLnk();
				   wLib.moveToExpectedElemnet(driver, contactBtn);
				   contactBtn.click();
				  
				   
				 /* step 2 : navigate to create new Contact page */
				    Contacts cp = new Contacts(driver);
				    cp.getCreateOrgImg().click();
				    
				 /* step 3 : create new contact */
			      CreateNewContactReport cnc=new CreateNewContactReport(driver);
			      cnc.createContact(contfirstNAme, contLastNAme);
			      /* Selecting the created contact  and clear */
			      hp.getContactLnk().click();
			      cp.getCreateOrgImg().click();
			      cnc.clearContact(contfirstNAme, contLastNAme);
			      cnc.createContact(contfirstNAme, contLastNAme);
			      
			      /* step 9 : logout & close */
		          hp.logout();
		          driver.quit();
			      
				 
			}
		
	
}

