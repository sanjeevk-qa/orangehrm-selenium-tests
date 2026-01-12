package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getExtent() {
        if (extent == null) {
            String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String reportPath = System.getProperty("user.dir") + "/test-output/extent/ExtentReport_" + ts + ".html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setReportName("OrangeHRM Automation Report");
            spark.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Project", "OrangeHRM");
            extent.setSystemInfo("Browser", System.getProperty("browser", "chrome"));
            extent.setSystemInfo("OS", System.getProperty("os.name"));
        }
        return extent;
    }
}
