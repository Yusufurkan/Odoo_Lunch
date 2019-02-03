package com.odoo.tests.managerTests.ordersbyVendorsTests;

import com.odoo.utilities.BrowserUtils;
import com.odoo.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewAllOrders extends TestBase {

    @Test
    public void canSeeOrdersByVendor() throws Exception {
        extentLogger = report.createTest("Can See Order By Vendor Test");
        extentLogger.info("Sign In");
        pages.login().goLunch();
        extentLogger.info("Click Order By Vendor button");
        BrowserUtils.waitForClickablility(pages.ordersbyVendorPage().ordersByVendorBtn, 5);
        pages.lunchPage().goToFunctionality("Orders by Vendor");
        extentLogger.info("Vendor's name is displayed");
        Assert.assertTrue(pages.ordersbyVendorPage().allVendorsNames.isDisplayed());
        extentLogger.pass("Can See Order By Vendor Test PASSED");
    }

    @Test
    public void ordersByMonthIsDisplayed() throws Exception {
        extentLogger = report.createTest("Orders By Month Is Displayed Test");
        extentLogger.info("Sign In");
        pages.login().goLunch();
        extentLogger.info("Click Order By Vendor button");
        BrowserUtils.waitForClickablility(pages.ordersbyVendorPage().ordersByVendorBtn, 10);
        pages.lunchPage().goToFunctionality("Orders by Vendor");
        extentLogger.info("Click Vendor's name");
        pages.ordersbyVendorPage().vendorsName.click();
        extentLogger.info("Verify vendor's name is visible");
        BrowserUtils.waitForVisibility(pages.ordersbyVendorPage().month, 5);
        Assert.assertTrue(pages.ordersbyVendorPage().month.isDisplayed());
        extentLogger.pass("Orders By Month Is Displayed Test PASSED");
    }


//    @Test
//    public void addOrderKanbanView() throws Exception {
//        pages.login().goLunch();
//        BrowserUtils.waitForClickablility(pages.ordersbyVendorPage().ordersByVendorBtn, 5);
//        pages.lunchPage().goToFunctionality("Orders by Vendor");
//
//
//    }







}
