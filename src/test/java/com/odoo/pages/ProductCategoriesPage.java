package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCategoriesPage {
    public ProductCategoriesPage(){
        PageFactory.initElements(Driver.getDriver(), this );
    }

    @FindBy(xpath = "//span[contains(text(),'Product Categories')]")
    public WebElement productCategories;

    @FindBy (xpath = "//button[@accesskey='c']")
    public WebElement createButton;

    @FindBy (xpath = "//input[@class='o_field_char o_field_widget o_input o_required_modifier']")
    public WebElement textBox;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[2]/button[1]")
    public WebElement saveButton;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/table/tbody/tr[28]/td[2]")
    public WebElement exoticFoods;





}
