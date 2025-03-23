package ui.tabs;

import java.util.List;
import java.util.ArrayList;
import ui.BudgetManagerUI;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class DashboardTab extends Tab {

    private String greeting;
    private JLabel greet;
    private JLabel accountBalanceLabel;
    private JLabel totalEarningsLabel;
    private JLabel totalExpensesLabel;
    private JLabel totalSavingsLabel;
    private List<JLabel> listOfInfo;
    private JPanel infoPanel;
    private JPanel mainBlock;
    private JProgressBar progressBar;

    // EFFECTS: constructs a home tab for console with buttons and a greeting
    public DashboardTab(BudgetManagerUI controller) {
        super(controller);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(5, 15, 0, 0));
        mainBlock = new JPanel(new GridLayout(3, 1, 0, 5));
        mainBlock.setAlignmentX(LEFT_ALIGNMENT);
        placeGreeting();
        printInfo(setAccountInfo());
        setUpButtons();

        this.add(mainBlock);
        addProgressBar();
    }

    // initializes the greeting
    public void setGreeting() {
        greeting = "Welcome, " + getController().getAccount().getName() + "!";
    }

    // MODIFIES: this
    // EFFECTS: creates greeting at top of console
    private void placeGreeting() {
        setGreeting();
        greet = new JLabel(greeting, JLabel.CENTER);
        greet.setAlignmentX(Component.CENTER_ALIGNMENT);
        greet.setAlignmentY(Component.TOP_ALIGNMENT);
        greet.setSize(WIDTH, 5);
        greet.setFont(new Font("Helvetica", Font.BOLD, 20));
        mainBlock.add(greet);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
    }

    // MODIFIES: this
    // EFFECTS: sets Account info
    private List<JLabel> setAccountInfo() {
        accountBalanceLabel = new JLabel();
        totalEarningsLabel = new JLabel();
        totalExpensesLabel = new JLabel();
        totalSavingsLabel = new JLabel();

        updateAccountInfo();

        listOfInfo = new ArrayList<>();
        listOfInfo.add(accountBalanceLabel);
        listOfInfo.add(totalEarningsLabel);
        listOfInfo.add(totalExpensesLabel);
        listOfInfo.add(totalSavingsLabel);
        return listOfInfo;
    }

    // MODIFIES: this
    // EFFECTS: places all info
    private void printInfo(List<JLabel> list) {
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        for (JLabel label : list) {
            label.setFont(new Font("Arial", Font.PLAIN, 14));
            label.setAlignmentX(LEFT_ALIGNMENT);
            infoPanel.add(label);
        }
        mainBlock.add(infoPanel);

    }

    // EFFECTS: updates printed account info
    private void updateAccountInfo() {
        Integer accountBalance = this.getController().getAccount().getBalance();
        Integer totalEarnings = this.getController().getAccount().getTotalEarnings();
        Integer totalExpenses = this.getController().getAccount().getTotalExpenses();
        Integer totalSavings = this.getController().getAccount().getSavings();

        accountBalanceLabel.setText("Account Balance: $" + accountBalance);
        totalEarningsLabel.setText("Total Earnings: $" + totalEarnings);
        totalExpensesLabel.setText("Total Expenses: $" + totalExpenses);
        totalSavingsLabel.setText("Total Savings: $" + totalSavings);

        this.revalidate();
        this.repaint();
    }

    // EFFECTS: updates progress bar
    private void updateProgressBar() {
        if (this.getController().getAccount().getTotalEarnings() != 0) {
            int progressValue = (int) ((double) this.getController().getAccount().getSavings()
                    / this.getController().getAccount().getTotalEarnings() * 100);
            progressBar.setValue(progressValue);
        }
        progressBar.setStringPainted(true);
        mainBlock.revalidate();
        mainBlock.repaint();
        this.revalidate();
        this.repaint();
    }

    // EFFECTS: updates entire dashboard
    private void updateDashboard() {
        updateAccountInfo();
        updateProgressBar();
    }

    // EFFECTS: sets up savings, update and save to file and quit app button
    private void setUpButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 2));
        buttonPanel.add(setUpUpdateButton());
        buttonPanel.add(setUpSaveButton());
        buttonPanel.add(setUpAddToSavingsButton());
        buttonPanel.setPreferredSize(new Dimension(100, 10));
        mainBlock.add(buttonPanel);
    }

    // EFFECTS: sets up update button
    private JButton setUpUpdateButton() {
        JButton update = new JButton("Update info");
        update.addActionListener(e -> updateDashboard());
        return update;
    }

    // EFFECTS: sets up save info to file button
    private JButton setUpSaveButton() {
        JButton save = new JButton("Save info to file");
        save.addActionListener(e -> saveToFile());
        return save;
    }

    // EFFECTS: sets up add to savings button
    private JButton setUpAddToSavingsButton() {
        JButton saveAmount = new JButton("Add to savings");
        saveAmount.addActionListener(e -> addToSavings());
        return saveAmount;
    }

    // EFFECTS: saves info to file
    private void saveToFile() {
        try {
            this.getController().getJsonWriter().open();
            this.getController().getJsonWriter().write(this.getController().getAccount());
            this.getController().getJsonWriter().close();
            System.out.println("Saved " + this.getController().getAccount().getName() + " to "
                    + this.getController().getJsonStore());
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + this.getController().getJsonStore());
        }
    }

    // EFFECTS: adds to savings of account
    private void addToSavings() {
        JButton save = new JButton("Save");
        JDialog savingsDialog = new JDialog((Frame) null, "Save Amount", false);
        JTextField amountField = new JTextField();
        savingsDialog.add(new JLabel("Amount:"));
        savingsDialog.add(amountField);
        savingsDialog.add(save);
        savingsDialog.setLayout(new GridLayout(1, 1));
        savingsDialog.setSize(250, 90);
        savingsDialog.setLocationRelativeTo(this);
        savingsDialog.setVisible(true);
        save.addActionListener(e -> addSavings(amountField));
    }

    // adds progress bar
    private void addProgressBar() {
        JLabel progress = new JLabel("Your savings with respect to total earnings: ");
        progress.setPreferredSize(new Dimension(50, 10));
        progress.setFont(new Font("Arial", Font.PLAIN, 12));
        progressBar = new JProgressBar();
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setValue(0);
        if (this.getController().getAccount().getTotalEarnings() != 0) {
            int progressValue = (int) ((double) this.getController().getAccount().getSavings()
                    / this.getController().getAccount().getTotalEarnings() * 100);
            progressBar.setValue(progressValue);
        }
        progressBar.setStringPainted(true);
        this.add(progress);
        this.add(progressBar);
    }

    // EFFECTS: show not enough balance popup
    public void notEnoughBalancePopUp() {
        JLabel notEnoughBalance = new JLabel("Not enough balance", SwingConstants.CENTER);
        notEnoughBalance.setFont(new Font("Arial", Font.PLAIN, 12));
        notEnoughBalance.setAlignmentX(CENTER_ALIGNMENT);
        JDialog newDialog = new JDialog((Frame) null, "Add Savings", false);
        newDialog.setLayout(new GridLayout(1, 1));
        newDialog.add(notEnoughBalance);
        newDialog.setSize(250, 150);
        newDialog.setLocationRelativeTo(this);
        newDialog.setVisible(true);
    }

    // EFFECTS: Adds amount to savings, shows popup if not enough amount
    public void addSavings(JTextField amountField) {
        int amount = Integer.parseInt(amountField.getText());
        if (this.getController().getAccount().getBalance() - amount < 0) {
            notEnoughBalancePopUp();
            return;
        }
        this.getController().getAccount().saveAmount(amount);
    }

}
