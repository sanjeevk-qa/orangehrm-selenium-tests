package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class PIMPage {
    private final WebDriver driver;

    public   PIMPage (WebDriver driver) {
        this.driver= driver;
    }

    private final By pimMenu = By.xpath("//span[text()='PIM']");
    private final By employeeListBttn= By.xpath("//a[text()='Add Employee']");
    private final By employeeListHeader= By.xpath("//a[normalize-space()='Employee List']");

    public void clickOnPIMMenu() {
        WaitUtils.waitForElementTobeClickable(driver,pimMenu,10).click();
    }
    public AddEmployeePage clickOnAddEmployeebBttn() {
        WaitUtils.waitForElementTobeClickable(driver, employeeListBttn, 10).click();
        return new AddEmployeePage(driver);
    }
        public void clickOnEmployeeListHeader() {
            WaitUtils.waitForElementTobeClickable(driver,employeeListHeader,10).click();
        }


    }
