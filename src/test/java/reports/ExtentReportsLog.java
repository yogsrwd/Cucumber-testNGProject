package reports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsLog {

	public static ExtentTest test;

	public static ExtentReports extent;

	public static ExtentReports getInstance() {

		if (extent == null) {

			// Set new folder for reports
			String reportFolder = System.getProperty("user.dir") + "/new-test-output";

			// Set the path for the report inside the new folder
			String reporterPath = reportFolder + "/ExtentReport.html";

			// Create the new report directory if it doesn't exist
			File reportDir = new File(reportFolder);

			if (!reportDir.exists()) {
				reportDir.mkdir(); // Creates the new folder
			}

			// Initialize the ExtentSparkReporter with the new report path
			ExtentSparkReporter reporter = new ExtentSparkReporter(reporterPath);

			reporter.config().setReportName("Automation test results QATools");
			reporter.config().setDocumentTitle("Test Report");

			// Initialize ExtentReports and attach the reporter
			extent = new ExtentReports();
			extent.attachReporter(reporter);

			extent.setSystemInfo("Tester Name", "yogesh");
			extent.setSystemInfo("Testing Environment", "Windows 11");
			extent.setSystemInfo("Browser", "Chrome");
		}

		return extent;
	}
}
