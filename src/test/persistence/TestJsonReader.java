package persistence;

import org.junit.jupiter.api.Test;
import model.Account;
import model.Transaction;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestJsonReader extends JsonTest{

    // Code source: JsonSerializationDemo file: https://github.com/stleary/JSON-java
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Account acc = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }
    
    @Test
    void testReaderEmptyAccount() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyAccount.json");
        try {
            Account acc = reader.read();
            assertEquals("account 1", acc.getName());
            assertEquals("210", acc.getPassword());
            assertEquals(0, acc.getBalance());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            Account acc = reader.read();
            assertEquals("account 2", acc.getName());
            assertEquals("211", acc.getPassword());
            List<Transaction> earnings = acc.getListOfEarnings();
            assertEquals(2, earnings.size());
            checkTransaction("Received gift from Mom", 251, 1, 3, 2025, earnings.get(0));
            checkTransaction("Received gift from Dad",249,5,3,2021, earnings.get(1));

            List<Transaction> expenses = acc.getListOfExpenses();
            assertEquals(1, expenses.size());
            checkTransaction("Bought UBC shirt", 20, 6, 4, 2024, expenses.get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
