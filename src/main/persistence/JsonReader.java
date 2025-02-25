package persistence;

import model.Account;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;

// represents a reader that reads an Account frm JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: construct reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads Account from file and returns it;
    // throws IOException if an error occurs reading data from file
    // Code source: JsonSerializationDemo file: https://github.com/stleary/JSON-java
    public Account read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseAccount(jsonObject);
    }

    // Code source: JsonSerializationDemo file: https://github.com/stleary/JSON-java
    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses Account from JSON object and returns it
    private Account parseAccount(JSONObject jsonObject) {
        String name = jsonObject.getString("Account name");
        String password = jsonObject.getString("Account password");
        int balance = jsonObject.getInt("Balance");
        int savingTarget = jsonObject.getInt("Savings target");
        int savedAmt = jsonObject.getInt("Amount saved");
        Account acc = new Account(name, password);
        acc.setSavingTarget(savingTarget);
        acc.saveAmount(savedAmt);
        addTransactions(acc, jsonObject, "earnings");
        addTransactions(acc, jsonObject, "expenses");
        assertEquals(balance, acc.getBalance());
        return acc;
    }

    // MODIFIES: acc
    // EFFECTS: parses transactions from JSON object and adds them to workroom
    private void addTransactions(Account acc, JSONObject jsonObject, String typeOfTr) {
        if (typeOfTr == "earnings") {
            JSONArray jsonArray = jsonObject.getJSONArray("List of Earnings");
            for (Object json : jsonArray) {
                JSONObject nextTr = (JSONObject) json;
                addTransaction(acc, nextTr, typeOfTr);
            }
        } else {
            JSONArray jsonArray = jsonObject.getJSONArray("List of Expenses");
            for (Object json : jsonArray) {
                JSONObject nextTr = (JSONObject) json;
                addTransaction(acc, nextTr, typeOfTr);
            }
        }
    }

    // MODIFIES: acc
    // EFFECTS: parses transaction from JSON object and adds them to workroom
    private void addTransaction(Account acc, JSONObject jsonObject, String typeOfTr) {
        if (typeOfTr == "earnings") {

            int amount = jsonObject.getInt("amount");
            int day = jsonObject.getInt("day");
            int month = jsonObject.getInt("month");
            int year = jsonObject.getInt("year");
            String title = jsonObject.getString("title");
            acc.addEarning(amount, day, month, year, title);
        } else {

            int amount = jsonObject.getInt("amount");
            int day = jsonObject.getInt("day");
            int month = jsonObject.getInt("month");
            int year = jsonObject.getInt("year");
            String title = jsonObject.getString("title");
            acc.addExpense(amount, day, month, year, title);
        }

    }

}
