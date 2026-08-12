package tests;

import base.BaseTest;
import org.testng.Assert;
import config.ConfigReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.ClaimPage;
import pages.DashboardPage;
import pages.LoginPage;

import java.time.Duration;

public class TestUserCanCreateClaim extends BaseTest {
    @Test
    public void testUserCanCreateClaim() {
        LoginPage login = new LoginPage(driver);
        login.loginAs(ConfigReader.get("username"), ConfigReader.get("password"));

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickOnClaim();

        ClaimPage claim = new ClaimPage(driver);
        claim.createClaim("Accommodation", "United States Dollar", "Test");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean claimDetailsPageOpenened = wait.until(ExpectedConditions.urlContains("/claim/submitClaim/id/"));

        Assert.assertTrue(claimDetailsPageOpenened, "Claim-details page did not open after creating the claim");

    }


}