package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class PreviousOrdersPage {
    public PreviousOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this );
    }
}
