package persistence;
import model.Account;
import model.Transaction;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {

    // Code source: 
    protected void checkTransaction(String title, int amt, int day, int month, int year, Transaction tr) {
        assertEquals(title, tr.getTitle());
        assertEquals(day, tr.getDay());
        assertEquals(month, tr.getMonth());
        assertEquals(year, tr.getYear());
        assertEquals(amt, tr.getAmount());
    }
}
