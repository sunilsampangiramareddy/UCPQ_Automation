package testCases;

import java.io.IOException;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObects.homePage;
import pageObects.loginPage;
import pageObects.newOpportunityPage;
import pageObects.opportunitiesPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.ReadConfig;




public class TC001_Login extends BaseClass {	
	@Test(dataProvider = "excelData", dataProviderClass = DataProviders.class, groups="regression")
	public void login_SFDC(String email, String pwd, String accName, String oppTye, String oppName, String contact, String salesPlay) throws InterruptedException 
	{
		loginPage lp = new loginPage(driver);
		homePage hp = new homePage(driver);
		ReadConfig readConfig = new ReadConfig();
		opportunitiesPage op = new opportunitiesPage(driver);
		newOpportunityPage nop=new newOpportunityPage(driver);
		
		try
		{		
		logger.info("Execution of Test Script Started");
		
		driver.get(readConfig.getApplicationURL());
		Thread.sleep(10000);
		logger.info("Application URL entered");
		
		Thread.sleep(6000);
		lp.enterUserName(email);
		Thread.sleep(6000);
		logger.info("Username entered");
		
		lp.clickNextButton();
		Thread.sleep(10000);
		logger.info("Clicked on the Next button");
		
		  
		    if(driver.getTitle().contains(lp.passwordPageLabel))
		        {
		        lp.enterPassword(pwd);
		        logger.info("Password entered");
				Thread.sleep(6000);
							
				lp.clickSignInButton();
				logger.info("Clicked on Sign In button");
				Thread.sleep(6000);
				
				lp.clickYesButton();
				logger.info("Clicked on Yes button");
				Thread.sleep(6000);
		        }
		    
		          
		Thread.sleep(6000);				
		boolean homePageStatus = hp.isMyHomePageExists();
		Assert.assertEquals(homePageStatus, true, "Spark Home Page Loaded");
		logger.info("SFDC Homepage loaded successfully");
		Thread.sleep(10000);
		
		hp.clickOnOpportunitiesTab();
		logger.info("Clicked on Opportunity tab");
		Thread.sleep(6000);	
		
		nop.clickOnNewOppotunityButton();
		logger.info("Clicked on New Opportunity");
		Thread.sleep(20000);	
		
		nop.searchAccount(accName);
		logger.info("Searching Account");		
		Thread.sleep(10000);	
		
		nop.selectSearchedAccount();
		logger.info("Select searched account");		
		Thread.sleep(10000);	
		
		nop.clickNextButton();
		logger.info("Clicked on Next button");		
		Thread.sleep(10000);	
		
		nop.selectOpportunityType(oppTye);
		logger.info("Selected Opportunity Type");		
		Thread.sleep(6000);
		
		nop.enterOppotunityName(oppName);
		logger.info("Entered Opportunity name");		
		Thread.sleep(6000);
		
		nop.selectPrimaryContact(contact);
		logger.info("Selected Primary contact");		
		Thread.sleep(6000);
		
		nop.selectSalesPlay(salesPlay);
		logger.info("Selected Sales Play");		
		Thread.sleep(6000);
		
		nop.clickNextButton_1();
		logger.info("Clicked on Next button");		
		Thread.sleep(10000);
		
		
		
		
		
		
		
		
		
		
		
		hp.logout();
		logger.info("clicked on logout button");
		Thread.sleep(10000);
		
		
		
		
		//driver.get(readConfig.getApplicationURL());
		//Thread.sleep(6000);
		
		
		
		}
		catch (Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug logs");
		}
		
		logger.info("Finished executing test case");
		
	}	
	
	
	
		}
	
	

