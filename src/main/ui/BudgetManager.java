package ui;

import model.Account;
import model.Transaction;

import java.util.ArrayList;
import java.util.Scanner;

// A budget manager application that allows user to create an account to manage earnings, expenses, savings and balance
public class BudgetManager {

    private ArrayList<Account> listOfAccounts;
    private Account currentAccount;
    private boolean isProgramRunning;
    private Scanner scanner;

    // main program
    // SOURCE: I used the flashcard reviewer app to learn how implementing an UI works
    public BudgetManager() {
        initialize();
        System.out.println();
        System.out.println("Welcome to the Budget Manager!");
        printDivider();
        while (this.isProgramRunning) {
            handleMenu();
            printDivider();
        }
    }

    // initializes the app
    public void initialize() {
        listOfAccounts = new ArrayList<>();
        isProgramRunning = true;
        currentAccount = null;
        scanner = new Scanner(System.in);
    }

    // EFFECTS: displays menu for all accounts
    public void printMenuAllAccounts() {
        System.out.println("Please select an option:\n");
        System.out.println("c: Create new account");
        System.out.println("v: View an account");
        System.out.println("w: View all accounts");
        System.out.println("q: Quit application");
        printDivider();
    }

    // EFFECTS: displays menu for an account selected
    public void printMenuOneAccount() {
        System.out.println("Please select an option:\n");
        System.out.println("a: View Account Details");
        System.out.println("b: Add an Earning");
        System.out.println("c: Add an Expense");
        System.out.println("d: Set a saving target");
        System.out.println("e: Add savings");
        System.out.println("f: Logout and return to main menu");
        printDivider();
    }

    // EFFECTS: displays menu for an account selected for view options
    public void printMenuViewAccount() {
        System.out.println("Please select an option:\n");
        System.out.println("e: View Account Balance");
        System.out.println("f: View List of Earnings");
        System.out.println("g: View List of Expenses");
        System.out.println("h: View total money spent");
        System.out.println("i: View total money earned");
        System.out.println("j: View total account report");
        System.out.println("k: Logout and return to main menu");
        printDivider();
    }

    // handle main menu
    public void handleMenu() {
        printMenuAllAccounts();
        String input = this.scanner.nextLine();
        processMainMenuCommands(input);
    }

    // REQUIRES: currentAccount != null
    // handles menu for one account
    public void handleSubMenu() {
        printMenuOneAccount();
        String input = this.scanner.nextLine();
        processSubMenuCommands(input);
    }

    // REQUIRES: currentAccount != null
    // handles menu for one account
    public void handleViewMenu() {
        printMenuViewAccount();
        String input = this.scanner.nextLine();
        processViewMenuCommands(input);
    }

