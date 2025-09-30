package testCases_SFDC;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.net.URL;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;

import utilities.AutoScreenshotCleanup;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.net.URL;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.commons.io.FileUtils; 
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	 @BeforeSuite
	    public void setup() {
		// Pass the number of days as an argument to delete old screen shots 
		 AutoScreenshotCleanup.deleteOldScreenshots(15);  
	    }
	
	 
	@BeforeClass(groups= {"Sanity", "Regression", "Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws InterruptedException, IOException
	{
		//loading config.properties file
		FileReader file=new FileReader(".\\src\\test\\resources\\Config.properties");
		p=new Properties();
		p.load(file);
				
		logger=LogManager.getLogger(this.getClass()); 
		
		//execution in selenium grid environment 
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
				
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
			default: System.out.println("No matching browser"); return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
		
		 		                 
//-------Enable below line of code to run browser parameter from POM.xml file or Jenkins browser parameters---------------
			//br=System.getProperty("browserProperty");
			
		//execution in local machine environment
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		switch(br.toLowerCase())
		{
		case "chrome" : 
//-------Enable below three lines of code to run headless mode of execution and disable other line------------------------
//			ChromeOptions options=new ChromeOptions();
//			options.addArguments("--headless=new");
//			driver=new ChromeDriver(options);
//-------Enable below line of code to run head mode of execution-----------------------------------------------------------			
			driver=new ChromeDriver(); 
			break;
			
		case "edge" : driver=new EdgeDriver(); break;
		case "firefox" : driver=new FirefoxDriver(); break;
		default : System.out.println("Invalid browser name.."); return;
		}	 
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//reading url from properties file
		String baseUrl=p.getProperty("sfdcURL");
		
//-----Enable below line of code to read url from POM.xml file or Jenkins URL parameters----------------
		//baseUrl = System.getProperty("test.env.url");
        
		driver.get(baseUrl);
		logger.info("Application url loaded "+baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(Duration.ofSeconds(6));
	}
	
	
	@BeforeMethod
	 public void setUp(ITestContext context) {
	    context.setAttribute("driver", driver);
	    }
	
	
//	@AfterClass(groups= {"Sanity", "Regression", "Master"})
//	public void tearDown()
//	{
//		driver.quit();		
//	}
	
		
		
	public String captureScreen(String tname) throws IOException {
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());		
		
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);		
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+ tname +"_"+ timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;	
	}
	
	
}
