package com.odoo.tests.managerTests.employeePaymentsTests;

import com.odoo.utilities.BrowserUtils;
import com.odoo.utilities.TestBase;
import com.sun.xml.internal.bind.v2.TODO;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ManagerTransactionTests extends TestBase {

    @Test(description = "Verify that manager can delete a single/multiple or all transactions")
    public void DeleteTransactionsTest() throws Exception {
        extentLogger = report.createTest("Category Sort Test.");
        extentLogger.info("Sign into 'Lunch' module");
        pages.login().goToMainPage();

        extentLogger.info("Go to Employee Payments link");
        pages.lunchPage().goToFunctionality("Employee Payments");

        extentLogger.info("Click on first transaction");
        pages.employeePaymentsPage().firstTransaction.click();

        String currentTitle = pages.employeePaymentsPage().lunchCashMove.getText();

        extentLogger.info("Click 'Action' drop down menu");
        BrowserUtils.waitForClickablility(pages.employeePaymentsPage().actionButton, 5).click();
        extentLogger.info("Click 'Delete' option from menu");
        BrowserUtils.waitForClickablility(pages.employeePaymentsPage().deleteOption, 5).click();

        extentLogger.info("Verify delete confirmation message");
        assertEquals(pages.employeePaymentsPage().confirmationMessage.getText(),
                "Are you sure you want to delete this record ?");

        extentLogger.info("Click 'OK' button to confirm delete");
        pages.employeePaymentsPage().oKDeleteButton.click();

        BrowserUtils.wait(3);

        String afterTitle = pages.employeePaymentsPage().lunchCashMove.getText();

        extentLogger.info("Verify transaction has been deleted");
        assertNotEquals(currentTitle,afterTitle);

        extentLogger.info("Go back to Employee Payments link");
        pages.lunchPage().goToFunctionality("Employee Payments");

        int startingTransactions = pages.employeePaymentsPage().amountList.size();

        extentLogger.info("Select first and second transaction checkboxes");
        pages.employeePaymentsPage().firstCheckBox.click();
        pages.employeePaymentsPage().secondCheckBox.click();

        extentLogger.info("Click 'Action' hidden drop down menu");
        BrowserUtils.waitForClickablility(pages.employeePaymentsPage().hiddenActionButton, 5).click();
        extentLogger.info("Click 'Delete' option from menu");
        BrowserUtils.waitForClickablility(pages.employeePaymentsPage().deleteOption, 5).click();

        extentLogger.info("Verify delete confirmation message");
        assertEquals(pages.employeePaymentsPage().confirmationMessage.getText(),
                "Are you sure you want to delete this record ?");

        extentLogger.info("Click 'OK' button to confirm delete");
        pages.employeePaymentsPage().oKDeleteButton.click();

        BrowserUtils.wait(3);

        int endingTransactions = pages.employeePaymentsPage().amountList.size();

        extentLogger.info("Verify transactions have been deleted.");
        assertTrue(endingTransactions < startingTransactions);

        extentLogger.pass("Delete transactions test passed.");
    }

    @Test(description = "Verify that manager can export transactions")
    public void ExportTransactionsTest() throws Exception {
        extentLogger = report.createTest("Category Sort Test.");
        extentLogger.info("Sign into 'Lunch' module");
        pages.login().goToMainPage();

        extentLogger.info("Go to Employee Payments link");
        pages.lunchPage().goToFunctionality("Employee Payments");

        extentLogger.info("Select first transaction checkbox");
        pages.employeePaymentsPage().firstCheckBox.click();

        extentLogger.info("Click 'Action' hidden drop down menu");
        BrowserUtils.waitForClickablility(pages.employeePaymentsPage().hiddenActionButton, 5).click();
        extentLogger.info("Click 'Export' option from menu");
        BrowserUtils.waitForClickablility(pages.employeePaymentsPage().exportOption, 5).click();

        //TODO finish test case
    }

}
