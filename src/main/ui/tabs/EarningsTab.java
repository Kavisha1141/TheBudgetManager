package ui.tabs;

import ui.BudgetManagerUI;

public class EarningsTab extends TransactionTab {

    public EarningsTab(BudgetManagerUI controller) {
        super(controller);
        printEarnings();
    }

    public void printEarnings() {
        reportText.setText(getController().stringTransaction(getController().getAccount().getListOfEarnings()));
        reportPane.setViewportView(reportText);
    }

}
