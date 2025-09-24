package testCases_FastQuotes;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObects_SFDC.AddProductsPage;
import pageObects_SFDC.BasePage;
import pageObects_SFDC.CreateOpportunitiesPage;
import pageObects_SFDC.LoginPage;
import pageObects_SFDC.OpportunitiesPage;
import pageObjects_CPQ.HomePageCPQ;
import pageObjects_FastQuotes.HomePageFastQuotes;
import retryAnalyzer.RetryAnalyzer;
import testBase.WriteTestResults;
import testCases_SFDC.BaseClass;
import utilities.DataProviders;

public class TC_FastQuotesConfig extends BaseClass{
	public Properties p;
	public int sw=5; public int mw=10; public int lw=20;
	public int pre_Count=1; int lineCount;
	public String current_URL; String testCase="TC_FastQuotesConfig"; String booleanStatus="PASS";
	
	@Test(dataProvider="TC_FastQuotesConfig", dataProviderClass=DataProviders.class, retryAnalyzer = RetryAnalyzer.class, groups={"Regression", "Master"})
	public void createFastQuotesConfig (String userName, String accountName, String opportunityType, String opportunityName, String primaryContact, String salesPlay, String salesType, String installedBaseType, String currency, String channel, String hyperscaler, String pathway, String partnerSalesModel, String endCustomerUsage, String reseller, String resellerSalesRep, String resellerSE, String product, String salesPrice, String subProduct) throws InterruptedException, IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		BasePage bp=new BasePage(driver);
		CreateOpportunitiesPage cop=new CreateOpportunitiesPage(driver);
		OpportunitiesPage op=new OpportunitiesPage(driver);
		AddProductsPage app=new AddProductsPage(driver);
		HomePageCPQ hpc=new HomePageCPQ(driver);
		HomePageFastQuotes hpfq=new HomePageFastQuotes(driver);
		WriteTestResults wtr=new WriteTestResults(driver);
		//loading config.properties file
		FileReader file=new FileReader(".\\src\\test\\resources\\Config.properties");
		p=new Properties();
		p.load(file);
		
		logger.info("Started TC_FastQuotesConfig Test Execution");
		
		try
		{	
//-----------------Login Screen--------------------------------------------------------------------------------
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
			
//-------------------Create Opportunity-------------------------------------------------------------------------	
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
			cop.clickNextButton2();
			logger.info("Clicked on next button");			
			
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
			logger.info("Opportunity created screen captured");
			
//-------------------Add Product in SFDC--------------------------------------------------------------------
			app.clickProducts();
			logger.info("Click on products link");			
			app.clickAddProdcuts();
			logger.info("Clicked on add products");			
			app.searchProdcut(product);
			logger.info("Entered product name "+product);			
			app.clickLightningIcon();
			logger.info("Clicked on search lightning icon");			
			app.selectSearchedProduct();
			logger.info("selected searched product");			
			app.clickNextButton();
			logger.info("Click on next button");			
			app.enterSalesPrice(salesPrice);
			logger.info("Entered sales price "+salesPrice);			
			app.clickSaveButton();
			logger.info("Clickec on save button");			
			app.clickOpptyLink();
			logger.info("Navigating back to opportunity page");
			bp.captureScreenshot(driver);
			logger.info("Add product screen captured");
			
//---------------------Create Quote-----------------------------------------------------------------------
			op.clickCreateQuote();
			logger.info("Clicked on create qutoe");			
			op.clickUnifiedCPQ();
			logger.info("Clicked on unified CPQ");			
			op.clickCreateQuoteButton();
			logger.info("Clicked on create quote button");			
			op.switchToNewTabAndCloseParentTab();
			logger.info("Driver control switched to new CPQ tab and closed parent sfdc tab");			
			
//-------------------CPQ capture home page details---------------------------------------------------------
			op.clickSaveButton();
			logger.info("Clicked on save button");
			String quoteNumber=hpc.getQuoteNumber();
			logger.info("Captured quote number "+quoteNumber);	
			String quoteName=hpc.getQuoteName();
			logger.info("Captured quote name "+quoteName);	
			String quoteStatus=hpc.getQuoteDraftStatus();
			logger.info("Captured quote status "+quoteStatus);			
			bp.captureScreenshot(driver);
			logger.info("CPQ homepage screen captured");
			
//--------------------Configure Fast Quotes product-------------------------------------------------------------
			hpc.clickProdctsTab();
			logger.info("Clicked on products tab");			
			hpc.clickConfigureProduct();
			logger.info("Clicked on configure product button");            
			hpfq.clickFastQuotesProdcut();
			logger.info("Clicked on fast quotes prodcut");
			hpfq.clickAddToQuoteFASTQUOTEAFFA20001(subProduct);
			logger.info("clicked on configure button for the sub product "+subProduct);	
			hpc.clickSettingsExpandAll();
			logger.info("Clicked on settings and clicked on expand all option");	
			lineCount= hpc.getLineCount();
			logger.info("Reading line count number from products table "+lineCount);
			hpc.readProductColumnFromProductsTable(lineCount);
			logger.info("Reading product column data from products table");
			bp.captureScreenshot(driver);
			logger.info("Captured screen shot of product configured");
			quoteStatus=hpc.getQuoteConfiguredStatus();
			logger.info("Captured quote status "+quoteStatus);
			hpc.clickSaveIcon();
			logger.info("Clicked on save icon");
			
		
//-----------Write test results to excel sheet--------------------------------------------------------------
			wtr.write_TC_FastQuotesConfigTestResults(driver, testCase, opptyNumber, opptyName, accName, channelName, quoteNumber, quoteName, quoteStatus, booleanStatus);			
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