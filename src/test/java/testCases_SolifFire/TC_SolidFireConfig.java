package testCases_SolifFire;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pageObects_SFDC.AddProductsPage;
import pageObects_SFDC.BasePage;
import pageObects_SFDC.CreateOpportunitiesPage;
import pageObects_SFDC.LoginPage;
import pageObects_SFDC.OpportunitiesPage;
import pageObjects_CPQ.HomePageCPQ;
import pageObjects_SolidFIre.HomePageSolidFire;
import retryAnalyzer.RetryAnalyzer;
import testBase.WriteTestResults;
import testCases_SFDC.BaseClass;
import utilities.DataProviders;

public class TC_SolidFireConfig extends BaseClass{
	public Properties p;
	public int sw=5; public int mw=10; public int lw=20;
	public int pre_Count=1; int lineCount;
	public String current_URL; String testCase="TC_SolidFireConfig"; String booleanStatus="PASS";
	
	@Test(dataProvider="TC_SolidFireConfig", dataProviderClass=DataProviders.class, retryAnalyzer = RetryAnalyzer.class, groups={"Regression", "Master"})
	public void createSolidFireConfig (String userName, String accountName, String opportunityType, String opportunityName, String primaryContact, String salesPlay, String salesType, String installedBaseType, String currency, String channel, String hyperscaler, String pathway, String partnerSalesModel, String endCustomerUsage, String reseller, String resellerSalesRep, String resellerSE, String product, String salesPrice, String subProduct, String newCapacity, String newTerm) throws InterruptedException, IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		BasePage bp=new BasePage(driver);
		CreateOpportunitiesPage cop=new CreateOpportunitiesPage(driver);
		OpportunitiesPage op=new OpportunitiesPage(driver);
		AddProductsPage app=new AddProductsPage(driver);
		HomePageCPQ hpc=new HomePageCPQ(driver);
		HomePageSolidFire hpsf=new HomePageSolidFire(driver);
		WriteTestResults wtr=new WriteTestResults(driver);
		//loading config.properties file
		FileReader file=new FileReader(".\\src\\test\\resources\\Config.properties");
		p=new Properties();
		p.load(file);
		
		logger.info("Started TC_SolidFireConfig Test Execution");
		
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
			
//--------------------Configure Solid Fire product-------------------------------------------------------------
			hpc.clickProdctsTab();
			logger.info("Clicked on products tab");			
			hpc.clickConfigureProduct();
			logger.info("Clicked on configure product button");            
			hpsf.clickSolidFireProdcut();
			logger.info("Clicked on solid fire prodcut");			
			hpsf.clickConfigureTBCLS(subProduct);
			logger.info("clicked on configure button for the sub product "+subProduct);			
			hpsf.enterNewCapacity(newCapacity);
			logger.info("Entered new capacity in TB "+newCapacity);			
			hpsf.selectNewTerm(newTerm);
			logger.info("Entered new term in months "+newTerm);	
			bp.captureScreenshot(driver);
			logger.info("Captured screen shot of solid fire product config");			
			hpsf.clickAddToQuote();
			logger.info("Clicked on add to quote button");
			
//--------------------Validate Product table details in Products page--------------------------------------------
			hpc.clickSettingsExpandAll();
			logger.info("Clicked on settings and clicked on expand all option");
			lineCount=hpc.getLineCount();
			logger.info("Reading line count number from products table "+lineCount);
			hpc.readProductsTableByColumnName("Product");
			logger.info("Reading product column data from products table");
			bp.captureScreenshot(driver);
			logger.info("Captured screen shot of solid fire product config");
			quoteStatus=hpc.getQuoteConfiguredStatus();
			logger.info("Captured quote status "+quoteStatus);
			
			System.out.println("Product values in the Collection DB: " + hpc.productColumnValues);
			logger.info("Stored all product column details in Collection DB");
			hpc.verifyProductColumnValueInArrayList(subProduct);
			logger.info("Expected product name has been verified in products table "+ subProduct);
			
			hpc.readProductsTableByColumnName("List Price");
			logger.info("Reading List Price column values from products table");
			hpc.readProductsTableByColumnName("Net Price");
			logger.info("Reading Net Price column values from products table");
			
			hpc.readProductsTableByColumnName("Current Discount");
			logger.info("Reading Current Discount values from products table");
			
			hpc.readProductsTableByColumnName("Eligible Discount");
			logger.info("Reading Eligible Discount values from products table");
			
			hpc.readProductsTableByColumnName("Part Description");
			logger.info("Reading Part Description values from products table");

			hpc.readProductsTableByColumnName("Treshold Group");
			logger.info("Reading Treshold Group values from products table");
			
			
			
			
			
			hpc.clickSaveIcon();
			logger.info("Clicked on save icon");
			
//-----------Write test results to excel sheet--------------------------------------------------------------
			wtr.writeTC_SolidFireConfigTestResults(driver, testCase, opptyNumber, opptyName, accName, channelName, quoteNumber, quoteName, quoteStatus, booleanStatus);			
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
