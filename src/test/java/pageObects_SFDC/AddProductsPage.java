package pageObects_SFDC;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddProductsPage extends BasePage {

public int sw=5; public int mw=10; public int lw=20;

	public AddProductsPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(how = How.XPATH, using = "//span[@title='Products'][contains(text(), 'Products')]")
	@CacheLookup
	WebElement products;

	@FindBy(how = How.XPATH, using = "//div[2]/ul/li/a")
	@CacheLookup
	WebElement addProducts;	
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div[1]/div/label/div/div/div[1]/div[1]/div/input")
	@CacheLookup
	WebElement searchProduct;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div[1]/div/label/div/div/div[1]/div[1]/div/div/div[1]/div/lightning-icon/span/lightning-primitive-icon")
	@CacheLookup
	WebElement lightningIcon;
	
	@FindBy(how = How.XPATH, using = "//tr[1]/td[2]/span/div/span")
	@CacheLookup
	WebElement searchedProduct;
	
	@FindBy(how = How.XPATH, using = "//div[2]/div/div[3]/div/button[2]")
	@CacheLookup
	WebElement nextButton;
	
	@FindBy(how = How.XPATH, using = "//span/span[2]/button")
	@CacheLookup
	WebElement preClickSalesPrice;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[2]/div/div/div[1]/div/div/div/input")
	@CacheLookup
	WebElement salesPrice;
	
	@FindBy(how = How.XPATH, using = "//div[3]/div/button[3]")
	@CacheLookup
	WebElement saveButton;
	
	@FindBy(how = How.XPATH, using = "//ol/li[2]/a")
	@CacheLookup
	WebElement opptyLink;
	
	public void clickProducts() throws InterruptedException
	{
		BasePage.fluentWait_IsDiplayed(driver, products, sw);
		products.click();
		Thread.sleep(Duration.ofSeconds(sw));
	}
	
	public void clickAddProdcuts() throws InterruptedException 
	{
		BasePage.fluentWait_IsDiplayed(driver, addProducts, sw);
		addProducts.click();
		Thread.sleep(Duration.ofSeconds(sw));
	}
	
	public void searchProdcut(String product) throws InterruptedException 
	{
		if(!(product.isEmpty()))
		{
		searchProduct.click();	
		searchProduct.sendKeys(product); //All SAN Array Flash Config
		Thread.sleep(Duration.ofSeconds(sw));
		}
	}
	
	public void clickLightningIcon() throws InterruptedException 
	{
		BasePage.fluentWait_IsDiplayed(driver, lightningIcon, sw);
		lightningIcon.click();
		Thread.sleep(Duration.ofSeconds(sw));
	}
	
	public void selectSearchedProduct() 
	{
		BasePage.fluentWait_IsDiplayed(driver, searchedProduct, sw);
		searchedProduct.click();
	}
	
	public void clickNextButton() throws InterruptedException
	{
		BasePage.fluentWait_IsDiplayed(driver, nextButton, sw);
		nextButton.click();
		Thread.sleep(Duration.ofSeconds(sw));
	}
	
	public void enterSalesPrice(String price) throws InterruptedException 
	{
		if(!(price.isEmpty()))
		{
		preClickSalesPrice.click();
		salesPrice.click();
		salesPrice.sendKeys(price);
		Thread.sleep(Duration.ofSeconds(sw));
		}
	}
	
	public void clickSaveButton() throws InterruptedException
	{
		BasePage.fluentWait_IsDiplayed(driver, saveButton, sw);
		saveButton.click();
		Thread.sleep(Duration.ofSeconds(sw));
	}
	
	
	public void clickOpptyLink() throws InterruptedException
	{
		BasePage.fluentWait_IsDiplayed(driver, opptyLink, sw);
		opptyLink.click();
		Thread.sleep(Duration.ofSeconds(sw));
	}
	
}
