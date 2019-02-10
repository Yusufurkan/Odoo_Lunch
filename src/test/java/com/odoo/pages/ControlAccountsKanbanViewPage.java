package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ControlAccountsKanbanViewPage {

    public ControlAccountsKanbanViewPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".o-kanban-button-new")
    public WebElement createBtn;

    @FindBy(css = ".oe_kanban_global_click")
    public List<WebElement> transactions;

    @FindBy(xpath = "(//div[@class='btn-group o_dropdown'])[3]")
    public WebElement actionButton;

    @FindBy(xpath = "//div[@class='btn-group o_dropdown open']/ul/li[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "//span[.='Ok']")
    public WebElement okButton;

    @FindBy(css = ".breadcrumb>li:nth-child(2)")
    public WebElement cashMoveId;

    @FindBy(css = ".o_form_buttons_view>button:nth-child(1)")
    public WebElement editButton;







}
