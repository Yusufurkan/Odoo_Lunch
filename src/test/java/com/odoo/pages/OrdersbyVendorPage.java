package com.odoo.pages;

import com.odoo.utilities.BrowserUtils;
import com.odoo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = "(//i[@class='fa fa-plus'])[2]")
    public WebElement plusSignOnKanbanView;

    @FindBy(xpath = "//input[@class='o_input']")
    public  WebElement inputDolma;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary o_kanban_add']")
    public WebElement addDolma;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default o_form_button_cancel']")
    public WebElement discardDolma;

    @FindBy(xpath = "(//i[@class='fa fa-gear'])[2]")
    public WebElement settingButtonOnKanbanView;

    @FindBy(xpath = "(//a[@class='o_kanban_toggle_fold'])[2]")
    public WebElement foldButtonOnKanbanView;

    @FindBy(xpath = "//span[@class='o_searchview_more fa fa-search-plus']")
    public WebElement advancedSearchButton;

    @FindBy(xpath = "(//button[@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle'])[4]")
    public WebElement groupByButton;

    @FindBy(xpath = "//div[@class='o_facet_values']")
    public WebElement selectedBgroupByOnTop;

    @FindBy(xpath = "selected")
    public List<WebElement> selectedGroupBy;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement searchFieldOnTheTop;

    @FindBy (xpath = "//tr[@class='o_group_header o_group_has_content']/th")
    public WebElement vendorsNameafterAdana;

    @FindBy(xpath = "//tr[@class='o_group_header o_group_has_content']")
    public WebElement monthAfterVendorName;

    @FindBy(xpath = "(//div[@class='oe_kanban_global_click o_kanban_record ui-sortable-handle'])[2]")
    public WebElement foodSource;

    @FindBy(xpath = "(//div[@class='oe_kanban_global_click o_kanban_record ui-sortable-handle'])[3]")
    public WebElement foodTarget;


    public void dragDrop(WebElement source, WebElement target){
        Actions action = new Actions(Driver.getDriver());
        action.dragAndDrop(source, target).build().perform();
    }










    public boolean compare(List<WebElement> lwe, WebElement ele) {
        boolean res = false;
        for (int i=0; i<lwe.size(); i++){
            res =selectedBgroupByOnTop.getText().contains(lwe.get(i).getText());
        }
        return res;
    }








}
