package ui.tabs;

import java.util.List;
import java.util.ArrayList;

import ui.BudgetManagerUI;

import javax.swing.*;
import java.awt.*;

public class DashboardTab extends Tab {

    private String greeting;
    private JLabel greet; 
    private JLabel accountBalanceLabel;
    private JLabel totalEarningsLabel;
    private JLabel totalExpensesLabel;
    private JLabel totalSavingsLabel;
    private JLabel savingsTargetLabel;

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public DashboardTab(BudgetManagerUI controller) {
        super(controller);
        setLayout(new GridLayout(3, 1));
        placeGreeting();
        printInfo(setAccountInfo());
    }

    // initializes the greeting
    public void setGreeting() {
        greeting = "Welcome, "+ getController().getAccount().getName()+ "!";
    }

    //MODIFIES: this
    //EFFECTS: creates greeting at top of console
    private void placeGreeting() {
        setGreeting();
        greet = new JLabel(greeting, JLabel.CENTER);
        greet.setSize(WIDTH, HEIGHT / 3);
        this.add(greet);
    }

    //MODIFIES: this
    //EFFECTS: sets Account info 
    private List<JLabel> setAccountInfo() {
        Integer accountBalance = this.getController().getAccount().getBalance();
        Integer totalEarnings = this.getController().getAccount().getTotalEarnings();
        Integer totalExpenses = this.getController().getAccount().getTotalExpenses();
        Integer totalSavings = this.getController().getAccount().getSavings();
        Integer savingsTarget = this.getController().getAccount().getSavingsTarget();
        accountBalanceLabel = new JLabel("Account Balance:   "+"$" + accountBalance.toString());
        totalEarningsLabel = new JLabel("Total earnings:   "+"$" + totalEarnings.toString());
        totalExpensesLabel = new JLabel("Total expenses:   "+"$" + totalExpenses.toString());
        totalSavingsLabel = new JLabel("Total savings:   "+"$" + totalSavings.toString());
        savingsTargetLabel = new JLabel("Savings target:   "+"$" + savingsTarget.toString());
        List<JLabel> listOfInfo = new ArrayList<>();
        listOfInfo.add(accountBalanceLabel);
        listOfInfo.add(totalEarningsLabel);
        listOfInfo.add(totalExpensesLabel);
        listOfInfo.add(totalSavingsLabel);
        listOfInfo.add(savingsTargetLabel);
        return listOfInfo;
    }

    //MODIFIES: this
    //EFFECTS: places all info
    private void printInfo(List<JLabel> list) {
        JPanel infoPanel = new JPanel();
        infoPanel.setBorder(BorderFactory.createEmptyBorder(0, 35, 0, 0));
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        for (JLabel label: list) {
            label.setSize(WIDTH, HEIGHT / 2);
            infoPanel.add(label);
        }
        this.add(infoPanel);
    }



}
