package com.odoo.tests.smokeTest;

import com.odoo.utilities.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends TestBase {


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

        pages.login().loginBttn.click();
    }

    @Test
    public void verifyTitles() throws InterruptedException {
        extentLogger= report.createTest("Verify Functionality's Titles.");

        extentLogger.info("Login with valid credentials.");
        pages.login().goLunch();

        extentLogger.info("Go to functionality verify the title.  ");

        for (int i = 1; i < pages.lunchPage().functions.size(); i++) {
            pages.lunchPage().functions.get(i).click();
            Thread.sleep(3000);
            String func = pages.lunchPage().functions.get(i).getText();
            String expectedTitle = "";
            switch (func) {
                case "New Order":
                    expectedTitle = "New";
                    break;
                case "Previous Orders":
                    expectedTitle = "Your Orders";
                    break;
                case "Your Lunch Account":
                    expectedTitle = "Your Account";
                    break;
                case "Today's Orders":
                    expectedTitle = "Orders by Vendor";
                    break;
                case "Orders by Vendor":
                    expectedTitle = "Control Vendors";
                    break;
                case "Control Accounts":
                    expectedTitle = "Control Accounts";
                    break;
                case "Employee Payments":
                    expectedTitle = "Register Cash Moves";
                    break;
                case "Products":
                    expectedTitle = "Products";
                    break;
                case "Product Categories":
                    expectedTitle = "Product Categories";
                    break;
                case "Alerts":
                    expectedTitle = "Alerts";
                    break;
            }
            Assert.assertTrue(pages.lunchPage().title.getText().equals(expectedTitle));
            extentLogger.info("\"" + func + "\"" + "  is clicked the titles is verified: " +expectedTitle );
        }
    }

}
