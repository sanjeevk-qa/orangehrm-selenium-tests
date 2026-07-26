package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class DirectoryPage {
    private final WebDriver driver;

    public DirectoryPage(WebDriver driver) {
        this.driver = driver;
    }
    private  final By directoryHeader = By.xpath("//h6[normalize-space()='Directory']");

    public String getDirectoryHeader () {
      return  WaitUtils.waitForElementVisible(driver,directoryHeader,10).getText().trim();
    }



}
