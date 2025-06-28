// Secure BankAccount class using encapsulation
class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private int pin;

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double balance, int pin) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Initial balance cannot be negative. Setting to 0.");
            this.balance = 0;
        }
        this.pin = pin;
    }

    // Getters (No setter for account number for immutability)
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    // Getter for balance with PIN verification
    public double getBalance(int inputPin) {
        if (this.pin == inputPin) {
            return balance;
        } else {
            System.out.println("Incorrect PIN! Access Denied.");
            return -1;
        }
    }

    // Deposit method with validation
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw method with PIN verification and sufficient balance check
    public void withdraw(double amount, int inputPin) {
        if (this.pin != inputPin) {
            System.out.println("Incorrect PIN! Withdrawal denied.");
            return;
        }
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Withdrawal denied.");
        } else {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        }
    }

    // Method to check balance securely
    public void checkBalance(int inputPin) {
        double bal = getBalance(inputPin);
        if (bal != -1) {
            System.out.println("Current Balance: ₹" + bal);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        // Create a bank account
        BankAccount account = new BankAccount("ACC123456", "Sumanth J M", 10000.0, 4321);

        // Access account info (name & account number)
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("-------------------------------");

        // Valid operations
        account.deposit(5000);
        account.withdraw(3000, 4321);
        account.checkBalance(4321);

        System.out.println("-------------------------------");

        // Invalid operations
        account.withdraw(20000, 4321);      // Insufficient balance
        account.withdraw(500, 1234);        // Wrong PIN
        account.deposit(-100);              // Invalid deposit
        account.checkBalance(9999);         // Invalid PIN
    }
}
