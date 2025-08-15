package vtigerCRMUsingGU_POM;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertiesFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.LoginPage;

public class CreateContactWithGU_POM {

	public static void main(String[] args) throws IOException, InterruptedException {
		 WebDriver driver = null;
		//DataDrivenTesting
		//Read the data from prop
		 PropertiesFileUtility putil= new PropertiesFileUtility();
		 String URL =putil.readDataFromPropertiesFile("Url");
		 String UNAME = putil.readDataFromPropertiesFile("Username");
		 String PSWD = putil.readDataFromPropertiesFile("Password");
		 String BROWSER =putil.readDataFromPropertiesFile("Browser");
		
		//Genrate Random Number
			JavaUtility jutil= new JavaUtility();
			int r= jutil.generateRandomNumber();
		
		//Read the data from excel file
		 ExcelFileUtility eutil= new ExcelFileUtility();
		 String lastname = eutil.toReadDataFromExcelFile("Contact", 1, 2)+r;
		
		
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
		
		//Step1 : Launch the browser
				
				driver.manage().window().maximize();

				WebDriverUtility wutil= new WebDriverUtility();
				wutil.waitForPageToLoad(driver);
				
				//Step 2: Navigate to vtiger CRM
				driver.get(URL);
				System.out.println("Navigate to Vtiger");
				
				//step 3: login
				LoginPage lp = new LoginPage(driver);
				lp.getUsernameTF().sendKeys(UNAME);
				lp.getPasswordTF().sendKeys(PSWD);
				lp.getLoginBtn().click();
				System.out.println("Successfully logged in");
				
				//step 4: Navigate to contact module
				driver.findElement(By.linkText("Contacts")).click();
				System.out.println("Navigated to contact page");
				
				//step 5: : click on aadd contact lookup image
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				
				
				
				//STep 6: Enter mandatory details
				driver.findElement(By.name("lastname")).sendKeys(lastname);
				
				//STep 7: click on save 
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Step 8: Verify the contact info
				WebElement headerInfo= driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
				String message = headerInfo.getText();
				if(message.contains(lastname)) {
					System.out.println("Successfully created the contact");
				}else {
					System.out.println("Failed to create the contact");
				}
				
				//stpe 9: log out
				WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				
				Actions act= new Actions(driver);
				act.moveToElement(administrator).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				
				//Step 10: CLose the browser
				Thread.sleep(3000);
				driver.quit();

	}

}
