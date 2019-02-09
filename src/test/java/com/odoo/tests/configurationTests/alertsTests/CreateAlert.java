package com.odoo.tests.configurationTests.alertsTests;

import com.odoo.utilities.Driver;
import com.odoo.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAlert extends TestBase {

    @Test
    public void createAlertSpecificDay() {

        extentLogger = report.createTest("Create Alert Specific Day");

        extentLogger.info("Login with as a manager.");
        extentLogger.info("Go to Lunch module.");
        pages.login().goLunch();

        extentLogger.info("Go to Alerts.");
        pages.lunchPage().goToFunctionality("alerts");
        Driver.nap(1000);

        extentLogger.info("Get the alerts size before creating Alert.");
        int alertSizeBeforeCreate = pages.alertsPage().alertsInput.size();

        extentLogger.info("Create alert with specific day.");
        pages.createAlertPage().createAlert();

        extentLogger.info("Go to Alerts.");
        pages.lunchPage().goToFunctionality("alerts");
        Driver.nap(1000);

        extentLogger.info("Get the size of the alerts after creation.");
        int alertSizeAfterCreate = pages.alertsPage().alertsInput.size();

        extentLogger.info("Verify the size after creating alert increased by one.");
        Assert.assertTrue(alertSizeBeforeCreate + 1 == alertSizeAfterCreate);

        extentLogger.pass("Create Alert Specific Day Passed");
    }

    @Test
    public void cantCreateWithoutTheMessage() {
        extentLogger = report.createTest("Can't Create Alert Without The Message");

        extentLogger.info("Login with as a manager.");
        extentLogger.info("Go to Lunch module.");
        pages.login().goLunch();

        extentLogger.info("Go to Alerts.");
        pages.lunchPage().goToFunctionality("alerts");
        pages.alertsPage().create.click();

        extentLogger.info("Create alert without message.");
        pages.createAlertPage().selectRecurrence("Specific Day");
        pages.createAlertPage().day.clear();
        pages.createAlertPage().day.sendKeys(pages.createAlertPage().date(10));
        pages.createAlertPage().between.clear();
        pages.createAlertPage().between.sendKeys("01.01");
        pages.createAlertPage().and.clear();
        pages.createAlertPage().and.sendKeys("21.21");
        pages.createAlertPage().save.click();

        extentLogger.info("Verify error message pops up.");
        Assert.assertTrue(pages.createAlertPage().errorMessage.isDisplayed());

        extentLogger.pass("Can't Create Alert Without The Message Test Passed");

    }

    @Test
    public void canDiscardCreatingAlert() {
        extentLogger = report.createTest("Can Discard Creating Alert");

        extentLogger.info("Login with as a manager.");
        extentLogger.info("Go to Lunch module.");
        pages.login().goLunch();

        extentLogger.info("Go to Alerts.");
        pages.lunchPage().goToFunctionality("alerts");

        extentLogger.info("Create alert enter all required fields.");
        pages.alertsPage().create.click();
        pages.createAlertPage().selectRecurrence("Specific Day");
        pages.createAlertPage().day.clear();
        pages.createAlertPage().day.sendKeys(pages.createAlertPage().date(10));
        pages.createAlertPage().between.clear();
        pages.createAlertPage().between.sendKeys("01.01");
        pages.createAlertPage().and.clear();
        pages.createAlertPage().and.sendKeys("21.21");
        pages.createAlertPage().message.sendKeys("This the new Alert.");

        extentLogger.info("Click Discard button.");
        pages.createAlertPage().discard.click();

        extentLogger.info("Click on Ok on the pop up.");
        pages.createAlertPage().warningOk.click();

        extentLogger.info("Verify the title is Alerts");
        Assert.assertEquals(pages.lunchPage().title.getText(), "Alerts");

        extentLogger.info("Can Discard Creating Alert Test Passed");
    }

    @Test
    public void createAlertEveryDay() {
        extentLogger = report.createTest("Create Alert Every Day");

        extentLogger.info("Login with as a manager.");
        extentLogger.info("Go to Lunch module.");
        pages.login().goLunch();

        extentLogger.info("Go to Alerts.");
        pages.lunchPage().goToFunctionality("alerts");
        int alertsizeBeforeCreate = pages.alertsPage().alertsInput.size();
        Driver.nap(1000);

        extentLogger.info("Create alert with every day.");
        pages.alertsPage().create.click();
        pages.createAlertPage().selectRecurrence("Every Day");
        pages.createAlertPage().between.clear();
        pages.createAlertPage().between.sendKeys("01.01");
        pages.createAlertPage().and.clear();
        pages.createAlertPage().and.sendKeys("21.21");
        pages.createAlertPage().message.sendKeys("This the new Alert Specific Day.");
        pages.createAlertPage().save.click();
        pages.lunchPage().goToFunctionality("alerts");
        Driver.nap(1000);

        Assert.assertTrue(alertsizeBeforeCreate + 1 == pages.alertsPage().alertsInput.size());

    }

    @Test
    public void createAlertEveryWeek() {
        extentLogger = report.createTest("Create Alert Every Week");
        extentLogger.info("Login with as a manager.");
        extentLogger.info("Go to Lunch module.");

        pages.login().goLunch();
        pages.lunchPage().goToFunctionality("alerts");
        int alertsizeBeforeCreate = pages.alertsPage().alertsInput.size();

        extentLogger.info("Create alert with every week.");
        pages.alertsPage().create.click();
        pages.createAlertPage().selectRecurrence("Every Week");
        pages.createAlertPage().between.clear();
        pages.createAlertPage().between.sendKeys("01.01");
        pages.createAlertPage().and.clear();
        pages.createAlertPage().and.sendKeys("21.21");
        pages.createAlertPage().message.sendKeys("This the new Alert Every Week.");
        pages.createAlertPage().save.click();
        pages.lunchPage().goToFunctionality("alerts");
        Driver.nap(1000);

        Assert.assertTrue(alertsizeBeforeCreate + 1 == pages.alertsPage().alertsInput.size());

    }

}
