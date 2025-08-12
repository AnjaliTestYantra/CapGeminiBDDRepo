package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathByContains_Startswith {

	public static void main(String[] args) throws InterruptedException{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://demowebshop.tricentis.com/");
	    Thread.sleep(3000);
	    driver.findElement(By.linkText("Log in")).click();
	    //click on login button
	    driver.findElement(By.xpath("//input[@type='submit' and @value='Log in']")).click();
	    //Print the error message
	  WebElement errorMessage = driver.findElement(By.xpath(" //span[contains(text(),'unsuccessful')]"));
			  //driver.findElement(By.xpath("//span[starts-with(text(),'Login')]"));
	  System.out.println(errorMessage.getText());
	  //span[starts-with(text(),'Login')]
	  //span[contains(text(),'unsuccessful')]
	    

	}

}
