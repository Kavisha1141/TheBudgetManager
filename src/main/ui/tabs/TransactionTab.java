package ui.tabs;

import javax.swing.*;
import java.awt.*;

import ui.BudgetManagerUI;

public class TransactionTab extends Tab {

    protected JPanel reportBlock;
    protected JScrollPane reportPane;
    protected JTextArea reportText;
    protected JLabel heading;
    protected JButton updateTransactionReportButton;
    protected JButton addTransactionButton;

    //REQUIRES: SmartHomeUI controller that holds this tab
    //EFFECTS: creates report tab with buttons and application status functionality
    public TransactionTab (BudgetManagerUI controller) {
        super(controller);
        reportBlock = new JPanel();
        reportBlock.setLayout(new BoxLayout(reportBlock, BoxLayout.Y_AXIS));
        reportBlock.setSize(BudgetManagerUI.WIDTH - 5, BudgetManagerUI.HEIGHT - 3);

    }

    //EFFECTS: sets up scroll pane with text 
    public void setUpScrollPane() {
        reportText = new JTextArea("", 16, 30);
        reportText.setLineWrap(true);
        reportText.setWrapStyleWord(true);

        reportPane = new JScrollPane(reportText);
        reportPane.setMaximumSize(new Dimension(500, 250));  
        reportPane.setPreferredSize(new Dimension(500, 250));
        reportBlock.add(reportPane);
    }

    //EFFECTS: sets up heading block on top of scrollpane
    public void setUpHeading(String headingText) {
        heading = new JLabel(headingText, SwingConstants.CENTER);
        JPanel headingPanel = new JPanel();
        headingPanel.add(heading);
        
        headingPanel.setMaximumSize(new Dimension(500, 40));
        headingPanel.setPreferredSize(new Dimension(500, 40));

        reportBlock.add(headingPanel, BorderLayout.NORTH);
    }

    //EFFECTS: sets up buttons between heading and scroll pane
    public void setUpButtons(String typeOfTransaction) {
        updateTransactionReportButton = new JButton("Update "+typeOfTransaction+"s report");
        addTransactionButton = new JButton("Add an "+typeOfTransaction);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonPanel.add(updateTransactionReportButton);
        buttonPanel.add(addTransactionButton);

        buttonPanel.setMaximumSize(new Dimension(500, 40));
        buttonPanel.setPreferredSize(new Dimension(500, 40));
        reportBlock.add(buttonPanel);
    }






}
