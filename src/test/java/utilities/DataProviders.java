package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;



public class DataProviders {
	
	//DataProvider1
	@DataProvider(name = "excelData")
    public Object[][] excelDataProvider() throws IOException {
 
        // We are creating an object from the excel sheet data by calling a method that
        // reads data from the excel stored locally in our system
        Object[][] arrObj = getExcelData("C:\\Users\\sunilr2\\eclipse-workspace\\UCPQ_Automation\\testData\\TestDataSheet.xlsx", "Test");
        return arrObj;
	}
 
	
	
	
	
    // This method handles the excel - opens it and reads the data from the
    // respective cells using a for-loop & returns it in the form of a string array
    public String[][] getExcelData(String fileName, String sheetName) throws IOException {
        String[][] data = null;
        try {
 
            FileInputStream fis = new FileInputStream(fileName); 
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(0);
            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();
            Cell cell;
            data = new String[noOfRows - 1][noOfCols];
 
            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    row = sheet.getRow(i);
                    cell = row.getCell(j);
                    data[i - 1][j] = cell.getStringCellValue();
                }
            }
        } catch (Exception e) {
            System.out.println("The exception is: " + e.getMessage());
        }
        return data;
    }
}