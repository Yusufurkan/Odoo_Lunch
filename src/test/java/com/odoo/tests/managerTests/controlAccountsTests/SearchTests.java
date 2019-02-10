package com.odoo.tests.managerTests.controlAccountsTests;

import com.odoo.utilities.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class SearchTests extends TestBase {

    @BeforeMethod
    public void setUp() {
        pages.login().signIn();
        BrowserUtils.wait(5);
    }

    @Test(description = "Verify that manager can filter results by categories")
    public void filterResultByCategories() {
        extentLogger= report.createTest("Filter results by categories test");

        extentLogger.info("Clicking on 'Lunch' tab");
        pages.main().lunchButton.click();
        pages.lunchPage().closePopup();

        extentLogger.info("Clicking on 'Control Accounts'");
        BrowserUtils.waitForClickablility(pages.controlAccountsPage().controlAccountsButton, 10).click();

        extentLogger.info("Verifying default search term");
        BrowserUtils.isElementsTextAMatch(pages.controlAccountsPage().defaultSearchTerm, "By Employee", 10);

        BrowserUtils.wait(3);

        extentLogger.info("Clicking on x to remove default search term");
        pages.controlAccountsPage().defaultSearchTermRemoveBtn.click();

        pages.controlAccountsPage().advancedSearchBtn.click();

        extentLogger.info("Clicking on Group By");
        BrowserUtils.waitForClickablility(pages.controlAccountsPage().groupBy, 10).click();

        extentLogger.info("Clicking on Add custom group");
        BrowserUtils.waitForClickablility(pages.controlAccountsPage().addCustomGroup, 10).click();

        extentLogger.info("Selecting a category from the dropdown box and clicking Apply");

        pages.controlAccountsPage().getCustomGroup().selectByVisibleText("Date");
        pages.controlAccountsPage().applyBtn.click();

        extentLogger.info("Verifying default search term changed to the newly selected category");
        BrowserUtils.isElementsTextAMatch(pages.controlAccountsPage().defaultSearchTerm, "Date", 10);

        extentLogger.pass("Filter results by categories test passed.");
    }


    @Test(description = "Verify that manager can add custom filter")
    public void addCustomFilter() {
        extentLogger= report.createTest("Add custom filter test");

        extentLogger.info("Clicking on 'Lunch' tab");
        pages.main().lunchButton.click();
        pages.lunchPage().closePopup();

        extentLogger.info("Clicking on 'Control Accounts'");
        BrowserUtils.waitForClickablility(pages.controlAccountsPage().controlAccountsButton, 10).click();

        extentLogger.info("Clicking on x to remove default search term");
        BrowserUtils.waitForClickablility(pages.controlAccountsPage().defaultSearchTermRemoveBtn, 10).click();

        pages.controlAccountsPage().advancedSearchBtn.click();

        extentLogger.info("Clicking on Filters tab");
        pages.controlAccountsPage().filters.click();

        extentLogger.info("Clicking on Add Custom Filter");
        pages.controlAccountsPage().addCustomFilter.click();

        extentLogger.info("Selecting filter category");
        pages.controlAccountsPage().getcustomFilterCategory().selectByVisibleText("Order");

        extentLogger.info("Selecting filter condition");
        pages.controlAccountsPage().getcustomFilterCondition().selectByVisibleText("contains");

        extentLogger.info("Writing filter value");
        pages.controlAccountsPage().customFilterValue.sendKeys("Pizza");

        extentLogger.info("Clicking on Apply button");
        pages.controlAccountsPage().filterApplyBtn.click();

        extentLogger.info("Verifying default search term changed to the newly selected filter");
        assertTrue(pages.controlAccountsPage().defaultSearchTerm.getText().contains("Order contains \"Pizza\""));

        extentLogger= report.createTest("Add custom filter test passed");
    }

}
