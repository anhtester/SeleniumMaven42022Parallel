package anhtester.com.listeners;

import anhtester.com.helpers.CaptureHelpers;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext result) {
        System.out.println("onStart: " + result.getStartDate());
    }

    @Override
    public void onFinish(ITestContext result) {
        System.out.println("onFinish: " + result.getEndDate());
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " is pass.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " is fail.");
        CaptureHelpers.takeScreenshot(result); //Chụp màn hình khi Fail
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName() + " is skip.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

}
