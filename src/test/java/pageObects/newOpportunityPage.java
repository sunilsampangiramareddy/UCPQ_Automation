package pageObects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class newOpportunityPage {
public static WebDriver driver;
	
	public newOpportunityPage(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'New Opportunity')]")
	@CacheLookup
	WebElement newOpportunityButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/section/div/div/section/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-list-container/div/flowruntime-section-with-header/lightning-accordion/div/slot/lightning-accordion-section/div/section/div[2]/slot/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-lwc-field/div/flowruntime-lookup/lightning-lookup/lightning-lookup-desktop/lightning-grouped-combobox/div[1]/div/lightning-base-combobox/div/div/div[1]/div[1]/div/input")
	@CacheLookup
	WebElement searchAccounts;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/section/div/div/section/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-list-container/div/flowruntime-section-with-header/lightning-accordion/div/slot/lightning-accordion-section/div/section/div[2]/slot/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field/flowruntime-lwc-field/div/flowruntime-lookup/lightning-lookup/lightning-lookup-desktop/lightning-grouped-combobox/div[1]/div/lightning-base-combobox/div/div/div[2]/lightning-base-combobox-item/span[1]/lightning-icon")
	@CacheLookup
	WebElement lightningIcon;
	
	
	@FindBy(how = How.XPATH, using = "//a[text()='Apple Estates']")
	@CacheLookup
	WebElement searchedAccount;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[3]/section/div/div/section/flowruntime-flow/flowruntime-navigation-bar/footer/div[2]/lightning-button/button")
	@CacheLookup
	WebElement nextButton;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[3]/section/div/div/section/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")
	@CacheLookup
	WebElement opportunityType;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[3]/section/div/div/section/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-section-with-header/lightning-accordion/div/slot/lightning-accordion-section/div/section/div[2]/slot/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-lwc-field/div/flowruntime-flow-screen-input/flowruntime-input-wrapper2/div/lightning-input/lightning-primitive-input-simple/div[1]/div/input")
	@CacheLookup
	WebElement opportunityName;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[3]/section/div/div/section/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-section-with-header/lightning-accordion/div/slot/lightning-accordion-section/div/section/div[2]/slot/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[4]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")
	@CacheLookup
	WebElement primaryContact;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[3]/section/div/div/section/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-section-with-header/lightning-accordion/div/slot/lightning-accordion-section/div/section/div[2]/slot/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[11]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")
	@CacheLookup
	WebElement salesPlay;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[3]/section/div/div/section/flowruntime-flow/flowruntime-navigation-bar/footer/div[2]/lightning-button[2]/button")
	@CacheLookup
	WebElement nextButton_1;
	
	
	
	public void clickOnNewOppotunityButton() {
		Actions act = new Actions(driver);
		act.moveToElement(newOpportunityButton).click().perform();
	}
	
	public void searchAccount(String accName) throws InterruptedException {
		searchAccounts.sendKeys(accName);
		Thread.sleep(4000);	
		lightningIcon.click();
		}
	
	public void selectSearchedAccount() {
		Actions act = new Actions(driver);
		act.moveToElement(searchedAccount).click().perform();
		}
	
	public void clickNextButton() {
		nextButton.click();
	}
	
	public void selectOpportunityType(String value) {
		Select select = new Select(driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[3]/section/div/div/section/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
		select.selectByVisibleText(value);	
	}
	
	public void enterOppotunityName(String name) {
		opportunityName.sendKeys(name);		
	}
	
	public void selectPrimaryContact(String value) {
		Select select = new Select(driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[3]/section/div/div/section/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-section-with-header/lightning-accordion/div/slot/lightning-accordion-section/div/section/div[2]/slot/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[4]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
		select.selectByVisibleText(value);	
	}
	
	public void selectSalesPlay(String value) {
		Select select = new Select(driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[3]/section/div/div/section/flowruntime-flow/flowruntime-lwc-body/div/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[2]/flowruntime-list-container/div/flowruntime-section-with-header/lightning-accordion/div/slot/lightning-accordion-section/div/section/div[2]/slot/flowruntime-base-section/div/flowruntime-screen-field[1]/flowruntime-list-container/div/flowruntime-base-section/div/flowruntime-screen-field[11]/flowruntime-lwc-field/div/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select")));
		select.selectByVisibleText(value);	
	}
	
	public void clickNextButton_1() {
		nextButton_1.click();
	}
	
	
}
