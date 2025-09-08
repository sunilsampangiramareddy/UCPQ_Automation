package pageObject_CPQ;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Products']")
	@CacheLookup
	WebElement productTab;
	
	@FindBy(how = How.XPATH, using = "//button[@aria-label='Configure Product']")
	@CacheLookup
	WebElement configureProdct;
	
	@FindBy(how = How.XPATH, using = "//span[@class='oj-ux-ico-settings']")
	@CacheLookup
	WebElement settings_ProdcutsTab;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Expand All')]")
	@CacheLookup
	WebElement expandAll;
	
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
	
	public void clickProdctsTab() throws InterruptedException
	{
		BasePage.jsClick(driver, productTab);
		Thread.sleep(Duration.ofSeconds(sw));		
	}
	
	public void clickConfigureProduct() throws InterruptedException
	{
		BasePage.jsClick(driver, configureProdct);
		Thread.sleep(Duration.ofSeconds(lw));		
	}
	
	public void clickSettingsExpandAll() throws InterruptedException
	{
		BasePage.actClick(settings_ProdcutsTab, driver);
		expandAll.click();
		Thread.sleep(Duration.ofSeconds(mw));		
	}
	
	// Print full table data
	public void readFullTable(WebDriver driver) throws InterruptedException
	{
		WebElement table = driver.findElement(By.id("datagrid-container")); 
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		// print complete table data 
		for (WebElement row : rows) { 
		List<WebElement> cols = row.findElements(By.tagName("td"));     
		for (WebElement col : cols) {            
		System.out.print(col.getText() + "\t"); 
		} 
		System.out.println();
		}
		Thread.sleep(Duration.ofSeconds(lw));
	}
	
}
