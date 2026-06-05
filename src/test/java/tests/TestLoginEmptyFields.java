package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TestLoginEmptyFields extends BaseTest {

    @Test
    public void testBothFieldsEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmit();
        Assert.assertTrue(loginPage.isUsernameRequiredShown(), "Username 'Required' message not shown");
        Assert.assertTrue(loginPage.isPasswordRequiredShown(), "Password 'Required' message not shown");
    }

    @Test
    public void testUsernameFieldEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword("admin123");
        loginPage.clickSubmit();
        Assert.assertTrue(loginPage.isUsernameRequiredShown(), "Username 'Required' message not shown");
        Assert.assertFalse(loginPage.isPasswordRequiredShown(), "Password 'Required' message should not appear when password is filled");
    }

    @Test
    public void testPasswordFieldEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.clickSubmit();
        Assert.assertFalse(loginPage.isUsernameRequiredShown(), "Username 'Required' message should not appear when username is filled");
        Assert.assertTrue(loginPage.isPasswordRequiredShown(), "Password 'Required' message not shown");
    }
}
