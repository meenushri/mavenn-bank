package bankapp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        // Each test-ku fresh account — 1000 balance
        account = new BankAccount("TestUser", 1000.0);
    }

    // ✅ Test 1: Deposit positive amount
    @Test
    void testDepositPositiveAmount() {
        account.deposit(500);
        assertEquals(1500.0, account.getBalance());
    }

    // ✅ Test 2: Withdraw valid amount
    @Test
    void testWithdrawValidAmount() {
        account.withdraw(300);
        assertEquals(700.0, account.getBalance());
    }

    // ✅ Test 3: Withdraw full balance
    @Test
    void testWithdrawFullBalance() {
        account.withdraw(1000);
        assertEquals(0.0, account.getBalance());
    }

    // ✅ Test 4: Overdraft — balance vida jaasthi withdraw
    @Test
    void testOverdraftThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(2000);
        });
    }

    // ✅ Test 5: Negative deposit
    @Test
    void testNegativeDepositThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100);
        });
    }

    // ✅ Test 6: Zero withdraw
    @Test
    void testZeroWithdrawThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(0);
        });
    }

    // ✅ Test 7: Initial balance check
    @Test
    void testInitialBalance() {
        assertEquals(1000.0, account.getBalance());
    }

    // ✅ Test 8: Negative initial balance
    @Test
    void testNegativeInitialBalanceThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount("Bad", -500);
        });
    }
}