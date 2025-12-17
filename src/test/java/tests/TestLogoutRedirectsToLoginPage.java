package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class TestLogoutRedirectsToLoginPage extends BaseTest {
    //1.extends Base Test
    //2.Use LoginPage to login
    //3.Implement Logout again  or somehow use the Logout test itself ?
    //4.After Logout validate either URL or Login text just above username field
    @Test
    public void validateLogoutRedirectsToLoginPage() {
        LoginPage login= new LoginPage(driver);
        login.loginAs("Admin","admin123");
        DashboardPage dashboard= new DashboardPage(driver);
        dashboard.logOut();

        LoginPage loginPageAfterLogout= new LoginPage(driver);
        Assert.assertTrue(loginPageAfterLogout.isOnLoginPage());
    }


}
