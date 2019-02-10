package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedHashSet;
import java.util.List;


public class EmployeePaymentsPage {

    public EmployeePaymentsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[contains(text(),'Product Categories')]")
    public WebElement EmployeePayments;

    @FindBy(xpath = "(//li[@class='active'])[3]")
    public WebElement RegisterCashMoves;

    @FindBy(xpath = "//thead//th[2]")
    public WebElement date;

    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> dateList;

    @FindBy(xpath = "//thead//th[3]")
    public WebElement user;

    @FindBy(xpath = "//tbody//td[3]")
    public List<WebElement> userList;

    @FindBy(xpath = "//thead//th[4]")
    public WebElement description;

    @FindBy(xpath = "//tbody//td[4]")
    public List<WebElement> descriptionList;

    @FindBy(xpath = "//thead//th[5]")
    public WebElement amount;

    @FindBy(xpath = "//tbody//td[5]")
    public List<WebElement> amountList;

    @FindBy(xpath = "//span[contains(@class,'o_searchview_more fa fa-search')]")
    public WebElement advancedSearchButton;

    @FindBy(xpath = "//span[@class='fa fa-bars']/..")
    public WebElement groupBy;

    @FindBy(xpath = "//a[contains(text(),'By User')]")
    public WebElement byUser;

    @FindBy(xpath = "//th[@class='o_group_name']")
    public List<WebElement> userGroupList;

    @FindBy(xpath = "//td[@class='o_list_number']")
    public List<WebElement> transactionAmountGroupList;

    @FindBy(xpath = "(//td[@class='o_data_cell'])[1]")
    public WebElement firstTransaction;

    @FindBy(xpath = "//button[contains(text(),'Action')]")
    public WebElement actionButton;

    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    public WebElement deleteOption;

    @FindBy(xpath = "//div[contains(text(),'Are you sure')]")
    public WebElement confirmationMessage;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary']")
    public WebElement oKDeleteButton;

    @FindBy(xpath = "//li[contains(text(),'Lunch Cash')]")
    public WebElement lunchCashMove;

    @FindBy(xpath = "(//input[@type='checkbox'])[4]")
    public WebElement firstCheckBox;

    @FindBy(xpath = "(//input[@type='checkbox'])[5]")
    public WebElement secondCheckBox;

    @FindBy(xpath = "//button[contains(text(),'Action')]")
    public WebElement hiddenActionButton;

    @FindBy(xpath = "//a[contains(text(),'Export')]")
    public WebElement exportOption;

    @FindBy(xpath = "//h4[@class='modal-title']")
    public WebElement exportWindowTitle;



    public int[] parseDate(String date) {

        String[] temp = date.split("/");
        int[] dateArray = new int[temp.length];

        for (int i = 0; i < dateArray.length; i++) {
            dateArray[i] = Integer.parseInt(temp[i]);
        }

        return dateArray;
    }
}
