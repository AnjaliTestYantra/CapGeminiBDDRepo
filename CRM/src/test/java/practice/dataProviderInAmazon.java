package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderInAmazon {
	@Test(dataProvider = "getData")
	public void getProductInfo(String brandName, String prodName) throws InterruptedException {
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		
		//Search the product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);
		
		//Capture the price of product
		String xpath= "//span[text()='"+prodName+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		String price = driver.findElement(By.xpath(xpath)).getText();
		System.out.println(price);
		Thread.sleep(5000);
		driver.quit();
		}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		FileInputStream efis= new FileInputStream("C:\\Users\\Anjali Unnikrishnan\\Desktop\\Online PPT\\Corporate Training\\CapGemini\\dataProviderData.xlsx");
		Workbook wb = WorkbookFactory.create(efis);
		Sheet sh = wb.getSheet("Iphone");
		int rowCount = sh.getLastRowNum();
		Object [][] objArr= new Object[rowCount][2];
		for(int i= 0; i<rowCount; i++) {
			objArr[i][0]= sh.getRow(i+1).getCell(0).getStringCellValue();
			objArr[i][1]= sh.getRow(i+1).getCell(1).getStringCellValue();
			}
		
		return objArr;
	}

}
