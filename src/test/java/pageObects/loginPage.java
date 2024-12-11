package pageObects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
	
	//private static final JavascriptExecutor Idriver = null;

	public static WebDriver driver;
	public String passwordPageLabel = "Sign in to your account";
	
	public loginPage(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"signInName\"]")
	@CacheLookup
	WebElement userName;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"next\"]")
	@CacheLookup
	WebElement nextButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"loginHeader\"]/div")
	@CacheLookup
	WebElement enterPasswordLabel;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"i0118\"]")
	@CacheLookup
	WebElement pwd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"idSIButton9\"]")
	@CacheLookup
	WebElement signInButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"idSIButton9\"]")
	@CacheLookup
	WebElement yesButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"oneHeader\"]/div[1]/div/span")
	@CacheLookup
	WebElement msgHomePageLabel;
	
	
	
	public void enterUserName(String username) {
		userName.sendKeys(username);
	}
	
	public void clickNextButton() {
		nextButton.click();
	}
	
	public boolean pwdPageLabel() {
	boolean status=enterPasswordLabel.isDisplayed();
	return status;		
	}
	
	public void enterPassword(String password) {
		pwd.sendKeys(password);	
	}
	
	public void clickSignInButton() {
		signInButton.click();
	}
	
	public void clickYesButton() {
		//Solution 1
		yesButton.click();
		
		//Solution 2
		//Actions act = new Actions(driver);
		//act.moveToElement(yesButton).click().perform();
		
		//Solution 3
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", yesButton);
		
		//Solution 4
		//WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//myWait.until(ExpectedConditions.elementToBeClickable(yesButton)).click();
				
	}
	
	public String getHomePageLabel() {
		try {
			return (msgHomePageLabel.getText());
		} catch (Exception e){
			return (e.getMessage());				
		}
		
	}
	
	
	
	

}
