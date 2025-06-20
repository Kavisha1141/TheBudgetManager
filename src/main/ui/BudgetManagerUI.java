package ui;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;

import model.Account;
import model.EventLog;
import model.Transaction;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.tabs.DashboardTab;
import ui.tabs.EarningsTab;
import ui.tabs.ExpensesTab;

public class BudgetManagerUI extends JFrame {

    private static final String JSON_STORE = "./data/CurrentAccounts.json";
    public static final int DASHBOARD_TAB_INDEX = 0;
    public static final int EARNINGS_TAB_INDEX = 1;
    public static final int EXPENSES_TAB_INDEX = 2;
    public static final int SAVINGS_TAB_INDEX = 3;

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    private JTabbedPane sidebar;
    private Account account;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private ScreenPrinter screenPrinter;

    public static void main(String[] args) {
        new BudgetManagerUI();
    }

    // EFFECTS: creates BudgetManager app, loads Account info, displays LoginScreen
    public BudgetManagerUI() {
        super("BudgetManager Console");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.LEFT);
        createAccount();
        loadTabs();
        add(sidebar);
        setVisible(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                printLogBeforeClosing();
            }
        });
    }

    // EFFECTS: prints log before closing
    public void printLogBeforeClosing() {

        JFrame screenPrinterWindow = new JFrame("Screen Printer");
        screenPrinterWindow.setSize(400, 300);
        screenPrinterWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        screenPrinter = new ScreenPrinter(this);
        screenPrinterWindow.add(screenPrinter);
        screenPrinter.printLog(EventLog.getInstance());
        screenPrinter.setVisible(true);
        screenPrinterWindow.setVisible(true);
    }

    // updates current account
    public void createAccount() {
        LoginFrame loginFrame = new LoginFrame(jsonReader, JSON_STORE);
        loginFrame.setVisible(true);
        while (loginFrame.getAccount() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        account = loginFrame.getAccount();
        loginFrame.dispose();
    }

    // MODIFIES: this
    // EFFECTS: adds Dashboard tab, Earnings tab, and expenses tab to this UI
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

    // EFFECTS: returns sidebar of this UI
    public JTabbedPane getTabbedPane() {
        return sidebar;
    }

    // EFFECTS: returns a String list of transactions and its info
    public String stringTransaction(ArrayList<Transaction> listToPrint) {
        StringBuilder status = new StringBuilder();
        status.append("               TITLE                               AMOUNT                        DATE");
        status.append("\n");
        for (Transaction t : listToPrint) {
            status.append("\n").append(transactionInfo(t));
        }
        return status.toString();
    }

    // EFFECTS: returns a transaction as a string
    public String transactionInfo(Transaction transaction) {
        return transaction.getTitle() + "                              "
                + "$" + transaction.getAmount() + "                         " + transaction.getMonth()
                + "/" + transaction.getDay() + "/" + transaction.getYear();
    }

    public JsonReader getJsonReader() {
        return this.jsonReader;
    }

    public JsonWriter getJsonWriter() {
        return this.jsonWriter;
    }

    public String getJsonStore() {
        return JSON_STORE;
    }

}
