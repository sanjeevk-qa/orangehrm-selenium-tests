package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class ClaimPage {
    private final WebDriver driver ;

    public ClaimPage (WebDriver driver) {
        this.driver = driver ;
    }

    private final By claimHeader = By.xpath("//h6[normalize-space() = 'Claim']");
    private final By submitClaimButton= By.xpath("//a[text()='Submit Claim']");
    private final By eventField = By.xpath(
            "//label[text()='Event']" +
                    "/ancestor::div[contains(@class,'oxd-grid-item')]" +
                    "//div[contains(@class,'oxd-select-text')]"
    );
    private final By currencyField = By.xpath(
            "//label[text()='Currency']" +
            "/ancestor::div[contains(@class, 'oxd-grid-item')]" +
                    "//div[contains(@class, 'oxd-select-text')]"
    );
    private final By createClaimButton= By.xpath("//button[@type='submit']") ;
    private final By cancelClaimCreateButton= By.xpath("//button[@text='Cancel']");
    private final By remarkInputBox= By.xpath(
           "//label[text()='Remarks']" +
                   "/ancestor::div[contains(@class,'oxd-grid-item')]" +
                   "//textarea[contains(@class,'oxd-textarea')]"
    );
    private  By dropDownOption(String optionName)  {
        return By.xpath("//div[contains(@class, 'oxd-select-option')]" +
                "[normalize-space()='" + optionName + "']" ) ;
    }

    public void clickOnSubmitClaim() {
        WaitUtils.waitForElementTobeClickable(driver,submitClaimButton,10).click();
    }

    public void selectEvent(String eventName) {
        WaitUtils.waitForElementTobeClickable(driver,eventField,10).click();
        WaitUtils.waitForElementTobeClickable(driver,dropDownOption(eventName),10).click();

    }

    public void selectCurrency(String currencyName) {
        WaitUtils.waitForElementTobeClickable(driver, currencyField,10).click();
        WaitUtils.waitForElementTobeClickable(driver,dropDownOption(currencyName),10).click();
    }
    public void createClaim(String eventName,String currencyName,String remark) {
        clickOnSubmitClaim();
        selectEvent(eventName);
        selectCurrency(currencyName);
        enterRemark(remark);
        WaitUtils.waitForElementTobeClickable(driver,createClaimButton,10).click();
    }

    public void enterRemark(String remark) {
        WaitUtils.waitForElementVisible(driver,remarkInputBox,10).sendKeys(remark);
    }
}
