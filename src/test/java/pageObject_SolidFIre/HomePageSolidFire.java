package pageObject_SolidFIre;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import pageObects_SFDC.BasePage;

public class HomePageSolidFire extends BasePage {

public int nw=3; int sw=5; public int mw=10; public int lw=20;

	public HomePageSolidFire(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(how = How.XPATH, using = "//div[@id='SolidFire']")
	@CacheLookup
	WebElement solidFireProdct;
	
	@FindBy(how = How.XPATH, using = "//tbody/tr[2]/td[1]/div[3]/div[1]/a[1]")
	@CacheLookup
	WebElement configureTBCLS;
	
	@FindBy(how = How.XPATH, using = "//input[@id='termCapNewCapacity|input']")
	@CacheLookup
	WebElement newCapacity;	

	@FindBy(how = How.XPATH, using = "//div[2]/oj-collapsible/div[2]/div/div[1]/div[1]/div[4]/div[2]/oj-select-single/oj-input-text/div/div/input")
	@CacheLookup
	WebElement newTerm;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"addToQuoteButton\"]/div/span")
	@CacheLookup
	WebElement addToQuote;
	
	public void clickSolidFireProdcut() throws InterruptedException
	{
		BasePage.jsClick(driver, solidFireProdct);
		Thread.sleep(Duration.ofSeconds(sw));		
	}
	
	public void clickConfigureTBCLS(String subProdct) throws InterruptedException
	{
		if(!(subProdct.isEmpty()))
		{
			if(subProdct.contains("Term Based Capacity License Software"))
			{
				BasePage.jsClick(driver, configureTBCLS);
				Thread.sleep(Duration.ofSeconds(mw));	
			}
		}
	}
	
	public void enterNewCapacity(String newCapacityTB) throws InterruptedException 
	{
		if(!(newCapacityTB.isEmpty()))
		{
		newCapacity.click();
		newCapacity.sendKeys(newCapacityTB);
		Thread.sleep(Duration.ofSeconds(mw));
		}
	}
	
	public void selectNewTerm(String new_Term) throws InterruptedException 
	{
		if(!(new_Term.isEmpty()))
		{			
			BasePage.actDoubleClick(driver, newTerm);
			//Parameterize and concatenate xpath for list options clicking.		
			String finalXpath="//span[normalize-space()='"+new_Term+"']";
			driver.findElement(By.xpath(finalXpath)).click();
			Thread.sleep(Duration.ofSeconds(sw));
			
		}
	}
	
	public void clickAddToQuote() throws InterruptedException
	{
		BasePage.jsClick(driver, addToQuote);
		Thread.sleep(Duration.ofSeconds(lw));	
		Thread.sleep(Duration.ofSeconds(sw));
	}
	
	

}
