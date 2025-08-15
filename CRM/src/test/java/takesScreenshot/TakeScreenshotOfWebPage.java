package takesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenshotOfWebPage {

	public static void main(String[] args) throws IOException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://doodles.google/");
		//Take the screenshot
		// step 1: Typecasting
		TakesScreenshot tks= (TakesScreenshot)driver;
		//Step 2: Capture the ss and store in temp
		File temp= tks.getScreenshotAs(OutputType.FILE);
		//Step 3: Create Perm Loc
		File perm= new File("./errorShots/doodle.jpeg");
		//step 4: Copy from temp to perm
		FileHandler.copy(temp, perm);

	}

}
