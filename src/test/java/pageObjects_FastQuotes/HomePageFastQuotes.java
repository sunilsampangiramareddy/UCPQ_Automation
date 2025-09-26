package pageObjects_FastQuotes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import pageObects_SFDC.BasePage;

public class HomePageFastQuotes extends BasePage {

public int nw=3; int sw=5; public int mw=10; public int lw=20;

	public HomePageFastQuotes(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(how = How.XPATH, using = "//div[@id='FAST-Quotes']")
	@CacheLookup
	WebElement fastQuotesProduct;
	
	@FindBy(how = How.XPATH, using = "(//a[@data-prodline='cDotSystems'][normalize-space()='Add To Quote'])[1]")
	@CacheLookup
	WebElement configureFASTQUOTEAFFA20001;
	
		
	public void clickFastQuotesProdcut() throws InterruptedException
	{
		BasePage.jsClick(driver, fastQuotesProduct);
		Thread.sleep(Duration.ofSeconds(sw));		
	}
	
	public void clickAddToQuoteFASTQUOTEAFFA20001(String subProdct) throws InterruptedException
	{
		if(!(subProdct.isEmpty()))
		{
			if(subProdct.contains("FASTQUOTE-AFF-A20-001"))
			{
				BasePage.jsClick(driver, configureFASTQUOTEAFFA20001);
			}
		}
		Thread.sleep(Duration.ofSeconds(lw));	
		Thread.sleep(Duration.ofSeconds(mw));
	}
	
	
	
	
	
}
