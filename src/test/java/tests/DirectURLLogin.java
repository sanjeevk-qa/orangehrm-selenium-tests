package tests;


import config.ConfigReader;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class DirectURLLogin  {

      private WebDriver driver;
         @Test
    public  void testDirectURLLogin() {
             ConfigReader.loadConfig();
             String browser = ConfigReader.get("browser");

             driver = BrowserFactory.createBrowserInstance(browser);

             driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

             LoginPage loginpage = new LoginPage(driver);
             Assert.assertTrue(loginpage.isOnLoginPage(), "User should be redirected to Login page when accessing secured URL without login");
         }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
