package base;

import config.ConfigReader;
import factory.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.slf4j.Logger;

public class BaseTest {

    protected  WebDriver driver;

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    public String getScreenshotBase64() {
        if (driver == null) {
            log.warn("Cannot capture screenshot because driver is null");
            return null;
        }

        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BASE64);
    }

   @BeforeMethod
    public  void setUp()  {
       ConfigReader.loadConfig();
       String browser= ConfigReader.get("browser");
       String url= ConfigReader.get("url");

       log.info("Launching  browser");
       DriverManager.startDriver(browser);
       driver = DriverManager.getDriver() ;
       driver.manage().window().maximize();
       driver.get(url);

       log.info("Navigated to OrangeHRM login page");
    }

   @AfterMethod(alwaysRun= true)
   public void  tearDown() {
       if (driver != null) {
           log.info("Closing browser");
           driver.quit();
       } else {
           log.warn("Driver was null — browser was never launched, skipping quit()");
       }
    }
}
