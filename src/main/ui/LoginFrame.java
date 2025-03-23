package ui;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import model.Account;
import persistence.JsonReader;


// creates a login frame which takes username password from user and initializes account
public class LoginFrame extends JFrame{
    private Account account;
    private JsonReader jsonReader;
    private JButton createAccountButton;
    private JButton signInButton;
    private JButton loadFromFileButton;
    private String username;
    private String password;
    private String jsonStore;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel stringOutput;


    public LoginFrame(JsonReader jsonReader, String jsonStore) {
        super("Login Console");
        loadingScreen();
        this.jsonReader = jsonReader;
        this.jsonStore = jsonStore;
        setSize(600, 300);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUpUsernamePassword();
        setUpButtons();
    }

    //EFFECTS: sets up buttons of the screen
    public void setUpButtons() {
        JPanel buttonPanel = new JPanel(new FlowLayout());
        createAccountButton = new JButton("Create Account");
        createAccountButton.addActionListener(e -> createAccount());
        
        signInButton = new JButton("Sign in");
        signInButton.addActionListener(e -> login());

        loadFromFileButton = new JButton("Load from file");
        loadFromFileButton.addActionListener(e -> readFromFile());
        buttonPanel.add(createAccountButton);
        buttonPanel.add(signInButton);
        buttonPanel.add(loadFromFileButton);
        this.add(buttonPanel);
    }

    //EFFECTS: takes username password text from user 
    public void setUpUsernamePassword() {
        JPanel usernamePanel = new JPanel(new FlowLayout());
        usernameField = new JTextField(20); 
        usernameField.setPreferredSize(new Dimension(150, 30)); 
        usernameField.setSize(100, 50);

        usernamePanel.add(new JLabel("Username: "));
        usernamePanel.add(usernameField);

        JPanel passwordPanel = new JPanel(new FlowLayout());
        passwordField = new JPasswordField(20);
        passwordField.setSize(100, 50);
        passwordField.setPreferredSize(new Dimension(150, 30)); 
        
        passwordPanel.add(new JLabel("Password: "));
        passwordPanel.add(passwordField);
        this.add(usernamePanel);
        this.add(passwordPanel);
    }

    //EFFECTS: creates account based on user input
    public void createAccount() {
        username = usernameField.getText();
        password = new String(passwordField.getPassword());
        account = new Account(username, password);
    }

    //EFFECTS: reads account from file
    public void readFromFile() {
        try {
            account = jsonReader.read();
            stringOutput = new JLabel("Successfully loaded from"+ jsonStore);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + jsonStore);
        }
    }

    //EFFECTS: opens account using saved username password
    public Account openAccount() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        if (account!= null) {
            if (username.equals(account.getName()) && password.equals(account.getPassword())) {
                return account;
            }
        }
        return null;
    }

    //returns account
    public Account getAccount() {
        return account;
    }

    //EFFECTS: logs in user to account if correct username password entered
    public void login() {
        if (openAccount() == null) {
            stringOutput = new JLabel("Incorrect username or password. Try again");
            this.add(stringOutput);
        } else {
            stringOutput = new JLabel("Successfully logged in");
            this.add(stringOutput);
        }
    }

    //EFFECTS: adds a splash screen
    //IMAGE SOURCE: TheBudgetManager.gif uses a component downloaded from https://giphy.com/gifs/JustStartInvesting-cJFQJzZxFMhONxDTnt
    private void loadingScreen() {
        JWindow loadScreen = new JWindow();
        loadScreen.setSize(500, 400);
        ImageIcon loadIcon = new ImageIcon("data/TheBudgetManager.gif");
        JLabel loadLabel = new JLabel(loadIcon);
        loadScreen.getContentPane().add(loadLabel);
        loadScreen.setVisible(true);
        try {
            Thread.sleep(3000); // 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loadScreen.setVisible(false);
        loadScreen.dispose();
    }

}
