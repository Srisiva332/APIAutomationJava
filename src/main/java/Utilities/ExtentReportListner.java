package Utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListner implements ITestListener {

    protected static ExtentReports reports;
    protected static ExtentTest test;

    public void onTestStart(ITestResult result) {

        test = reports.startTest(result.getMethod().getMethodName());
        test.log(LogStatus.INFO, result.getMethod().getMethodName());
        System.out.println(result.getTestClass().getTestName());
        System.out.println(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        test.log(LogStatus.PASS, "Test is pass");

    }

    public void onTestFailure(ITestResult result) {
        test.log(LogStatus.FAIL, "Test is fail");

    }

    public void onTestSkipped(ITestResult result) {
        test.log(LogStatus.SKIP, "Test is skipped");

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onStart(ITestContext context) {
        System.out.println(FrameworkConstants.REPORT_lOCATION + "  ReportLocation");
        reports = new ExtentReports(FrameworkConstants.REPORT_lOCATION + "ExtentReport.html");
        test = reports.startTest("");

    }

    public void onFinish(ITestContext context) {
        reports.endTest(test);
        reports.flush();

    }
}
