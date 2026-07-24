package tests;

import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class TestValidLogin extends BaseTest {
    @Test
    public void testValidLogin()  {
        LoginPage login = new LoginPage(driver);
        login.loginAs(ConfigReader.get("username"), ConfigReader.get("password"));
        System.out.println("Successfull login");

        DashboardPage dashboard= new DashboardPage(driver);
        Assert.assertTrue(dashboard.isOnDashboard());
        Assert.assertTrue(dashboard.isProfileNameDisplayed());
        String profileName= dashboard.getProfileNameText();
        Assert.assertEquals(profileName, "Admin", "Profile name did not match expected user");
        System.out.println("Logged in as: " + profileName);
    }

}

