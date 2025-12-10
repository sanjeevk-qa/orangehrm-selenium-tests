package base;
import config.ConfigReader;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected  WebDriver driver;
   @BeforeMethod
    public  void Login()  {
       ConfigReader.loadConfig();
       String browser= ConfigReader.get("browser");
       String url= ConfigReader.get("url");
       driver=BrowserFactory.createBrowserInstance("browser");
       driver.get(url);

    }


   @AfterMethod
   public void  tearDown() {
      driver.quit();

    }
}
