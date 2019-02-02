package com.odoo.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.odoo.utilities.Driver;

import java.sql.SQLOutput;
import java.util.List;

public class LunchPage {

    public LunchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary']")
    public WebElement error;

    @FindBy(xpath = "(//div[@class='oe_secondary_menu'])[13]//li")
    public List<WebElement> functions;

    @FindBy(xpath = "//ol[@class='breadcrumb']/li")
    public WebElement title;

    public void goToFunctionality(String functionality) throws Exception {
        for (int i = 0; i < functions.size(); i++) {
            if (functions.get(i).getText().equalsIgnoreCase(functionality)) {
                functions.get(i).click();
            } else {
                throw new Exception("Functionality does not exist.. Check spelling! ");
            }
        }
    }

    public void closePopup() {
        try {
            error.click();
        } catch (NoSuchElementException e) {
        }
<<<<<<< HEAD
    }
=======
    }


}
>>>>>>> origin/master
