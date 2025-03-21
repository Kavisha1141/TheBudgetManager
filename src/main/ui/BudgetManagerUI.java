package ui;

import java.util.ArrayList;
import javax.swing.*;

import model.Account;
import model.Transaction;
import ui.tabs.DashboardTab;
import ui.tabs.EarningsTab;
import ui.tabs.ExpensesTab;

public class BudgetManagerUI extends JFrame {

    public static final int DASHBOARD_TAB_INDEX = 0;
    public static final int EARNINGS_TAB_INDEX = 1;
    public static final int EXPENSES_TAB_INDEX = 2;
    public static final int SAVINGS_TAB_INDEX = 3;

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    private JTabbedPane sidebar;
    private Account account;

    public static void main(String[] args) {
        new BudgetManagerUI();
    }

    // EFFECTS: creates BudgetManager app, loads Account info, displays LoginScreen
    private BudgetManagerUI() {
        super("BudgetManager Console");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.LEFT);

        createAccount();

        loadTabs();
        add(sidebar);
        setVisible(true);
    }

    //updates current account
    public void createAccount() {
        account = new Account("User1", "1141");
        account.addEarning(1000, 12, 1, 2025, "Received paycheck");
    }

    //MODIFIES: this
    //EFFECTS: adds Dashboard tab, Earnings tab, and expenses tab to this UI
    private void loadTabs() {
        JPanel dashboardTab = new DashboardTab(this);
        JPanel earningsTab = new EarningsTab(this);
        JPanel expensesTab = new ExpensesTab(this);

        sidebar.add(dashboardTab, DASHBOARD_TAB_INDEX);
        sidebar.setTitleAt(DASHBOARD_TAB_INDEX, "Dashboard");

        sidebar.add(earningsTab, EARNINGS_TAB_INDEX);
        sidebar.setTitleAt(EARNINGS_TAB_INDEX, "Earnings");

        sidebar.add(expensesTab, EXPENSES_TAB_INDEX);
        sidebar.setTitleAt(EXPENSES_TAB_INDEX, "Expenses");
    }

    // returns current account
    public Account getAccount() {
        return account;
    }

    //EFFECTS: returns sidebar of this UI
    public JTabbedPane getTabbedPane() {
        return sidebar;
    }

     //EFFECTS: returns a String list of transactions and its info
    public String stringTransaction(ArrayList<Transaction> listToPrint) {
        StringBuilder status = new StringBuilder(); 
        status.append("               TITLE                               AMOUNT                        DATE");
        status.append("\n");
        for (Transaction t : listToPrint) {
            status.append("\n").append(transactionInfo(t));
        }
        return status.toString();
    }

    //EFFECTS: returns a transaction as a string
    public String transactionInfo(Transaction transaction) {
        return transaction.getTitle() + "                             " 
        +"$"+ transaction.getAmount()+ "                   " + transaction.getMonth()
        + "/"+transaction.getDay() + "/" +transaction.getYear();
    }

}
