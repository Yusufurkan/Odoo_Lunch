package com.odoo.tests.managerTests.controlAccountsTests;

import com.odoo.utilities.*;
import static org.testng.Assert.*;
import org.testng.annotations.*;

public class ManageAccountTransactionsTests extends TestBase {

    @BeforeMethod
    public void setUp() {
        pages.login().signIn();
        BrowserUtils.wait(3);
    }

    @Test(description = "Verify that 'Lunch' tab is visible from the top navigation tab", groups = "smoke")
    public void verifyLunchTabVisible() {
        extentLogger= report.createTest("Lunch tab visibility test");

        //Verify that 'Lunch' tab is visible  on the top navigation tab
        extentLogger.info("Verifying that 'Lunch' tab is visible");
        assertTrue(pages.main().lunchButton.isDisplayed());

        //Verify that 'Lunch' tab is clickable on the top navigation tab
        extentLogger.info("Verifying that 'Lunch' tab is clickable");
        assertTrue(BrowserUtils.isClickable(pages.main().lunchButton));

        extentLogger.info("Clicking on 'Lunch' tab");
        pages.main().lunchButton.click();
        extentLogger.pass("Lunch tab visibility test passed.");
    }

    @Test(description = "Verify that 'Control Accounts' becomes available and clickable on the left navigation tab", groups = "smoke")
    public void verifyControlAccountsPageDisplayed() {
        extentLogger= report.createTest("Control Accounts visibility and clickability test");

        extentLogger.info("Clicking on 'Lunch' tab");
        pages.main().lunchButton.click();
        pages.lunchPage().closePopup();
        BrowserUtils.wait(3);

        extentLogger.info("Verifying title contains 'New Order'");
        assertTrue(driver.getTitle().contains("New Order"));

        extentLogger.info("Verifying 'Control Accounts' section is displayed");
        assertEquals(pages.controlAccountsPage().controlAccountsButton.getText(), "Control Accounts");

        extentLogger.info("Verifying 'Control Accounts' is clickable");
        assertTrue(BrowserUtils.isClickable(pages.controlAccountsPage().controlAccountsButton));

        extentLogger.info("Clicking on 'Control Accounts'");
        pages.controlAccountsPage().controlAccountsButton.click();
        BrowserUtils.wait(3);

        //Verify that system displays 'Control Accounts' page
        extentLogger.info("Displaying 'Control Accounts' page");
        assertEquals(pages.controlAccountsPage().pageHeaderText.getText(), "Control Accounts");

        extentLogger.pass("Control Accounts page display test passed.");
    }

    @Test(description = "Verify that manager can see total amount of all balances at the bottom of the page")
    public void verifyTotalAmountOfBalances() {
        extentLogger = report.createTest("Correct total amount displayed test");

        extentLogger.info("Clicking on 'Lunch'");
        pages.main().lunchButton.click();
        pages.lunchPage().closePopup();

        extentLogger.info("Clicking on 'Control Accounts'");
        pages.controlAccountsPage().controlAccountsButton.click();
        BrowserUtils.wait(3);

        extentLogger.info("Verifying transactions for all employees is displayed");
        for (int i = 0; i < pages.controlAccountsPage().allAmounts.size(); i++) {
            assertTrue(pages.controlAccountsPage().allAmounts.get(i).isDisplayed());
        }

        extentLogger.info("Verifying correct sum of all transactions is displayed");
        double sum = 0;
        for (int i = 0; i < pages.controlAccountsPage().allAmounts.size(); i++) {
            sum += Double.valueOf(pages.controlAccountsPage().allAmounts.get(i).getText());
        }
        assertEquals(sum, Double.valueOf(pages.controlAccountsPage().totalAmount.getText().replace(",", "")));

        extentLogger.pass("Correct total amount displayed test passed");
    }

