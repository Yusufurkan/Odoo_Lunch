package com.odoo.pages;

import com.odoo.utilities.BrowserUtils;
import com.odoo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class OrdersbyVendorPage {
    public OrdersbyVendorPage(){
        PageFactory.initElements(Driver.getDriver(), this );
    }


    @FindBy(xpath = "(//a[@class='oe_menu_leaf'])[82]")
    public WebElement ordersByVendorBtn;

    @FindBy(xpath = "//table[@class='o_list_view table table-condensed table-striped o_list_view_grouped']/tbody")
    public WebElement allVendorsNames;

    @FindBy(xpath = "//table[@class='o_list_view table table-condensed table-striped o_list_view_grouped']/tbody/tr/th")
    public WebElement vendorsName;

    @FindBy(xpath = "(//table[@class='o_list_view table table-condensed table-striped o_list_view_grouped']/tbody/tr/th)[2]")
    public WebElement month;

    @FindBy(xpath = "//div[@class='btn-group btn-group-sm o_cp_switch_buttons']/button[2]")
    public WebElement kanbanView;






}
