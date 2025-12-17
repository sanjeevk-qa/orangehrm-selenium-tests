package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;



public class DashboardPage {
  private final   WebDriver driver;
    //constructor
    public DashboardPage(WebDriver driver) {
        this.driver=driver;
    }
    //Constructor
    private final By dashboardHeader= By.cssSelector("h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
    private final By profileName = By.cssSelector("p.oxd-userdropdown-name");
    private final By performanceBtn=By.xpath("//span[text()='Performance']");
    private final By logoutBtn= By.xpath("//a[text()='Logout']");

   //waits
    //private WebDriverWait getwait() {
    //    return new WebDriverWait(driver, Duration.ofSeconds(10));
    //}

    //Methods
    public  String getDashboardHeaderText() {
       return  WaitUtils.waitForElementVisible(driver,dashboardHeader,10).getText().trim();
       // getwait().until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader));
        //return  driver.findElement(dashboardHeader).getText();
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
     public void clickOnProfile() {
        WaitUtils.waitForElementTobeClickable(driver,profileName,10).click();
     }
     public void logout()  {
        clickOnProfile();
        WaitUtils.waitForElementTobeClickable(driver,logoutBtn,10).click();
     }


}
