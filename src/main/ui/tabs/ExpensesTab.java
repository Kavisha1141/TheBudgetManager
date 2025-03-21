package ui.tabs;

import ui.BudgetManagerUI;

public class ExpensesTab extends TransactionTab {

    public ExpensesTab (BudgetManagerUI controller) {
        super(controller);
        printEarnings();
    }

    public void printEarnings() {
        reportText.setText(getController().stringTransaction(getController().getAccount().getListOfExpenses()));
        reportPane.setViewportView(reportText);
    }

}
