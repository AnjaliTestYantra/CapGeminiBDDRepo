package practice2;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import baseClassUtility.BaseClass;

public class ToLearnGrid3 extends BaseClass{
@Test
	public void sampleTest3() throws MalformedURLException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://automationexercise.com/test_cases");
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.close();
		
				
	}

}
