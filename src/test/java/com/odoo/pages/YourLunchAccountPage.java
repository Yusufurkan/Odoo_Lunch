package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class YourLunchAccountPage {

    public YourLunchAccountPage(){
        PageFactory.initElements(Driver.getDriver(), this );
    }
}
