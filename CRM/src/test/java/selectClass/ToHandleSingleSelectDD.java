package selectClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ToHandleSingleSelectDD {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");
		//Handle Country Dropdown
		WebElement countryDD= driver.findElement(By.name("country"));
		
		Select countrySel= new Select(countryDD);
		countrySel.selectByValue("IN");	
		Thread.sleep(3000);
		countrySel.selectByVisibleText("Uganda");
		Thread.sleep(3000);
	List<WebElement> allCountries = countrySel.getOptions();
		//countrySel.deselectByValue("UG");
	for(WebElement ele:allCountries) {
		System.out.println(ele.getText());
		Thread.sleep(1000);
	}
	}

}
