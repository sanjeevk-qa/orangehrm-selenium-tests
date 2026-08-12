package hooks;


import config.ConfigReader;
import factory.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static final Logger log =
            LoggerFactory.getLogger(Hooks.class);
@Before
    public void setUp() {
        ConfigReader.loadConfig();

        String browser = ConfigReader.get("browser");
        String url = ConfigReader.get("url");

        log.info("Launching browser for Cucumber scenario");

        DriverManager.startDriver(browser);
        WebDriver driver= DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get(url);

        log.info("Navigated to OrangeHRM login page");

    }
    @After
    public void tearDown() {
        log.info("Closing browser after Cucumber scenario");
        DriverManager.quitDriver();
    }
}



