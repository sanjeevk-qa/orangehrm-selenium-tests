package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class PersonalDetailsPage {
      private final    WebDriver driver;

    public PersonalDetailsPage(WebDriver driver) {
        this.driver=driver;
    }

    private By personalDetailHeader= By.xpath("//h6[text()='Personal Details']");
    private By employeeFullNameHeader= By.cssSelector("h6.oxd-text.oxd-text--h6.--strong");

    public  boolean isOnPersonalDetails() {
        return WaitUtils.waitForElementVisible(driver,personalDetailHeader,20).isDisplayed();
    }

}
