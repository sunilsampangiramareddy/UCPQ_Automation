package pageObject_CPQ;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import pageObects_SFDC.BasePage;

public class HomePageCPQ extends BasePage {

public int sw=5; public int mw=10; public int lw=20;

	public HomePageCPQ(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(how = How.XPATH, using = "//div[3]/div[1]/div[2]")
	@CacheLookup
	WebElement quoteNumber;
	
	@FindBy(how = How.XPATH, using = "//div[2]/div[1]/div[2]/div")
	@CacheLookup
	WebElement quoteName;
	
	@FindBy(how = How.XPATH, using = "//div[3]/div[2]/div[2]")
	@CacheLookup
	WebElement quoteStatus;
	
	@FindBy(how = How.XPATH, using = "//oj-vb-fragment[5]/oj-module/oj-c-button/button")
	@CacheLookup
	WebElement saveButton;
	
	
	public String getQuoteNumber()
	{
		return quoteNumber.getText();
	}
	
	public String getQuoteName()
	{
		return quoteName.getText();
	}
	
	public String getQuoteStatus()
	{
		return quoteStatus.getText();
	}

	public void clickSaveButton() throws InterruptedException
	{
		saveButton.click();
		Thread.sleep(Duration.ofSeconds(mw));
	}
	
}
