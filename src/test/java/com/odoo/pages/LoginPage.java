package com.odoo.pages;

import com.odoo.utilities.Config;
import com.odoo.utilities.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.odoo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    Pages pages = new Pages();
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Sign in")
    public WebElement signInBtn;

    @FindBy(linkText = "BriteErpDemo")
    public WebElement demo;

    @FindBy(id = "login")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "(//button)[2]")
    public WebElement loginBttn;


    public void signIn() {
        demo.click();
        email.sendKeys(Config.getProperty("username"));
        password.sendKeys(Config.getProperty("password"));
        loginBttn.click();

    }

    public void goLunch() {
        pages.login().signIn();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(pages.main().lucnhButtn)).click();
        pages.lunchPage().closePopup();
    }
}
