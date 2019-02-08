package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(css = ".o_facet_values>span")
    public WebElement defaultSearchTerm;

    @FindBy(css = ".o_facet_remove")
    public WebElement defaultSearchTermRemoveBtn;

    @FindBy(css = ".o_searchview_more")
    public WebElement advancedSearchBtn;

    @FindBy(xpath = "(//button[@data-toggle='dropdown'])[4]")
    public WebElement groupBy;

    @FindBy(css = ".o_add_custom_group>a")
    public WebElement addCustomGroup;

    @FindBy(css = ".o_input")
    public WebElement customGroupDropDown;
    public Select getCustomGroup() {
            return new Select(customGroupDropDown);
    }

    @FindBy(css = ".o_select_group")
    public WebElement applyBtn;

    @FindBy(xpath = "(//button[@data-toggle='dropdown'])[3]")
    public WebElement filters;

    @FindBy(css = ".o_add_filter")
    public WebElement addCustomFilter;

    @FindBy(css = ".o_searchview_extended_prop_field")
    public WebElement customFilterCategory;
    public Select getcustomFilterCategory() {
        return new Select(customFilterCategory);
    }

    @FindBy(css = ".o_searchview_extended_prop_op")
    public WebElement customFilterCondition;
    public Select getcustomFilterCondition() {
        return new Select(customFilterCondition);
    }

    @FindBy(css = ".o_searchview_extended_prop_value>input")
    public WebElement customFilterValue;

    @FindBy(css = ".o_apply_filter")
    public WebElement filterApplyBtn;

    @FindBy(css = ".o_cp_switch_buttons>button:nth-child(2)")
    public WebElement kanbanView;

}
