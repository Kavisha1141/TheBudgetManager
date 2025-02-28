package persistence;

import model.Transaction;
import model.Account;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// CODE SOURCE: JsonSerializationDemo file: https://github.com/stleary/JSON-java
class TestJsonWriter extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Account acc = new Account("account 1", "210");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Account acc = new Account("account 1", "210");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(acc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            acc = reader.read();
            assertEquals("account 1", acc.getName());
            assertEquals(0, acc.getBalance());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            Account acc = new Account("account 2" , "211");
            acc.addEarning(251, 1, 3, 2024, "Received gift from Mom");
            acc.addExpense(20, 6, 4, 2024, "Bought UBC shirt");
            acc.addEarning(249,5, 3, 2021, "Received gift from Dad");
            acc.setSavingTarget(50);
            assertEquals(480,acc.getBalance());
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(acc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            Account accRead = reader.read();
            assertEquals("account 2", accRead.getName());
            assertEquals("211", accRead.getPassword());
            List<Transaction> earnings = accRead.getListOfEarnings();
            assertEquals(2, earnings.size());
            checkTransaction("Received gift from Mom", 251, 1, 3, 2024, earnings.get(0));
            checkTransaction("Received gift from Dad", 249, 5, 3, 2021, earnings.get(1));

            List<Transaction> expenses = accRead.getListOfExpenses();
            assertEquals(1, expenses.size());
            checkTransaction("Bought UBC shirt", 20, 6, 4, 2024, expenses.get(0));

            assertEquals(50,accRead.getSavingsTarget());
            assertEquals(0, accRead.getSavings());
            assertEquals(480, accRead.getBalance());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
