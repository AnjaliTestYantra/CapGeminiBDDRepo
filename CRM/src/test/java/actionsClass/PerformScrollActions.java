package actionsClass;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PerformScrollActions {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://doodles.google/");
		
		//Scroll Actions
		Actions act= new Actions(driver);
		act.scrollByAmount(0, 500).perform();
		Thread.sleep(2000);
		act.scrollByAmount(0, 500).perform();
		Thread.sleep(2000);
		act.scrollByAmount(0, -300).perform();

		driver.get("https://demowebshop.tricentis.com/");
		WebElement googlePlus = driver.findElement(By.linkText("Google+"));
		act.scrollToElement(googlePlus).perform();
		
	}

}
