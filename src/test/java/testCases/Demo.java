package testCases;

import org.testng.annotations.Test;

import utilities.DataProviders;

public class Demo {
	
	@Test(dataProvider = "excelData", dataProviderClass = DataProviders.class)
    public void search(String keyWord1, String keyWord2, String keyword3, String keyword4, String keyword5) {
     System.out.print(keyword3 +"        " + keyword4+"        "+ keyword5+"        " + keyword3+"        " + keyword4+"        ");
    }

}
