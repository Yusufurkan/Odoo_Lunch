package com.odoo.utilities;

import com.odoo.pages.*;

public class Pages {
    private LoginPage loginPage;
    private MainPage mainPage;
    private LunchPage lunchPage;
    private AlertsPage alertPage;
    private ControlAccountsPage controlAccountsPage;
    private EmployeePaymentsPage employeePaymentsPage;
    private OrdersbyVendorPage ordersbyVendorPage;
    private PreviousOrdersPage previousOrdersPage;
    private ProductCategoriesPage productCategoriesPage;
    private ProductsPage productsPage;
    private TodaysOrdersPage todaysOrdersPage;
    private YourLunchAccountPage yourLunchAccountPage;

    public YourLunchAccountPage yourLunchAccountPage() {
        if (yourLunchAccountPage == null) {
            yourLunchAccountPage = new YourLunchAccountPage();
        }
        return yourLunchAccountPage;
    }

    public TodaysOrdersPage todaysOrdersPage() {
        if (todaysOrdersPage == null) {
            todaysOrdersPage = new TodaysOrdersPage();
        }
        return todaysOrdersPage;
    }

    public ProductsPage productsPage() {
        if (productsPage == null) {
            productsPage = new ProductsPage();
        }
        return productsPage;
    }


    public ProductCategoriesPage productCategoriesPage() {
        if (previousOrdersPage == null) {
            productCategoriesPage = new ProductCategoriesPage();
        }
        return productCategoriesPage;
    }

    public PreviousOrdersPage previousOrdersPage() {
        if (previousOrdersPage == null) {
            previousOrdersPage = new PreviousOrdersPage();
        }
        return previousOrdersPage;
    }

    public OrdersbyVendorPage ordersbyVendorPage() {
        if (ordersbyVendorPage == null) {
            ordersbyVendorPage = new OrdersbyVendorPage();
        }
        return ordersbyVendorPage;
    }

    public EmployeePaymentsPage employeePaymentsPage() {
        if (employeePaymentsPage == null) {
            employeePaymentsPage = new EmployeePaymentsPage();
        }
        return employeePaymentsPage;
    }

    public ControlAccountsPage controlAccountsPage() {
        if (controlAccountsPage == null) {
            controlAccountsPage = new ControlAccountsPage();
        }
        return controlAccountsPage;
    }

    public AlertsPage alertsPage() {
        if (alertPage == null) {
            alertPage = new AlertsPage();
        }
        return alertPage;
    }

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
