package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LogOutTest  extends BaseTest {
@Test
    public void ValidateLogOut()  {
        LoginPage login = new LoginPage(driver);
        login.loginAs("Admin","admin123");
        DashboardPage dashboard= new DashboardPage(driver);
        dashboard.logout();


    }
}
