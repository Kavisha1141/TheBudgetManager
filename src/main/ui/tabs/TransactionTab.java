package ui.tabs;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ui.BudgetManagerUI;
import ui.ButtonNames;

public class TransactionTab extends Tab {

    protected static final String REPORT_GEN_MESSAGE = "Latest report generated today at ";

    protected JScrollPane reportPane;
    protected JTextArea reportText;
    protected JLabel reportMessage;
    protected String currTime;
    protected SimpleDateFormat timeFormat;
    protected Date currDate;

    //REQUIRES: SmartHomeUI controller that holds this tab
    //EFFECTS: creates report tab with buttons and application status functionality
    public TransactionTab (BudgetManagerUI controller) {
        super(controller);

        currDate = Calendar.getInstance().getTime();
        timeFormat = new SimpleDateFormat("HH:mm:ss");
        updateCurrTime();

        JPanel reportBlock = new JPanel(new GridLayout(3, 1));
        reportBlock.setSize(BudgetManagerUI.WIDTH - 1,
                BudgetManagerUI.HEIGHT - 3);
        reportPane = new JScrollPane(new JTextArea(20, 40));
        reportText = new JTextArea("", 16, 40);
        reportText.setVisible(true);
        
        reportBlock.add(reportPane);
        add(reportBlock);
    }


    //MODIFIES: this
    //EFFECTS: updates current time in format HH:mm:ss
    protected void updateCurrTime() {
        currDate = Calendar.getInstance().getTime();
        currTime = timeFormat.format(currDate);
    }

}
