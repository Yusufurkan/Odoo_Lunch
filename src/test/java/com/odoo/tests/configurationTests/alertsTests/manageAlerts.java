package com.odoo.tests.configurationTests.alertsTests;

import com.odoo.pages.AlertsPage;
import com.odoo.utilities.BrowserUtils;
import com.odoo.utilities.Driver;
import com.odoo.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class manageAlerts extends TestBase {


    @Test
    public void deleteAlert() throws Exception {
        pages.login().goLunch();
        System.out.println("Before click " +driver.findElement(By.xpath("(//li[@class='active'])[3]")).getText());
        pages.lunchPage().goToFunctionality("alerts");
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(5);
        System.out.println("After click " +driver.findElement(By.xpath("(//li[@class='active'])[3]")).getText());


//        pages.login().goLunch();
//        pages.alertsPage().alertBttn.click();
//        create();
//        pages.lunchPage().goToFunctionality("Alerts");
//
//       Driver.nap(1500);
//
//        AlertsPage ap = new AlertsPage();
//        ap.alerts.get(ap.alerts.size() - 1).click();
//
//        pages.alertsPage().action.click();
//        pages.alertsPage().actions.get(3).click();
//        pages.alertsPage().confirmationPopupOk.click();
    }


    public void create() {
        //pages.login().goLunch();
        pages.alertsPage().create.click();
        pages.createAlertPage().selectRecurrence("Specific Day");
        pages.createAlertPage().day.clear();
        //TODO make the selected day and time dynamic (random)
        pages.createAlertPage().day.sendKeys(pages.createAlertPage().date(10));
        pages.createAlertPage().between.clear();
        pages.createAlertPage().between.sendKeys("01.01");
        pages.createAlertPage().and.clear();
        pages.createAlertPage().and.sendKeys("21.21");


        pages.createAlertPage().message.sendKeys("This the new Alert.");
        pages.createAlertPage().save.click();


    }
}