    // EFFECTS: processes the user's input in the main menu
    public void processMainMenuCommands(String input) {
        switch (input) {
            case "c":
                createAccount();
                printDivider();
                break;
            case "v":
                openAccount();
                printDivider();
                break;
            case "w":
                viewAllAccounts();
                printDivider();
                break;
            case "q":
                quitApplication();
                printDivider();
                break;
            default:
                System.out.println("Invalid option inputted. Please try again.");
                printDivider();
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a new account with username and password; adds it to list of
    // accounts
    public void createAccount() {
        System.out.println("Please enter Account name:");
        String name = this.scanner.nextLine();

        System.out.println("Please set Account password:");
        String password = this.scanner.nextLine();

        Account newAccount = new Account(name, password);
        listOfAccounts.add(newAccount);
        currentAccount = newAccount;
        System.out.println("Account successfully created! \n");
        handleSubMenu();
    }

    // REQUIRES: listOfAccounts.size() > 0
    // MODIFIES: this
    // EFFECTS: creates a new account with username and password; adds it to list of
    // accounts
    public void openAccount() {
        if (!listOfAccounts.isEmpty()) {
            System.out.println("Please enter Account name:");
            String name = this.scanner.nextLine();
            System.out.println("Please enter Account password:");
            String password = this.scanner.nextLine();
            for (Account account : listOfAccounts) {
                if (account.getName().equals(name) & account.getPassword().equals(password)) {
                    currentAccount = account;
                    handleSubMenu();
                    break;
                }
            }
            System.out.println("Username or password incorrect!");
        } else {
            System.out.println("No account created yet!");
        }
    }

    // EFFECTS: prints all account names
    public void viewAllAccounts() {
        if (!listOfAccounts.isEmpty()) {
            System.out.println("Account names: ");
            for (Account account : listOfAccounts) {
                System.out.println(account.getName());
            }
        } else {
            System.out.println("No accounts created yet!");
        }
    }

    // MODIFIES: this
    // EFFECTS: quit application
    public void quitApplication() {
        System.out.println("Thanks for using the Budget Manager!");
        System.out.println("Have a good day!");
        this.isProgramRunning = false;
    }

    // REQUIRES: currentAccount != null
    // EFFECTS: processes the user's input in options about one account
    public void processSubMenuCommands(String input) {
        switch (input) {
            case "a":
                handleViewMenu();
            case "b":
                addEarning();
            case "c":
                addExpense();
            case "d":
                setTarget();
            case "e":
                saveAmount();
            case "f":
                System.out.println("Successfully logged out!");
                handleMenu();
                break;
            default:
                System.out.println("Invalid option inputted. Please try again.");
        }
        if (isProgramRunning) {
            printDivider();
            handleSubMenu();
        }
    }

    public void processViewMenuCommands(String input) {
        switch (input) {
            case "a":
                System.out.println("Account Balance: $" + currentAccount.getBalance());
            case "f":
                printListOfExpenses();
            case "g":
                printListOfEarnings();
            case "h":
                System.out.println("Total amount spent: $" + currentAccount.getTotalExpenses());
            case "i":
                System.out.println("Total amount earned: $" + currentAccount.getTotalEarnings());
            case "j":
                printActivityReport();
            case "k":
                handleSubMenu();
                break;
            default:
                System.out.println("Invalid option inputted. Please try again.");
        }
        handleViewMenu();
    }

    // REQUIRES: currentAccount != null
    // EFFECTS: prints list of earnings
    public void printListOfEarnings() {
        if (!currentAccount.getListOfEarnings().isEmpty()) {
            System.out.println("List of Earnings:");
            printList(currentAccount.getListOfEarnings());
        } else {
            System.out.println("No earnings recorded yet!");
        }

    }

    // REQUIRES: currentAccount != null
    // EFFECTS: prints list of expenses
    public void printListOfExpenses() {
        if (!currentAccount.getListOfEarnings().isEmpty()) {
            System.out.println("List of Expenses:");
            printList(currentAccount.getListOfExpenses());
        } else {
            System.out.println("No expenses recorded yet!");
        }

    }

    // EFFECTS: get int input from user
    public int getInput() {
        int input = this.scanner.nextInt();
        this.scanner.nextLine();
        return input;
    }

    // REQUIRES: currentAccount != null
    // MODIFIES: Account
    // EFFECTS: add expense to the current account
    public void addExpense() {
        System.out.println("Enter amount of expense: ");
        int amount = getInput();
        System.out.println("Enter day expense was made: ");
        int day = getInput();
        System.out.println("Enter the month expense was made: ");
        int month = getInput();
        System.out.println("Enter the year expense was made: ");
        int year = getInput();
        System.out.println("Enter the expense title: ");
        String title = this.scanner.nextLine();
        currentAccount.addExpense(amount, day, month, year, title);
    }

    // REQUIRES: currentAccount != null
    // MODIFIES: Account
    // EFFECTS: add earning to the current account
    public void addEarning() {
        System.out.println("Enter amount of earning: ");
        int amount = getInput();
        System.out.println("Enter day earning was made: ");
        int day = getInput();
        System.out.println("Enter the month earning was made: ");
        int month = getInput();
        System.out.println("Enter the year earning was made: ");
        int year = getInput();
        System.out.println("Enter the earning title: ");
        String title = scanner.nextLine();
        currentAccount.addEarning(amount, day, month, year, title);
    }

    // REQUIRES: currentAccount != null
    // MODIFIES: Account
    // EFFECTS: save amount from balance
    public void saveAmount() {
        if (currentAccount.getSavingsTarget() != 0) {
            System.out.println("Enter amount to save from total balance: ");
            int amount = getInput();
            currentAccount.saveAmount(amount);
        } else {
            System.out.println("Please set a savings target first.");
        }
    }

    // REQUIRES: currentAccount != null
    // MODIFIES: Account
    // EFFECTS: set a saving target
    public void setTarget() {
        System.out.println("Enter target amount to save: ");
        int amount = getInput();
        currentAccount.setSavingTarget(amount);
        System.out.println("Target set to $" + amount);
    }

    // REQUIRES: currentAccount != null
    // EFFECTS: print a list of Transactions
    public void printList(ArrayList<Transaction> listToPrint) {
        System.out.println("  AMOUNT ($)      DATE                 TITLE           ");
        for (Transaction nextTransaction : listToPrint) {
            System.out.println(" " + nextTransaction.getAmount()
                    + "   " + nextTransaction.getMonth()
                    + "/" + nextTransaction.getDay() + "/"
                    + nextTransaction.getYear() + "   "
                    + nextTransaction.getTitle() + "    |");
        }
    }

    // EFFECTS: prints divider
    public void printDivider() {
        System.out.println(" --------------------------------------------------");
        System.out.println();
    }

    // REQUIRES: currentAccount != null
    // EFFECTS: print activity report
    public void printActivityReport() {
        System.out.println("ACCOUNT ACTIVITY REPORT");
        printDivider();
        System.out.println("Current Balance: $" + currentAccount.getBalance());
        System.out.println("Total amount spent: $" + currentAccount.getTotalExpenses());
        System.out.println("Total amount earned: $" + currentAccount.getTotalEarnings());
        System.out.println("Total savings: $" + currentAccount.getSavings());
        System.out.println("Savings target: $" + currentAccount.getSavingsTarget());
        printDivider();
        System.out.println("List of Earnings:");
        printList(currentAccount.getListOfEarnings());
        printDivider();
        System.out.println("List of Expenses:");
        printList(currentAccount.getListOfExpenses());
        printDivider();
    }

}
