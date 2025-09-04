package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pageObects.BasePage;
import pageObects.LoginPage;
import pageObects.CreateOpportunitiesPage;
import utilities.DataProviders;

public class TC001_HappyPathScript extends BaseClass{
	public Properties p;
	public int sw=5; public int mw=10; public int lw=20;
	
	@Test(dataProvider="excelData", dataProviderClass=DataProviders.class, groups={"Regression", "Master"})
	public void verifyHappyPath(String userName, String accountName, String opportunityType, String opportunityName, String primaryContact, String salesPlay, String salesType, String installedBaseType, String currency, String channel) throws InterruptedException, IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		BasePage bp=new BasePage(driver);
		CreateOpportunitiesPage cop=new CreateOpportunitiesPage(driver);
		//loading config.properties file
		FileReader file=new FileReader(".\\src\\test\\resources\\Config.properties");
		p=new Properties();
		p.load(file);
		
		logger.info("Started TC001_HappyPath Test Execution");
		
		try
		{	
			lp.enterEmailAddress(userName);
			logger.info("Entered email address as " + userName);			
			
			lp.clickNextButton();
			logger.info("Clicked on Next button");			
			
			lp.enterPassword(p.getProperty("pwd"));
			logger.info("Entered password");
			
			lp.clickSignInButton();
			logger.info("Click on sign in button");
			
			lp.clickStaySignInButton();
			logger.info("Click on stay signin yes button");			
					
			cop.navigateToOpportunitiesPage();
			logger.info("Navigated to opportunities page");	
			Thread.sleep(Duration.ofSeconds(8));
			
			cop.clickNewOpportunity();
			logger.info("Clicked on new opportunity button");
			
			
			cop.enterSearchAccount(accountName);
			logger.info("Entered account name "+ accountName);
			
			
			cop.clickLightningIcon();
			logger.info("Clicked on search lightning icon");
		
			
			cop.selectSearchedAccount();
			logger.info("Searched account has been selected");
		
			
			cop.clickSelectButton();
			logger.info("Clicked on select button");
			
			
			cop.clickNextButton();
			logger.info("Clicked on next button");
			
			cop.selectOpportunityType(opportunityType);
			logger.info("Selected opportunity type "+opportunityType);			
		
			
			cop.enterOpportunityName(opportunityName);
			logger.info("Entered opportunity name "+opportunityName);
			
			cop.selectPrimaryContact(primaryContact);
			logger.info("Selected primary contact "+primaryContact);			
			Thread.sleep(Duration.ofSeconds(5));
			
			cop.selectSalesPlay(salesPlay);
			logger.info("Selected sales play "+salesPlay);
			
			cop.selectSalesType(salesType);
			logger.info("Selected sales type "+salesType);
			
			cop.selectInstalledBaseType(installedBaseType);
			logger.info("Selected installed base type "+installedBaseType);
			
			cop.selectCurrency(currency);
			logger.info("Selected currency "+currency);
			
			cop.selectChannel(channel);
			logger.info("Selected channel "+channel);
			
			cop.clickNextButton2();
			logger.info("Clicked on next button");
			
			
			

			
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug logs");
			
		}
		
	}

}
