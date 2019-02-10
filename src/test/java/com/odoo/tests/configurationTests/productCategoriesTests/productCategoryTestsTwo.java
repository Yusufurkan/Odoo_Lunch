package com.odoo.tests.configurationTests.productCategoriesTests;

import com.odoo.utilities.BrowserUtils;
import com.odoo.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class productCategoryTestsTwo extends TestBase {

    @Test
    public void exportUsingExcelFile(){

        extentLogger = report.createTest("Export Using Excel File");

        extentLogger.info("Sign in with valid credentials.");
        pages.login().goLunch();

        extentLogger.info("Lunch  Button is displayed");
        Assert.assertTrue(pages.main().lucnhButton.isDisplayed());

        extentLogger.info("Click on Product Categories");
        pages.productCategoriesPage().productCategories.click();

        extentLogger.info("Product Categories is displayed");
        Assert.assertTrue(pages.productCategoriesPage().productCategories.isDisplayed());

        BrowserUtils.wait(3);

        extentLogger.info("click fruit checkbox");
        pages.productCategoriesPage().fruitCheckbox.click();

        extentLogger.info("Click Action Dropdown");
        pages.productCategoriesPage().actionDropdown.click();

        extentLogger.info("Click Export");
        pages.productCategoriesPage().exportButton.click();

        extentLogger.info("Verify Import Compatible Export Formats and CSV are selected by default");
        Assert.assertTrue(pages.productCategoriesPage().importCompatibleImport.isDisplayed());
        Assert.assertTrue(pages.productCategoriesPage().csvFileOption.isDisplayed());

        extentLogger.info("Click Export All Data and Excel Buttons");
        pages.productCategoriesPage().exportAllData.click();
        pages.productCategoriesPage().excelButton.click();

        extentLogger.info("Click Export To File");
        pages.productCategoriesPage().exportToFileButton.click();

    }

    @Test
    public void exportUsingCsvFile(){
        extentLogger = report.createTest("Export Using CSV File");

        extentLogger.info("Sign in with valid credentials.");
        pages.login().goLunch();

        extentLogger.info("Lunch  Button is displayed");
        Assert.assertTrue(pages.main().lucnhButton.isDisplayed());

        extentLogger.info("Click on Product Categories");
        pages.productCategoriesPage().productCategories.click();

        extentLogger.info("Product Categories is displayed");
        Assert.assertTrue(pages.productCategoriesPage().productCategories.isDisplayed());

        BrowserUtils.wait(3);

        extentLogger.info("click fruit checkbox");
        pages.productCategoriesPage().fruitCheckbox.click();

        extentLogger.info("Click Action Dropdown");
        pages.productCategoriesPage().actionDropdown.click();

        extentLogger.info("Click Export");
        pages.productCategoriesPage().exportButton.click();

        extentLogger.info("Verify Import Compatible Export Formats and CSV are selected by default");
        Assert.assertTrue(pages.productCategoriesPage().importCompatibleImport.isDisplayed());
        Assert.assertTrue(pages.productCategoriesPage().csvFileOption.isDisplayed());

        extentLogger.info("Click Export All Data");
        pages.productCategoriesPage().exportAllData.click();

        extentLogger.info("Click Export To File");
        pages.productCategoriesPage().exportToFileButton.click();


    }

    @Test
    public void deleteProductCategoryReferenced(){

        extentLogger = report.createTest("Delete Product Category While Being Referenced By Another Record");

        extentLogger.info("Sign in with valid credentials.");
        pages.login().goLunch();

        extentLogger.info("Lunch  Button is displayed");
        Assert.assertTrue(pages.main().lucnhButton.isDisplayed());

        extentLogger.info("Click on Product Categories");
        pages.productCategoriesPage().productCategories.click();

        extentLogger.info("Product Categories is displayed");
        Assert.assertTrue(pages.productCategoriesPage().productCategories.isDisplayed());

        BrowserUtils.wait(3);

        extentLogger.info("mediterranean Cuisine");
        pages.productCategoriesPage().mediterraneanCuisine.click();

        extentLogger.info("Click Action Dropdown");
        pages.productCategoriesPage().actionDropdown.click();

        extentLogger.info("Click Delete");
        pages.productCategoriesPage().deleteFromActionDropdown.click();

        extentLogger.info("Click ok");
        pages.productCategoriesPage().okDeleteButton.click();

        extentLogger.info("Verify Error Message");
        Assert.assertTrue(pages.productCategoriesPage().odooServerErrorMessage.isDisplayed());

    }

    @Test
    public void deleteProductCategory(){

        extentLogger = report.createTest("Delete Product Category");

        extentLogger.info("Sign in with valid credentials.");
        pages.login().goLunch();

        extentLogger.info("Lunch  Button is displayed");
        Assert.assertTrue(pages.main().lucnhButton.isDisplayed());

        extentLogger.info("Click on Product Categories");
        pages.productCategoriesPage().productCategories.click();

        extentLogger.info("Product Categories is displayed");
        Assert.assertTrue(pages.productCategoriesPage().productCategories.isDisplayed());

        BrowserUtils.wait(3);

        extentLogger.info("Click Fruit Checkbox");
        pages.productCategoriesPage().fruitCheckbox.click();

        extentLogger.info("Click Action Dropdown");
        pages.productCategoriesPage().actionDropdown.click();

        extentLogger.info("Click Delete");
        pages.productCategoriesPage().deleteFromActionDropdown.click();

        extentLogger.info("Click ok");
        pages.productCategoriesPage().okDeleteButton.click();

    }

    @Test
    public void createDuplicate(){


        extentLogger = report.createTest("Create Duplicate Product Category");

        extentLogger.info("Sign in with valid credentials.");
        pages.login().goLunch();

        extentLogger.info("Lunch  Button is displayed");
        Assert.assertTrue(pages.main().lucnhButton.isDisplayed());

        extentLogger.info("Click on Product Categories");
        pages.productCategoriesPage().productCategories.click();

        extentLogger.info("Product Categories is displayed");
        Assert.assertTrue(pages.productCategoriesPage().productCategories.isDisplayed());

        BrowserUtils.wait(3);

        extentLogger.info("Mediterranean Cuisine");
        pages.productCategoriesPage().MediterraneanCuisineText.click();

        extentLogger.info("Click Action Dropdown");
        pages.productCategoriesPage().actionDropdown.click();

        extentLogger.info("Click Duplicate");
        pages.productCategoriesPage().duplicateButton.click();

        extentLogger.info("Click Save");
        pages.productCategoriesPage().saveAfterDuplicate.click();

    }

}
