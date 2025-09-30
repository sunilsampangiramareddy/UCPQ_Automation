package testCases_SFDC;

import java.io.FileReader;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.InvalidSelectorException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObects_SFDC.AddProductsPage;
import pageObects_SFDC.BasePage;
import pageObects_SFDC.CreateOpportunitiesPage;
import pageObects_SFDC.LoginPage;
import pageObects_SFDC.OpportunitiesPage;
import pageObjects_CPQ.HomePageCPQ;
import testBase.WriteTestResults;
import utilities.DataProviders;
import utilities.ExtentReport;
import retryAnalyzer.RetryAnalyzer;
import retryAnalyzer.RetryListener;
public class TC_CreateDirectOpportunity extends BaseClass{
	public Properties p;
	public int pre_Count=1; int sw=5;
	public String current_URL; String testCase="TC_CreateDirectOpportunity"; String booleanStatus="PASS";
	
	
	@Test(dataProvider="TC_CreateDirectOpportunity", dataProviderClass=DataProviders.class, retryAnalyzer = RetryAnalyzer.class, groups={"Smoke", "Regression", "Master"})
	public void createDirectOpportunity (String userName, String accountName, String opportunityType, String opportunityName, String primaryContact, String salesPlay, String salesType, String installedBaseType, String currency, String channel, String hyperscaler, String pathway, String partnerSalesModel, String endCustomerUsage, String reseller, String resellerSalesRep, String resellerSE) throws InterruptedException, IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		BasePage bp=new BasePage(driver);
		CreateOpportunitiesPage cop=new CreateOpportunitiesPage(driver);
		OpportunitiesPage op=new OpportunitiesPage(driver);
		WriteTestResults wtr=new WriteTestResults(driver);
		//loading config.properties file
		FileReader file=new FileReader(".\\src\\test\\resources\\Config.properties");
		p=new Properties();
		p.load(file);
		
		logger.info("Started TC_CreateDirectOpportunity Test Execution");
		
		try
		{						
//-----------------Login Screen-----------------------------------------------
			if(pre_Count==1)
			{	
			lp.enterEmailAddress(userName);
			logger.info("Entered email address as " + userName);
			ExtentReport.logStep(driver, "Entered email address-"+userName);
			
			lp.clickNextButton();
			logger.info("Clicked on Next button");
			ExtentReport.logStep(driver, "Clicked on Next button");
			
			lp.enterPassword(p.getProperty("pwd"));
			logger.info("Entered password");
						
			lp.clickSignInButton();
			logger.info("Click on sign in button");	
			ExtentReport.logStep(driver, "Click on sign in button");
			
			lp.clickStaySignInButton();
			logger.info("Click on stay signin yes button");	
			ExtentReport.logStep(driver, "Click on stay signin yes button");
			
			logger.info("SFDC homepage screen captured");
			ExtentReport.logStep(driver, "SFDC homepage screen captured");
			
			pre_Count++;
			current_URL=driver.getCurrentUrl();
			logger.info("Captured SFDC homepage url");
			}
//---------------Create Direct Opportunity-----------------------------------------	
			driver.get(current_URL);			
			logger.info("Navigated to Home page");	
			Thread.sleep(Duration.ofSeconds(sw));
			
			cop.clickOpportunityTab();
			logger.info("Navigated to opportunities page");
			ExtentReport.logStep(driver, "Navigated to opportunities page ");
			
			cop.clickNewOpportunity();
			logger.info("Clicked on new opportunity button");
			ExtentReport.logStep(driver, "Clicked on new opportunity button");
			
			cop.enterSearchAccount(accountName);
			logger.info("Entered account name "+ accountName);
			ExtentReport.logStep(driver, "Entered account name-"+accountName);
			
			cop.clickLightningIcon();
			logger.info("Clicked on search lightning icon");
			ExtentReport.logStep(driver, "Clicked on search lightning icon");
						
			cop.selectSearchedAccount();
			logger.info("Searched account has been selected");	
			ExtentReport.logStep(driver, "Searched account has been selected");
			
			cop.clickSelectButton();
			logger.info("Clicked on select button");
			ExtentReport.logStep(driver, "Clicked on select button");
						
			cop.clickNextButton();
			logger.info("Clicked on next button");	
			ExtentReport.logStep(driver, "Clicked on next button ");
			
			cop.selectOpportunityType(opportunityType);
			logger.info("Selected opportunity type "+opportunityType);
			ExtentReport.logStep(driver, "Selected opportunity type-"+opportunityType);
						
			cop.enterOpportunityName(opportunityName);
			logger.info("Entered opportunity name "+opportunityName);
			ExtentReport.logStep(driver, "Entered opportunity name-"+opportunityName);
						
			cop.selectPrimaryContact(primaryContact);
			logger.info("Selected primary contact "+primaryContact);
			ExtentReport.logStep(driver, "Selected primary contact-"+primaryContact);
					
			cop.selectSalesPlay(salesPlay);
			logger.info("Selected sales play "+salesPlay);
			ExtentReport.logStep(driver, "Selected sales play-"+salesPlay);
					
			cop.selectSalesType(salesType);
			logger.info("Selected sales type "+salesType);
			ExtentReport.logStep(driver, "Selected sales type-"+salesType);
					
			cop.selectInstalledBaseType(installedBaseType);
			logger.info("Selected installed base type "+installedBaseType);	
			ExtentReport.logStep(driver, "Selected installed base type-"+installedBaseType);
						
			cop.selectCurrency(currency);
			logger.info("Selected currency "+currency);	
			ExtentReport.logStep(driver, "Selected currency-"+currency);
			
			cop.selectChannel(channel);
			logger.info("Selected channel "+channel);
			ExtentReport.logStep(driver, "Selected channel-"+channel);
						
			cop.clickNextButton2();
			logger.info("Clicked on next button");
			ExtentReport.logStep(driver, "Clicked on next button");
			
			
			logger.info("Opportunity created and screen captured");
			ExtentReport.logStep(driver, "Opportunity created and screen captured ");
				
			
//----------------Capture Opportunity details--------------------------------------------------------------
			String opptyNumber= op.getOpportunityNumber();
			logger.info("Captured opportunity number "+opptyNumber);
			ExtentReport.logStep(driver, "Captured opportunity number-"+opptyNumber);
			
			String opptyName=op.getOpportunityName();
			logger.info("Captured opportunity name "+opptyName);
			ExtentReport.logStep(driver, "Captured opportunity name-"+opptyName);
			
			String accName=op.getAccountName();
			logger.info("Captured account name "+accName);	
			ExtentReport.logStep(driver, "Captured account name-"+accName);
			
			String channelName=op.getChannelName();
			logger.info("Captured channel name "+channelName);
			ExtentReport.logStep(driver, "Captured channel name-"+channelName);
			
			bp.captureScreenshot(driver);
			logger.info("Opportunity details screen captured");	
			ExtentReport.logStep(driver, "Opportunity details screen captured ");
			
//-----------Write test results to excel sheet--------------------------------------------------------------
			wtr.writeTC_CreateDirectOpportunityTestResults(driver, testCase, opptyNumber, opptyName, accName, channelName, booleanStatus);			
			logger.info("Test execution results has been written in excel sheet");
			
		}
		catch (NullPointerException eNull) {
			 System.err.println("Error message: " + eNull.getMessage());
			 System.err.println("NullPointerException has been handled");
     	}
		catch(Exception e) {
			logger.error("Test Failed");
			logger.debug("Debug logs");
			e.printStackTrace();
			throw e;
		}		
	}


}
