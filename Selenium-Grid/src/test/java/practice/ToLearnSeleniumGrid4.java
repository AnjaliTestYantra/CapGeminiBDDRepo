package practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ToLearnSeleniumGrid4 {
@Test
public void sample4Test() throws MalformedURLException, InterruptedException {
	ChromeOptions option= new ChromeOptions();
	URL ip= new URL("http://10.10.20.183:4444/wd/hub");
	RemoteWebDriver driver= new RemoteWebDriver(ip, option);
	driver.manage().window().maximize();
	Reporter.log("Sample test 4", true);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://demoapps.qspiders.com/ui/virtual?sublist=0");
	Thread.sleep(3000);
	driver.quit();
}
}
