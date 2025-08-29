package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider1
		@DataProvider(name="excelData")	
		public Object[][] excelDataProvider() throws IOException {
			Object[][] arrObj=getExcelData(".\\testData\\TestDataSheet.xlsx", "Test"); //Excel sheet location and tab name
			return arrObj;
		}


		public String[][] getExcelData(String fileName, String sheetName) throws IOException {
			String[][] data=null;
			try {
				FileInputStream fis=new FileInputStream(fileName);
				XSSFWorkbook workbook=new XSSFWorkbook(fis);
				XSSFSheet sheet=workbook.getSheet(sheetName);
				XSSFRow row=sheet.getRow(0);
				
				int noOfRows=sheet.getPhysicalNumberOfRows();
				int noOfCols=row.getLastCellNum();
				Cell cell;
				data=new String[noOfRows - 1][noOfCols];
				
				for(int i=3; i<noOfRows; i++)
				{
					for (int j=0; j<noOfCols; j++)
					{
						row=sheet.getRow(i);
						cell=row.getCell(j);
						data[i - 1][j]=cell.getStringCellValue();
					}
				}
				
			} catch (Exception e) {
				System.out.println("The exception is:" + e.getMessage());
			}
			return data;		
		}
		
		
		
		//DataProvider 2
			
		
		
		//DataProvider 3
		
		//DataProvider 4
		

}
