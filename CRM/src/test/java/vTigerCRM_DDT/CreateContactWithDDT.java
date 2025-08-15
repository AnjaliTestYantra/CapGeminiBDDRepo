package vTigerCRM_DDT;

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

public class CreateContactWithDDT {

	public static void main(String[] args) throws IOException, InterruptedException {
		 WebDriver driver = null;
		//DataDrivenTesting
		//Read the data from prop
		FileInputStream pfis= new FileInputStream("./configAppData/CommonData.properties");
		Properties prop= new Properties();
		prop.load(pfis);
		String URL = prop.getProperty("Url");
		String UNAME = prop.getProperty("Username");
		String PSWD = prop.getProperty("Password");
		String BROWSER = prop.getProperty("Browser");
		
		//Read the data from excel file
		FileInputStream efis= new FileInputStream("./configAppData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(efis);
		String lastname = wb.getSheet("Contact").getRow(1).getCell(2).getStringCellValue();
		
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
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				//Step 2: Navigate to vtiger CRM
				driver.get(URL);
				System.out.println("Navigate to Vtiger");
				
				//step 3: login
				driver.findElement(By.name("user_name")).sendKeys(UNAME);
				driver.findElement(By.name("user_password")).sendKeys(PSWD);
				driver.findElement(By.id("submitButton")).click();
				System.out.println("Successfully logged in");
				
				//step 4: Navigate to contact module
				driver.findElement(By.linkText("Contacts")).click();
				System.out.println("Navigated to contact page");
				
				//step 5: : click on aadd contact lookup image
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				
				//Genrate Random Number
				Random r = new Random();
				int ranNum = r.nextInt(500);
				
				//STep 6: Enter mandatory details
				driver.findElement(By.name("lastname")).sendKeys(lastname+ranNum);
				
				//STep 7: click on save 
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Step 8: Verify the contact info
				WebElement headerInfo= driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
				String message = headerInfo.getText();
				if(message.contains(lastname+ranNum)) {
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
