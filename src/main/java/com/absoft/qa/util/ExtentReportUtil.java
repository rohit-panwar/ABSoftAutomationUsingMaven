package com.absoft.qa.util;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportUtil {

	ExtentReports reports;
	ExtentTest testInfo;
	ExtentHtmlReporter htmlReporter;
	
	// Before Test
	public void extentReportSetUp() {
		htmlReporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/AutomationReport.html"));
		htmlReporter.loadXMLConfig("C:\\Users\\Rohit\\eclipse-workspace\\ABSoftAutomation\\"
				+ "src\\main\\java\\com\\absoft\\qa\\util\\Extent-Report.xml");
		reports=new ExtentReports();
		reports.setSystemInfo("Envt", "QA");
		reports.attachReporter(htmlReporter);
	}

	// After Test
	public void extentReportcleanUp() {
		reports.flush();
	}
	
	// Before Method
	public void extendReportRegister(Method method) {
		String testName= method.getName();
		testInfo= reports.createTest(testName);
	}
	
	// After Method
	public void extendReportCaptureStatus(ITestResult result) {
		if(result.getStatus()== ITestResult.SUCCESS) {
			testInfo.log(Status.PASS, "I am PASS: "+result.getName());
		} else if(result.getStatus()== ITestResult.FAILURE) {
			testInfo.log(Status.FAIL, "I am FAIL: "+result.getName());
		} else if(result.getStatus()== ITestResult.SKIP) {
			testInfo.log(Status.SKIP, "I am SKIPPED: "+result.getName());
		} 
	}
}
