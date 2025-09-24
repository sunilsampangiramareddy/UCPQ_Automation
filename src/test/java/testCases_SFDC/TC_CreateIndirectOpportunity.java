package testCases_SFDC;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.Test;

import pageObects_SFDC.AddProductsPage;
import pageObects_SFDC.BasePage;
import pageObects_SFDC.CreateOpportunitiesPage;
import pageObects_SFDC.LoginPage;
import pageObects_SFDC.OpportunitiesPage;
import pageObjects_CPQ.HomePageCPQ;
import retryAnalyzer.RetryAnalyzer;
import testBase.WriteTestResults;
import utilities.DataProviders;

public class TC_CreateIndirectOpportunity extends BaseClass{
	public Properties p;
	public int pre_Count=1; int sw=5;
	public String current_URL; String testCase="TC_CreateIndirectOpportunity"; String booleanStatus="PASS";
	
	
	@Test(dataProvider="TC_CreateIndirectOpportunity", dataProviderClass=DataProviders.class, retryAnalyzer = RetryAnalyzer.class, groups={"Smoke", "Regression", "Master"})
	public void createIndirectOpportunity (String userName, String accountName, String opportunityType, String opportunityName, String primaryContact, String salesPlay, String salesType, String installedBaseType, String currency, String channel, String hyperscaler, String pathway, String partnerSalesModel, String endCustomerUsage, String reseller, String resellerSalesRep, String resellerSE) throws InterruptedException, IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		BasePage bp=new BasePage(driver);
		CreateOpportunitiesPage cop=new CreateOpportunitiesPage(driver);
		OpportunitiesPage op=new OpportunitiesPage(driver);
		AddProductsPage app=new AddProductsPage(driver);
		HomePageCPQ hpc=new HomePageCPQ(driver);
		WriteTestResults wtr=new WriteTestResults(driver);
		//loading config.properties file
		FileReader file=new FileReader(".\\src\\test\\resources\\Config.properties");
		p=new Properties();
		p.load(file);
		
		logger.info("Started TC_CreateIndirectOpportunity Test Execution");
		
		try
		{	
//-----------------Login Screen--------------------------------------------------------
			if(pre_Count==1)
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
			bp.captureScreenshot(driver);
			logger.info("SFDC homepage screen captured");			
			pre_Count++;
			current_URL=driver.getCurrentUrl();
			logger.info("Captured SFDC homepage url");
			}	

//---------------Create Indirect Opportunity--------------------------------------------	
			driver.get(current_URL);			
			logger.info("Navigated to Home page");	
			Thread.sleep(Duration.ofSeconds(sw));
			cop.clickOpportunityTab();
			logger.info("Navigated to opportunities page");
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
			cop.selectPathway(pathway);
			logger.info("Selected pathway "+pathway);	
			cop.selectPartnerSalesModel(partnerSalesModel);
			logger.info("Selected partner sales model "+partnerSalesModel);	
			cop.clickNextButton2();
			logger.info("Clicked on next button");			
			cop.selectEndCustomerUsage(endCustomerUsage);
			logger.info("Selected end customer usage "+endCustomerUsage);	
			cop.enterReseller(reseller);
			logger.info("Entered reseller "+reseller);
			cop.clickLightningIcon_2();
			logger.info("Clicked on lightning icon");
			cop.selectSearchedAccount_2();
			logger.info("Selected searched account");			
			cop.clickSelectButton_2();
			logger.info("Clicked select button");			
			cop.clickNextButton_2();
			logger.info("Clicked next button");
			cop.selectResellerSalesRep(resellerSalesRep);
			logger.info("Selected reseller sales rep "+resellerSalesRep);			
			cop.selectResellerSE(resellerSE);
			logger.info("Selected reseller SE "+resellerSE);			
			cop.clickNextButton_3();
			logger.info("Clicked next button");
			bp.captureScreenshot(driver);
			logger.info("Opportunity created and screen captured");

//----------------Capture Opportunity details--------------------------------------------------------------
			String opptyNumber= op.getOpportunityNumber();
			logger.info("Captured opportunity number "+opptyNumber);			
			String opptyName=op.getOpportunityName();
			logger.info("Captured opportunity name "+opptyName);			
			String accName=op.getAccountName();
			logger.info("Captured account name "+accName);			
			String channelName=op.getChannelName();
			logger.info("Captured channel name "+channelName);
			bp.captureScreenshot(driver);
			logger.info("Opportunity details screen captured");	
			
//-----------Write test results to excel sheet--------------------------------------------------------------
			wtr.writeTC_CreateIndirectOpportunityTestResults(driver, testCase, opptyNumber, opptyName, accName, channelName, booleanStatus);			
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
