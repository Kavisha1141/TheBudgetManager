package ui.tabs;

import javax.swing.*;
import java.awt.*;

import ui.BudgetManagerUI;

public class TransactionTab extends Tab {

    protected JPanel reportBlock;
    protected JScrollPane reportPane;
    protected JTextArea reportText;
    protected JLabel heading;

    //REQUIRES: SmartHomeUI controller that holds this tab
    //EFFECTS: creates report tab with buttons and application status functionality
    public TransactionTab (BudgetManagerUI controller) {
        super(controller);
        reportBlock = new JPanel();
        reportBlock.setLayout(new BoxLayout(reportBlock, BoxLayout.Y_AXIS));
        reportBlock.setSize(BudgetManagerUI.WIDTH - 5, BudgetManagerUI.HEIGHT - 3);

        setUpHeading("Earnings");
        setUpScrollPane();
        reportBlock.setVisible(true);
        add(reportBlock);
    }

    public void setUpScrollPane() {
        reportText = new JTextArea("", 16, 30);
        reportText.setLineWrap(true);
        reportText.setWrapStyleWord(true);

        reportPane = new JScrollPane(reportText);
        reportPane.setMaximumSize(new Dimension(500, 250));  
        reportPane.setPreferredSize(new Dimension(500, 250));
        reportBlock.add(reportPane);
    }

    public void setUpHeading(String headingText) {
        heading = new JLabel(headingText, SwingConstants.CENTER);
        JPanel headingPanel = new JPanel();
        headingPanel.add(heading);
        
        headingPanel.setMaximumSize(new Dimension(400, 30));
        headingPanel.setPreferredSize(new Dimension(400, 30));

        reportBlock.add(headingPanel, BorderLayout.NORTH);
    }





}
