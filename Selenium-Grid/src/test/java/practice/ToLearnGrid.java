package practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import baseClassUtility.BaseClass;

public class ToLearnGrid extends BaseClass {
@Test
	public void sampleTest() throws MalformedURLException, InterruptedException {
		//ChromeOptions option= new ChromeOptions();
		//URL ipAddress= new URL("http://10.10.61.122:5555");//divakar
		//URL ipAddress= new URL("http://10.10.61.24:5555");//PC
		//URL ip= new URL("http://10.10.20.54:5555");
		//URL ip= new URL("http://10.10.51.204:4444/wd/hub");
		//RemoteWebDriver driver= new RemoteWebDriver(ip, option);
		driver.manage().window().maximize();
		//RemoteWebDriver driver= new RemoteWebDriver(ip, option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoapps.qspiders.com/ui/virtual?sublist=0");
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.close();
					
	}

}
