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

    @Test
    public void verifyErrorMessage(){
        extentLogger = report.createTest("Verify Error Message");

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

        extentLogger.info("Click Save");
        pages.productCategoriesPage().saveButton.click();

        extentLogger.info("Error message: 'THE FOLLOWING FIELDS \n" +
                "ARE INVALID, CATEGORY' is displayed");
        Assert.assertTrue(pages.productCategoriesPage().errorMessage.isDisplayed());


    }

    @Test
    public void discardNewProductCategory(){

        extentLogger = report.createTest("Discard New Product Category");

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

        extentLogger.info("Click Discard");
        pages.productCategoriesPage().discardButton.click();

        extentLogger.info("Warning Message is Displayed");
        Assert.assertTrue(pages.productCategoriesPage().warningMessage.isDisplayed());

        extentLogger.info("Click ok");
        pages.productCategoriesPage().warningOkButton.click();

    }

    @Test
    public void attachJpgFile(){

        extentLogger = report.createTest("Attach Jpg File to Product Category");

        extentLogger.info("Sign in with valid credentials.");
        pages.login().goLunch();

        extentLogger.info("Lunch  Button is displayed");
        Assert.assertTrue(pages.main().lucnhButton.isDisplayed());

        extentLogger.info("Click on Product Categories");
        pages.productCategoriesPage().productCategories.click();

        extentLogger.info("Product Categories is displayed");
        Assert.assertTrue(pages.productCategoriesPage().productCategories.isDisplayed());

        extentLogger.info("Click on Exotic Foods");
        pages.productCategoriesPage().exoticFoods.click();

        extentLogger.info("Click Attachment Dropdown");
        pages.productCategoriesPage().attachmentDropDown.click();

        extentLogger.info("Select Add");
        pages.productCategoriesPage().getAddAttachment.sendKeys("/Users/Desktop/food.jpeg");

        BrowserUtils.wait(5);
    }

    @Test
    public void deleteJpegFile(){

        extentLogger = report.createTest("Attach Jpg File to Product Category");

        extentLogger.info("Sign in with valid credentials.");
        pages.login().goLunch();

        extentLogger.info("Lunch  Button is displayed");
        Assert.assertTrue(pages.main().lucnhButton.isDisplayed());

        extentLogger.info("Click on Product Categories");
        pages.productCategoriesPage().productCategories.click();

        extentLogger.info("Click on Exotic Foods");
        pages.productCategoriesPage().exoticFoods.click();

        extentLogger.info("Click Attachment Dropdown");
        pages.productCategoriesPage().attachmentDropDown.click();

        extentLogger.info("Verify Attachment is displayed");
        Assert.assertTrue(pages.productCategoriesPage().attachment.isDisplayed());

        extentLogger.info("Delete Attachment");
        pages.productCategoriesPage().delete.click();

        extentLogger.info("Click Ok");
        pages.productCategoriesPage().okDeleteButton.click();


    }
}
