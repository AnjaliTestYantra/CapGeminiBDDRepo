package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLearnXpathByAttribute {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://demowebshop.tricentis.com/");
	    Thread.sleep(3000);
	    //Search books
	    driver.findElement(By.id("small-searchterms")).sendKeys("Books");
	    //click on search Button
	    driver.findElement(By.xpath("//input[@value='Search']")).click();
	}

}
