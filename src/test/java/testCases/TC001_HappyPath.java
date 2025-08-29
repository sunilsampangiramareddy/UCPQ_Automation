package testCases;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObects.BasePage;
import pageObects.LoginPage;
import utilities.DataProviders;
import java.util.Properties;

public class TC001_HappyPath extends BaseClass{
	public Properties p;
	
	
	@Test(dataProvider="excelData", dataProviderClass=DataProviders.class, groups={"Regression", "Master"})
	public void verifyHappyPath(String username, String email, String phonenumber, String gender, String day, String country) throws InterruptedException
	{
		
		LoginPage lp=new LoginPage(driver);
		BasePage bp=new BasePage(driver);
		logger.info("Started TC001_HappyPath Test Execution");
		
		try
		{	
			lp.enterEmailAddress(username);
			logger.info("Entered email address as " + email);			
			
			lp.clickNextButton();
			logger.info("Clicked on Next button");			
			
			lp.enterPassword("    ");
			logger.info("Entered password");
			
			lp.clickSignInButton();
			logger.info("Click on sign in button");
			
			lp.clickStaySignInButton();
			logger.info("Click on stay signin yes button");
			
			Thread.sleep(Duration.ofSeconds(10));
			
			
	
	
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug logs");
			
		}
		
	}

}
