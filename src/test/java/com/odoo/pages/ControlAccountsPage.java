package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class ControlAccountsPage {
    public ControlAccountsPage(){
        PageFactory.initElements(Driver.getDriver(), this );
    }
}
