package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class PerformancePage {
 private WebDriver driver;
 public  PerformancePage(WebDriver driver) {
     this.driver=driver;
 }

 private By header= By.cssSelector("h6.oxd-topbar-header-breadcrumb-module");


 public String getModuleHeaderText() {
    String text= WaitUtils.waitForElementVisible(driver, header,10).getText().trim();
    //System.out.println(text);
    return text;
 }
 public boolean isOnPerformancePage() {
    return getModuleHeaderText().equalsIgnoreCase("Performance");
 }

}





