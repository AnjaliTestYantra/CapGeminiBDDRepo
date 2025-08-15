package practice2;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import baseClassUtility.BaseClass;

public class ToLearnGrid2 extends BaseClass {
@Test
	public void sampleTest2() throws MalformedURLException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com/");
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.close();
		
				
	}

}
