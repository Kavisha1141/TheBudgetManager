package ui.tabs;

import javax.swing.*;
import java.awt.*;

import ui.BudgetManagerUI;

public class TransactionTab extends Tab {

    protected JPanel reportBlock;
    protected JScrollPane reportPane;
    protected JTextArea reportText;
    protected JLabel heading;
    protected JButton updateTransactionReportButton;
    protected JButton addTransactionButton;

    // popup window fields
    protected JDialog dialog;
    protected JButton saveButton;
    protected JButton cancelButton;

    // REQUIRES: SmartHomeUI controller that holds this tab
    // EFFECTS: creates report tab with buttons and application status functionality
    public TransactionTab(BudgetManagerUI controller) {
        super(controller);
        reportBlock = new JPanel();
        reportBlock.setLayout(new BoxLayout(reportBlock, BoxLayout.Y_AXIS));
        reportBlock.setSize(BudgetManagerUI.WIDTH - 5, BudgetManagerUI.HEIGHT - 3);

    }

    // EFFECTS: sets up scroll pane with text
    public void setUpScrollPane() {
        reportText = new JTextArea("", 16, 30);
        reportText.setLineWrap(true);
        reportText.setWrapStyleWord(true);

        reportPane = new JScrollPane(reportText);
        reportPane.setMaximumSize(new Dimension(500, 250));
        reportPane.setPreferredSize(new Dimension(500, 250));
        reportBlock.add(reportPane);
    }

    // EFFECTS: sets up heading block on top of scrollpane
    public void setUpHeading(String headingText) {
        heading = new JLabel(headingText, SwingConstants.CENTER);
        JPanel headingPanel = new JPanel();
        headingPanel.add(heading);

        headingPanel.setMaximumSize(new Dimension(500, 40));
        headingPanel.setPreferredSize(new Dimension(500, 40));

        reportBlock.add(headingPanel, BorderLayout.NORTH);
    }

    // EFFECTS: sets up buttons between heading and scroll pane
    public void setUpButtons(String typeOfTransaction) {
        updateTransactionReportButton = new JButton("Update " + typeOfTransaction + "s report");
        addTransactionButton = new JButton("Add an " + typeOfTransaction);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonPanel.add(updateTransactionReportButton);
        buttonPanel.add(addTransactionButton);

        buttonPanel.setMaximumSize(new Dimension(500, 40));
        buttonPanel.setPreferredSize(new Dimension(500, 40));
        reportBlock.add(buttonPanel);
    }

    // EFFECTS: adds popup window to add a transaction
    public void addTransactionPopUp(String typeOfTransaction) {
        dialog = new JDialog(new JDialog((Frame) null, "Add Transaction", false));
        dialog.setLayout(new GridLayout(6, 2, 10, 10));

        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        setUpPopUpFields(typeOfTransaction);
    }

    public void setUpPopUpFields(String typeOfTransaction) {
        JTextField titleField = new JTextField();
        JTextField amountField = new JTextField();
        JTextField dayField = new JTextField();
        JTextField monthField = new JTextField();
        JTextField yearField = new JTextField();
        dialog.add(new JLabel("Title:"));
        dialog.add(titleField);
        dialog.add(new JLabel("Amount:"));
        dialog.add(amountField);
        dialog.add(new JLabel("Day (DD):"));
        dialog.add(dayField);
        dialog.add(new JLabel("Month (MM):"));
        dialog.add(monthField);
        dialog.add(new JLabel("Year (YYYY):"));
        dialog.add(yearField);
        addTransaction(titleField, amountField, dayField, monthField, yearField, typeOfTransaction);
        cancelButton.addActionListener(e -> dialog.dispose());
        dialog.add(saveButton);
        dialog.add(cancelButton);
        dialog.setSize(300, 250);
        dialog.setVisible(true);
    }

    //adds a transaction to the account
    public void addTransaction(JTextField titleField, JTextField amountField,
            JTextField dayField, JTextField monthField, JTextField yearField, String typeOfTransaction) {
        saveButton.addActionListener(e -> {
            String title = titleField.getText();
            int amount = Integer.parseInt(amountField.getText());
            int day = Integer.parseInt(dayField.getText());
            int month = Integer.parseInt(monthField.getText());
            int year = Integer.parseInt(yearField.getText());

            if (typeOfTransaction.equals("earning")) {
                this.getController().getAccount().addEarning(amount, day, month, year, title);
            } else {
                this.getController().getAccount().addExpense(amount, day, month, year, title);
            }
            dialog.dispose();
        });
    }

}
