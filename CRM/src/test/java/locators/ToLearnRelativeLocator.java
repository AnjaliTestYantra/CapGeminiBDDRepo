package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class ToLearnRelativeLocator {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(3000);
		WebElement searchTF = driver.findElement(By.id("small-searchterms"));
		searchTF.sendKeys("java");
		//locate search button with the help of relative loc
		WebElement searchBtn = driver.findElement(RelativeLocator.with
								(By.tagName("input")).toRightOf(searchTF));
		searchBtn.click();
		Thread.sleep(5000);
		driver.quit();
	}

}
