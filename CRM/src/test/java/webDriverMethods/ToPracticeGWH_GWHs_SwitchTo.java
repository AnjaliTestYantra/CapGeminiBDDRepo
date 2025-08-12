package webDriverMethods;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToPracticeGWH_GWHs_SwitchTo {
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://shoppersstack.com/products_page/29");
		Thread.sleep(10000);
		driver.findElement(By.id("compare")).click();
		 String parentID = driver.getWindowHandle();//parent ID //23704F4E2BD0742D517C9E9D5A88AAF9
		 Set<String> allWindowIds = driver.getWindowHandles();//Parent and child ID
		 System.out.println(parentID);
		 System.out.println(allWindowIds);
		 allWindowIds.remove(parentID);
		 for(String winId:allWindowIds) {
			 driver.switchTo().window(winId);
			 Thread.sleep(1000);
			 driver.close();
			 }
driver.switchTo().window(parentID);
Thread.sleep(2000);
driver.close();
	}

}
