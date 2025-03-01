package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import reports.ExtentReportsLog;

public class Base {

	public static ExtentReports extent;

	public static ExtentTest test;

	
	@BeforeSuite
	public static void setupReports() {
		
		if(extent==null ) {
			
			extent = ExtentReportsLog.getInstance();

		}


	}

	public static void createTest(String testName) {

		test = extent.createTest(testName);

	}

	protected static WebDriver driver; // Shared static driver

	public static WebDriver getDriver() {
		if (driver == null) { // Initialize only once
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://demoqa.com/elements"); // Open the website
			System.out.println("Driver setup done, browser opened.");
		}
		return driver; // Return the initialized driver
	}

	@AfterSuite
	public void flushReport() {

		if (extent != null) {

			extent.flush();

			System.out.println("extent reports flushed");
		}
	}

	public  void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {

			test.pass("test passed:" + result.getName());
		} else if (result.getStatus() == ITestResult.FAILURE) {

			test.fail("test Failed: " + result.getName());
		}

	}

	/*
	 * public static void quitDriver() { if (driver != null) { driver.quit(); driver
	 * = null; // Reset the driver after quitting
	 * System.out.println("Driver closed."); } }
	 */
}
