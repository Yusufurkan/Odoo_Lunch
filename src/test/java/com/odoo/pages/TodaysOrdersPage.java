package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TodaysOrdersPage {
    public TodaysOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this );
    }
    @FindBy(xpath = "//input[@class=\"o_searchview_input\"]")
    public WebElement searchField;

    @FindBy(xpath = "(//li[@class=\"active\"])[3]")
    public WebElement pageheader;

}
