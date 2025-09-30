package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import retryAnalyzer.RetryAnalyzer;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReport implements ITestListener {
	public static ExtentReports extentReports;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	public ExtentTest test;
	String repName;

    @Override
    public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
        
        // Get the fully qualified test class name
        String fullClassName = context.getCurrentXmlTest().getClasses().get(0).getName();        
        // Extract only the class name without the package
        String testClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
        
		repName = testClassName + "-Full-Test-Report-" + timeStamp + ".html";		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);// specify location of the report
		sparkReporter.config().setReportName("Automation Test Results");
        sparkReporter.config().setDocumentTitle("UCPQ Automation Report");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Application", "CPQ Project Automation");
        extentReports.setSystemInfo("Module", "Regression Test");
        extentReports.setSystemInfo("Sub Module", "Functional Test");
        extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
        extentReports.setSystemInfo("Environemnt", "QA");
		String os = context.getCurrentXmlTest().getParameter("os");
		extentReports.setSystemInfo("Operating System", os);
		String browser = context.getCurrentXmlTest().getParameter("browser");
		extentReports.setSystemInfo("Browser", browser);
		
		List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
		extentReports.setSystemInfo("Groups", includedGroups.toString());
		}
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
        String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport = new File(pathOfExtentReport);		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {        
    	extentTest.get().log(Status.FAIL, "Test Failed");        
        extentTest.get().log(Status.FAIL, result.getThrowable());
        extentTest.get().log(Status.FAIL, "WebDriver instance was null, screenshot not captured.");
     }
    
    
    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not implemented
    }

    public static void logStep(WebDriver driver, String stepDescription) {
        String screenshotPath = ScreenshotUtils.captureScreenshot(driver, stepDescription);
        extentTest.get().log(Status.INFO, stepDescription).addScreenCaptureFromPath(screenshotPath);
    }
}