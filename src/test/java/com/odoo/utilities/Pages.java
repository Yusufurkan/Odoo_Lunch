package com.odoo.utilities;

import com.odoo.pages.LoginPage;
import com.odoo.pages.LunchPage;
import com.odoo.pages.MainPage;

public class Pages {
    private LoginPage loginPage;
    private MainPage mainPage;
    private LunchPage lunchPage;

    public LoginPage login() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public MainPage main() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public LunchPage lunchPage() {
        if (lunchPage == null) {
            lunchPage = new LunchPage();
        }
        return lunchPage;
    }

}
