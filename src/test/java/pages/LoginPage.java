package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;


public class LoginPage {
//public static LoginPage() {
      WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    private final By username = By.name("username");
    private final By password=By.name("password");
    private final By LoginButton=By.cssSelector("button[type=submit]");

    //Actions

    public  void enterUsername(String user) {
        WaitUtils.waitForElementVisible(driver,username,10).sendKeys(user);

    }
    public  void enterPaswword (String pass) {
     WaitUtils.waitForElementVisible(driver,password,10).sendKeys(pass);
    }
    public void clickSubmit() {
       WaitUtils.waitForElementTobeClickable(driver,LoginButton,10).click();
    }

    //Combined Login action
    public void loginAs (String user, String pass)  {
        enterUsername(user);
        enterPaswword(pass);
        clickSubmit();

    }
}

