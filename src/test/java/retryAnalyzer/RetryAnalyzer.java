package retryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer  implements IRetryAnalyzer {
	    public int retryCount = 0;
	    
	    //public static final int MAX_RETRY_COUNT = 3; // Define maximum retry attempts

//-----Enable below two lines of code to read Retry Execution from POM.xml file or Jenkins URL parameters----------------
	    public static String maxRetryCountProperty = System.getProperty("maxRetryCount");
	    public static final int MAX_RETRY_COUNT= Integer.parseInt(maxRetryCountProperty);

	    @Override
	    public boolean retry(ITestResult result) {
	        if (retryCount < MAX_RETRY_COUNT) {
	            retryCount++;
	            return true; // Retry the test
	        }
	        return false; // Do not retry
	    }
	}



