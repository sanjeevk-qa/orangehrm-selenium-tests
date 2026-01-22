package tests;

import base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TestAddEmployee extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TestAddEmployee.class);

    @Test
    public void testAddEmployee () {
        LoginPage loginPage = new LoginPage( driver) ;
        loginPage.loginAs("Admin","admin123");

        PIMPage pimPage= new PIMPage(driver);
        pimPage.clickOnPIMMenu();
        pimPage.clickOnAddEmployeebBttn();

        String firstName= "TestFN" + System.currentTimeMillis();
        String middleName= " TestMN";
        String lastName= " TestLN";

        log.info(firstName+ middleName+ lastName);

        AddEmployeePage employeePage= new AddEmployeePage(driver);
        String empId = employeePage.getEmployeeID();
        log.info(empId);
        PersonalDetailsPage  personalDetailsPage= employeePage.addEmployee(firstName,middleName,lastName);
        Assert.assertTrue(personalDetailsPage.isOnPersonalDetails()," Personal Details page not displayed after saving employee. EmpId:" + empId);

        PIMPage pimPagePostEmployeeCreation = new PIMPage(driver);
        pimPagePostEmployeeCreation.clickOnEmployeeListHeader();
        log.info("Clicked on Employee Header");

        EmployeeListPage employListPage= new EmployeeListPage(driver);
        //employListPage.waitForFormLoad();
        log.info("Form Loaded");
        Assert.assertTrue(employListPage.searchByemployeeid(empId));



    }
}
