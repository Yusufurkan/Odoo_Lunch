package com.odoo.tests.managerTests.ordersbyVendorsTests;

import com.odoo.utilities.BrowserUtils;
import com.odoo.utilities.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewAllOrders extends TestBase {

    @Test(description = "Verify that manager can see orders by vendor")
    public void canSeeOrdersByVendor() throws Exception {
        extentLogger = report.createTest("Can See Order By Vendor Test");
        extentLogger.info("Sign In");
        pages.login().goToMainPage();
        extentLogger.info("Click Order By Vendor button");
        BrowserUtils.waitForClickablility(pages.ordersbyVendorPage().ordersByVendorBtn, 5);
        pages.lunchPage().goToFunctionality("Orders by Vendor");
        extentLogger.info("Vendor's name is displayed");
        Assert.assertTrue(pages.ordersbyVendorPage().allVendorsNames.isDisplayed());
        extentLogger.pass("Can See Order By Vendor Test PASSED");
    }

    @Test(description = "Verify that only orders by month is displayed")
    public void ordersByMonthIsDisplayed() throws Exception {
        extentLogger = report.createTest("Orders By Month Is Displayed Test");
        extentLogger.info("Sign In");
        pages.login().goToMainPage();
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

    @Test(description = "Verify that only orders by month is displayed")
    public void addAnyOrderKanbanView() throws Exception {
        extentLogger = report.createTest("Verify that manager can add any order through Kanban view");
        extentLogger.info("Sign In");
        pages.login().goToMainPage();
        extentLogger.info("Click Order By Vendor button");
        BrowserUtils.waitForClickablility(pages.ordersbyVendorPage().ordersByVendorBtn, 10);
        pages.lunchPage().goToFunctionality("Orders by Vendor");
        extentLogger.info("Clicking the Kanban view button");
        pages.ordersbyVendorPage().kanbanView.click();
        extentLogger.info("Click the any plus sign");
        pages.ordersbyVendorPage().plusSignOnKanbanView.click();
        extentLogger.info("Send the food name Dolma to the Title tab");
        pages.ordersbyVendorPage().inputDolma.sendKeys("Dolma");
        extentLogger.info("Add Dolma");
        pages.ordersbyVendorPage().addDolma.click();
        extentLogger.info("Click the Discard");
        pages.ordersbyVendorPage().discardDolma.click();
    }

    @Test(description = "Verify that only orders by month is displayed")
    public void managerCanEditAndDeleteAnyOrder() throws Exception {
        extentLogger = report.createTest("Verify that manager can edit and delete any order through Kanban view");
        extentLogger.info("Sign In");
        pages.login().goToMainPage();
        extentLogger.info("Click Order By Vendor button");
        BrowserUtils.waitForClickablility(pages.ordersbyVendorPage().ordersByVendorBtn, 10);
        pages.lunchPage().goToFunctionality("Orders by Vendor");
        extentLogger.info("Clicking the Kanban view button");
        pages.ordersbyVendorPage().kanbanView.click();
        extentLogger.info("HoverOver the mouse on the plus sign of any vendor has on the top right");
        pages.ordersbyVendorPage().plusSignOnKanbanView.click();
        pages.ordersbyVendorPage().settingButtonOnKanbanView.click();
        pages.ordersbyVendorPage().foldButtonOnKanbanView.click();

    }

    @Test(description = "Verify that only orders by month is displayed")
    public void managerCanDeleteAndAddAdvancedSearch() throws Exception {
        extentLogger = report.createTest("Verify that manager can delete and add Advanced Search buttons");
        extentLogger.info("Sign In");
        pages.login().goToMainPage();
        extentLogger.info("Click Order By Vendor button");
        BrowserUtils.waitForClickablility(pages.ordersbyVendorPage().ordersByVendorBtn, 10);
        pages.lunchPage().goToFunctionality("Orders by Vendor");
        extentLogger.info("Clicking the Kanban view button");
        pages.ordersbyVendorPage().kanbanView.click();
        extentLogger.info("Click the Advanced Search button on the right side of Search field");
        pages.ordersbyVendorPage().advancedSearchButton.click();

    }

    @Test
    public void managerCanFilterResultsBySearch() throws Exception {
        extentLogger = report.createTest("Verify that manager can filter results by search");
        extentLogger.info("Sign In");
        pages.login().goToMainPage();
        extentLogger.info("Click Order By Vendor button");
        BrowserUtils.waitForClickablility(pages.ordersbyVendorPage().ordersByVendorBtn, 10);
        pages.lunchPage().goToFunctionality("Orders by Vendor");
        extentLogger.info("Click the Group By button");
        BrowserUtils.waitForClickablility(pages.ordersbyVendorPage().advancedSearchButton,5);
        pages.ordersbyVendorPage().advancedSearchButton.click();
        extentLogger.info("Click the Advanced Search button on the right side of Search field");
        pages.ordersbyVendorPage().groupByButton.click();
        extentLogger.info("Verify that marked dropdown options are same as on the search field");
        pages.ordersbyVendorPage().compare(pages.ordersbyVendorPage().selectedGroupBy, pages.ordersbyVendorPage().selectedBgroupByOnTop);

    }

    @Test
    public void vendorsNameBySearchingFoodName() throws Exception {
        extentLogger = report.createTest("Verify that manager can find the Vendor's name by searching food name");
        extentLogger.info("Sign In");
        pages.login().goToMainPage();
        extentLogger.info("Click Order By Vendor button");
        BrowserUtils.waitForClickablility(pages.ordersbyVendorPage().ordersByVendorBtn, 10);
        pages.lunchPage().goToFunctionality("Orders by Vendor");
        extentLogger.info("Type the Adana on search field and hit the Enter");
        BrowserUtils.waitForVisibility(pages.ordersbyVendorPage().searchFieldOnTheTop,10);
        pages.ordersbyVendorPage().searchFieldOnTheTop.sendKeys("Adana" + Keys.ENTER);
    }


    @Test
    public void actionOnMarkedFoodThroughSearchField() throws Exception {
        extentLogger = report.createTest("Verify that manager can do Action on marked food through search field");
        extentLogger.info("Sign In");
        pages.login().goToMainPage();
        extentLogger.info("Click Order By Vendor button");
        BrowserUtils.waitForClickablility(pages.ordersbyVendorPage().ordersByVendorBtn, 10);
        pages.lunchPage().goToFunctionality("Orders by Vendor");
        extentLogger.info("Type the Adana on search field and hit the Enter");
        BrowserUtils.waitForVisibility(pages.ordersbyVendorPage().searchFieldOnTheTop,10);
        pages.ordersbyVendorPage().searchFieldOnTheTop.sendKeys("Adana" + Keys.ENTER);
        extentLogger.info("Mark the any of appeared food under vendor's name");
        BrowserUtils.waitForClickablility(pages.ordersbyVendorPage().vendorsNameafterAdana,10);
        pages.ordersbyVendorPage().vendorsNameafterAdana.click();
        //BrowserUtils.waitForClickablility(pages.ordersbyVendorPage().monthAfterVendorName,5);
        pages.ordersbyVendorPage().monthAfterVendorName.click();
    }


    @Test
    public void managerCanChangetoKanbanView() throws Exception {
        extentLogger = report.createTest("Verify that manager can change to Kanban view");
        extentLogger.info("Sign In");
        pages.login().goToMainPage();
        extentLogger.info("Click Order By Vendor button");
        BrowserUtils.waitForClickablility(pages.ordersbyVendorPage().ordersByVendorBtn, 10);
        pages.lunchPage().goToFunctionality("Orders by Vendor");
        extentLogger.info("Clicking the Kanban view button");
        pages.ordersbyVendorPage().kanbanView.click();
    }



    @Test
    public void managerCanManageVendorDetails() throws Exception {
        extentLogger = report.createTest("Verify that manager can manage vendor details in Kanban view");
        extentLogger.info("Sign In");
        pages.login().goToMainPage();
        extentLogger.info("Click Order By Vendor button");
        BrowserUtils.waitForClickablility(pages.ordersbyVendorPage().ordersByVendorBtn, 10);
        pages.lunchPage().goToFunctionality("Orders by Vendor");
        extentLogger.info("Clicking the Kanban view button");
        pages.ordersbyVendorPage().kanbanView.click();
        BrowserUtils.wait(5);
        extentLogger.info("Drag any product from Undefined column and Drop after next product");
        pages.ordersbyVendorPage().dragDrop(pages.ordersbyVendorPage().foodSource, pages.ordersbyVendorPage().foodTarget);
        extentLogger.pass("Verify that manager can manage vendor details in Kanban view - PASSED");

    }




}
