package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class AddEmployeePage {
    private final WebDriver driver;

    public  AddEmployeePage (WebDriver driver) {
        this.driver=driver;
    }

    private final By firstName= By.name("firstName");
    private final By middleName= By.name("middleName");
    private final By lastName= By.name("lastName");
    private final By saveButton=By.xpath("//button[@type='submit']");
    private final By employeeID = By.xpath("//label[text()='Employee Id']/../following-sibling::div/input");

    public  AddEmployeePage enterFirstName(String fName) {
         WaitUtils.waitForElementVisible(driver,firstName,10).sendKeys(fName);
         return this;
    }
    public  AddEmployeePage enterMiddleName(String mName) {
           WaitUtils.waitForElementVisible(driver,middleName,10).sendKeys(mName);
           return  this;
    }
    public  AddEmployeePage enterLastName( String lName) {
           WaitUtils.waitForElementVisible(driver,lastName,10).sendKeys(lName);
           return this;
    }
    public PersonalDetailsPage clickOnSaveButton() {
        WaitUtils.waitForElementTobeClickable(driver,saveButton,10).click();
        return new PersonalDetailsPage(driver);
    }
    public String getEmployeeID(){
        return WaitUtils.waitForElementVisible(driver,employeeID,10).getAttribute("value").trim();
    }
    public PersonalDetailsPage addEmployee (String fName,String mName, String lName) {
        enterFirstName(fName);
        enterMiddleName(mName);
        enterLastName(lName);
       return clickOnSaveButton();
    }


}
