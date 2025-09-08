package pageObects_SFDC;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.Date;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.io.FileHandler;

public class BasePage {
	
	public WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	
//----COMMON METHODS-------------------------------------------------------------------------------------------------------
	//Java script click on element
	public static void jsClick(WebDriver driver, WebElement elementToClick) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementToClick);
			}
	
    //Actions click on element
	public static void actClick(WebElement elementToClick, WebDriver driver) {
		Actions ob = new Actions(driver);
		ob.moveToElement(elementToClick).click().build().perform();
	}
	
	//Implicit wait
	public static void implicitWait(WebDriver driver, int wait_sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait_sec));
	}
	
	//Implicit wait and click on element
	public static void implicitWaitAndClick(WebDriver driver, WebElement elementToClick, int wait_sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait_sec));
		elementToClick.click();
	}
	
	//Explicit wait for the element to be displayed
	public static void explicitWait_IsDiplayed(WebDriver driver, WebElement element, int wait_sec)
	{
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(wait_sec));
	    wait.until(d -> element.isDisplayed());
	}
	
	//Explicit wait for the element to be displayed and click
	public static void explicitWaitAndClick(WebDriver driver, WebElement elementToClick, int wait_sec)
	{
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(wait_sec));
	    wait.until(d -> elementToClick.isDisplayed());
	    elementToClick.click();
	}
	
	//Fluent wait for the element to be displayed
	public static void fluentWait_IsDiplayed(WebDriver driver, WebElement element, int wait_sec)
	{
		Wait<WebDriver> wait = new FluentWait<>(driver)
							       .withTimeout(Duration.ofSeconds(wait_sec))
				                   .pollingEvery(Duration.ofMillis(300))
				                   .ignoring(NoSuchElementException.class);
		wait.until(d -> element.isDisplayed());
	}
	
	//Fluent wait for the element to be displayed and click
	public static void fluentWaitAndClick(WebDriver driver, WebElement elementToClick, int wait_sec)
	{
		Wait<WebDriver> wait = new FluentWait<>(driver)
							       .withTimeout(Duration.ofSeconds(wait_sec))
				                   .pollingEvery(Duration.ofMillis(300))
				                   .ignoring(NoSuchElementException.class);
		wait.until(d -> elementToClick.isDisplayed());
		wait.until(d -> elementToClick.isEnabled());
	    elementToClick.click();
	}
	
	
	//Java script to scroll to the element
	public static void jsScrollToElement(WebDriver driver, WebElement element)
	{
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	//Java script to scroll to the element and click
	public static void jsScrollToElementAndClick(WebDriver driver, WebElement element)
	{
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	element.isDisplayed();
	element.isEnabled();
	element.click();
	}
	
	//Actions class to move to the element
	public static void actMoveToElement(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);	
	    actions.moveToElement(element).perform();
	}
	
	//Actions class to move to the element and click
	public static void actMoveToElementAndClick(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);	
	    actions.moveToElement(element).click().build().perform();
	}
	
	//Actions class for double click
	public static void actDoubleClick(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);	
	    actions.moveToElement(element).doubleClick().build().perform();
	}
	
	// Normal alert with only OK button
	public static void handleSimpleAlert(WebDriver driver, int wait_sec) throws InterruptedException
		{		   
	    Alert alert = driver.switchTo().alert();
	    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(wait_sec));
	    wait.until(ExpectedConditions.alertIsPresent());
	    System.out.print(alert.getText());
	    alert.accept();
	    }
	
	
	//Confirmation alert with Ok and Cancel options
	public static void handleConfirmationAlert(WebDriver driver, int wait_sec) throws InterruptedException
	{		   
    Alert alert = driver.switchTo().alert();
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(wait_sec));
    wait.until(ExpectedConditions.alertIsPresent());
    System.out.print(alert.getText());
    alert.accept();
    //alert.dismiss();
    }
	
	//Prompt alert with input dialouge box options
		public static void handlePromptAlert(WebDriver driver, int wait_sec, String value) throws InterruptedException
		{		   
	    Alert alert = driver.switchTo().alert();
	    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(wait_sec));
	    wait.until(ExpectedConditions.alertIsPresent());
	    System.out.print(alert.getText());
	    alert.sendKeys(value);
	    alert.accept();
	   //alert.dismiss();
	    }
		
		//Mouse hover and click element
		public static void mouseHover(WebDriver driver, WebElement mainElement) 
		{
			Actions action = new Actions(driver);
			action.moveToElement(mainElement).contextClick().perform();
		}		
		
		
		//Mouse hover and click element
		public static void mouseHoverClick(WebDriver driver, WebElement mainElement, WebElement subElementToClick) 
		{
			Actions action = new Actions(driver);
			action.moveToElement(mainElement).contextClick().perform();
			subElementToClick.click();
		}
		
		// Verify page label or header values
		public static boolean verifyLabelIsDisplayed(WebDriver driver, WebElement element ) 
		{
			try
			{
				return(element.isDisplayed());
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
		
		
//----Switching tabs are below two functions 'switchToNewTab' and 'switchToOldTab'--------------------------------------	
			public String oldTab;
			public void switchToNewTab(WebDriver driver) throws InterruptedException
			{		
				 //BasePage.jsScrollToElement(driver, newTabButton);
				 		 
				// considering that there is only one tab opened in that point.
			    oldTab = driver.getWindowHandle();
			    
			    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			    newTab.remove(oldTab);
			    
			    // change focus to new tab
			    driver.switchTo().window(newTab.get(0));
			    //System.out.println(driver.getTitle());
			    
			    // change focus back to old tab
			    //driver.switchTo().window(oldTab);
			    //System.out.print(driver.findElement(By.xpath("//*[@id=\"header-inner\"]/div[1]/h1")).getText());
			}	
			
			
			public void switchToOldTab(WebDriver driver) throws InterruptedException
			{
				// change focus back to old tab
			    driver.switchTo().window(oldTab);
			    //System.out.println(driver.getTitle());
			}
//-------------------------------------------------------------------------------------------------------------------
		
			
//----Switching multiple windows are below two functions 'switchNewWindow' and 'switchOldWindow'--------------------------------------				
		public String mainWindow;	
		public void switchNewWindow(WebDriver driver) throws InterruptedException
		{
			String mainWindow = driver.getWindowHandle();
			Set<String> s1 = driver.getWindowHandles();
			Iterator<String> i1 = s1.iterator();
			
			while (i1.hasNext()) {
	            String ChildWindow = i1.next();
	                if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	                driver.manage().window().maximize();
	                //System.out.print(driver.getTitle());	
	              }
	            }
		//  Switch back to the main window which is the parent window.
	        //driver.switchTo().window(mainWindow);
		}
		
		
		public void switchOldWindow(WebDriver driver)
		{
		//  Switch back to the main window which is the parent window.
	        driver.switchTo().window(mainWindow);
	        //System.out.print(driver.getTitle());
		}

//-------------------------------------------------------------------------------------------------------------------------	
		
		
		//Method to decode password
		//use the below decodeString method like below ex:
		//driver.findElement(By.xpath("//@id-password").sendKeys(decodeString("----------")
		public static String decodeString(String encodedPassword)
		{
			byte[] decodedString=Base64.decodeBase64(encodedPassword);
			return(new String(decodedString));
		}		
		
				
		//Direct method to capture screenshots
		public void captureScreenshot(WebDriver driver) throws IOException {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy somewhere
			String timeNote=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			FileUtils.copyFile(scrFile, new File(".\\screenshots\\screenshot"+"_"+ timeNote +".png"));
	    }
		
						
       //Write test results to excel sheet
		public void writeExcelTestResults(WebDriver driver, String testName, int optyNumber, int quoteNumber, String testRusult ) throws IOException
		{
			// workbook object
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        // spreadsheet object
	        XSSFSheet spreadsheet = workbook.createSheet("Test Execution Results");
	        // creating a row object
	        XSSFRow row;
	        
	     // This data needs to be written (Object[])
	        Map<String, Object[]> studentData = new TreeMap<String, Object[]>();
	        studentData.put("1", new Object[] { "Test Name", "Opportunity Number", "Quote Number", "Execution Status" });
	        studentData.put("2", new Object[] { testName, Integer.toString(optyNumber), Integer.toString(quoteNumber),testRusult });
	       
	        Set<String> keyid = studentData.keySet();
	        int rowid = 0;
	        
	     // writing the data into the sheets...
	        for (String key : keyid) 
	        {
	        	row = spreadsheet.createRow(rowid++);
	            Object[] objectArr = studentData.get(key);
	            int cellid = 0;

	            for (Object obj : objectArr) 
	            {
	                Cell cell = row.createCell(cellid++);
	                cell.setCellValue((String)obj);
	            }
	        }
	        // writing the workbook into the file...
	    	// Now you can do whatever you need to do with it, for example copy somewhere
			String timeNote=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());			
	        FileOutputStream out = new FileOutputStream(new File(".\\excelTestResults\\Test_Results"+"_"+timeNote+".xlsx"));
	        workbook.write(out);
	        out.close();
		}
		
		
		//Generate random string 
		public String randomString(int num)
		{
			String generatedString=RandomStringUtils.randomAlphabetic(num);
			return generatedString;
		}
		
		//Generate random number
		public String randomNumber(int num)
		{
			String generatedNumber=RandomStringUtils.randomNumeric(num);
			return generatedNumber;
		}
		
	
		
//--------------------------------------------------------------------------------------------------------------------------------		
		
		







}





		
		
		
		

	
	