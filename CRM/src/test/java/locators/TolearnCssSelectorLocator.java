package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TolearnCssSelectorLocator {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(3000);
		//search books
		driver.findElement(By.id("small-searchterms")).sendKeys("Books");
		//click on search button
		driver.findElement(By.cssSelector("input[value='Search']")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
