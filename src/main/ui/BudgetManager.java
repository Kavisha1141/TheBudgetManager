package ui;

import model.Account;
import java.util.ArrayList;
import java.util.Scanner;

// A budget manager application that allows user to create an account to manage earnings, expenses, savings and balance
public class BudgetManager {

    private ArrayList<Account> listOfAccounts;
    private Account currentAccount;
    private boolean isProgramRunning;
    private Scanner scanner;

    public BudgetManager() {
        initialize();
        System.out.println("Welcome to the Budget Manager!");
    }

    public void initialize() {
        listOfAccounts = new ArrayList<>();
        isProgramRunning = true;
        currentAccount = null;
        scanner = new Scanner(System.in);
    }

    // displays menu for all accounts
    public void printMenuAllAccounts() {
        System.out.println("Please select an option:\n");
        System.out.println("c: Create new account");
        System.out.println("v: View an account");
        System.out.println("w: View all accounts");
    }

    // displays menu for an account selected
    public void printMenuOneAccount() {
        System.out.println("Please select an option:\n");
        System.out.println("a: View Account Balance");
        System.out.println("b: Add an Expense");
        System.out.println("c: Add an Earning");
        System.out.println("d: Set a saving target");
        System.out.println("e: Add savings");
        System.out.println("f: View List of Earnings");
        System.out.println("g: View List of Expenses");
        System.out.println("h: View total money spent");
        System.out.println("i: View total money earned");
        System.out.println("i: View total account report");
    }

    // handle main menu
    public void handleMenu() {
        printMenuAllAccounts();
        String input = this.scanner.nextLine();
        processMenuCommands(input);
    }

    // EFFECTS: processes the user's input in the main menu
    public void processMenuCommands(String input) {
        switch (input) {
            case "a":
                createAccount();
                break;
            case "v":
                openAccount();
                break;
            case "r":
                viewAllAccounts();
                break;
            case "q":
                quitApplication();
                break;
            default:
                System.out.println("Invalid option inputted. Please try again.");
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
    }

    // REQUIRES: listOfAccounts.size() > 0
    // MODIFIES: this
    // EFFECTS: creates a new account with username and password; adds it to list of
    // accounts
    public void openAccount() {
        System.out.println("Please enter Account name:");
        String name = this.scanner.nextLine();

        System.out.println("Please enter Account password:");
        String password = this.scanner.nextLine();

        for (Account account : listOfAccounts) {
            if (account.getName() == name && account.getPassword() == password) {
                currentAccount = account;
                break;
            }
        }
        System.out.println("Username or password incorrect!");
    }

    // EFFECTS: prints all account names
    public void viewAllAccounts() {
        if (!listOfAccounts.isEmpty()) {
            for (Account account : listOfAccounts) {
                System.out.println(account.getName());
            }
        } 
        else {
            System.out.println("No accounts created yet!");
        }
    }

    // MODIFIES: this
    // EFFECTS: quit application
    public void quitApplication() {
        this.isProgramRunning = false;
    }

}
