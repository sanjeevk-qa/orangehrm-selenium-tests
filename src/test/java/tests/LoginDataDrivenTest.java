package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.TestDataProviders;

public class LoginDataDrivenTest extends BaseTest implements ITest {

    private String currentTestName= "";

    @Test(dataProvider = "loginJsonData", dataProviderClass = TestDataProviders.class)
    public void login_shouldBehaveAsExpected(String testName,String username,String password,String expectedResult ) {
        currentTestName= testName;

        LoginPage login = new LoginPage(driver);
        login.loginAs(username,password);
        System.out.println("Login attempted: " + testName + " | user=" + username + " | expected=" + expectedResult);




        if ("SUCCESS".equalsIgnoreCase(expectedResult)) {
            DashboardPage dashboard= new DashboardPage(driver);
            Assert.assertTrue(dashboard.isOnDashboard(),"Expected login SUCCESS but it failed");
        } else {
            Assert.assertTrue(login.isInvalidLoginMsg(), "Expected login FAILURE but error message not shown");
        }
    }

    @Override
    public String getTestName() {
        return "LoginDDT - " + currentTestName;
    }
}
