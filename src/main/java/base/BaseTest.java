package base;
import config.ConfigReader;
import factory.BrowserFactory;
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
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
   @BeforeMethod
    public  void login()  {
       ConfigReader.loadConfig();
       String browser= ConfigReader.get("browser");
       String url= ConfigReader.get("url");
       log.info("Launching Chrome browser");
       driver=BrowserFactory.createBrowserInstance(browser);
       driver.get(url);
       log.info("Navigated to OrangeHRM login page");
       driver.manage().window().maximize();
    }


   @AfterMethod
   public void  tearDown() {
       log.info("Closing browser");
      driver.quit();

    }
}
