package ui;

import javax.swing.*;
import model.Account;
import ui.tabs.DashboardTab;

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
        loadTabs();
        add(sidebar);
        setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: adds Dashboard tab, Earnings tab, and expenses tab to this UI
    private void loadTabs() {
        JPanel homeTab = new DashboardTab(this);
        sidebar.add(homeTab, DASHBOARD_TAB_INDEX);

    }

    // returns current account
    private Account getAccount() {
        return account;
    }

}
