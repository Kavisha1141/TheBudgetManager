package ui;

// code learned from SmartHome lecture lab
public enum ButtonNames {
    EARNINGS("Earnings"),
    ADD_EARNINGS("Add an earning"),
    EXPENSES("Expenses"),
    ADD_EXPENSE("Add an expense"),
    SAVINGS("Savings"),
    SAVE_AMOUNT("Add to savings"),
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
