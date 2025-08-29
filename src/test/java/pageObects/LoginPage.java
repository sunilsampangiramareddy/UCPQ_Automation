package pageObects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BasePage {
	
public static WebDriver driver;

	
int small_Wait=5; int medium_Wait=10; int long_Wait=20;

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='signInName']")
	@CacheLookup
	WebElement emailAddress;
	
	@FindBy(how=How.XPATH, using="//button[@id='next']")
	@CacheLookup
	WebElement nextButton;
	
	@FindBy(how=How.XPATH, using="//input[@id='i0118']")
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.XPATH, using="//input[@id='idSIButton9']")
	@CacheLookup
	WebElement signInButton;
	
	@FindBy(how=How.XPATH, using="//input[@id='idSIButton9']")
	@CacheLookup
	WebElement staySignInYesButton;
	
	
	
	
	public void enterEmailAddress(String email)
	{
		BasePage.fluentWait_IsDiplayed(driver, emailAddress, medium_Wait);
		emailAddress.sendKeys(email);		
	}
	
	public void clickNextButton()
	{
		nextButton.click();
	}
	
	public void enterPassword(String pwd)
	{
		BasePage.fluentWait_IsDiplayed(driver, password, medium_Wait);
		password.sendKeys(pwd);		
	}
	
	public void clickSignInButton()
	{
		signInButton.click();
	}
	
	public void clickStaySignInButton()
	{
		BasePage.fluentWait_IsDiplayed(driver, staySignInYesButton, medium_Wait);
		staySignInYesButton.click();
	}



















}
