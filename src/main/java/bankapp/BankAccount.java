package bankapp;
public class BankAccount {

    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;

        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative!");
        }
        this.balance = initialBalance;
    }

    // Deposit Money
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive!");
        }
        balance += amount;
    }

    // Withdraw Money
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive!");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance!");
        }
        balance -= amount;
    }

    // Get Balance
    public double getBalance() {
        return balance;
    }

    // Get Account Holder Name
    public String getAccountHolder() {
        return accountHolder;
    }
}