package selenium_framework_design_resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {

	public static ExtentReports getReportObject() {

		String path = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Tutorials Point Automation Test Results");
		reporter.config().setDocumentTitle("Tutorials Point Forms Automation Test");

		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("QA", "Abhishek Samal");
		return report;
	}
}
