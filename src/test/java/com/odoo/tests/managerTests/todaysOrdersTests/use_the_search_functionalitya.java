package com.odoo.tests.managerTests.todaysOrdersTests;

import com.odoo.utilities.BrowserUtils;
import com.odoo.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class use_the_search_functionalitya extends TestBase {
    @Test(description = "Verify that manager see search function")
    public void Verify_that_manager_can_filter_results_by_search() throws Exception {
        extentLogger = report.createTest("Verify_that_manager_can_filter_results_by_search");
        extentLogger.info("log in With valid credentials");
        pages.login().goToMainPage();
        extentLogger.info("Clicked Lunch Button");
        pages.main().lunchButton.click();
        extentLogger.info("Closed Pop-up");
        pages.lunchPage().closePopup();
        BrowserUtils.wait(3);
        extentLogger.info("Clicked on Today's Orders");
        pages.lunchPage().goToFunctionality("Today's Orders");
        BrowserUtils.wait(3);
        extentLogger.info("Verify Page Header is displayed and matches");
        Assert.assertEquals(pages.todaysOrdersPage().pageheader.getText(), "Orders by Vendor");
        extentLogger.info("Verify Search Button is displayed");
        Assert.assertTrue(pages.todaysOrdersPage().searchField.isDisplayed());
        extentLogger.pass("PASSED TEST!!! ==>> Verify_that_manager_can_filter_results_by_search");
    }
}
