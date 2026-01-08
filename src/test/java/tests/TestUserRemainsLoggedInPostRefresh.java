package tests;

import base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class TestUserRemainsLoggedInPostRefresh  extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TestUserRemainsLoggedInPostRefresh.class);
    @Test
    public void validateRemainsLoggedInPostRefresh() {
        LoginPage loginpage= new LoginPage(driver);
        loginpage.loginAs("Admin","admin123");
        log.info("logged in with Valid Credentials");

        DashboardPage dashboardBeforeRefresh= new DashboardPage(driver);
        Assert.assertTrue(dashboardBeforeRefresh.isOnDashboard(),"User is not on Dashboard after login");

        driver.navigate().refresh();

        DashboardPage dashboardAfterRefresh= new DashboardPage(driver);
        Assert.assertTrue(dashboardAfterRefresh.isOnDashboard(),"User is not on Dashboard after refresh (session may be lost)");

    }
}
