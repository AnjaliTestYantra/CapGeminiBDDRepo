package listenersUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseClassUtility.BaseClass;
import genericUtility.JavaUtility;


public class ListenersImplementationClass implements ISuiteListener, ITestListener{
	JavaUtility jutil= new JavaUtility();
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String tcName = result.getMethod().getMethodName();
		Reporter.log("=======STARTED======"+tcName, true);
		 test = report.createTest(tcName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String tcName = result.getMethod().getMethodName();
		Reporter.log("=======SUCCESS======"+tcName, true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String tcName = result.getMethod().getMethodName();
		test= report.createTest(tcName);
		String time = jutil.dateForScreenshot();
		Reporter.log("=======FAILED======"+tcName, true);
		TakesScreenshot tks= (TakesScreenshot) BaseClass.sDriver;
		String ss = tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(ss);
//		File temp = tks.getScreenshotAs(OutputType.FILE);
//		File perm= new File("./errorShots/"+tcName+time+".png");
//		try {
//			FileHandler.copy(temp, perm);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		test.log(Status.FAIL, "=======FAILED======");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String tcName = result.getMethod().getMethodName();
		Reporter.log("=======SKIPPED======"+tcName, true);
	}

	@Override
	public void onStart(ISuite suite) {
		Reporter.log("Report configuration", true);
		String time = jutil.dateForScreenshot();
		ExtentSparkReporter spark= new ExtentSparkReporter("./AdvanceReports/Report_"+time+".html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("VTigerCRM");
		spark.config().setReportName("CRM -Report");
		report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows11");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Author", "Anjali");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("Report Back up", true);
		report.flush();
	}
	
	

}
