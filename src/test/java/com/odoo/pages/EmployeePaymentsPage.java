package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmployeePaymentsPage {

    public EmployeePaymentsPage(){
        PageFactory.initElements(Driver.getDriver(), this );
    }

    @FindBy (xpath = "//*[contains(text(),'Product Categories')]")
    public WebElement EmployeePayments;

    @FindBy (xpath = "//tbody//td[5]")
    public List<WebElement> transactionAmount;



}
