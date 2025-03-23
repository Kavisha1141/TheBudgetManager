package ui.tabs;

import ui.BudgetManagerUI;

public class ExpensesTab extends TransactionTab {

    public ExpensesTab(BudgetManagerUI controller) {
        super(controller);
        setUpHeading("EXPENSES");
        setUpButtons("expense");
        setUpScrollPane();
        reportBlock.setVisible(true);
        add(reportBlock);
        updateTransactionReportButton.addActionListener(e -> printReport());
        addTransactionButton.addActionListener(e -> addExpense());
    }

    // EFFECTS: prints all expenses report
    public void printReport() {
        reportText.setText(getController().stringTransaction(getController().getAccount().getListOfExpenses()));
        reportPane.setViewportView(reportText);
    }

    // EFFECTS: adds expense; if not enough balance, shows popup
    public void addExpense() {
        if (this.getController().getAccount().getBalance() > 0) {
            addTransactionPopUp("expense");
        } else {
            this.notEnoughBalancePopUp();
        }
    }
}
