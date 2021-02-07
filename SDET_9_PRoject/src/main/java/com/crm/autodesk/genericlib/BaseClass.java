package com.crm.autodesk.genericlib;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Login;
/**
 * Base class having all the common test steps required for every testscript
 * @author Nitheesha
 *
 */
public class BaseClass {
	public FileUtility fLib=new FileUtility();
	public WebDriverUtiles wLib=new WebDriverUtiles();
	public DatabaseUtils dbLib = new DatabaseUtils();
	public JavaUtils jLib = new JavaUtils();
	public ExcelUtility eLib = new ExcelUtility();
	public Login loginPage;

	public WebDriver driver;
	
	@BeforeSuite(groups = {"smokeTest" , "regressionTest"})
	public void configBS() {
		System.out.println("connect to database\n configure extent report");
		dbLib.connectToDB();
	}
	
	/*@BeforeTest(groups = {"smokeTest" , "regressionTest"})
	public void configBT() {
		//used for cross browser exceution
	}*/
	
	@Parameters("browser")
	//@BeforeTest(groups = {"smokeTest" , "regressionTest"})
	public void configBCParallel(String BROWSER) throws Throwable {
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("ie")) {
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		wLib.waitForHTMLDOM(driver);
		driver.get(fLib.getPropertyKeyValue("url"));
	}
	
	/**
	 * Launching the browser in normal mode and entering the url 
	 * @throws Throwable
	 */
	@BeforeClass(groups = {"smokeTest" , "regressionTest"})
	public void configBC() throws Throwable {
		String BROWSER = fLib.getPropertyKeyValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("ie")) {
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		wLib.waitForHTMLDOM(driver);
		driver.get(fLib.getPropertyKeyValue("url"));
	}
	/**
	 * login to Vtiger application
	 * @throws Throwable 
	 */
	@BeforeMethod(groups = {"smokeTest" , "regressionTest"})
	public void configBM() throws Throwable {
		loginPage=new Login(driver);
		loginPage.loginToApp(fLib.getPropertyKeyValue("username"),fLib.getPropertyKeyValue("password"));
	}
	
	
	/**
	 * logout from Vtiger application
	 */
	@AfterMethod(groups = {"smokeTest" , "regressionTest"})
	public void configAM() {
		Home hp = new Home(driver);
		hp.logout();
	}
	
	/**
	 * close the browser
	 */
	@AfterClass(groups = {"smokeTest" , "regressionTest"})
	public void configAC() {
		driver.quit();
	}
	
	//@AfterTest(groups = {"smokeTest" , "regressionTest"})
	public void configAT() {
		//close browser launched in cross browser testing
	}
	
	
	@AfterSuite(groups = {"smokeTest" , "regressionTest"})
	public void configAS() throws SQLException {
		
		System.out.println("close connection to database\n flush extent report");
		dbLib.closeDb();
	}
	
}
