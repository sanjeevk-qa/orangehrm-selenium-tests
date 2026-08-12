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

    @Given("the user is on Orange HRM page")
        public void userIsOnLoginPage() {
             driver = DriverManager.getDriver();

            loginPage = new LoginPage(driver) ;
            Assert.assertTrue(loginPage.isOnLoginPage(),"OrangePageHRM was not displayed");

        log.info("OrangeHRM login page is displayed");
    }

    @When("the user enters valid username and password")
     public void userEntersValidCredentials() {
             loginPage.enterUsername(ConfigReader.get("username"));
             loginPage.enterPassword(ConfigReader.get("password"));

     log.info("Login details submitted successfully");
    }

    @And("the user clicks on the Login button")
    public void userClickOnLoginButton() {
        loginPage.clickSubmit();
    }

    @Then("the OrangeHRM dashboard should open")
        public void dashboardPageShouldOpen() {
            dashboardPage= new DashboardPage(driver);
            Assert.assertTrue(dashboardPage.isOnDashboard());
    }


    }



