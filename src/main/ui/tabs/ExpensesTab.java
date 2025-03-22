package ui.tabs;

import ui.BudgetManagerUI;
import javax.swing.*;
import java.awt.*;

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
        if (this.getController().getAccount().getBalance() > 0){
            addTransactionPopUp("expense");
        } else {
            JLabel notEnoughBalance = new JLabel("Not enough balance", SwingConstants.CENTER);
            notEnoughBalance.setFont(new Font("Arial", Font.PLAIN, 12));
            notEnoughBalance.setAlignmentX(CENTER_ALIGNMENT);
            JDialog newDialog = new JDialog((Frame) null, "Add Transaction", false);
            newDialog.setLayout(new GridLayout(1,1));
            newDialog.add(notEnoughBalance);
            newDialog.setSize(250, 150);
            newDialog.setLocationRelativeTo(this); 
            newDialog.setVisible(true);

        }
       
    }

}
