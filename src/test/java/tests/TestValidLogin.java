package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class TestValidLogin extends BaseTest {

    @Test
    public  void testValidLogin()  {
        LoginPage login = new LoginPage(driver);
        login.loginAs("Admi","admin123");
        System.out.println("Successfull login");

        DashboardPage dashboard= new DashboardPage(driver);
        Assert.assertTrue(dashboard.isOnDashboard());
        Assert.assertTrue(dashboard.isProfileNameDisplayed());
      String profileName= dashboard.getProfileNameText();
        System.out.println("Logged in as: " + profileName);
    }

}

