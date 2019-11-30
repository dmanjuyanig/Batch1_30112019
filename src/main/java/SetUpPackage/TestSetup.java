package SetUpPackage;

import java.lang.reflect.Method;

import org.aeonbits.owner.ConfigFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import UtilityPackage.ExcelReader;
import UtilityPackage.configProperties;
import io.restassured.RestAssured;

public class TestSetup{

	protected static configProperties config;

	public static ExcelReader excel = new ExcelReader("./src/test/resources/TestData/TestData.xlsx");

	/*public static ExtentReports extentReport;
	public static ThreadLocal<ExtentTest> classLevelLog = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> testLevelLog = new ThreadLocal<ExtentTest>();
	public static ExtentTest test=null;*/

	@BeforeSuite
	public void beforeSuite() {

		/*System.out.println("Environement selected in Jenkins is:- "+System.getProperty("environment"));
		ConfigFactory.setProperty("environment", System.getProperty("environment"));*/
		config = ConfigFactory.create(configProperties.class);
		RestAssured.baseURI = config.getBaseURI();
		RestAssured.basePath = config.getBasePath();
	/*	TestUtils.archiveTestReport();
		extentReport = Extentmanager
				.GetExtent(config.getTestReportFilepath() + config.getTestReportName());*/

	
	}

	/*@BeforeClass
	public void beforeClass() {
		// ExtentTest test = new ExtentTest(getClass().getSimpleName());
		ExtentTest classLevelTest = extentReport.createTest(getClass().getSimpleName());
		classLevelLog.set(classLevelTest);
	}*/

	/*@BeforeMethod
	public void beforeMethod(Method method) {
		 test = classLevelLog.get().createNode(method.getName());
		testLevelLog.set(test);

		ExtentTest test = classLevelLog.get().createNode(method.getName());
		testLevelLog.set(test);
		testLevelLog.get().info("Test Case:- " + method.getName() + " execution started");
		// System.out.println("Test Case :- " + method.getName() + " execution
		// started");

	}*/

	/*@AfterMethod
	public void afterMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			testLevelLog.get().pass("Test Case passed");
			System.out.println("This Test cases is passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			testLevelLog.get().fail("This test case failed");
			System.out.println("This Test Case is failed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			testLevelLog.get().skip("Test case skipped");
			System.out.println("Test Case is skipped");
		}
		extentReport.flush();
	}*/

	@AfterSuite
	public void afterSuite() {
	
	}
}