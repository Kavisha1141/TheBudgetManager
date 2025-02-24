package persistence;
import model.Account;
import java.io.IOException;

import org.json.JSONObject;

// represents a reader that reads an Account frm JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: construct reader to read from source file
    public JsonReader(String source) {

    }

    // EFFECTS: reads Account from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Account read() throws IOException{
        return null;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        return null;
    }

    // EFFECTS: parses Account from JSON object and returns it
    private Account parseAccount(JSONObject jsonObject) {
        return null;
    }

    // MODIFIES: acc
    // EFFECTS: parses transactions from JSON object and adds them to workroom
    private void addTransactions(Account acc, JSONObject jsonObject) {

    }

    // MODIFIES: acc
    // EFFECTS: parses transaction from JSON object and adds them to workroom
    private void addTransaction(Account acc, JSONObject jsonObject) {

    }




}
