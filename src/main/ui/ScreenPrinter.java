package ui;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.*;

import model.Event;
import model.EventLog;

/**
 * Represents a screen printer for printing event log to screen.
 */
// CODE SOURCE: AlarmSystem:
// https://github.students.cs.ubc.ca/CPSC210/AlarmSystem
public class ScreenPrinter extends JPanel implements LogPrinter {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private JTextArea logArea;

    /**
     * Constructor sets up window in which log will be printed on screen
     * 
     * @param parent the parent component
     */
    public ScreenPrinter(Component parent) {
        setLayout(new BorderLayout());
        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        logArea.setSize(new Dimension(WIDTH, HEIGHT));
        scrollPane.setSize(new Dimension(WIDTH, HEIGHT));
        add(scrollPane);
        setSize(WIDTH, HEIGHT);
        setPosition(parent);
        setVisible(true);
    }

    @Override
    public void printLog(EventLog el) {
        for (Event next : el) {
            logArea.setText(logArea.getText() + next.toString() + "\n\n");
        }

        repaint();
    }

    /**
     * Sets the position of window in which log will be printed relative to
     * parent
     * 
     * @param parent the parent component
     */
    private void setPosition(Component parent) {
        setLocation(parent.getWidth() - getWidth() - 20,
                parent.getHeight() - getHeight() - 20);
    }
}
