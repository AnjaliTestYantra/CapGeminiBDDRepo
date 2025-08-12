package vtigerCRM_TestNG;

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
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClassUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertiesFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactsPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
@Listeners(listenersUtility.ListenersImplementationClass.class)
public class CreateContactWithTestNG extends BaseClass{
	@Test
	public void createContactTest() throws IOException, InterruptedException {

		//Genrate Random Number
			JavaUtility jutil= new JavaUtility();
			int r= jutil.generateRandomNumber(); 
		
		//Read the data from excel file
		 ExcelFileUtility eutil= new ExcelFileUtility();
		// String lastname = eutil.toReadDataFromExcelFile("Contact", 1, 2)+r;
		
				//step 4: Navigate to contact module
				HomePage hp = new HomePage(driver);
				hp.getContactsLink().click();
				Reporter.log("Navigated to contact page", true);
				
				//step 5: : click on aadd contact lookup image
				ContactsPage cp = new ContactsPage(driver);
				cp.getCreateContactBtn().click();
				
				//STep 6: Enter mandatory details
				CreateNewContactsPage ccp = new CreateNewContactsPage(driver);
				ccp.getLastNameTF().sendKeys("Anjali");
				
				//STep 7: click on save 
				ccp.getSaveBtn().click();
				
				//Step 8: Verify the contact info
				ContactsInfoPage cip= new ContactsInfoPage(driver);
				WebElement headerInfo=cip.getHeaderMsg();
				String message = headerInfo.getText();
				
				//Hard Assert
//				Assert.assertEquals("Anjali", "Anju", "Failed to create the contact");
//				Reporter.log("Successfully created the contact", true);
//				
				SoftAssert soft = new SoftAssert();
				soft.assertEquals("Anjali", "Anju","Failed to create the contact" );
				Reporter.log("Successfully created the contact", true);
				
				soft.assertEquals(true, false, "Fail");
				Reporter.log("Pass", true);
				
				
				
//				if(message.equalsIgnoreCase("Anju")) {
//					Reporter.log("Successfully created the contact", true);
//				}else {
//					Reporter.log("Failed to create the contact", true);
//				}
			
				soft.assertAll();
	}

}
