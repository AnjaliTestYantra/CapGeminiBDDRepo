package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ToPracticeTestNG2 {
//	@Test
//	public void m1() {
//		Reporter.log("M1 Executed", true);
//	}
//	@Test
//	public void m123() {
//		Reporter.log("M123 Executed", true);
//	}
//	@Test
//	public void m8() {
//		Reporter.log("M8 Executed", true);
//	}
//	@Test
//	public void m3() {
//		Reporter.log("M3 Executed", true);
//	}
//	@Test
//	public void m5() {
//		Reporter.log("M5 Executed", true);
//	}
	
	@Test
	public void createAccount() {
		Reporter.log("Account Created", true);
	}
	@Test//(dependsOnMethods = "createAccount")
	public void editAccount() {
		Reporter.log("Account Edited", true);
	}
	@Test(dependsOnMethods =  "editAccount")
	public void deleteAccount() {
		Reporter.log("Account deleted", true);
	}
}
