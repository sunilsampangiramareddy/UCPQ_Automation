package pageObects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class homePage {

public static WebDriver driver;
	
	public homePage(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"oneHeader\"]/div[1]/div/span")
	@CacheLookup
	WebElement homePageLabel;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"92:213;a\"]/span[1]/div/span")
	@CacheLookup
	WebElement logo;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[3]/a//*[contains(text(),'Opportunities')]")
	@CacheLookup
	WebElement opportunitiesTab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"oneHeader\"]/div[1]/div/a")
	@CacheLookup
	WebElement logout;
	
		
	public boolean isMyHomePageExists() {
	try{
			return (homePageLabel.isDisplayed());
	   }
	catch(Exception e) {
	return false;
	   }
	}
	
	public void logout() {
		logout.click();
		
	}
	
	public void clickOnOpportunitiesTab()
	{
		Actions act = new Actions(driver);
		act.moveToElement(opportunitiesTab).click().perform();
		
	}
	
	
	
	}
	
	
	

