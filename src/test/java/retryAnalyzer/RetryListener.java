package retryAnalyzer;

import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        RetryAnalyzer retryAnalyzer = new RetryAnalyzer();
        if (retryAnalyzer.retry(result)) {
            result.setStatus(ITestResult.SUCCESS);
        } else {
            result.setStatus(ITestResult.FAILURE);
        }
    }
}
