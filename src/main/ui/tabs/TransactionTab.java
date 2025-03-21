package ui.tabs;

import javax.swing.*;
import java.awt.*;

import ui.BudgetManagerUI;

public class TransactionTab extends Tab {

    protected static final String REPORT_GEN_MESSAGE = "Latest report generated today at ";

    protected JPanel reportBlock;
    protected JScrollPane reportPane;
    protected JTextArea reportText;
    protected JLabel heading;

    //REQUIRES: SmartHomeUI controller that holds this tab
    //EFFECTS: creates report tab with buttons and application status functionality
    public TransactionTab (BudgetManagerUI controller) {
        super(controller);
        reportBlock = new JPanel(new GridLayout(3, 1));
        reportBlock.setSize(BudgetManagerUI.WIDTH - 1,
                BudgetManagerUI.HEIGHT - 3);
        setUpScrollPane();
        setUpHeading("Earnings");
        reportBlock.setVisible(true);
        add(reportBlock);
    }

    public void setUpScrollPane() {
        reportPane = new JScrollPane(new JTextArea(20, 40));
        reportText = new JTextArea("", 16, 40);
        reportPane.add(reportText);
        reportPane.setVisible(true);
        reportText.setVisible(true);
        reportBlock.add(reportPane);
    }

    public void setUpHeading(String headingText) {
        heading = new JLabel(headingText);
        heading.setVisible(true);
        reportBlock.add(heading);
    }





}
