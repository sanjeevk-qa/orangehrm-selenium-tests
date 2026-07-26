package tests;

import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.DirectoryPage;
import pages.LoginPage;

public class TestNavigateToDirectoryPage extends BaseTest {
@Test
public void validateNavigationToDirectory() {
    LoginPage login = new LoginPage(driver);
    login.loginAs(ConfigReader.get("username"),ConfigReader.get("password"));

    DashboardPage dashboard1= new DashboardPage(driver);
    dashboard1.clickOnDirectory();

    DirectoryPage directoryPage = new DirectoryPage(driver);
    Assert.assertEquals(directoryPage.getDirectoryHeader(),"Directory", "Directory page header is incorrect");
}
}
