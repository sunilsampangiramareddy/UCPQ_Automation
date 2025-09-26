package pageObjects_CPQ;

import java.time.Duration;
import java.util.ArrayList;
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
	WebElement quoteDraftStatus;
	
	@FindBy(how = How.XPATH, using = "//div[normalize-space()='Configured']")
	@CacheLookup
	WebElement quoteConfiguredStatus;
	
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
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"cx-cpq-line-items-div\"]/div/ul/div[1]/div[2]")
	@CacheLookup
	WebElement lineCount;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'oj-flex-bar oj-sm-12 oj-sm-align-self-center oj-sm-flex-wrap-nowrap oracle-cx-cpq-fragmentsUI-cx-cpq-fragment-dataGridColumnTruncate cx-cpq-line-item-row')]")
	@CacheLookup
	WebElement productColumn;
	
	
	
	public String getQuoteNumber()
	{
		return quoteNumber.getText();
	}
	
	public String getQuoteName()
	{
		return quoteName.getText();
	}
	
	public String getQuoteDraftStatus()
	{
		return quoteDraftStatus.getText();
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
		

	public int getLineCount()
	{
		String line_Count=lineCount.getText();
		return Integer.parseInt(line_Count.trim());
		
	}
			
	public String getQuoteConfiguredStatus()
		{
			return quoteConfiguredStatus.getText();
		}
		
		
	// Create an ArrayList to store the values
	public ArrayList<String> productColumnValues = new ArrayList<>();
	public void readProductsTableByColumnName(String columnName) throws InterruptedException
	{
		switch (columnName) {
		case "Product":
			// Locate elements using XPath
	        List<WebElement> elements_1 = driver.findElements(By.xpath("//div[contains(@class, 'oj-flex-bar oj-sm-12 oj-sm-align-self-center oj-sm-flex-wrap-nowrap oracle-cx-cpq-fragmentsUI-cx-cpq-fragment-dataGridColumnTruncate cx-cpq-line-item-row')]"));
	        // Extract and print text of each element
	        for (WebElement element_1 : elements_1) {
	        	BasePage.jsScrollToElement(driver, element_1);
	        	productColumnValues.add(element_1.getText()); //Store product values in array list
	            System.out.println(element_1.getText());
	           }
	        Thread.sleep(Duration.ofSeconds(nw));
	    break;
	    case "List Price":
        		// Locate elements using XPath
                List<WebElement> elements_2 = driver.findElements(By.xpath("//div[contains(@class, 'oj-flex oracle-cx-cpq-fragmentsUI-cx-cpq-fragment-dataGridColumnTruncate oj-fa-cx-cpq-field-listPrice_l_c')]"));
                // Extract and print text of each element
                for (WebElement element_2 : elements_2) {
                	BasePage.jsScrollToElement(driver, element_2);
                    System.out.println(element_2.getText());
                }
                Thread.sleep(Duration.ofSeconds(nw));
         break;
        case "Net Price":
        		// Locate elements using XPath
                List<WebElement> elements_3 = driver.findElements(By.xpath("//div[contains(@class, 'oj-flex oracle-cx-cpq-fragmentsUI-cx-cpq-fragment-dataGridColumnTruncate oj-fa-cx-cpq-field-netPrice_l_c')]"));
                // Extract and print text of each element
                for (WebElement element_3 : elements_3) {
                	BasePage.jsScrollToElement(driver, element_3);
                    System.out.println(element_3.getText());
                 }
                Thread.sleep(Duration.ofSeconds(nw));
        break;  	
        case "Current Discount":
    		// Locate elements using XPath
            List<WebElement> elements_4 = driver.findElements(By.xpath("//div[contains(@class, 'oj-flex oracle-cx-cpq-fragmentsUI-cx-cpq-fragment-dataGridColumnTruncate oj-fa-cx-cpq-field-currentDiscount_l_c')]"));
            // Extract and print text of each element
            for (WebElement element_4 : elements_4) {
            	BasePage.jsScrollToElement(driver, element_4);
                System.out.println(element_4.getText());
               }
            Thread.sleep(Duration.ofSeconds(nw));
        break;
        case "Eligible Discount":
    		// Locate elements using XPath
            List<WebElement> elements_5 = driver.findElements(By.xpath("//div[contains(@class, 'oj-flex oracle-cx-cpq-fragmentsUI-cx-cpq-fragment-dataGridColumnTruncate oj-fa-cx-cpq-field-eligibleDiscount_l_c')]"));
            // Extract and print text of each element
            for (WebElement element_5 : elements_5) {
            	BasePage.jsScrollToElement(driver, element_5);
                System.out.println(element_5.getText());
              }
            Thread.sleep(Duration.ofSeconds(nw));
        break;
        case "Part Description":
    		// Locate elements using XPath
            List<WebElement> elements_6 = driver.findElements(By.xpath("//div[contains(@class, 'oj-flex oracle-cx-cpq-fragmentsUI-cx-cpq-fragment-dataGridColumnTruncate oj-fa-cx-cpq-field-partDescription_l_c')]"));
            // Extract and print text of each element
            for (WebElement element_6 : elements_6) {
            	BasePage.jsScrollToElement(driver, element_6);
                System.out.println(element_6.getText());
              }
            Thread.sleep(Duration.ofSeconds(nw));
        break;
        case "Treshold Group":
    		// Locate elements using XPath
            List<WebElement> elements_7 = driver.findElements(By.xpath("//div[contains(@class, 'oj-flex oracle-cx-cpq-fragmentsUI-cx-cpq-fragment-dataGridColumnTruncate oj-fa-cx-cpq-field-thresholdGroup_l_c')]"));
            // Extract and print text of each element
            for (WebElement element_7 : elements_7) {
            	BasePage.jsScrollToElement(driver, element_7);
                System.out.println(element_7.getText());
              }
            Thread.sleep(Duration.ofSeconds(nw));
        break;
        default:
        		System.out.println("Invalid column name");
        break;
            
		}
	}
	
	
	
	public void verifyProductColumnValueInArrayList(String value)
		{
			// Check if the value is present in the ArrayList
	        if (productColumnValues.contains(value)) {
	            System.out.println(value + " product name has been verified in products table");
	        } else {
	            System.out.println(value + " product name is not present in products table ");
	        }
		}

	
	
	
	
	
	
	
		
}
