package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObects_SFDC.AddProductsPage;
import pageObects_SFDC.BasePage;
import pageObects_SFDC.CreateOpportunitiesPage;
import pageObects_SFDC.LoginPage;
import pageObects_SFDC.OpportunitiesPage;
import pageObject_CPQ.HomePageCPQ;
import pageObject_SolidFIre.HomePageSolidFire;
import utilities.DataProviders;
import java.util.Properties;

public class tryLogic extends BaseClass{
	public Properties p;
	
	
	@Test(dataProvider="SolidFire_Config", dataProviderClass=DataProviders.class, groups={"Regression", "Master"})
	public void verifyHappyPath(String userName, String accountName, String opportunityType, String opportunityName, String primaryContact, String salesPlay, String salesType, String installedBaseType, String currency, String channel, String pathway, String partnerSalesModel, String endCustomerUsage, String reseller, String resellerSalesRep, String resellerSE, String product, String salesPrice, String subProduct, String newCapacity, String newTerm) throws InterruptedException, IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		BasePage bp=new BasePage(driver);
		CreateOpportunitiesPage cop=new CreateOpportunitiesPage(driver);
		OpportunitiesPage op=new OpportunitiesPage(driver);
		AddProductsPage app=new AddProductsPage(driver);
		HomePageCPQ hpc=new HomePageCPQ(driver);
		HomePageSolidFire hpsf=new HomePageSolidFire(driver);
		//loading config.properties file
		FileReader file=new FileReader(".\\src\\test\\resources\\Config.properties");
		p=new Properties();
		p.load(file);
		
		logger.info("Started TC001_HappyPath Test Execution");
		
		try
		{	
			//-------Login Screen-----------------------------------------------
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
			
//---------------Create Direct Opportunity-----------------------------------------	
//			cop.navigateToOpportunitiesPage();
//			logger.info("Navigated to opportunities page");				
//			cop.clickOpportunityTab();
//			logger.info("Navigated to opportunities page");
//			cop.clickNewOpportunity();
//			logger.info("Clicked on new opportunity button");			
//			cop.enterSearchAccount(accountName);
//			logger.info("Entered account name "+ accountName);			
//			cop.clickLightningIcon();
//			logger.info("Clicked on search lightning icon");			
//			cop.selectSearchedAccount();
//			logger.info("Searched account has been selected");			
//			cop.clickSelectButton();
//			logger.info("Clicked on select button");			
//			cop.clickNextButton();
//			logger.info("Clicked on next button");			
//			cop.selectOpportunityType(opportunityType);
//			logger.info("Selected opportunity type "+opportunityType);				
//			cop.enterOpportunityName(opportunityName);
//			logger.info("Entered opportunity name "+opportunityName);			
//			cop.selectPrimaryContact(primaryContact);
//			logger.info("Selected primary contact "+primaryContact);			
//			cop.selectSalesPlay(salesPlay);
//			logger.info("Selected sales play "+salesPlay);			
//			cop.selectSalesType(salesType);
//			logger.info("Selected sales type "+salesType);			
//			cop.selectInstalledBaseType(installedBaseType);
//			logger.info("Selected installed base type "+installedBaseType);			
//			cop.selectCurrency(currency);
//			logger.info("Selected currency "+currency);			
//			cop.selectChannel(channel);
//			logger.info("Selected channel "+channel);			
//			cop.clickNextButton2();
//			logger.info("Clicked on next button");
	
			
			driver.navigate().to("https://netapp2--uat.sandbox.lightning.force.com/lightning/r/Opportunity/006ce000008VyT7AAK/view");
			Thread.sleep(Duration.ofSeconds(10));
			
			//--------Create Quote-----------------------------------------------------------
			op.clickCreateQuote();
			logger.info("Clicked on create qutoe");			
//			op.clickUnifiedCPQ();
//			logger.info("Clicked on unified CPQ");			
			op.clickCreateQuoteButton();
			logger.info("Clicked on create quote button");			
			op.switchToNewTab();
			logger.info("Driver control switched to CPQ tab");			
			
			//--------CPQ capture home page details-----------------------------------------
						
//			String quoteName=hpc.getQuoteName();
//			logger.info("Captured quote name "+quoteName);			
//			String quoteNumber=hpc.getQuoteNumber();
//			logger.info("Captured quote number "+quoteNumber);			
//			String quoteStatus=hpc.getQuoteStatus();
//			logger.info("Captured quote status "+quoteStatus);			
//			hpc.clickSaveButton();
//			logger.info("Clicked on save button");
//			bp.captureScreenshot(driver);
//			logger.info("CPQ homepage screen captured");
			
			
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
			hpsf.clickAddToQuote();
			logger.info("Clicked on add to quote button");
//			op.clickSaveButton();
//			logger.info("Clicked on save button");
			hpc.clickSettingsExpandAll();
			logger.info("Clicked on settings and clicked on expand all option");			
			hpc.readFullTable(driver);
			logger.info("Reading prodct table details");
			bp.captureScreenshot(driver);
			
			

			
			
			
			
			
			
	
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug logs");
			
		}
		
	}

}
