package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
   // WebDriver driver; not recommended
    public static WebDriver createBrowserInstance(String BrowserName) {
        WebDriver driver;
        switch (BrowserName) {
            case "chrome":
                ChromeOptions options= new ChromeOptions();
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                System.out.println("Browser not supported. Launching Chrome by default.");
                driver = new ChromeDriver();
        }
        return driver;
    }

    }

