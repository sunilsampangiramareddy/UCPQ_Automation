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
	public void writeTC_CreateDirectOpportunityTestResults(WebDriver driver, String testcase, String optyNumber, String optyName, String accName, String channel, String executionStatus ) throws IOException
	{
		// workbook object
        XSSFWorkbook workbook = new XSSFWorkbook();
        // spreadsheet object
        XSSFSheet spreadsheet = workbook.createSheet("TC_CreateDirectOpportunity Results");
        // creating a row object
        XSSFRow row;
        
     // This data needs to be written (Object[])
        Map<String, Object[]> studentData = new TreeMap<String, Object[]>();
        studentData.put("1", new Object[] { "Test Case", "Opportunity Number", "Opportunity Name", "Account Name", "Channel", "Execution Status"});
        studentData.put("2", new Object[] { testcase, optyNumber, optyName, accName, channel, executionStatus});
       
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
        FileOutputStream out = new FileOutputStream(new File(".\\excelTestResults\\TC_CreateDirectOpportunity_Test_Results"+"_"+timeNote+".xlsx"));
        workbook.write(out);
        out.close();
	}

	//Write Indirect opportunity test results to excel sheet
		public void writeTC_CreateIndirectOpportunityTestResults(WebDriver driver, String testCase, String optyNumber, String optyName, String accName, String channel, String executionStatus ) throws IOException
		{
			// workbook object
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        // spreadsheet object
	        XSSFSheet spreadsheet = workbook.createSheet("TC_CreateIndirectOpportunity Results");
	        // creating a row object
	        XSSFRow row;
	        
	     // This data needs to be written (Object[])
	        Map<String, Object[]> studentData = new TreeMap<String, Object[]>();
	        studentData.put("1", new Object[] { "Test Case", "Opportunity Number", "Opportunity Name", "Account Name", "Channel", "Execution Status"});
	        studentData.put("2", new Object[] { testCase, optyNumber, optyName, accName, channel, executionStatus});
	       
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
	        FileOutputStream out = new FileOutputStream(new File(".\\excelTestResults\\TC_CreateIndirectOpportunity_Test_Results"+"_"+timeNote+".xlsx"));
	        workbook.write(out);
	        out.close();
		}

	//Write 1P opportunity test results to excel sheet
		public void writeTC_Create1POpportunityTestResults(WebDriver driver, String testcase, String optyNumber, String optyName, String accName, String channel, String executionStatus ) throws IOException
		{
			// workbook object
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        // spreadsheet object
	        XSSFSheet spreadsheet = workbook.createSheet("TC_Create1POpportunityTestResults Results");
	        // creating a row object
	        XSSFRow row;
	        
	     // This data needs to be written (Object[])
	        Map<String, Object[]> studentData = new TreeMap<String, Object[]>();
	        studentData.put("1", new Object[] { "Test Case", "Opportunity Number", "Opportunity Name", "Account Name", "Channel", "Execution Status"});
	        studentData.put("2", new Object[] { testcase, optyNumber, optyName, accName, channel, executionStatus});
	       
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
	        FileOutputStream out = new FileOutputStream(new File(".\\excelTestResults\\TC_Create1POpportunity_Test_Results"+"_"+timeNote+".xlsx"));
	        workbook.write(out);
	        out.close();
		}
	
//Write TC_SolidFireConfig test results to excel sheet
		public void writeTC_SolidFireConfigTestResults(WebDriver driver, String testCase, String optyNumber, String optyName, String accName, String channel, String quoteNum, String quoteName, String quoteStatus, String executionStatus) throws IOException
		{
			// workbook object
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        // spreadsheet object
	        XSSFSheet spreadsheet = workbook.createSheet("TC_SolidFireConfig Results");
	        // creating a row object
	        XSSFRow row;
	        
	     // This data needs to be written (Object[])
	        Map<String, Object[]> studentData = new TreeMap<String, Object[]>();
	        studentData.put("1", new Object[] { "Test Case", "Opportunity Number", "Opportunity Name", "Account Name", "Channel", "Quote Number", "Quote Name", "Quote Status", "Execution Status"});
	        studentData.put("2", new Object[] { testCase, optyNumber, optyName, accName, channel, quoteNum, quoteName, quoteStatus, executionStatus });
	       
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
	        FileOutputStream out = new FileOutputStream(new File(".\\excelTestResults\\TC_SolidFireConfig_Test_Results"+"_"+timeNote+".xlsx"));
	        workbook.write(out);
	        out.close();
		}
	
//Write TC_StorageGridConfig test results to excel sheet
				public void write_TC_StorageGridConfigTestResults(WebDriver driver, String testCase, String optyNumber, String optyName, String accName, String channel, String quoteNum, String quoteName, String quoteStatus, String executionStatus) throws IOException
				{
					// workbook object
			        XSSFWorkbook workbook = new XSSFWorkbook();
			        // spreadsheet object
			        XSSFSheet spreadsheet = workbook.createSheet("TC_StorageGridConfig Results");
			        // creating a row object
			        XSSFRow row;
			        
			     // This data needs to be written (Object[])
			        Map<String, Object[]> studentData = new TreeMap<String, Object[]>();
			        studentData.put("1", new Object[] { "Test Case", "Opportunity Number", "Opportunity Name", "Account Name", "Channel", "Quote Number", "Quote Name", "Quote Status", "Execution Status"});
			        studentData.put("2", new Object[] { testCase, optyNumber, optyName, accName, channel, quoteNum, quoteName, quoteStatus, executionStatus });
			       
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
			        FileOutputStream out = new FileOutputStream(new File(".\\excelTestResults\\TC_StorageGridConfig_Test_Results"+"_"+timeNote+".xlsx"));
			        workbook.write(out);
			        out.close();
				}	
	
	
	//Write TC_FastQuotesConfig test results to excel sheet
				public void write_TC_FastQuotesConfigTestResults(WebDriver driver, String testCase, String optyNumber, String optyName, String accName, String channel, String quoteNum, String quoteName, String quoteStatus, String executionStatus) throws IOException
				{
					// workbook object
			        XSSFWorkbook workbook = new XSSFWorkbook();
			        // spreadsheet object
			        XSSFSheet spreadsheet = workbook.createSheet("TC_FastQuotesConfig Results");
			        // creating a row object
			        XSSFRow row;
			        
			     // This data needs to be written (Object[])
			        Map<String, Object[]> studentData = new TreeMap<String, Object[]>();
			        studentData.put("1", new Object[] { "Test Case", "Opportunity Number", "Opportunity Name", "Account Name", "Channel", "Quote Number", "Quote Name", "Quote Status", "Execution Status"});
			        studentData.put("2", new Object[] { testCase, optyNumber, optyName, accName, channel, quoteNum, quoteName, quoteStatus, executionStatus });
			       
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
			        FileOutputStream out = new FileOutputStream(new File(".\\excelTestResults\\TC_FastQuotesConfig_Test_Results"+"_"+timeNote+".xlsx"));
			        workbook.write(out);
			        out.close();
				}	
}
