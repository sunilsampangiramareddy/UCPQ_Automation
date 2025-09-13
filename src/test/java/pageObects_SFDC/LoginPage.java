package pageObects_SFDC;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BasePage {
	
public static WebDriver driver;
	
public int sw=5; public int mw=10; public int lw=20;

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
		if(!(email.isEmpty()))
		{
		BasePage.fluentWait_IsDiplayed(driver, emailAddress, mw);
		emailAddress.sendKeys(email);
		}
	}
	
	public void clickNextButton()
	{
		nextButton.click();
	}
	
	public void enterPassword(String pwd)
	{
		BasePage.fluentWait_IsDiplayed(driver, password, mw);
		password.sendKeys(decodeString(pwd));		
	}
	
	public void clickSignInButton()
	{
		signInButton.click();
	}
	
	public void clickStaySignInButton() throws InterruptedException
	{
		BasePage.fluentWait_IsDiplayed(driver, staySignInYesButton, mw);
		staySignInYesButton.click();
		Thread.sleep(Duration.ofSeconds(lw));
	}

	
	}




