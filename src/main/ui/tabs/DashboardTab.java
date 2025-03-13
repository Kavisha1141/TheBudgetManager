package ui.tabs;

import javax.swing.JLabel;
import ui.ButtonNames;
import ui.BudgetManagerUI;

import javax.swing.*;
import java.awt.*;

public class DashboardTab extends Tab {

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public DashboardTab(BudgetManagerUI controller) {
        super(controller);

        setLayout(new GridLayout(3, 1));
    }

}
