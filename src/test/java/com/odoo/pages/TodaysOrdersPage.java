package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class TodaysOrdersPage {
    public TodaysOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this );
    }
}
