package stepdefinitions;

import config.ConfigReader;
import factory.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginSteps {

    private static final Logger log =
            LoggerFactory.getLogger(LoginSteps.class);

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Given("the user is on Orange HRM login page")
    public void userIsOnLoginPage() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);

        Assert.assertTrue(
                loginPage.isOnLoginPage(),
                "OrangeHRM login page was not displayed"
        );

        log.info("OrangeHRM login page is displayed");
    }

    @When("the user enters valid username and password")
    public void userEntersValidCredentials() {
        loginPage.enterUsername(
                ConfigReader.get("username")
        );

        loginPage.enterPassword(
                ConfigReader.get("password")
        );

        log.info("Valid login credentials entered");
    }

    @When("the user enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(
            String username,
            String password
    ) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);

        log.info(
                "Entered username and password for login validation"
        );
    }

    @When("the user enters username {string}")
    public void userEntersUsername(String username) {
        loginPage.enterUsername(username);

        log.info("Username entered");
    }

    @When("the user enters password {string}")
    public void userEntersPassword(String password) {
        loginPage.enterPassword(password);

        log.info("Password entered");
    }

    @When("the user leaves the username blank")
    public void userLeavesUsernameBlank() {
        log.info("Username was left blank");
    }

    @When("the user leaves the password blank")
    public void userLeavesPasswordBlank() {
        log.info("Password was left blank");
    }

    @When("the user leaves the username and password blank")
    public void userLeavesUsernameAndPasswordBlank() {
        log.info("Username and password were left blank");
    }

    @And("the user clicks on the Login button")
    public void userClicksOnLoginButton() {
        loginPage.clickSubmit();

        log.info("Clicked on the Login button");
    }

    @Then("the OrangeHRM dashboard should open")
    public void dashboardShouldOpen() {
        dashboardPage = new DashboardPage(driver);

        Assert.assertTrue(
                dashboardPage.isOnDashboard(),
                "OrangeHRM dashboard did not open"
        );

        log.info("OrangeHRM dashboard opened successfully");
    }

    @And("the profile name should be displayed")
    public void profileNameShouldBeDisplayed() {
        Assert.assertTrue(
                dashboardPage.isProfileNameDisplayed(),
                "Profile name was not displayed"
        );

        String profileName =
                dashboardPage.getProfileNameText();

        Assert.assertNotNull(
                profileName,
                "Profile name was null"
        );

        Assert.assertFalse(
                profileName.isBlank(),
                "Profile name was blank"
        );

        log.info(
                "Logged-in profile name: {}",
                profileName
        );
    }

    @Then("the invalid credentials message should be displayed")
    public void invalidCredentialsMessageShouldBeDisplayed() {
        Assert.assertTrue(
                loginPage.isInvalidLoginMsg(),
                "Invalid credentials message was not displayed"
        );

        log.info(
                "Invalid credentials message is displayed"
        );
    }

    @And("the invalid credentials message should be {string}")
    public void invalidCredentialsMessageShouldMatch(
            String expectedMessage
    ) {
        String actualMessage =
                loginPage.textInvalidLoginMsg();

        Assert.assertEquals(
                actualMessage,
                expectedMessage,
                "Invalid credentials message did not match"
        );

        log.info(
                "Invalid credentials message: {}",
                actualMessage
        );
    }

    @Then("the username required message should be displayed")
    public void usernameRequiredMessageShouldBeDisplayed() {
        Assert.assertTrue(
                loginPage.isUsernameRequiredShown(),
                "Required message was not displayed for username"
        );

        log.info(
                "Username required message is displayed"
        );
    }

    @Then("the password required message should be displayed")
    public void passwordRequiredMessageShouldBeDisplayed() {
        Assert.assertTrue(
                loginPage.isPasswordRequiredShown(),
                "Required message was not displayed for password"
        );

        log.info(
                "Password required message is displayed"
        );
    }
}