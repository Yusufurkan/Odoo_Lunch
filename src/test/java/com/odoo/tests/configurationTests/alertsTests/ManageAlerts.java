package com.odoo.tests.configurationTests.alertsTests;

import com.github.javafaker.Faker;
import com.odoo.utilities.Driver;
import com.odoo.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class ManageAlerts extends TestBase {


    @Test
    public void deleteAlert() {
        extentLogger = report.createTest("Delete Alert");
        extentLogger.info("Login with as a manager.");
        extentLogger.info("Go to Lunch module.");
        pages.login().goLunch();

        extentLogger.info("Go to Alerts.");
        pages.lunchPage().goToFunctionality("alerts");

        extentLogger.info("Create Alert.");
        Driver.nap(2000);
        pages.createAlertPage().createAlert();

        extentLogger.info("Go to Alerts.");
        pages.lunchPage().goToFunctionality("alerts");
        Driver.nap(1000);

        extentLogger.info("Getting the alert size before deletion.");
        int sizeBeforeDelete = pages.alertsPage().alertsInput.size();

        extentLogger.info("Delete Alert.");
        pages.createAlertPage().deleteAlert();
        Driver.nap(1000);

        extentLogger.info("Verify alerts decreased by one.");
        Assert.assertTrue(sizeBeforeDelete - 1 == pages.alertsPage().alertsInput.size());
        extentLogger.pass("Delete Alerte Test Passed.");

    }

    @Test
    public void archiveAlert() {
        extentLogger = report.createTest("Archive Alert");


        extentLogger.info("Login with as a manager.");
        extentLogger.info("Go to Lunch module.");
        pages.login().goLunch();

        extentLogger.info("Go to Alerts.");
        pages.lunchPage().goToFunctionality("alerts");
        Driver.nap(1000);
        pages.alertsPage().isAlertDisplayed();

        extentLogger.info("Click on the magnet in the search button.");
        pages.constants().magnet.click();
        pages.constants().filter.click();

        extentLogger.info("Go to archived files.");
        pages.constants().getToFilter("archived");
        Driver.nap(1000);

        extentLogger.info("Get the alert size in archive.");
        int sizeOfArchive = pages.alertsPage().alertsInput.size();

        extentLogger.info("Go to Alerts.");
        pages.lunchPage().goToFunctionality("alerts");

        extentLogger.info("Get the last alert and add to Archive");
        Driver.nap(1000);
        WebElement lastAlert = pages.alertsPage().alertsInput.get(pages.alertsPage().alertsInput.size() - 1);
        lastAlert.click();

        pages.alertsPage().action.click();
        pages.alertsPage().actions.get(1).click();

        extentLogger.info("Go to archived files.");
        pages.constants().filter.click();
        pages.constants().getToFilter("archived");
        Driver.nap(2000);

        extentLogger.info("Get the size of alerts in archive.");
        int sizeAfterArchived = pages.alertsPage().alertsInput.size();
        Driver.nap(1000);

        extentLogger.info("Verify is the alerts in the archive is one increased.");
        Assert.assertTrue(sizeOfArchive + 1 == sizeAfterArchived);

        extentLogger.pass("Archive Alert Test Passed");
    }

    @Test
    public void unArchiveAlert() {

        extentLogger = report.createTest("Unarchive Alert");
        extentLogger.info("Login with as a manager.");
        extentLogger.info("Go to Lunch module.");
        pages.login().goLunch();


        extentLogger.info("Go to Alerts.");
        pages.lunchPage().goToFunctionality("alerts");
        Driver.nap(1000);
        pages.alertsPage().isAlertDisplayed();
        extentLogger.info("Get tje alert size.");
        int alertSize = pages.alertsPage().alertsInput.size();

        extentLogger.info("Click on the magnet in the search button.");
        pages.constants().magnet.click();
        pages.constants().filter.click();

        extentLogger.info("Go to archived files.");
        pages.constants().getToFilter("archived");
        Driver.nap(1000);

        extentLogger.info("Get the last alert and add to unarchive");
        WebElement lastAlert = pages.alertsPage().alertsInput.get(pages.alertsPage().alertsInput.size() - 1);
        lastAlert.click();

        pages.alertsPage().action.click();
        pages.alertsPage().actions.get(2).click();

        extentLogger.info("Go to Alerts.");
        pages.lunchPage().goToFunctionality("alerts");

        extentLogger.info("Get the size of alerts after unarchive.");
        int aletsSizeAfterUnarchive = pages.alertsPage().alertsInput.size();
        Driver.nap(1000);

        extentLogger.info("Verify the alert size is increased by one");
        Assert.assertTrue(alertSize + 1 == aletsSizeAfterUnarchive);

        extentLogger.pass("Unarchive Alert Test Passed");
    }

    //TODO complete the edit story
    @Test
    public void editAlert() {
        extentLogger = report.createTest("Edit Alert");


        extentLogger.info("Login with as a manager.");
        extentLogger.info("Go to Lunch module.");
        pages.login().goLunch();

        extentLogger.info("Go to Alerts.");
        pages.lunchPage().goToFunctionality("alerts");
        Driver.nap(1000);

        extentLogger.info("Click on random alert.");
        pages.alertsPage().alertsMessage.get((int) (Math.random() * pages.alertsPage().alertsInput.size())).click();
        pages.alertDetailPage().edit.click();

        extentLogger.info("Enter the recurrence.");
        String recurrenceType = "Every Day";
        pages.createAlertPage().selectRecurrence(recurrenceType);
        pages.createAlertPage().between.clear();

        extentLogger.info("Enter random start time.");
        String between = "0" + (int) (Math.random() * 10) + ":" + (10+(int) (Math.random() * 61));
        pages.createAlertPage().between.sendKeys(between);

        extentLogger.info("Enter random end time.");
        pages.createAlertPage().and.clear();
        String and = "" + (12 + ((int) (Math.random() * 13))) + ":" + (10+(int) (Math.random() * 61));
        pages.createAlertPage().and.sendKeys(and);

        extentLogger.info("Enter click.");
        pages.createAlertPage().save.click();
        Driver.nap(1000);

        extentLogger.info("Verify changed time is matching for both start time and end time.");
        Assert.assertEquals(pages.alertDetailPage().between.getText(), between);
        Assert.assertEquals(pages.alertDetailPage().and.getText(), and);

        extentLogger.pass("Edit Alert Test Passed.");
    }

}
