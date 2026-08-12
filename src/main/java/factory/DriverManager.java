package factory;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
        // Prevent creation of DriverMnager objet
    }
    public static void startDriver(String browserName) {
        driver = BrowserFactory.createBrowserInstance(browserName) ;
    }
    public static WebDriver  getDriver() {
        if (driver == null) {
            throw new IllegalStateException(
                    "WebDriver has not been started. Call startDriver() first."
            );
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
