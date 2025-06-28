// Abstract BankAccount class
abstract class BankAccount {
    String accountNumber;
    double balance;

    // Constructor
    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Abstract methods
    abstract void deposit(double amount);
    abstract void withdraw(double amount);

    // Common method to display balance
    void displayBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
        System.out.println("-----------------------------");
    }
}
class SavingsAccount extends BankAccount {
    int withdrawalsThisMonth = 0;
    final int withdrawalLimit = 3;

    SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount + " to Savings Account.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    void withdraw(double amount) {
        if (withdrawalsThisMonth >= withdrawalLimit) {
            System.out.println("Withdrawal limit reached for this month.");
        } else if (amount > 0 && amount <= balance) {
            balance -= amount;
            withdrawalsThisMonth++;
            System.out.println("Withdrew ₹" + amount + " from Savings Account.");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}
class CurrentAccount extends BankAccount {
    double overdraftLimit;

    CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount + " to Current Account.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrew ₹" + amount + " from Current Account (Overdraft allowed).");
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        // Create accounts
        BankAccount savings = new SavingsAccount("SAV123", 5000);
        BankAccount current = new CurrentAccount("CUR456", 3000, 2000);

        // Perform operations
        System.out.println("=== Savings Account Transactions ===");
        savings.deposit(1000);
        savings.withdraw(2000);
        savings.withdraw(1500);
        savings.withdraw(1000); // Exceeds limit
        savings.displayBalance();

        System.out.println("=== Current Account Transactions ===");
        current.deposit(500);
        current.withdraw(4000); // Within overdraft
        current.withdraw(2000); // Exceeds overdraft
        current.displayBalance();
    }
}
