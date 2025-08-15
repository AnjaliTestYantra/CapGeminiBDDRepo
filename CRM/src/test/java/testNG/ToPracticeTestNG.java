package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ToPracticeTestNG {
	
	@Test(priority = -2)
	public void  zepto() {
		Reporter.log("Zepto Executed", true);
	}

	@Test(priority = 9)
	public void swiggy() {
		Reporter.log("Swiggy Executed", true);
	}
	
	@Test(priority = 3)
	public void ola() {
		Reporter.log("Ola Executed", true);
	}
	@Test(priority = 3)
	public void blinkIt() {
		Reporter.log("BlinkIt Executed", true);
	}
	@Test(priority = 6)
	public void zomato() {
		Reporter.log("Zomato Executed", true);
	}
}
