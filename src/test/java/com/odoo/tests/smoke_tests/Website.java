package com.odoo.tests.smoke_tests;

import com.odoo.utilities.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Website extends TestBase {


    @Test
    public void test() {
        extentLogger = report.createTest("Login Test.");
        extentLogger.info("Sign in");
        pages.login().signIn();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        extentLogger.info("Click on 'Lunch'. ");
        wait.until(ExpectedConditions.elementToBeClickable(pages.main().lucnhButtn)).click();
        extentLogger.info("Close pop-up");
        pages.lunchPage().closePopup();
       // fail();
        extentLogger.pass("Login Test Passed...");

    }
}
