package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class PIMPage {
    private final WebDriver driver;

    public   PIMPage (WebDriver driver) {
        this.driver= driver;
    }

    private  By pimMenu = By.xpath("//span[text()='PIM']");
    private By employeeListBttn= By.xpath("//a[text()='Add Employee']");

    public void clickOnPIMMenu() {
        WaitUtils.waitForElementTobeClickable(driver,pimMenu,10).click();
    }
    public AddEmployeePage clickOnAddEmployeebBttn() {
        WaitUtils.waitForElementTobeClickable(driver,employeeListBttn,10).click();
        return new AddEmployeePage(driver);


    }
}
