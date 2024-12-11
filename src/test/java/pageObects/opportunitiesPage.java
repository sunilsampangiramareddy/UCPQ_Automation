package pageObects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class opportunitiesPage {
public static WebDriver driver;
	
	public opportunitiesPage(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'New Opportunity')]")
	@CacheLookup
	WebElement newOpportunityButton;
	
	
	
	public void clickOnNewOppotunityButton() {
		Actions act = new Actions(driver);
		act.moveToElement(newOpportunityButton).click().perform();
	}
	
	
	
	
}
