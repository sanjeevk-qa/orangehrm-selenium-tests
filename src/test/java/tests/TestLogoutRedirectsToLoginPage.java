package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class TestLogoutRedirectsToLoginPage extends BaseTest {
    @Test
    public void validateLogoutRedirectsToLoginPage() {
        LoginPage login= new LoginPage(driver);
        login.loginAs("Admin","admin123");
        DashboardPage dashboard= new DashboardPage(driver);
        dashboard.logout();

        LoginPage loginPageAfterLogout= new LoginPage(driver);
        Assert.assertTrue(loginPageAfterLogout.isOnLoginPage());
    }


}
