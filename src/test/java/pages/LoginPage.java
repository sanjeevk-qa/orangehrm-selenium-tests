package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;


public class LoginPage {

   private final    WebDriver  driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    private final By username = By.name("username");
    private final By password=By.name("password");
    private final By LoginButton=By.cssSelector("button[type=submit]");
    private final By loginPageTitle=By.xpath("//h5[text()='Login']");
    private final By invalidLoginMsg = By.xpath("//p[text()='Invalid credentials']");
    //Actions

    public  void enterUsername(String user) {
        WaitUtils.waitForElementVisible(driver,username,10).sendKeys(user);

    }
    public  void enterPassword (String pass) {
     WaitUtils.waitForElementVisible(driver,password,10).sendKeys(pass);
    }
    public void clickSubmit() {
       WaitUtils.waitForElementTobeClickable(driver,LoginButton,10).click();
    }

    //Combined Login action
    public void loginAs (String user, String pass)  {
        enterUsername(user);
        enterPassword(pass);
        clickSubmit();
    }
    public  boolean  isOnLoginPage() {
        return WaitUtils.waitForElementVisible(driver, loginPageTitle, 10).getText().trim().equalsIgnoreCase("Login");
    }


    public String isInvalidLoginMsg() {
       return WaitUtils.waitForElementVisible(driver,invalidLoginMsg,10).getText().trim();
        }
    }


