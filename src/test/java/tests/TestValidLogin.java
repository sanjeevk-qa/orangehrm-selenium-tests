package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TestValidLogin extends BaseTest {

    @Test
    public  void testValidLogin()  {
        LoginPage login = new LoginPage(driver);
        login.loginAs("Admin","admin123");
        System.out.println("Successfull login");
    }
}

