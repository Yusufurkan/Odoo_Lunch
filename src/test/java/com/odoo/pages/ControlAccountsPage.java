package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class ControlAccountsPage {

    public ControlAccountsPage(){
        PageFactory.initElements(Driver.getDriver(), this );
    }

    @FindBy(css = ".o_list_buttons>button:nth-child(1)")
    public WebElement createButton;

    @FindBy(css = ".o_list_buttons>button:nth-child(2)")
    public WebElement importButton;

    @FindBy(css = ".o_searchview_input")
    public WebElement searchBox;

    @FindBy(css = ".breadcrumb>li")
    public WebElement pageHeaderText;

    @FindBy(css = ".o_group_name")
    public List<WebElement> accountNames;

    @FindBy(css = "tr.o_data_row>td.o_list_number")
    public List<WebElement> employeeAccountAmounts;

    @FindBy(css = ".o_group_header>td.o_list_number")
    public List<WebElement> allAmounts;

    @FindBy(css = "tfoot>tr>td.o_list_number")
    public WebElement totalAmount;

    @FindBy(css = "table>thead>tr>th:nth-child(2)")
    public WebElement selectorCheckBox;

    @FindBy(css = "table>thead>tr>th:nth-child(3)")
    public WebElement dateHeader;

    @FindBy(css = "table>thead>tr>th:nth-child(4)")
    public WebElement userHeader;

    @FindBy(css = "table>thead>tr>th:nth-child(5)")
    public WebElement descriptionHeader;

    @FindBy(css = "table>thead>tr>th:nth-child(6)")
    public WebElement amountHeader;

    @FindBy(xpath = "//tr[@class='o_data_row']/td[3]")
    public List<WebElement> transactionDates;

    @FindBy(xpath = "//tr[@class='o_data_row']/td[5]")
    public List<WebElement> transactionDescription;

    @FindBy(xpath = "//tr[@class='o_data_row']/td[6]")
    public  List<WebElement>  transactionAmounts;

    @FindBy(css = "[data-menu='103'] .oe_menu_text")
    public WebElement controlAccountsButton;

}
