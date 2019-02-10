package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ControlAccountsCreatePage {

    public ControlAccountsCreatePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".ui-autocomplete-input")
    public WebElement userField;

    @FindBy(css = ".ui-menu-item:nth-child(2)>a")
    public WebElement userSelected;

    @FindBy(css = ".o_datepicker_input")
    public WebElement dateFieldText;

    @FindBy(css = ".o_field_float")
    public WebElement amountField;

    @FindBy(css = ".o_field_text")
    public WebElement descriptionField;

    @FindBy(css = ".o_form_button_save")
    public WebElement saveBtn;

    @FindBy(name = "user_id")
    public WebElement userAfterCreate;

    @FindBy(css = ".o_field_date")
    public WebElement dateAfterCreate;

    @FindBy(css = ".o_field_number")
    public WebElement amountAfterCreate;

    @FindBy(css = ".o_field_text")
    public WebElement descriptionAfterCreate;

}
