package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TestInvalidCredentials extends BaseTest {
    @Test

    public void validateInvalidCredentials() {
        LoginPage loginPage = new LoginPage( driver) ;
        loginPage.loginAs("Admin","admin12");
        Assert.assertEquals(loginPage.textInvalidLoginMsg(),"Invalid credentials" ,"Invalid login message did not match");

    }
}