    @Test(description = "Verify that manager can see accounts by employee")
    public void seeAccountsByEmployee() {
        extentLogger = report.createTest("See accounts by employee test");

        extentLogger.info("Clicking on 'Lunch'");
        pages.main().lunchButton.click();
        pages.lunchPage().closePopup();

        extentLogger.info("Clicking on 'Control Accounts'");
        pages.controlAccountsPage().controlAccountsButton.click();
        BrowserUtils.wait(3);

        extentLogger.info("Verifying accounts are grouped by employee");
        for (int i = 0; i < pages.controlAccountsPage().accountNames.size(); i++) {
            assertTrue(pages.controlAccountsPage().accountNames.get(i).isDisplayed());
        }

        extentLogger.info("Verifying employee names alphabetically sorted");
        for (int i = 0; i < pages.controlAccountsPage().accountNames.size()-1; i++) {
            String current = pages.controlAccountsPage().accountNames.get(i).getText();
            String next = pages.controlAccountsPage().accountNames.get(i+1).getText();

            assertTrue(current.compareTo(next) < 0);
        }

        extentLogger.info("Verifying selected employee's account balances are displayed");
        int r = (int) (Math.random() * pages.controlAccountsPage().accountNames.size());
        pages.controlAccountsPage().accountNames.get(r).click();
        BrowserUtils.wait(3);

        for (int i = 0; i < pages.controlAccountsPage().employeeAccountAmounts.size(); i++) {
            assertTrue(pages.controlAccountsPage().employeeAccountAmounts.get(i).isDisplayed());
        }

        extentLogger.info("Verifying total transaction number is displayed next to the employee name");
        assertTrue(pages.controlAccountsPage().allAmounts.get(r).isDisplayed());

        extentLogger.pass("See accounts by employee test passed");
    }

    @Test(description = "Verify that when clicking header of a category, that category is sorted")
    public void categorySort() {
        extentLogger = report.createTest("Category sorted test");

        extentLogger.info("Clicking on 'Lunch'");
        pages.main().lunchButton.click();
        pages.lunchPage().closePopup();

        extentLogger.info("Clicking on 'Control Accounts'");
        pages.controlAccountsPage().controlAccountsButton.click();
        BrowserUtils.wait(3);

        extentLogger.info("Clicking on any employee");
        int r = (int) (Math.random() * pages.controlAccountsPage().accountNames.size());
        pages.controlAccountsPage().accountNames.get(r).click();
        BrowserUtils.wait(3);

        extentLogger.info("Clicking on Date header");
        pages.controlAccountsPage().dateHeader.click();
        BrowserUtils.wait(3);

        extentLogger.info("Verifying transaction dates sorted");
        for (int i = 0; i < pages.controlAccountsPage().transactionDates.size()-1; i++) {
            int currentMonth = Integer.parseInt(pages.controlAccountsPage().transactionDates.get(i).getText().substring(0,2));
            int nextMonth = Integer.parseInt(pages.controlAccountsPage().transactionDates.get(i+1).getText().substring(0,2));
            int currentDay = Integer.parseInt(pages.controlAccountsPage().transactionDates.get(i).getText().substring(3,5));
            int nextDay = Integer.parseInt(pages.controlAccountsPage().transactionDates.get(i+1).getText().substring(3,5));

            if (currentMonth != nextMonth && currentDay == nextDay) {
                assertTrue(currentMonth < nextMonth);
            } else if (currentMonth == nextMonth && currentDay != nextDay){
                assertTrue(currentDay < nextDay);
            } else {
                continue;
            }
        }

        extentLogger.info("Clicking on Description header");
        pages.controlAccountsPage().descriptionHeader.click();
        BrowserUtils.wait(3);

        extentLogger.info("Verifying descriptions sorted");
        for (int i = 0; i < pages.controlAccountsPage().transactionDescription.size()-1; i++) {
            String current = pages.controlAccountsPage().transactionDescription.get(i).getText();
            String next = pages.controlAccountsPage().transactionDescription.get(i+1).getText();

            if ((current.isEmpty() && next.isEmpty()) || current.isEmpty() || next.isEmpty()) {
                continue;
            } else if (current.equals(next)) {
                continue;
            } else {
                assertTrue(current.compareTo(next) < 0);
            }
        }

        extentLogger.info("Clicking on Amount header");
        pages.controlAccountsPage().amountHeader.click();
        BrowserUtils.wait(3);

        extentLogger.info("Verifying transaction amount sorted");
        for (int i = 0; i < pages.controlAccountsPage().transactionAmounts.size()-1; i++) {

            double current = Double.parseDouble(pages.controlAccountsPage().transactionAmounts.get(i).getText());
            double next = Double.parseDouble(pages.controlAccountsPage().transactionAmounts.get(i+1).getText());

            if (current == next) {
                continue;
            } else {
                assertTrue(current < next);
            }
        }

        extentLogger.pass("Category sorted test passed");
    }

}
