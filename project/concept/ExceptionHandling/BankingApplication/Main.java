// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Custom exception for invalid amount
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}
class BankAccount {
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Deposit method
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("Deposited ₹" + amount + ". New Balance: ₹" + balance);
    }

    // Withdraw method
    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance. Available: ₹" + balance);
        }
        balance -= amount;
        System.out.println("Withdrew ₹" + amount + ". New Balance: ₹" + balance);
    }

    // Display current balance
    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
        System.out.println("-----------------------------");
    }
}
public class Main {
    public static void main(String[] args) {
        // Create a bank account
        BankAccount account = new BankAccount("ACC123", 5000);

        System.out.println("---- Banking Application ----\n");

        try {
            account.deposit(2000);         // Valid deposit
            account.withdraw(1000);        // Valid withdrawal
            account.withdraw(7000);        // Will throw InsufficientBalanceException
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            account.deposit(-500);         // Will throw InvalidAmountException
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Display final balance
        account.displayBalance();
    }
}
