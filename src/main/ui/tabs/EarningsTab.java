package ui.tabs;

import static ui.tabs.TransactionTab.REPORT_GEN_MESSAGE;

import ui.BudgetManagerUI;

public class EarningsTab extends TransactionTab {

    public EarningsTab(BudgetManagerUI controller) {
        super(controller);
        printEarnings();
    }

    public void printEarnings() {
        updateCurrTime();
        String message = REPORT_GEN_MESSAGE + currTime;
        reportMessage.setText(message);
        reportText.setText(getController().stringTransaction(getController().getAccount().getListOfEarnings()));
        reportPane.setViewportView(reportText);
    }

}
