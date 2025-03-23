package ui.tabs;

import ui.BudgetManagerUI;

public class EarningsTab extends TransactionTab {

    public EarningsTab(BudgetManagerUI controller) {
        super(controller);
        setUpHeading("EARNINGS");
        setUpButtons("earning");
        setUpScrollPane();
        reportBlock.setVisible(true);
        add(reportBlock);
        updateTransactionReportButton.addActionListener(e -> printReport());
        addTransactionButton.addActionListener(e -> addEarning());
    }

    // EFFECTS: prints expenses with title, amount, and date
    public void printReport() {
        reportText.setText(getController().stringTransaction(getController().getAccount().getListOfEarnings()));
        reportPane.setViewportView(reportText);
    }

    // EFFECTS: creates user popup for adding an earning
    public void addEarning() {
        addTransactionPopUp("earning");
    }

}
