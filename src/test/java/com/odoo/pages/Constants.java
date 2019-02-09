package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Constants {
    public Constants() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='btn-group o_dropdown'])[3]")
    public WebElement filter;

    @FindBy(xpath = "(//ul[@class='dropdown-menu o_filters_menu'])/li")
    public List<WebElement> filters;


    @FindBy(xpath = "//span[@title='Advanced Search...']")
    public WebElement magnet;


    public void getToFilter(String functionality) {
        try {
            for (int i = 0; i < filters.size(); i++) {
                if (filters.get(i).getText().equalsIgnoreCase(functionality)) {
                    filters.get(i).click();
                    return;
                }
            }
            throw new Exception("Functionality does not exist.. Check spelling! ");
        } catch (Exception e) {
            System.err.println("Incorrect entry");
        }
    }


}
