package com.odoo.tests.managerTests.controlAccountsTests;

import com.odoo.utilities.*;
import static org.testng.Assert.*;
import org.testng.annotations.*;

public class ControlAccountTests extends TestBase {

    @BeforeMethod
    public void setUp() {
        extentLogger = report.createTest("Login Test");
        extentLogger.info("Sign in");
        pages.login().signIn();
        extentLogger.pass("Login Test Passed...");
        BrowserUtils.wait(3);
    }

    @Test(description = "Verify that 'Lunch' tab is visible from the top navigation tab", groups = "smoke")
    public void verifyLunchTabVisible() {
        extentLogger= report.createTest("Verify Lunch tab is visible");

        //Verify that 'Lunch' tab is visible  on the top navigation tab
        extentLogger.info("Verifying that 'Lunch' tab is visible");
        assertTrue(pages.main().lucnhButtn.isDisplayed());

        //Verify that 'Lunch' tab is clickable on the top navigation tab
        extentLogger.info("Verifying that 'Lunch' tab is clickable");
        assertTrue(BrowserUtils.isClickable(pages.main().lucnhButtn));

        extentLogger.info("Clicking on 'Lunch' tab");
        pages.main().lucnhButtn.click();
        extentLogger.pass("Lunch tab visibility test passed.");
    }

    @Test(description = "Verify that 'Control Accounts' becomes available and clickable on the left navigation tab", groups = "smoke")
    public void verifyControlAccountsPageDisplayed() {
        extentLogger= report.createTest("Verify 'Control Accounts' becomes available and clickable on the left navigation tab");

        extentLogger.info("Clicking on 'Lunch' tab");
        pages.main().lucnhButtn.click();
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
        pages.main().lucnhButtn.click();
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

}
