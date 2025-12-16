package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PerformancePage;

public class TestNavigateToPerformancePage extends BaseTest {
    @Test
    public void ValidateNavigationToPerformance() {
        LoginPage login= new LoginPage(driver);
        login.loginAs("Admin","admin123");
        DashboardPage dashboard= new DashboardPage(driver);
        dashboard.clickPerformanceBtn();
        PerformancePage performancePage= new PerformancePage(driver);
        performancePage.getModuleHeaderText();
        Assert.assertTrue(performancePage.isOnPerformancePage());
    }

}
