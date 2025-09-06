package pageObects_SFDC;

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
	
	
	@FindBy(how = How.XPATH, using = "//a[@title='Opportunities']")
	@CacheLookup
	WebElement opportunitiesTab;
	
	@FindBy(how = How.XPATH, using = "//div[@title='New Opportunity']")
	@CacheLookup
	WebElement newOpportunity;
	
	@FindBy(how = How.XPATH, using = "//div[1]/div[1]/div/input")
	@CacheLookup
	WebElement searchAccount;
									  
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/section/div[2]/div[2]/div[2]/div[1]/div/div/div/div[3]/section/div/div/section/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-list-container/div/flowruntime-section-with-header/lightning-accordion/div/slot/lightning-accordion-section/div/section/div[2]/slot/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-lwc-field/div/flowruntime-lookup/lightning-lookup/lightning-lookup-desktop/lightning-grouped-combobox/div[1]/div/lightning-base-combobox/div/div/div[2]/lightning-base-combobox-item/span[1]/lightning-icon/span/lightning-primitive-icon")
	@CacheLookup
	WebElement lightningIcon;
	
	@FindBy(how = How.XPATH, using = "//tr[1]/td[1]/lightning-primitive-cell-checkbox/span/label/span[1]")
	@CacheLookup
	WebElement selectSearchedAccount;
	
	@FindBy(how = How.XPATH, using = "//lightning-button[2]/button")
	@CacheLookup
	WebElement selectButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/section/div[2]/div[2]/div[2]/div[1]/div/div/div/div[3]/section/div/div/section/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-list-container/div/flowruntime-section-with-header/lightning-accordion/div/slot/lightning-accordion-section/div/section/div[2]/slot/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-lwc-field/div/flowruntime-lookup/lightning-lookup/lightning-lookup-desktop/lightning-grouped-combobox/div[1]/div/lightning-base-combobox/div/div/div[2]/ul/li[1]/lightning-base-combobox-item/span[1]/lightning-icon/span/lightning-primitive-icon/svg/g/path")
	@CacheLookup
	WebElement selectAccountInSearchedList;
	
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
	
	
	@FindBy(how = How.XPATH, using = "//div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")
	@CacheLookup
	WebElement pathway;
	
	@FindBy(how = How.XPATH, using = "//div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")
	@CacheLookup
	WebElement partnerSalesModel;	
	
	
	@FindBy(how = How.XPATH, using = "//lightning-button[2]/button")
	@CacheLookup
	WebElement nextButton2;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/section/div[2]/div[2]/div[2]/div[1]/div/div/div/div[3]/section/div/div/section/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-section-with-header/lightning-accordion/div/slot/lightning-accordion-section/div/section/div[2]/slot/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")
	@CacheLookup
	WebElement endCustomerUsage;
	
	@FindBy(how = How.XPATH, using = "//div[1]/div[1]/div/input")
	@CacheLookup
	WebElement reseller;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/section/div[2]/div[2]/div[2]/div[1]/div/div/div/div[3]/section/div/div/section/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-section-with-header/lightning-accordion/div/slot/lightning-accordion-section/div/section/div[2]/slot/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-lwc-field/div/flowruntime-lookup/lightning-lookup/lightning-lookup-desktop/lightning-grouped-combobox/div[1]/div/lightning-base-combobox/div/div/div[2]/lightning-base-combobox-item/span[1]/lightning-icon/span/lightning-primitive-icon")
	@CacheLookup
	WebElement lightningIcon_2;
	
	@FindBy(how = How.XPATH, using = "//tr[1]/td[1]/lightning-primitive-cell-checkbox/span/label/span[1]")
	@CacheLookup
	WebElement selectSearchedAccount_2;
	
	@FindBy(how = How.XPATH, using = "//slot/div/lightning-button[2]/button")
	@CacheLookup
	WebElement selectButton_2;
	
	@FindBy(how = How.XPATH, using = "//lightning-button[2]/button")
	@CacheLookup
	WebElement nextButton_2;
	
	@FindBy(how = How.XPATH, using = "//flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")
	@CacheLookup
	WebElement resellerSalesRep;
	
	@FindBy(how = How.XPATH, using = "//flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")
	@CacheLookup
	WebElement resellerSE;
	
	@FindBy(how = How.XPATH, using = "//lightning-button[2]/button")
	@CacheLookup
	WebElement nextButton_3;
	
	public void navigateToOpportunitiesPage() throws InterruptedException
	{
		driver.navigate().to("https://netapp2--uat.sandbox.lightning.force.com/lightning/o/Opportunity/list?filterName=__Recent");
		Thread.sleep(Duration.ofSeconds(mw));
	}
	
	public void clickOpportunityTab() throws InterruptedException
	{
		BasePage.actDoubleClick(driver, opportunitiesTab);
		Thread.sleep(Duration.ofSeconds(mw));
		
	}
		
	
	public void clickNewOpportunity() throws InterruptedException 
	{
		newOpportunity.click();
		Thread.sleep(Duration.ofSeconds(mw));
	}
	
	public void enterSearchAccount(String accname) throws InterruptedException 
	{
		if(!(accname.isEmpty()))
		{
		searchAccount.sendKeys(accname);
		Thread.sleep(Duration.ofSeconds(sw));
		}
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
	
	public void selectAccountInSearchedList() throws InterruptedException
	{
		selectAccountInSearchedList.click();
		Thread.sleep(Duration.ofSeconds(sw));
	}
	
	
	public void clickNextButton() throws InterruptedException 
	{
		nextButton.click();
		Thread.sleep(Duration.ofSeconds(mw));
	}
	
	public void selectOpportunityType(String opportunityType) 
	{
		if(!(opportunityType.isEmpty()))
		{
		Select dd = new Select(driver.findElement(By.xpath("//div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
		dd.selectByVisibleText(opportunityType);
		}
	}
	
	public void enterOpportunityName(String opptyName) throws InterruptedException
	{
		if(!(opptyName.isEmpty()))
		{
		String generatedNumber=RandomStringUtils.randomNumeric(5);
		opportunityName.sendKeys(opptyName+"-"+generatedNumber);
		}
	}
	
	public void selectPrimaryContact(String primaryContact) 
	{
		if(!(primaryContact.isEmpty()))
		{
		Select dd = new Select(driver.findElement(By.xpath("//flowruntime-screen-field[4]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
		dd.selectByVisibleText(primaryContact);
		}
	}
	
	public void selectSalesPlay(String salesPlay) 
	{
		if(!(salesPlay.isEmpty()))
		{
		Select dd = new Select(driver.findElement(By.xpath("//flowruntime-screen-field[11]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
		dd.selectByVisibleText(salesPlay);
		}
	}
	
	public void selectSalesType(String salesType) 
	{
		if(!(salesType.isEmpty()))
		{
			Select dd = new Select(driver.findElement(By.xpath("//flowruntime-screen-field[3]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
			dd.selectByVisibleText(salesType);
		}
	}
	
	public void selectInstalledBaseType(String installedBase) 
	{
		if(!(installedBase.isEmpty()))
		{
			Select dd = new Select(driver.findElement(By.xpath("//flowruntime-screen-field[8]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
			dd.selectByVisibleText(installedBase);
		}
	}
	
	public void selectCurrency(String currency) 
	{
		if(!(currency.isEmpty()))
		{
			Select dd = new Select(driver.findElement(By.xpath("//flowruntime-screen-field[9]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
			dd.selectByVisibleText(currency); 
		}
	}
	
	public void selectChannel(String channel) throws InterruptedException 
	{
		if(!(channel.isEmpty()))
		{
			Select dd = new Select(driver.findElement(By.xpath("//flowruntime-screen-field[13]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
			dd.selectByVisibleText(channel);
			Thread.sleep(Duration.ofSeconds(sw));
		}
	}
	
	public void selectPathway(String pathway) 
	{
		if(!(pathway.isEmpty()))
		{
			Select dd = new Select(driver.findElement(By.xpath("//div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
			dd.selectByVisibleText(pathway); 
		}
	}
	
	public void selectPartnerSalesModel(String partnerSalesModel) 
	{
		if(!(partnerSalesModel.isEmpty()))
		{
			Select dd = new Select(driver.findElement(By.xpath("//div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
			dd.selectByVisibleText(partnerSalesModel); 
		}
	}	
	
	
	public void clickNextButton2() throws InterruptedException 
	{
		nextButton2.click();
		Thread.sleep(Duration.ofSeconds(lw));
		
	}
	
	public void selectEndCustomerUsage(String endCustomerUsage) 
	{
		if(!(endCustomerUsage.isEmpty()))
		{
			Select dd = new Select(driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[2]/div[2]/div[2]/div[1]/div/div/div/div[3]/section/div/div/section/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-section-with-header/lightning-accordion/div/slot/lightning-accordion-section/div/section/div[2]/slot/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
			dd.selectByVisibleText(endCustomerUsage); 
		}
	}
	
	public void enterReseller(String enter_reseller) throws InterruptedException
	{
		if(!(enter_reseller.isEmpty()))
		{
		reseller.click();
		reseller.sendKeys(enter_reseller);
		Thread.sleep(Duration.ofSeconds(sw));
		}
	}
	
	public void clickLightningIcon_2() throws InterruptedException 
	{
		lightningIcon_2.click();
		Thread.sleep(Duration.ofSeconds(sw));
	}
	
	public void selectSearchedAccount_2() throws InterruptedException 
	{
		selectSearchedAccount_2.click();
		Thread.sleep(Duration.ofSeconds(sw));
	}
	
	public void clickSelectButton_2() throws InterruptedException 
	{
		selectButton_2.click();
		Thread.sleep(Duration.ofSeconds(sw));
	}
	
	public void clickNextButton_2() throws InterruptedException 
	{
		nextButton_2.click();
		Thread.sleep(Duration.ofSeconds(sw));
	}
	
	
	public void selectResellerSalesRep(String resellerSalesRep) 
	{
		if(!(resellerSalesRep.isEmpty()))
		{
			Select dd = new Select(driver.findElement(By.xpath("//flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
			dd.selectByVisibleText(resellerSalesRep); 
		}
	}
	
	public void selectResellerSE(String resellerSE) 
	{
		if(!(resellerSE.isEmpty()))
		{
			Select dd = new Select(driver.findElement(By.xpath("//flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
			dd.selectByVisibleText(resellerSE); 
		}
	}
	
	public void clickNextButton_3() throws InterruptedException 
	{
		nextButton_3.click();
		Thread.sleep(Duration.ofSeconds(lw));
		Thread.sleep(Duration.ofSeconds(sw));
	}
}
