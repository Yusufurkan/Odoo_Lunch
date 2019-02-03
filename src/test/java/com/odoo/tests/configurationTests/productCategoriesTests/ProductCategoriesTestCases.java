package com.odoo.tests.configurationTests.productCategoriesTests;

import com.odoo.utilities.BrowserUtils;
import com.odoo.utilities.TestBase;
import net.bytebuddy.implementation.bytecode.Throw;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductCategoriesTestCases extends TestBase {

    @Test
    public void saveNewProductCategory() {
        extentLogger = report.createTest("Save New Product Category");

        extentLogger.info("Sign in with valid credentials.");
        pages.login().goLunch();

        extentLogger.info("Lunch  Button is displayed");
        Assert.assertTrue(pages.main().lucnhButton.isDisplayed());

        extentLogger.info("Click on Product Categories");
        pages.productCategoriesPage().productCategories.click();

        extentLogger.info("Product Categories is displayed");
        Assert.assertTrue(pages.productCategoriesPage().productCategories.isDisplayed());

        BrowserUtils.wait(3);

        extentLogger.info("Click Create");
        pages.productCategoriesPage().createButton.click();

        extentLogger.info("Type Exotic Foods");
        pages.productCategoriesPage().textBox.sendKeys("Exotic Foods");

        extentLogger.info("Click Save");
        pages.productCategoriesPage().saveButton.click();

        extentLogger.info("Click Product  Categories");
        pages.productCategoriesPage().productCategories.click();

        extentLogger.info("Exotic  Foods  is displayed");
        Assert.assertTrue(pages.productCategoriesPage().exoticFoods.isDisplayed());

        extentLogger.pass("Save New Product Category Passed");

    }
}
