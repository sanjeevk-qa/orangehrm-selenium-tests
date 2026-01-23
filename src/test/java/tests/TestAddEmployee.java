package tests;

import base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.*;

public class TestAddEmployee extends BaseTest {

    private String empId;

    private static final Logger log = LoggerFactory.getLogger(TestAddEmployee.class);


    public String addEmployeeAndReturnID () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("Admin", "admin123");

        PIMPage pimPage = new PIMPage(driver);
        pimPage.clickOnPIMMenu();
        pimPage.clickOnAddEmployeebBttn();

        String firstName = "TestFN" + System.currentTimeMillis();
        String middleName = " TestMN";
        String lastName = " TestLN";

        log.info(firstName + middleName + lastName);

        AddEmployeePage employeePage = new AddEmployeePage(driver);
        String empId = employeePage.getEmployeeID();
        log.info(empId);
        PersonalDetailsPage personalDetailsPage = employeePage.addEmployee(firstName, middleName, lastName);
        Assert.assertTrue(personalDetailsPage.isOnPersonalDetails(), " Personal Details page not displayed after saving employee. EmpId:" + empId);

        return empId;
    }
      @Test
     public void testAddEmployee() {
           empId=  addEmployeeAndReturnID();
      }

      @Test
      public void searchAddedEmployee() {
           empId = addEmployeeAndReturnID();
          PIMPage pimPagePostEmployeeCreation = new PIMPage(driver);
          pimPagePostEmployeeCreation.clickOnEmployeeListHeader();
          log.info("Clicked on Employee List Header");

          EmployeeListPage employListPage = new EmployeeListPage(driver);
          //employListPage.waitForFormLoad();
          log.info("Form Loaded");
          Assert.assertTrue(employListPage.searchByemployeeid(empId));

      }
        @AfterMethod (alwaysRun = true)
          public void cleanUp() {
        if (empId == null || empId.isBlank()) {
            log.warn("Cleanup is skipped as empId is null or Blank");
            return;
            }


              PIMPage pimPageforEmployeeDelettion = new PIMPage(driver);
              pimPageforEmployeeDelettion.clickOnEmployeeListHeader();

              EmployeeListPage employeeListToDelete= new EmployeeListPage(driver);
              boolean found = employeeListToDelete.searchByemployeeid(empId);
              if (found) {
                  employeeListToDelete.deleteEmployee();
                  log.info("Deleted employee: {}", empId);
              } else {
                  log.warn("Employee not found for cleanup: {}", empId);
              }
            empId = null;

          }


    }

