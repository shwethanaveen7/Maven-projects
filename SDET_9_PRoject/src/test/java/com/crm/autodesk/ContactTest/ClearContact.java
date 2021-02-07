package com.crm.autodesk.ContactTest;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.ExcelUtility;
import com.crm.autodesk.genericlib.FileUtility;
import com.crm.autodesk.genericlib.JavaUtils;
import com.crm.autodesk.genericlib.WebDriverUtiles;
import com.crm.autodesk.objectrrepositorylib.Contacts;
import com.crm.autodesk.objectrrepositorylib.CreateNewContactReport;

import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Login;


public class ClearContact {
	/* object  Creation*/
	JavaUtils jLib = new JavaUtils();
	WebDriverUtiles wLib = new WebDriverUtiles();
	FileUtility flib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	@Test
	public void createContactWitORgTest() throws Throwable {

		/* Common Data */
		int randomNum = jLib.generateRandomNum();
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");
		String URL = flib.getPropertyKeyValue("url");
		String BROWSER = flib.getPropertyKeyValue("browser");
	    
		/* test data*/
		String contfirstNAme = eLib.getExcelData("contact", "tc_01", "contFirstName") + randomNum;
		String contLastNAme = eLib.getExcelData("contact", "tc_01", "contLastName") + randomNum;
		
		/* step 1 : open the browser */
		WebDriver driver = null;
		 if(BROWSER.equalsIgnoreCase("firefox")) {
		    driver= new FirefoxDriver();  
		 }else if(BROWSER.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
		 }else if(BROWSER.equalsIgnoreCase("ie")) {
			 driver = new InternetExplorerDriver();
		 }
		
		wLib.waitForHTMLDOM(driver);
		driver.get(URL);
		
		/* step 2 : login to APP */
		  Login lp = new Login(driver);
		  lp.loginToApp(USERNAME, PASSWORD);
		        
		       
		 /* step 3 : place mouse on contact and then click */
		  Home hp= new Home(driver);
		   hp.getContactLnk().click();
		  
		   
		 /* step 4 : navigate to create new Contact page */
		    Contacts cp = new Contacts(driver);
		    cp.getCreateOrgImg().click();
		    
		 /* step 5 : create new contact */
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
