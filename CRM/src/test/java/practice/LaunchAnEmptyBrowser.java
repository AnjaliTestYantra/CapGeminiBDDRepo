package practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchAnEmptyBrowser {

	public static void main(String[] args) {
//		WebDriver driver= new ChromeDriver();
//		Date d= new Date();
//		System.out.println(d);
//		SimpleDateFormat simple= new SimpleDateFormat("yyyy-MM-dd");
//		String currentDate = simple.format(d);
//		System.out.println(currentDate);

		
		Date d= new Date();
		System.out.println(d);
		String sysDate = d.toString().replace(" ", "_").replace(":", "_");
		System.out.println(sysDate);
		
//		SimpleDateFormat simple= new SimpleDateFormat("yyyy-MM-dd");
//		simple.format(d);
//		Calendar cal = simple.getCalendar();
//		cal.add(Calendar.DAY_OF_MONTH, 90);
//		String reqDate = simple.format(cal.getTime());
//		System.out.println(reqDate);
		
	}

}
