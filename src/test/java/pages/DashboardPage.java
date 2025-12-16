package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

import java.time.Duration;

public class DashboardPage {
    WebDriver driver;
    //constructor
    public DashboardPage(WebDriver driver) {
        this.driver=driver;
    }
    //Constructor
    private final By dashboardHeader= By.cssSelector("h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
    private final By profileName = By.cssSelector("p.oxd-userdropdown-name");
    private final By performanceBtn=By.xpath("//span[text()='Performance']");

   //waits
    private WebDriverWait getwait() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Methods
    public  String getDashboardHeaderText() {
        getwait().until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader));
        return  driver.findElement(dashboardHeader).getText();
    }
     public boolean isOnDashboard() {
        String header= getDashboardHeaderText();
        return header.equalsIgnoreCase("Dashboard");
     }

     public boolean isProfileNameDisplayed() {
        return driver.findElement(profileName).isDisplayed();
     }

     public String getProfileNameText (){
        return  driver.findElement(profileName).getText();
     }

     public void clickPerformanceBtn() {
         WaitUtils.waitForElementTobeClickable(driver,performanceBtn,10).click();

     }


}
