package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class OrdersbyVendorPage {
    public OrdersbyVendorPage(){
        PageFactory.initElements(Driver.getDriver(), this );
    }
}
