package ui;

// code learned from SmartHome lecture lab
public enum ButtonNames {
    EARNINGS("Earnings"),
    EXPENSES("Expenses"),
    SAVINGS("Savings"),
    DASHBOARD("Dashboard"),
    LOGOUT("Logout"),
    SAVE("Save info"),
    LOAD("Load account info from file"),
    CREATE_ACCOUNT("Create account!");

    private final String name;

    ButtonNames(String name) {
        this.name = name;
    }

    //EFFECTS: returns name value of this button
    public String getValue() {
        return name;
    }
}
