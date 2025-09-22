package pageObjects_CPQ;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import pageObects_SFDC.BasePage;

public class HomePageCPQ extends BasePage {

public int nw=2; int sw=5; int mw=10; int lw=20;

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
	
	@FindBy(how = How.XPATH, using = "(//span[@class='oj-ux-icon-size-5x oj-ux-ico-save'])[1]")
	@CacheLookup
	WebElement saveIcon;
	
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Products']")
	@CacheLookup
	WebElement productTab;
	
	@FindBy(how = How.XPATH, using = "//button[@aria-label='Configure Product']")
	@CacheLookup
	WebElement configureProdct;
	
	@FindBy(how = How.XPATH, using = "//button[@type='button']//span[@class='ButtonLabelLayoutStyles_container__1g78mbna']")
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

	public void clickSaveIcon() throws InterruptedException
	{
		saveIcon.click();
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
		Thread.sleep(Duration.ofSeconds(nw));
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
	
//	//Read Product column from Products table
//	public void readProductColumnFromProductsTable(int count) throws InterruptedException 
//	{
//		String firstPath="//*[@id=\"cx-cpq-line-item-";
//		String lastPath="\"]";
//		for(int i=2;i<(count+2);i++)
//		{
//			String finalPath=firstPath+i+lastPath;
//			System.out.println(driver.findElement(By.xpath(finalPath)).getText());	
//		}
//	 Thread.sleep(Duration.ofSeconds(mw));
//	 }
	
	
	
	
	//Read Product column from Products table
		public void readProductColumnFromProductsTable(int count) throws InterruptedException 
		{
			String firstPath="//*[@id=\"cx-cpq-line-item-";
			String lastPath="\"]";
			for(int i=2;i<(count+2);i++)
			{
				String finalPath=firstPath+i+lastPath;
				List<WebElement> elements=driver.findElements(By.xpath(finalPath));
				if (!elements.isEmpty()) {
					String elementText = elements.get(0).getText();
                    System.out.println(elementText);	
				}
				else {
                    // If the element is not found, exit the loop
                    System.out.println("Completed reading of all products");
                    break;
                }
			}
		 Thread.sleep(Duration.ofSeconds(mw));
		 }
		
		
		
		
		
		
		
		
		
		
}
