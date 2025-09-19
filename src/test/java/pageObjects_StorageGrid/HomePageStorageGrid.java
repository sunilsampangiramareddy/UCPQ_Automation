package pageObjects_StorageGrid;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import pageObects_SFDC.BasePage;

public class HomePageStorageGrid extends BasePage {

public int nw=3; int sw=5; public int mw=10; public int lw=20;

	public HomePageStorageGrid(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(how = How.XPATH, using = "//div[@id='StorageGRID']")
	@CacheLookup
	WebElement storageGridProduct;	
	
	@FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[1]/div[3]/div[1]/a[1]")
	@CacheLookup
	WebElement configureStorageGRIDApplianceAndSoftware;	
	
	@FindBy(how = How.XPATH, using = "//input[@id='oj-searchselect-filter-SG_Model|input']")
	@CacheLookup
	WebElement modelStorageNodes;	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"oj-searchselect-filter-SG_appliance|input\"]")
	@CacheLookup
	WebElement driveTypeStorageNodes;
	
	@FindBy(how = How.XPATH, using = "//input[@id='SG_qty|input']")
	@CacheLookup
	WebElement qtyStorageNodes;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"addToQuoteButton\"]/div/span")
	@CacheLookup
	WebElement addToQuote;
	
	
	
	
	public void clickStorageGridProdcut() throws InterruptedException
	{
		BasePage.jsClick(driver, storageGridProduct);
		Thread.sleep(Duration.ofSeconds(sw));		
	}
	
	public void clickConfigureconfigureStorageGRIDApplianceAndSoftware(String subProdct) throws InterruptedException
	{
		if(!(subProdct.isEmpty()))
		{
			if(subProdct.contains("StorageGRID Appliance and Software"))
			{
				BasePage.jsClick(driver, configureStorageGRIDApplianceAndSoftware);
				Thread.sleep(Duration.ofSeconds(mw));	
			}
		}
	}
	
	
	public void selectModelStorageNodes(String model_StorageNodes) throws InterruptedException 
	{
		if(!(model_StorageNodes.isEmpty()))
		{			
			BasePage.actDoubleClick(driver, modelStorageNodes);
			//Parameterize and concatenate xpath for list options clicking.		
			String finalXpath="//span[normalize-space()='"+model_StorageNodes+"']";
			driver.findElement(By.xpath(finalXpath)).click();
			Thread.sleep(Duration.ofSeconds(sw));
			
		}
	}
	
	public void selectDriveTypeStorageNodes(String driveType_StorageNodes) throws InterruptedException 
	{
		if(!(driveType_StorageNodes.isEmpty()))
		{			
			BasePage.actDoubleClick(driver, driveTypeStorageNodes);
			//Parameterize and concatenate xpath for list options clicking.		
			String finalXpath="//span[normalize-space()='"+driveType_StorageNodes+"']";
			driver.findElement(By.xpath(finalXpath)).click();
			Thread.sleep(Duration.ofSeconds(sw));
			
		}
	}
	
	public void enterQtyStorageNodes(String qty_StorageNodes) throws InterruptedException 
	{
		if(!(qty_StorageNodes.isEmpty()))
		{
		qtyStorageNodes.click();
		qtyStorageNodes.sendKeys(qty_StorageNodes);
		Thread.sleep(Duration.ofSeconds(mw));
		}
	}
	
	public void clickAddToQuote() throws InterruptedException
	{
		BasePage.jsClick(driver, addToQuote);
		Thread.sleep(Duration.ofSeconds(lw));	
		Thread.sleep(Duration.ofSeconds(mw));
	}
}
