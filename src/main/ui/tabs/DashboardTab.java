package ui.tabs;

import javax.swing.JLabel;
import ui.ButtonNames;
import ui.BudgetManagerUI;

import javax.swing.*;
import java.awt.*;

public class DashboardTab extends Tab {

    private String greeting;
    private JLabel greet; 

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public DashboardTab(BudgetManagerUI controller) {
        super(controller);
        setLayout(new GridLayout(3, 1));

        placeGreeting();
    }

    // initializes the greeting
    public void setGreeting() {
        greeting = "Welcome, "+ getController().getAccount().getName()+ "!";
    }

    //EFFECTS: creates greeting at top of console
    private void placeGreeting() {
        setGreeting();
        greet = new JLabel(greeting, JLabel.CENTER);
        greet.setSize(WIDTH, HEIGHT / 3);
        this.add(greet);
    }

}
