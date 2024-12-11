package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.TakesScreenshot;


public class BaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	
    //ReadConfig readConfig = new ReadConfig();	
	//public String appURL= readConfig.getApplicationURL();
	//public String username= readConfig.getUsername();
	

	@BeforeClass(groups= {"regression"})
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws InterruptedException
	{
		logger = LogManager.getLogger(BaseClass.class);
		
		if (br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("chrome://settings/clearBrowserData");
		    driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}	
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		else if(br.equals("ie"))
		{
			//WebDriverManager.iedriver().setup();
			//driver = new iedriver();
			//driver.manage().window().maximize();
		}		
				
	}
	
	
	@AfterClass(groups= {"regression"})
	public void tearDown()
	{
		driver.quit();
	}
	
	
	public String randomString()
	{
		String generatedRandomString = RandomStringUtils.randomAlphabetic(5);
		return generatedRandomString;
	}
	
	public String randomNumber()
	{
		String generatedRandomNumber = RandomStringUtils.randomNumeric(5);
		return generatedRandomNumber;
	}
	
	public String captureScreen(String tname) {
		
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty(("user.dir")+"\\screenshots"+ tname + "_" +timeStamp + ".png");
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;		
	}
	
	
	
}
