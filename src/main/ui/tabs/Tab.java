package ui.tabs;

import ui.BudgetManagerUI;
import javax.swing.*;
import java.awt.*;

// code source: SmartHome from lecture labs
public abstract class Tab extends JPanel {
    private final BudgetManagerUI controller;

    //REQUIRES: SmartHomeUI controller that holds this tab
    public Tab(BudgetManagerUI controller) {
        this.controller = controller;
    }

    //EFFECTS: creates and returns row with button included
    public JPanel formatButtonRow(JButton b) {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(b);
        return p;
    }

    //EFFECTS: returns the BudgetManagerUI controller for this tab
    public BudgetManagerUI getController() {
        return controller;
    }
}
