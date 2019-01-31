package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class ProductCategoriesPage {
    public ProductCategoriesPage(){
        PageFactory.initElements(Driver.getDriver(), this );
    }
}
