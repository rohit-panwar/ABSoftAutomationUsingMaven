package com.absoft.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.absoft.qa.util.TestUtil;
import com.absoft.qa.util.WebEventListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
//import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {
		// TODO Auto-generated constructor stub
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Rohit\\eclipse-workspace\\"
					+ "ABSoftAutomation\\src\\main\\java\\com\\absoft\\qa\\config\\config.properties");

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initilization() {
		String browserName = prop.getProperty("BROWSER");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\R\\BrowserDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\R\\BrowserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Page_Implicit_Wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
	}

	public static ExtentReports reports;
	public static ExtentTest testInfo;
	public static ExtentHtmlReporter htmlReporter;

	@BeforeSuite
	public void extentReportSetUp() {
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/AutomationReport.html"));
		htmlReporter.loadXMLConfig("C:\\Users\\Rohit\\eclipse-workspace\\ABSoftAutomation\\"
				+ "src\\main\\java\\com\\absoft\\qa\\util\\Extent-Report.xml");
		reports = new ExtentReports();
		
		reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("User Name", "Rohit Panwar");
		//reports.setSystemInfo("", "");
		reports.attachReporter(htmlReporter);
	}

	@AfterSuite
	public void extentReportcleanUp() {
		reports.flush();
	}

	public void extendReportRegister(Method method) {
		String testName = method.getName();
		testInfo = reports.createTest(testName);
	}

	public void extendReportCaptureStatus(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			//testInfo.log(Status.PASS, "Test Case PASSED: " + result.getName(), ExtentColor.GREEN);
			testInfo.log(Status.PASS, MarkupHelper.createLabel("Test Case PASSED: " + result.getName(),ExtentColor.GREEN));
		} else if (result.getStatus() == ITestResult.FAILURE) {
			//testInfo.log(Status.FAIL, "Test Case FAILED: " + result.getName(),ExtentColor.RED);
			testInfo.log(Status.FAIL, MarkupHelper.createLabel("Test Case FAILED: " + result.getName(),ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SKIP) {
			//testInfo.log(Status.SKIP, "Test Case SKIPPED: " + result.getName(),ExtentColor.YELLOW);
			testInfo.log(Status.SKIP, MarkupHelper.createLabel("Test Case SKIPPED: " + result.getName(),ExtentColor.LIME));
		}
	}
}
