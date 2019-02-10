package com.odoo.tests.managerTests.controlAccountsTests;

import com.odoo.utilities.BrowserUtils;
import com.odoo.utilities.TestBase;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KanbanViewTests extends TestBase {

    @BeforeMethod
    public void setUp() {
        pages.login().signIn();
        BrowserUtils.wait(5);
    }

    @Test(description = "Verify that manager can add a transaction in Kanban view")
    public void addTransaction() {
        extentLogger= report.createTest("Add a transaction in Kanban view test");

        extentLogger.info("Clicking on 'Lunch' tab");
        pages.main().lunchButton.click();
        pages.lunchPage().closePopup();

        extentLogger.info("Clicking on 'Control Accounts'");
        BrowserUtils.waitForClickablility(pages.controlAccountsPage().controlAccountsButton, 10).click();

        extentLogger.info("Clicking Kanban grid view");
        pages.controlAccountsPage().kanbanView.click();

        extentLogger.info("Clicking on Create button");
        pages.controlAccountsKanbanViewPage().createBtn.click();

        extentLogger.info("Entering user, amount and description fields");
        pages.controlAccountsCreatePage().userField.click();
        pages.controlAccountsCreatePage().userSelected.click();
        pages.controlAccountsCreatePage().amountField.clear();
        pages.controlAccountsCreatePage().amountField.sendKeys("10.00");
        pages.controlAccountsCreatePage().descriptionField.sendKeys("Manti");

        extentLogger.info("Clicking on Save button");
        pages.controlAccountsCreatePage().saveBtn.click();

        extentLogger.info("Verifying system displays newly created transaction's informations correctly");
        assertEquals(pages.controlAccountsCreatePage().userSelected.getText(), pages.controlAccountsCreatePage().userAfterCreate.getText());
        assertEquals(pages.controlAccountsCreatePage().amountField.getText(), pages.controlAccountsCreatePage().amountAfterCreate.getText());
        assertEquals(pages.controlAccountsCreatePage().descriptionField.getText(), pages.controlAccountsCreatePage().descriptionAfterCreate.getText());

        extentLogger= report.createTest("Add a transaction in Kanban view test passed");
    }

    @Test(description = "Verify that manager can delete a transaction in Kanban view")
    public void deleteTransaction() {
        extentLogger= report.createTest("Delete a transaction in Kanban view test");

        extentLogger.info("Clicking on 'Lunch' tab");
        pages.main().lunchButton.click();
        pages.lunchPage().closePopup();

        extentLogger.info("Clicking on 'Control Accounts'");
        BrowserUtils.waitForClickablility(pages.controlAccountsPage().controlAccountsButton, 10).click();

        extentLogger.info("Clicking Kanban grid view");
        pages.controlAccountsPage().kanbanView.click();

        extentLogger.info("Clicking on a transaction");
        int r = (int) (Math.random() * pages.controlAccountsKanbanViewPage().transactions.size());

        BrowserUtils.waitForClickablility(pages.controlAccountsKanbanViewPage().transactions.get(r), 10);
        pages.controlAccountsKanbanViewPage().transactions.get(r).click();

        extentLogger.info("Clicking on Action");
        pages.controlAccountsKanbanViewPage().actionButton.click();

        extentLogger.info("Clicking on Delete");
        pages.controlAccountsKanbanViewPage().deleteButton.click();

        String cashMoveId = pages.controlAccountsKanbanViewPage().cashMoveId.getText();

        int cashMoveIdBefore = Integer.valueOf(cashMoveId.substring(cashMoveId.indexOf("#")+1));

        pages.controlAccountsKanbanViewPage().okButton.click();
        BrowserUtils.wait(3);

        extentLogger.info("Verifying after delete system displays next transaction's id");
        int cashMoveIdAfter = Integer.valueOf(pages.controlAccountsKanbanViewPage().cashMoveId.getText().substring(cashMoveId.indexOf("#")+1));

        assertTrue(cashMoveIdAfter - cashMoveIdBefore == 1);

        extentLogger= report.createTest("Delete a transaction in Kanban view test passed");
    }

    @Test(description = "Verify that manager can edit a transaction in Kanban view")
    public void editTransaction() {
        extentLogger= report.createTest("Edit a transaction in Kanban view test");

        extentLogger.info("Clicking on 'Lunch' tab");
        pages.main().lunchButton.click();
        pages.lunchPage().closePopup();

        extentLogger.info("Clicking on 'Control Accounts'");
        BrowserUtils.waitForClickablility(pages.controlAccountsPage().controlAccountsButton, 10).click();

        extentLogger.info("Clicking Kanban grid view");
        pages.controlAccountsPage().kanbanView.click();

        extentLogger.info("Clicking on a transaction");
        int r = (int) (Math.random() * pages.controlAccountsKanbanViewPage().transactions.size());

        BrowserUtils.waitForClickablility(pages.controlAccountsKanbanViewPage().transactions.get(r), 10);
        pages.controlAccountsKanbanViewPage().transactions.get(r).click();

        pages.controlAccountsKanbanViewPage().editButton.click();

        String cashMoveId = pages.controlAccountsKanbanViewPage().cashMoveId.getText();

        int cashMoveIdBefore = Integer.valueOf(cashMoveId.substring(cashMoveId.indexOf("#")+1));

        extentLogger.info("Editing user, amount and description fields");
        pages.controlAccountsCreatePage().userField.click();
        pages.controlAccountsCreatePage().userSelected.click();
        pages.controlAccountsCreatePage().amountField.clear();
        pages.controlAccountsCreatePage().amountField.sendKeys("25.00");
        pages.controlAccountsCreatePage().descriptionField.clear();
        pages.controlAccountsCreatePage().descriptionField.sendKeys("Pide");

        extentLogger.info("Clicking on Save button");
        pages.controlAccountsCreatePage().saveBtn.click();

        extentLogger.info("Verifying after edit system displays same transaction's id");
        int cashMoveIdAfter = Integer.valueOf(pages.controlAccountsKanbanViewPage().cashMoveId.getText().substring(cashMoveId.indexOf("#")+1));

        assertTrue(cashMoveIdAfter == cashMoveIdBefore);
        extentLogger= report.createTest("Edit a transaction in Kanban view test passed");

    }

}
