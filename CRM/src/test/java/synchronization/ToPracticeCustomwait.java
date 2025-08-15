package synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToPracticeCustomwait {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
	
		driver.get("https://www.woodenstreet.com/");
		for(;;) {
			try {
				driver.findElement(By.xpath("//img[@alt='modal-close-img']")).click();
				break;
			}catch (Exception e) {
				Thread.sleep(250);
			}
				
		}
		driver.findElement(By.xpath("//p[text()='Cart (']")).click();
		

	}

}
