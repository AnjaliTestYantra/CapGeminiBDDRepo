package vtigerCRM;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithMandatoryDetails {

	public static void main(String[] args) throws InterruptedException {
		//Step1 : LKaunch the browser
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Step 2: Navigate to vtiger CRM
		driver.get("http://localhost:8888/");
		System.out.println("Navigate to Vtiger");
		
		//step 3: login
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
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
		driver.findElement(By.name("lastname")).sendKeys("godi_"+ranNum);
		
		//STep 7: click on save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8: Verify the contact info
		WebElement headerInfo= driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String message = headerInfo.getText();
		if(message.contains("godi_"+ranNum)) {
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
