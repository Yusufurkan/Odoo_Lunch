package com.odoo.tests.configurationTests.alertsTests;

import com.odoo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CreateAlertPage {



    public CreateAlertPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//select[@name='alert_type']")
    private WebElement recur;

    @FindBy(xpath = "//select[@name='alert_type']")
    public Select recurrence;

    @FindBy(xpath = "//input[@name='specific_day']")
    public WebElement day;

    @FindBy(xpath = "//input[@name='start_hour']")
    public WebElement between;

    @FindBy(xpath = "//input[@name='end_hour']")
    public WebElement and;

    @FindBy(css = "textarea[name='message']")
    public WebElement message;

    @FindBy(xpath = "(//button[@type='button'])[8]")
    public WebElement save;

    //TODO complete crating an Alert for each recurrences
    public void selectRecurrence(String recurType) {
        Select select = new Select(recur);
        select.selectByVisibleText(recurType);
    }

    public String date(int daysLater){
        DateTimeFormatter formaterr = DateTimeFormatter.ofPattern("MM/dd/Y");
        Period pr = Period.ofDays(daysLater);
        LocalDate date = LocalDate.now();
        date = date.plus(pr);
        return "" + date.format(formaterr);
    }

}
