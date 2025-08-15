package baseClassUtility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {
	public RemoteWebDriver driver;

	@Parameters("Browser")
	@BeforeClass
	public void confgBC(String brow) throws MalformedURLException {
		URL ip= new URL("http://10.10.20.183:4444/wd/hub");
		if(brow.equalsIgnoreCase("chrome")) {
			ChromeOptions option= new ChromeOptions();
			driver= new RemoteWebDriver(ip, option);
			}else if(brow.equalsIgnoreCase("edge")) {
				EdgeOptions option= new EdgeOptions();
				driver= new RemoteWebDriver(ip, option);
			}
			else if(brow.equalsIgnoreCase("firefox")) {
				FirefoxOptions option= new FirefoxOptions();
				driver= new RemoteWebDriver(ip, option);
			}
	}

}
