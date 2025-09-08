package testBase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import pageObects_SFDC.BasePage;

public class WriteTestResults extends BasePage {

public int nw=3; int sw=5; public int mw=10; public int lw=20;

	public WriteTestResults(WebDriver driver)
	{
		super(driver);
	}
	
//Write Direct opportunity test results to excel sheet
	public void writeCreateDirectOpportunityTestResults(WebDriver driver, String optyNumber, String optyName, String accName, String channel ) throws IOException
	{
		// workbook object
        XSSFWorkbook workbook = new XSSFWorkbook();
        // spreadsheet object
        XSSFSheet spreadsheet = workbook.createSheet("Test Execution Results");
        // creating a row object
        XSSFRow row;
        
     // This data needs to be written (Object[])
        Map<String, Object[]> studentData = new TreeMap<String, Object[]>();
        studentData.put("1", new Object[] { "Opportunity Number", "Opportunity Name", "Account Name", "Channel"});
        studentData.put("2", new Object[] { optyNumber, optyName, accName, channel});
       
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
        FileOutputStream out = new FileOutputStream(new File(".\\excelTestResults\\CreateDirectOpportunity_Results"+"_"+timeNote+".xlsx"));
        workbook.write(out);
        out.close();
	}

	//Write Indirect opportunity test results to excel sheet
		public void writeCreateIndirectOpportunityTestResults(WebDriver driver, String optyNumber, String optyName, String accName, String channel ) throws IOException
		{
			// workbook object
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        // spreadsheet object
	        XSSFSheet spreadsheet = workbook.createSheet("Test Execution Results");
	        // creating a row object
	        XSSFRow row;
	        
	     // This data needs to be written (Object[])
	        Map<String, Object[]> studentData = new TreeMap<String, Object[]>();
	        studentData.put("1", new Object[] { "Opportunity Number", "Opportunity Name", "Account Name", "Channel"});
	        studentData.put("2", new Object[] { optyNumber, optyName, accName, channel});
	       
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
	        FileOutputStream out = new FileOutputStream(new File(".\\excelTestResults\\CreateIndirectOpportunity_Results"+"_"+timeNote+".xlsx"));
	        workbook.write(out);
	        out.close();
		}

	
//Write test SolidFire config test results to excel sheet
		public void writeSolidFireConfigTestResults(WebDriver driver, String optyNumber, String optyName, String accName, String channel, String quoteNum, String quoteName, String quoteStatus ) throws IOException
		{
			// workbook object
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        // spreadsheet object
	        XSSFSheet spreadsheet = workbook.createSheet("Test Execution Results");
	        // creating a row object
	        XSSFRow row;
	        
	     // This data needs to be written (Object[])
	        Map<String, Object[]> studentData = new TreeMap<String, Object[]>();
	        studentData.put("1", new Object[] { "Opportunity Number", "Opportunity Name", "Account Name", "Channel", "Quote Number", "Quote Name", "Quote Status"});
	        studentData.put("2", new Object[] { optyNumber, optyName, accName, channel, quoteNum, quoteName, quoteStatus });
	       
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
	        FileOutputStream out = new FileOutputStream(new File(".\\excelTestResults\\SolidFire_Config_Results"+"_"+timeNote+".xlsx"));
	        workbook.write(out);
	        out.close();
		}
	
	
	
	
}
