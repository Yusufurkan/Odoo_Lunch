package com.odoo.tests.managerTests.employeePaymentsTests;

import com.odoo.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeePaymentsTests extends TestBase {

    @Test
    public void EmployeeTransactionsDIsplayedTest() throws Exception {
        extentLogger = report.createTest("Employee Payments Test.");
        extentLogger.info("Sign into 'Lunch' module");
        pages.login().goToMainPage();
        extentLogger.info("Go to Employee Payments link");
       pages.lunchPage().goToFunctionality("Employee Payments");
       extentLogger.info("Verify that employee payment transactions are displayed");
       Assert.assertTrue(pages.employeePaymentsPage().transactionAmount.size() > 0, "No payment transactions found");
       extentLogger.pass( pages.employeePaymentsPage().transactionAmount.size() + " employee transactions are displayed.");

    }
}
