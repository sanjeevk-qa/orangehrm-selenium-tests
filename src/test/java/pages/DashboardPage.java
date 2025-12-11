package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    WebDriver driver;
    //constructor
    public DashboardPage(WebDriver driver) {
        this.driver=driver;
    }
    //Constructor
    By dashboardHeader= By.cssSelector("h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
    By profileName = By.cssSelector("p.oxd-userdropdown-name");

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




}
