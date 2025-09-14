package pageObects_SFDC;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OpportunitiesPage extends BasePage {

public int sw=5; public int mw=10; public int lw=20;

	public OpportunitiesPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(how = How.XPATH, using = "//records-highlights-details-item[2]/div/p[2]/slot/lightning-formatted-text")
	@CacheLookup
	WebElement opportunityNumber;
	
	
	@FindBy(how = How.XPATH, using = "//h1/slot/lightning-formatted-text")
	@CacheLookup
	WebElement opportunityName;
	
	@FindBy(how = How.XPATH, using = "//p[2]/slot/records-formula-output/slot/lightning-formatted-text")
	@CacheLookup
	WebElement accountName;
	
	@FindBy(how = How.XPATH, using = "//records-highlights-details-item[4]/div/p[2]/slot/lightning-formatted-text")
	@CacheLookup
	WebElement channelName;
	
	
	@FindBy(how = How.XPATH, using = "//button[@name='Opportunity.Create_Quote']")
	@CacheLookup
	WebElement createQuote;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/article/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-lwc-field/div/flowruntime-radio-button-input-lwc/fieldset/div/span[1]/label/span[2]/lightning-formatted-rich-text/span[text()='Unified CPQ']")
	@CacheLookup
	WebElement unifiedCPQ;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/article/flowruntime-flow/flowruntime-navigation-bar/footer/div/lightning-button/button[text()='Create Quote']")
	@CacheLookup
	WebElement createQuoteButton;
	
	//@FindBy(how = How.XPATH, using = "//li[5]/div/div[2]/div/oj-vb-fragment/oj-module/oj-c-button/button")
	@FindBy(how = How.XPATH, using = "//button[@aria-label='Save Quote']")
	
	@CacheLookup
	WebElement saveButtonCPQ;
	
	
	
	public String getOpportunityNumber()
	{
		BasePage.fluentWait_IsDiplayed(driver, opportunityNumber, sw);
		return opportunityNumber.getText();		
	}
	
	public String getOpportunityName()
	{
		BasePage.fluentWait_IsDiplayed(driver, opportunityName, sw);
		return opportunityName.getText();
	}
	
	public String getAccountName()
	{
		BasePage.fluentWait_IsDiplayed(driver, accountName, sw);
		return accountName.getText();
	}
	
	public String getChannelName()
	{
		BasePage.fluentWait_IsDiplayed(driver, channelName, sw);
		return channelName.getText();
	}
	
	
	public void clickCreateQuote() throws InterruptedException
	{
		BasePage.fluentWait_IsDiplayed(driver, createQuote, sw);
		createQuote.click();
		Thread.sleep(Duration.ofSeconds(sw));
	}
	
	public void clickUnifiedCPQ() throws InterruptedException
	{
		unifiedCPQ.click();
		Thread.sleep(Duration.ofSeconds(sw));
	}
	
	public void clickCreateQuoteButton() throws InterruptedException
	{
		BasePage.fluentWait_IsDiplayed(driver, createQuoteButton, sw);
		createQuoteButton.click();
		Thread.sleep(Duration.ofSeconds(mw));
	}
	
	public String oldTab;
	public void switchToNewTabAndCloseParentTab() throws InterruptedException
	{		
		 //BasePage.jsScrollToElement(driver, newTabButton);
		 		 
		// considering that there is only one tab opened in that point.
	    oldTab = driver.getWindowHandle();
	    
	    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(oldTab);
	    
	    //Close parent tab
	    Thread.sleep(Duration.ofSeconds(mw));
	    driver.close();
	    
	    // change focus to new tab
	    driver.switchTo().window(newTab.get(0));
	    //System.out.println(driver.getTitle());
	    
	    // change focus back to old tab
	    //driver.switchTo().window(oldTab);
	    //System.out.print(driver.findElement(By.xpath("//*[@id=\"header-inner\"]/div[1]/h1")).getText());
	    Thread.sleep(Duration.ofSeconds(lw));
	    Thread.sleep(Duration.ofSeconds(mw));
	}	
	
	public void clickSaveButton() throws InterruptedException
	{
		saveButtonCPQ.click();
		Thread.sleep(Duration.ofSeconds(mw));
		
	}
	
	
	
	
}
