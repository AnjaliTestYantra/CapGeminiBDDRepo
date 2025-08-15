package webDriverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToPracticeManageMethod {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.instagram.com/");
		Thread.sleep(3000);
		
		//Manage methods
	//	driver.manage().window().maximize();
	//	Thread.sleep(3000);
//		driver.manage().window().minimize();
//		Thread.sleep(3000);
//		driver.manage().window().fullscreen();
//		Thread.sleep(3000);
//		Dimension sizeOfBrow = driver.manage().window().getSize();
//		System.out.println(sizeOfBrow);
//		Thread.sleep(3000);
//		driver.manage().window().maximize();
//		int width = driver.manage().window().getSize().getWidth();
//		int height = driver.manage().window().getSize().getHeight();
//		System.out.println("Width is: "+width+"\t"+"Height is: "+height);

//		Dimension setSizeOfBrow= new Dimension(1000, 500);
//		driver.manage().window().setSize(setSizeOfBrow);
		
//		System.out.println(driver.manage().window().getPosition());
//		System.out.println(driver.manage().window().getPosition().getX());
//		System.out.println(driver.manage().window().getPosition().getY());
		
		Point setPos = new Point(300, 100);
		driver.manage().window().setPosition(setPos);
	}

}
