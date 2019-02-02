package com.odoo.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.odoo.utilities.Driver;

public class LunchPage {

  public LunchPage(){
        PageFactory.initElements(Driver.getDriver(), this );
    }

    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary']")
    public WebElement error;

    public void closePopup(){
        try{error.click();}catch (NoSuchElementException e){
        }
    }