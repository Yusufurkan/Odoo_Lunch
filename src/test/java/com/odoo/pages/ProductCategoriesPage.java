package com.odoo.pages;

import com.odoo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCategoriesPage {
    public ProductCategoriesPage(){
        PageFactory.initElements(Driver.getDriver(), this );
    }

    @FindBy(xpath = "//span[contains(text(),'Product Categories')]")
    public WebElement productCategories;

    @FindBy (xpath = "//button[@accesskey='c']")
    public WebElement createButton;

    @FindBy (xpath = "//input[@class='o_field_char o_field_widget o_input o_required_modifier']")
    public WebElement textBox;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[2]/button[1]")
    public WebElement saveButton;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/table/tbody/tr[28]/td[2]")
    public WebElement exoticFoods;

    @FindBy (xpath = "//div[@class='o_notification_manager']")
    public WebElement errorMessage;

    @FindBy (xpath = "//button[@accesskey='j']")
    public WebElement discardButton;

    @FindBy (xpath = "//div[@class='modal-body']")
    public WebElement warningMessage;

    @FindBy (xpath = "//button[@class='btn btn-sm btn-primary']")
    public WebElement warningOkButton;

    @FindBy (xpath = "//button[contains(text(),'Attachment(s)')]")
    public WebElement attachmentDropDown;

    @FindBy (xpath = "//input[@name='ufile']")
    public WebElement getAddAttachment;

    @FindBy (xpath = "//a[@data-index='0']")
    public WebElement attachment;

    @FindBy (xpath = "//span[@class='fa fa-trash-o o_sidebar_delete_attachment']")
    public WebElement delete;

    @FindBy  (xpath = "//button[@class='btn btn-sm btn-primary']")
    public WebElement okDeleteButton;

    @FindBy (xpath = "(//input[@type='checkbox'])[28]")
    public WebElement fruitCheckbox;

    @FindBy (xpath = "//button[contains(text(),'Action')]")
    public WebElement actionDropdown;

    @FindBy (xpath = "//a[contains(text(),'Export')]")
    public WebElement exportButton;

    @FindBy (xpath = "//input[@checked='checked']")
    public WebElement importCompatibleImport;

    @FindBy (xpath = "//input[@name='o_export_format_name']")
    public WebElement csvFileOption;

    @FindBy (xpath = "(//input[@name='o_import_compat_name'])[2]")
    public WebElement exportAllData;

    @FindBy (xpath = "(//input[@type='radio'])[4]")
    public WebElement excelButton;

    @FindBy (xpath = "//button[@class='btn btn-sm btn-primary']")
    public WebElement exportToFileButton;

    @FindBy (xpath = "//a[contains(text(),'Delete')]")
    public WebElement deleteFromActionDropdown;

    @FindBy (xpath = "(//input[@type='checkbox'])[8]")
    public WebElement mediterraneanCuisine;

    @FindBy(xpath = "//div[@class='o_dialog_warning modal-body']")
    public WebElement odooServerErrorMessage;

    @FindBy (xpath = "(//td[@class='o_data_cell o_required_modifier'])[5]")
    public WebElement MediterraneanCuisineText;

    @FindBy (xpath = "//a[@data-index='1']")
    public WebElement duplicateButton;

    @FindBy (xpath = "//button[@accesskey='s']")
    public WebElement saveAfterDuplicate;





}
