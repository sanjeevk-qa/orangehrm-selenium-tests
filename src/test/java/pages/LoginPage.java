package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
//public static LoginPage() {
      WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    By username = By.name("username");
    By password=By.name("password");
    By LoginButton=By.cssSelector("button[type=submit]");
    //Actions

    public  void enterUsername(String user) {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOfElementLocated(username));
         driver.findElement(username).sendKeys(user);

    }
    public  void enterPaswword (String pass) {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
      driver.findElement(password).sendKeys(pass);
    }
    public void clickSubmit() {
        driver.findElement(LoginButton).click();
    }

    //Combined Login action
    public void loginAs (String user, String pass)  {
        enterUsername(user);
        enterPaswword(pass);
        clickSubmit();

    }
}

