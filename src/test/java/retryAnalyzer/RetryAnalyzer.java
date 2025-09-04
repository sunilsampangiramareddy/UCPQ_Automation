package retryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer  implements IRetryAnalyzer {
	    public int retryCount = 0;
	    public static final int MAX_RETRY_COUNT = 2; // Define maximum retry attempts

	    @Override
	    public boolean retry(ITestResult result) {
	        if (retryCount < MAX_RETRY_COUNT) {
	            retryCount++;
	            return true; // Retry the test
	        }
	        return false; // Do not retry
	    }
	}



