package reporting;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestNGListener implements ITestListener {

    private static final ExtentReports extent = ExtentManager.getExtent();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        test.get().info("Test started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed ✅");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());

        try {
            BaseTest base = (BaseTest) result.getInstance();
            String base64 = base.getScreenshotBase64();

            test.get().fail("Screenshot on failure",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build()
            );
        } catch (Exception e) {
            test.get().warning("Could not attach screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test skipped: " + (result.getThrowable() != null ? result.getThrowable() : ""));
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
