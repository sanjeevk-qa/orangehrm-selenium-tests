package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.TestAddEmployee;
import utils.WaitUtils;

public class EmployeeListPage {
    private static final Logger log = LoggerFactory.getLogger(EmployeeListPage.class);

    WebDriver driver;

    public EmployeeListPage (WebDriver driver) {
        this.driver= driver;
    }

    By employeeIDEmployeeInfo=By.xpath("//label[text()='Employee Id']/../following-sibling::div//input");
    By  searchButton=By.xpath("//button[@type='submit' and normalize-space()='Search']");
    By recordFoundText= By.xpath("//span[normalize-space()='(1) Record Found']");



    public void enterEmployeeID(String id) {
        WaitUtils.waitForElementVisible(driver,employeeIDEmployeeInfo,10).sendKeys(id);
    }

    public void clickOnSearch() {
        WaitUtils.waitForElementTobeClickable(driver,searchButton,15).click();
    }

    public boolean isRecordFound() {
       return WaitUtils.waitForElementVisible(driver,recordFoundText,10).isDisplayed();
    }

    public boolean searchByemployeeid(String empID) {
        enterEmployeeID(empID);
        clickOnSearch();
        return isRecordFound();
    }

}

