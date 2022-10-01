package anhtester.com.listeners;

import anhtester.com.helpers.CaptureHelpers;
import anhtester.com.utils.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext result) {
        System.out.println("Start Suite: " + result.getStartDate());
        CaptureHelpers.startRecord(result.getName());
    }

    @Override
    public void onFinish(ITestContext result) {
        System.out.println("Finish Suite: " + result.getEndDate());
        CaptureHelpers.stopRecord();
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info(result.getName() + " is pass.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //System.out.println(result.getName() + " is fail.");
        CaptureHelpers.takeScreenshot(result); //Chụp màn hình khi Fail
        Log.error(result.getName() + " is fail.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName() + " is skip.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

}
