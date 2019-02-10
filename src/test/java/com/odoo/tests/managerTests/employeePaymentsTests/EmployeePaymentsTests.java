package com.odoo.tests.managerTests.employeePaymentsTests;

import com.odoo.utilities.BrowserUtils;
import com.odoo.utilities.TestBase;
import com.sun.xml.internal.ws.db.glassfish.BridgeWrapper;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.*;
import static org.testng.Assert.assertTrue;

public class EmployeePaymentsTests extends TestBase {

    @Test(description = "Verify that manager can see transactions by payment")
    public void EmployeeTransactionsDisplayedTest() throws Exception {
        extentLogger = report.createTest("Employee Transactions Displayed Test.");
        extentLogger.info("Sign into 'Lunch' module");
        pages.login().goToMainPage();

        extentLogger.info("Go to Employee Payments link");
        pages.lunchPage().goToFunctionality("Employee Payments");

        extentLogger.info("Wait for Register Cash moves title to display");
        BrowserUtils.waitForVisibility(pages.employeePaymentsPage().RegisterCashMoves, 5);

        extentLogger.info("Verify that employee payment transactions are displayed");
        Assert.assertTrue(pages.employeePaymentsPage().amountList.size() > 0, "No payment transactions found");

        extentLogger.pass(pages.employeePaymentsPage().amountList.size() + " employee transactions are displayed.");

    }

    @Test(description = "Verify that when clicking header of a category, that category is sorted")
    public void CategorySortTest() throws Exception {
        extentLogger = report.createTest("Category Sort Test.");
        extentLogger.info("Sign into 'Lunch' module");
        pages.login().goToMainPage();

        extentLogger.info("Go to Employee Payments link");
        pages.lunchPage().goToFunctionality("Employee Payments");

        extentLogger.info("Wait for Register Cash moves title to display");
        BrowserUtils.waitForClickablility(pages.employeePaymentsPage().user, 15);

        List<String> defaultUserList = new ArrayList<>();
        for (WebElement element : pages.employeePaymentsPage().userList) {
            if (!defaultUserList.contains(element.getText())) {
                defaultUserList.add(element.getText());
            }
        }

        Collections.sort(defaultUserList);

        BrowserUtils.wait(2);
        extentLogger.info("Click on 'User' header");
        pages.employeePaymentsPage().user.click();
        BrowserUtils.wait(3);

        List<String> sortedUserList = new ArrayList<>();
        for (WebElement element : pages.employeePaymentsPage().userList) {
            if (!sortedUserList.contains(element.getText())) {
                sortedUserList.add(element.getText());
            }
        }

        extentLogger.info("Verify list of users is displayed in order (ascending)");
        Assert.assertEquals(sortedUserList, defaultUserList);

        extentLogger.info("Click on 'Description' header");
        pages.employeePaymentsPage().description.click();
        BrowserUtils.wait(3);

        extentLogger.info("Verify list of description is displayed in order (ascending)");
        for (int i = 0; i < pages.employeePaymentsPage().descriptionList.size() - 1; i++) {
            String current = pages.employeePaymentsPage().descriptionList.get(i).getText();
            String next = pages.employeePaymentsPage().descriptionList.get(i + 1).getText();

            if ((current.isEmpty() && next.isEmpty()) || current.isEmpty() || next.isEmpty()) {
                continue;
            } else if (current.equals(next)) {
                continue;
            } else {
                assertTrue(current.compareToIgnoreCase(next) < 0);
            }
        }

        BrowserUtils.wait(2);
        extentLogger.info("Click on 'Amount' header");
        pages.employeePaymentsPage().amount.click();
        BrowserUtils.wait(3);

        extentLogger.info("Verify list of transaction amounts is displayed in order (ascending)");
        for (int i = 0; i < pages.employeePaymentsPage().amountList.size() - 1; i++) {

            double current = Double.parseDouble(pages.employeePaymentsPage().amountList.get(i).getText());
            double next = Double.parseDouble(pages.employeePaymentsPage().amountList.get(i + 1).getText());

            if (current == next) {
                continue;
            } else {
                assertTrue(current < next);
            }
        }

        BrowserUtils.wait(2);
        extentLogger.info("Click on 'Date' header");
        pages.employeePaymentsPage().date.click();
        BrowserUtils.wait(3);

        extentLogger.info("Verify list of dates is displayed in order (ascending)");
        for (int i = 0; i < pages.employeePaymentsPage().dateList.size() - 1; i++) {

            int[] currentDate = pages.employeePaymentsPage().parseDate(pages.employeePaymentsPage().dateList.get(i).getText());

            LocalDate current = LocalDate.of(currentDate[2], currentDate[0], currentDate[1]);

            int[] nextDate = pages.employeePaymentsPage().parseDate(pages.employeePaymentsPage().dateList.get(i + 1).getText());

            LocalDate next = LocalDate.of(nextDate[2], nextDate[0], nextDate[1]);

            if (currentDate == nextDate) {
                continue;
            } else {
                assertTrue(current.isBefore(next));
            }
        }
        extentLogger.pass("Category Sort test passed.");
    }

    @Test(description = "Verify that can group transactions by categories")
    public void GroupTransactionsTest() throws Exception {
        extentLogger = report.createTest("Group Transactions Test.");
        extentLogger.info("Sign into 'Lunch' module");
        pages.login().goToMainPage();

        extentLogger.info("Go to Employee Payments link");
        pages.lunchPage().goToFunctionality("Employee Payments");

        extentLogger.info("Wait for Register Cash moves title to display");
        BrowserUtils.waitForClickablility(pages.employeePaymentsPage().user, 15);

        BrowserUtils.wait(2);
        extentLogger.info("Click on 'Advanced Search' button");
        pages.employeePaymentsPage().advancedSearchButton.click();

        extentLogger.info("Click 'Group By' drop down menu");
        BrowserUtils.waitForClickablility(pages.employeePaymentsPage().groupBy, 5).click();
        extentLogger.info("Click 'By User' option from drop down menu");
        BrowserUtils.waitForClickablility(pages.employeePaymentsPage().byUser, 5).click();

//        Use wait to allow list to load
//        BrowserUtils.wait(3);
//        for (WebElement element : pages.employeePaymentsPage().transactionAmountGroupList) {
//            System.out.println(element.getText());
//        }

        extentLogger.info("Verify transactions group by user");
        assertTrue(!pages.employeePaymentsPage().userGroupList.isEmpty());

        extentLogger.pass("Group Transactions test passed.");
    }
}
