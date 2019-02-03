package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AlertsPage {
    public AlertsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@data-menu='107']")
    public WebElement alertBttn;

    @FindBy(xpath = "//tbody//input")
    public List<WebElement> alerts;

    @FindBy(xpath = "(//button[@data-toggle='dropdown'])[2]")
    public WebElement action;

    @FindBy(xpath = "(//ul[@class='dropdown-menu'])[4]/li")
    public List<WebElement> actions;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_list_button_add']")
    public WebElement create;

    @FindBy(css = "button[class='btn btn-sm btn-primary']")
    public WebElement confirmationPopupOk;
    public int getRndmAlert() {
        return (int) (Math.random() * alerts.size());
    }

    public void selectAction(int action) {
        actions.get(action - 1).click();
    }

}
