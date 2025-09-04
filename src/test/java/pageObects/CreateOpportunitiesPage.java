package pageObects;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateOpportunitiesPage extends BasePage {

public int sw=5; public int mw=10; public int lw=20;

	public CreateOpportunitiesPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/section/div[2]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[3]/a/span|/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[3]/a//*[contains(text(),'Opportunities')]")
	@CacheLookup
	WebElement opportunitiesTab;
	
	@FindBy(how = How.XPATH, using = "//div[@title='New Opportunity']")
	@CacheLookup
	WebElement newOpportunity;
	
	@FindBy(how = How.XPATH, using = "//div[1]/div[1]/div/input")
	@CacheLookup
	WebElement searchAccount;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/section/div[2]/div[2]/div[2]/div[1]/div/div/div/div[1]/section/div/div/section/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-list-container/div/flowruntime-section-with-header/lightning-accordion/div/slot/lightning-accordion-section/div/section/div[2]/slot/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-lwc-field/div/flowruntime-lookup/lightning-lookup/lightning-lookup-desktop/lightning-grouped-combobox/div[1]/div/lightning-base-combobox/div/div/div[2]/lightning-base-combobox-item/span[1]/lightning-icon/span/lightning-primitive-icon")
	@CacheLookup
	WebElement lightningIcon;
	
	@FindBy(how = How.XPATH, using = "//tr[1]/td[1]/lightning-primitive-cell-checkbox/span/label/span[1]")
	@CacheLookup
	WebElement selectSearchedAccount;
	
	@FindBy(how = How.XPATH, using = "//lightning-button[2]/button")
	@CacheLookup
	WebElement selectButton;
	
	@FindBy(how = How.XPATH, using = "//lightning-button/button")
	@CacheLookup
	WebElement nextButton;
	
	@FindBy(how = How.XPATH, using = "//div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")
	@CacheLookup
	WebElement opportunityType;
	
	@FindBy(how = How.XPATH, using = "//flowruntime-input-wrapper2/div/lightning-input/lightning-primitive-input-simple/div[1]/div/input")
	@CacheLookup
	WebElement opportunityName;
	
	@FindBy(how = How.XPATH, using = "//flowruntime-screen-field[4]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")
	@CacheLookup
	WebElement primaryContact;
	
	@FindBy(how = How.XPATH, using = "//flowruntime-screen-field[11]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")
	@CacheLookup
	WebElement salesPlay;
	
	@FindBy(how = How.XPATH, using = "//flowruntime-screen-field[3]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")
	@CacheLookup
	WebElement salesType;
	
	@FindBy(how = How.XPATH, using = "//flowruntime-screen-field[8]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")
	@CacheLookup
	WebElement installedBaseType;
	
	@FindBy(how = How.XPATH, using = "//flowruntime-screen-field[9]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")
	@CacheLookup
	WebElement currency;
	
	@FindBy(how = How.XPATH, using = "//flowruntime-screen-field[13]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")
	@CacheLookup
	WebElement channel;
	
	@FindBy(how = How.XPATH, using = "//lightning-button[2]/button")
	@CacheLookup
	WebElement nextButton2;
	
	public void navigateToOpportunitiesPage()
	{
		driver.navigate().to("https://netapp2--uat.sandbox.lightning.force.com/lightning/o/Opportunity/list?filterName=__Recent");
	}
	
	
	public void clickNewOpportunity() throws InterruptedException 
	{
		newOpportunity.click();
		Thread.sleep(Duration.ofSeconds(mw));
	}
	
	public void enterSearchAccount(String accname) throws InterruptedException 
	{
		searchAccount.sendKeys(accname);
		Thread.sleep(Duration.ofSeconds(sw));
	}
	
	
	public void clickLightningIcon() throws InterruptedException 
	{
		lightningIcon.click();
		Thread.sleep(Duration.ofSeconds(sw));
	}
	
	
	public void selectSearchedAccount() throws InterruptedException 
	{
		selectSearchedAccount.click();
		Thread.sleep(Duration.ofSeconds(sw));
	}
	
	public void clickSelectButton() throws InterruptedException 
	{
		selectButton.click();
		Thread.sleep(Duration.ofSeconds(sw));
	}
	
	
	public void clickNextButton() throws InterruptedException 
	{
		nextButton.click();
		Thread.sleep(Duration.ofSeconds(mw));
	}
	
	public void selectOpportunityType(String opportunityType) 
	{
		Select dd = new Select(driver.findElement(By.xpath("//div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
		dd.selectByVisibleText(opportunityType);
	}
	
	public void enterOpportunityName(String opptyName) throws InterruptedException
	{
		String generatedNumber=RandomStringUtils.randomNumeric(5);
		opportunityName.sendKeys(opptyName+"-"+generatedNumber);
	}
	
	public void selectPrimaryContact(String primaryContact) 
	{
		Select dd = new Select(driver.findElement(By.xpath("//flowruntime-screen-field[4]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
		dd.selectByVisibleText(primaryContact);
	}
	
	public void selectSalesPlay(String salesPlay) 
	{
			Select dd = new Select(driver.findElement(By.xpath("//flowruntime-screen-field[11]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
			dd.selectByVisibleText(salesPlay);
	}
	
	public void selectSalesType(String salesType) 
	{
			Select dd = new Select(driver.findElement(By.xpath("//flowruntime-screen-field[3]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
			dd.selectByVisibleText(salesType);
	}
	
	public void selectInstalledBaseType(String installedBase) 
	{
			Select dd = new Select(driver.findElement(By.xpath("//flowruntime-screen-field[8]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
			dd.selectByVisibleText(installedBase);
	}
	
	public void selectCurrency(String currency) 
	{
			Select dd = new Select(driver.findElement(By.xpath("//flowruntime-screen-field[9]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
			dd.selectByVisibleText(currency); 
	}
	
	public void selectChannel(String channel) 
	{
			Select dd = new Select(driver.findElement(By.xpath("//flowruntime-screen-field[13]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
			dd.selectByVisibleText(channel);
	}
	
	public void clickNextButton2() throws InterruptedException 
	{
		nextButton2.click();
		Thread.sleep(Duration.ofSeconds(lw));
		
	}
	
}
