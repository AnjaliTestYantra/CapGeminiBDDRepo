package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class ToLearnHelperAttribute {
	@Test(invocationCount = 5, threadPoolSize = 3)
	public void sample() throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		Thread.sleep(3000);
		driver.quit();
	}

}
