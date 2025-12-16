package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class PerformancePage {
 private final WebDriver driver;
 public  PerformancePage(WebDriver driver) {
     this.driver=driver;
 }

 private final By header= By.cssSelector("h6.oxd-topbar-header-breadcrumb-module");


 public String getModuleHeaderText() {
     return   WaitUtils.waitForElementVisible(driver, header,10).getText().trim();
    //System.out.println(text);;
 }
 public boolean isOnPerformancePage() {
    return getModuleHeaderText().equalsIgnoreCase("Performance");
 }

}





