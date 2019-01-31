package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    public ProductsPage(){
        PageFactory.initElements(Driver.getDriver(), this );
    }

}
