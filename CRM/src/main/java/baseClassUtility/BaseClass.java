package baseClassUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import genericUtility.PropertiesFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	public WebDriver driver = null;
	public static WebDriver sDriver;//listeners
	PropertiesFileUtility putil= new PropertiesFileUtility();
	WebDriverUtility wutil= new WebDriverUtility();
	 
	
	
	
	@BeforeSuite
	public void configBS() {
		Reporter.log("Established the DB Connectivity", true);
	}

	@AfterSuite
	public void configAS() {
		Reporter.log("Closed the DB Connectivity", true);
	}

	@BeforeTest
	public void configBT() {
		Reporter.log("Pre-condition", true);
	}

	@AfterTest
	public void configAT() {
		Reporter.log("Post-condition", true);
	}

	@BeforeClass
	public void configBC() throws IOException {
		 String BROWSER =putil.readDataFromPropertiesFile("Browser");
		//cross browser testing
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}else {
			driver= new ChromeDriver();
		}
		sDriver= driver;
		driver.manage().window().maximize();
		wutil.waitForPageToLoad(driver);
		String URL =putil.readDataFromPropertiesFile("Url");
		driver.get(URL);
		Reporter.log("Navigate to Vtiger", true);

	}

	@AfterClass
	public void configAC() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	@BeforeMethod
	public void configBM() throws IOException {
		 String UNAME = putil.readDataFromPropertiesFile("Username");
		 String PSWD = putil.readDataFromPropertiesFile("Password");
		LoginPage lp = new LoginPage(driver);
//		lp.getUsernameTF().sendKeys(UNAME);
//		lp.getPasswordTF().sendKeys(PSWD);
//		lp.getLoginBtn().click();
		lp.loginToCRM(UNAME, PSWD);
		Reporter.log("Successfully logged in", true);

	}

	@AfterMethod
	public void configAM() {
		HomePage hp= new HomePage(driver);
		hp.logoutFromCRM();

	}

}
