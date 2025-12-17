package tests;

import base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class TestSessionInvalidation extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(TestSessionInvalidation.class);

    @Test
    public void validateSessionInvalidationAfterLogoutUsingBackAndRefresh() {
        LoginPage login= new LoginPage(driver);
        login.loginAs("Admin","admin123");
        DashboardPage dashboard= new DashboardPage(driver);
        dashboard.logout();

        // 3) IMPORTANT: Wait until logout redirect is complete (Login page is ready)
        LoginPage loginAfterLogout= new LoginPage(driver);
        Assert.assertTrue(loginAfterLogout.isOnLoginPage(),"Logout did not redirect to Login page.");

        driver.navigate().back();

        driver.navigate().refresh();

        LoginPage loginAfterBack= new LoginPage(driver);
        Assert.assertTrue(loginAfterBack.isOnLoginPage(),"After logout + Back + Refresh, user should be on Login page (session should be invalid).");



    }
}
