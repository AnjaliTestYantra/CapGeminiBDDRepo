package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLearnLinktextAndPartialLinkText {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(3000);
		//click on register link
		driver.findElement(By.linkText("Register")).click();
		
		//Click on books
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Books")).click();
		
		Thread.sleep(5000);
		driver.quit();
	}

}
