package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {
		
		
		//DataProvider 1	
				@DataProvider(name="TC_CreateDirectOpportunity")
				public String [][] getData_TC_CreateDirectOpportunity() throws IOException
				{
					String path=".\\testData\\TC_CreateDirectOpportunity.xlsx";//taking xl file from testData
							
					ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
					
					int totalrows=xlutil.getRowCount("Sheet1");	
					int totalcols=xlutil.getCellCount("Sheet1",1);
							
					String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
					
					for(int i=3;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
					{		
						for(int j=0;j<totalcols;j++)  //0    i is rows j is col
						{
							logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
						}
					}
				return logindata;//returning two dimension array					
				}
		
		
		//DataProvider 2	
				@DataProvider(name="TC_CreateIndirectOpportunity")
				public String [][] getData_TC_CreateIndirectOpportunity() throws IOException
				{
					String path=".\\testData\\TC_CreateIndirectOpportunity.xlsx";//taking xl file from testData
							
					ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
					
					int totalrows=xlutil.getRowCount("Sheet1");	
					int totalcols=xlutil.getCellCount("Sheet1",1);
							
					String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
					
					for(int i=3;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
					{		
						for(int j=0;j<totalcols;j++)  //0    i is rows j is col
						{
							logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
						}
					}
				return logindata;//returning two dimension array					
				}
				
				
			//DataProvider 3	
				@DataProvider(name="TC_Create1POpportunity")
				public String [][] getData_TC_Create1POpportunity() throws IOException
				{
					String path=".\\testData\\TC_Create1POpportunity.xlsx";//taking xl file from testData
							
					ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
					
					int totalrows=xlutil.getRowCount("Sheet1");	
					int totalcols=xlutil.getCellCount("Sheet1",1);
							
					String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
					
					for(int i=3;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
					{		
						for(int j=0;j<totalcols;j++)  //0    i is rows j is col
						{
							logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
						}
					}
				return logindata;//returning two dimension array					
				}
		
				
		//DataProvider 4	
				@DataProvider(name="TC_CreateOpportunity")
				public String [][] getData_TC_CreateOpportunity() throws IOException
				{
					String path=".\\testData\\TC_CreateOpportunity.xlsx";//taking xl file from testData
							
					ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
					
					int totalrows=xlutil.getRowCount("Sheet1");	
					int totalcols=xlutil.getCellCount("Sheet1",1);
							
					String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
					
					for(int i=3;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
					{		
						for(int j=0;j<totalcols;j++)  //0    i is rows j is col
						{
							logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
						}
					}
				return logindata;//returning two dimension array					
				}
				
					
		//DataProvider 5	
				@DataProvider(name="TC_SolidFireConfig")
				public String [][] getData_TC_SolidFireConfig() throws IOException
				{
					String path=".\\testData\\TC_SolidFireConfig.xlsx";//taking xl file from testData
							
					ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
					
					int totalrows=xlutil.getRowCount("Sheet1");	
					int totalcols=xlutil.getCellCount("Sheet1",1);
							
					String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
					
					for(int i=3;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
					{		
						for(int j=0;j<totalcols;j++)  //0    i is rows j is col
						{
							logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
						}
					}
				return logindata;//returning two dimension array					
				}
				
		
		//DataProvider 6	
				@DataProvider(name="TC_StorageGridConfig")
				public String [][] getData_TC_StorageGridConfig() throws IOException
				{
					String path=".\\testData\\TC_StorageGridConfig.xlsx";//taking xl file from testData
							
					ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
					
					int totalrows=xlutil.getRowCount("Sheet1");	
					int totalcols=xlutil.getCellCount("Sheet1",1);
							
					String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
					
					for(int i=3;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
					{		
						for(int j=0;j<totalcols;j++)  //0    i is rows j is col
						{
							logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
						}
					}
				return logindata;//returning two dimension array					
				}
		
			//DataProvider 7	
				@DataProvider(name="TC_FastQuotesConfig")
				public String [][] getData_TC_FastQuotesConfig() throws IOException
				{
					String path=".\\testData\\TC_FastQuotesConfig.xlsx";//taking xl file from testData
							
					ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
					
					int totalrows=xlutil.getRowCount("Sheet1");	
					int totalcols=xlutil.getCellCount("Sheet1",1);
							
					String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
					
					for(int i=3;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
					{		
						for(int j=0;j<totalcols;j++)  //0    i is rows j is col
						{
							logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
						}
					}
				return logindata;//returning two dimension array					
				}
	}	
		
		
		
		
		
		
		
		
		
		
		
		
		
//		//DataProvider
//		@DataProvider(name="excelData")	
//		public Object[][] excelDataProvider() throws IOException {
//			Object[][] arrObj=getExcelData(".\\testData\\TestDataSheet.xlsx", "Test"); //Excel sheet location and tab name
//			return arrObj;
//		}
//		public String[][] getExcelData(String fileName, String sheetName) throws IOException {
//			String[][] data=null;
//			try {
//				FileInputStream fis=new FileInputStream(fileName);
//				XSSFWorkbook workbook=new XSSFWorkbook(fis);
//				XSSFSheet sheet=workbook.getSheet(sheetName);
//				XSSFRow row=sheet.getRow(0);
//				
//				int noOfRows=sheet.getPhysicalNumberOfRows();
//				int noOfCols=row.getLastCellNum();
//				Cell cell;
//				data=new String[noOfRows - 1][noOfCols];
//				
//				for(int i=3; i<noOfRows; i++)
//				{
//					for (int j=0; j<noOfCols; j++)
//					{
//						row=sheet.getRow(i);
//						cell=row.getCell(j);
//						data[i - 1][j]=cell.getStringCellValue();
//					}
//				}
//				
//			} catch (Exception e) {
//				System.out.println("The exception is:" + e.getMessage());
//			}
//			return data;		
//		}
	//}
		
		//DataProvider - Use above 'DataProvide1' or this function - Both are same and working
//		@DataProvider(name = "excelData")
//	    public Object[][] getExcelData() throws IOException {
//	        String excelFilePath = ".\\testData\\TestDataSheet.xlsx"; // Specify your Excel file path
//	        FileInputStream fis = new FileInputStream(excelFilePath);
//	        Workbook workbook = new XSSFWorkbook(fis);
//	        Sheet sheet = workbook.getSheet("Test"); // Get the first sheet (index 0)
	//
//	        int rowCount = sheet.getLastRowNum();
//	        int colCount = sheet.getRow(0).getLastCellNum();
	//
//	        Object[][] data = new Object[rowCount][colCount];
	//
//	        for (int i = 2; i < rowCount; i++) {
//	            Row row = sheet.getRow(i+1); // Start from the third row (assuming headers in first)
//	            for (int j = 0; j < colCount; j++) {
//	                Cell cell = row.getCell(j);
	//
//	                if (cell != null) {
//	                    switch (cell.getCellType()) {
//	                        case STRING:
//	                            data[i][j] = cell.getStringCellValue();
//	                            break;
//	                        case NUMERIC:
//	                            data[i][j] = cell.getNumericCellValue();
//	                            break;
//	                        case BOOLEAN:
//	                            data[i][j] = cell.getBooleanCellValue();
//	                            break;
//	                        case FORMULA:
//	                            // Handle formula cells if needed, e.g., evaluate them
//	                            data[i][j] = cell.getStringCellValue(); // Or evaluate formula
//	                            break;
//	                        case BLANK:
//	                            data[i][j] = ""; // Or null, depending on desired behavior
//	                            break;
//	                        default:
//	                            data[i][j] = null; // Handle other types or set to null
//	                            break;
//	                    }
//	                } else {
//	                    data[i][j] = null; // Handle empty cells
//	                }
//	            }
//	        }
	//
//	        workbook.close();
//	        fis.close();
//	        return data;
//	    }

	//}


		
		//DataProvider 4	


