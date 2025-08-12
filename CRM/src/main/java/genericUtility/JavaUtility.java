package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int generateRandomNumber() {
		Random ran= new Random();
		int r = ran.nextInt(3000);
		return r;
	}
	
	public String generateSystemDateYYYYMMDD() {
		Date d= new Date();
		SimpleDateFormat simple= new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = simple.format(d);
		return currentDate;
	}
	
	public String generateRequiredDateYYYMMDD(int days) {
		Date d= new Date();
		SimpleDateFormat simple= new SimpleDateFormat("yyyy-MM-dd");
		simple.format(d);
		Calendar cal = simple.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = simple.format(cal.getTime());
		return reqDate;
	}
	
	public String dateForScreenshot() {
		Date d= new Date();
		String sysDate = d.toString().replace(" ", "_").replace(":", "_");
		return sysDate;
	}

}
