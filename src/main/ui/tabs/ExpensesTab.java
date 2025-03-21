package ui.tabs;

import ui.BudgetManagerUI;

public class ExpensesTab extends TransactionTab {

    public ExpensesTab (BudgetManagerUI controller) {
        super(controller);
        setUpHeading("EXPENSES");
        setUpButtons("expense");
        setUpScrollPane();
        reportBlock.setVisible(true);
        
        add(reportBlock);
        updateTransactionReportButton.addActionListener(e -> printReport());
        addTransactionButton.addActionListener(e -> addExpense());
    }


    public void printReport() {
        reportText.setText(getController().stringTransaction(getController().getAccount().getListOfExpenses()));
        reportPane.setViewportView(reportText);
    }

    public void addExpense() {
        addTransactionPopUp("expense");
    }

}
