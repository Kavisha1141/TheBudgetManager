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
    private JLabel savingsTargetLabel;
    private List<JLabel> listOfInfo;
    private  JPanel infoPanel;
    private JPanel mainBlock;

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public DashboardTab(BudgetManagerUI controller) {
        super(controller);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 0));
        mainBlock = new JPanel(new GridLayout(4, 1, 0, 15));
        mainBlock.setAlignmentX(LEFT_ALIGNMENT);
        placeGreeting();
        printInfo(setAccountInfo());
        setUpButtons();
        this.add(mainBlock);
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
        greet.setAlignmentX(Component.CENTER_ALIGNMENT);
        greet.setAlignmentY(Component.TOP_ALIGNMENT);
        greet.setSize(WIDTH, 5);
        greet.setFont(new Font("Helvetica", Font.BOLD, 20));
        mainBlock.add(greet);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
    }

    //MODIFIES: this
    //EFFECTS: sets Account info 
    private List<JLabel> setAccountInfo() {
        accountBalanceLabel = new JLabel(); 
        totalEarningsLabel = new JLabel(); 
        totalExpensesLabel = new JLabel(); 
        totalSavingsLabel = new JLabel(); 
        savingsTargetLabel = new JLabel();

        updateAccountInfo(); 
        
        listOfInfo = new ArrayList<>();
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
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        for (JLabel label: list) {
            label.setFont(new Font("Arial", Font.PLAIN, 14));
            label.setAlignmentX(LEFT_ALIGNMENT);
            infoPanel.add(label);
        }
        mainBlock.add(infoPanel);

    }

    //EFFECTS: updates printed account info 
    private void updateAccountInfo() {
        Integer accountBalance = this.getController().getAccount().getBalance();
        Integer totalEarnings = this.getController().getAccount().getTotalEarnings();
        Integer totalExpenses = this.getController().getAccount().getTotalExpenses();
        Integer totalSavings = this.getController().getAccount().getSavings();
        Integer savingsTarget = this.getController().getAccount().getSavingsTarget();
    
        accountBalanceLabel.setText("Account Balance: $" + accountBalance);
        totalEarningsLabel.setText("Total Earnings: $" + totalEarnings);
        totalExpensesLabel.setText("Total Expenses: $" + totalExpenses);
        totalSavingsLabel.setText("Total Savings: $" + totalSavings);
        savingsTargetLabel.setText("Savings Target: $" + savingsTarget);
    
        this.revalidate(); // Refresh layout
        this.repaint();
    }

    //EFFECTS: sets up savings, update and save to file and quit app button
    private void setUpButtons() {
        JButton saveAmount = new JButton("Add to savings");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 2));
        buttonPanel.add(setUpUpdateButton());
        buttonPanel.add(setUpSaveButton());

        buttonPanel.setPreferredSize(new Dimension(100, 30));
       
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        mainBlock.add(buttonPanel);

    }


    //EFFECTS: sets up update button
    private JButton setUpUpdateButton() {
        JButton update = new JButton("Update info");
        update.addActionListener(e -> updateAccountInfo());
        return update;
    }

    //EFFECTS: sets up save info to file button
    private JButton setUpSaveButton() {
        JButton save =  new JButton("Save info to file");
        save.addActionListener(e -> saveToFile());
        return save;
    }

    //EFFECTS: saves info to file
    private void saveToFile() {
        try {
            this.getController().getJsonWriter().open();
            this.getController().getJsonWriter().write(this.getController().getAccount());
            this.getController().getJsonWriter().close();
            System.out.println("Saved " + this.getController().getAccount().getName() + " to " + this.getController().getJsonStore());
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + this.getController().getJsonStore());
        }
    }
}
