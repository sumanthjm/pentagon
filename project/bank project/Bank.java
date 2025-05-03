import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;
import java.io.IOException;

public class Bank{
    private double accNo;
    private String accName;
    private double balance;
    private int pin;
    private String email;
    private String[] history = new String[100];
    private int historyIndex = 0;

    static final int MAX_USERS = 10;
    static Bank[] users = new Bank[MAX_USERS];
    static int userCount = 0;

    // === Setters and Getters ===
    public double getAccNo() { return accNo; }
    public void setAccNo(double accNo) { this.accNo = accNo; }
    public String getAccName() { return accName; }
    public void setAccName(String accName) { this.accName = accName; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public int getPin() { return pin; }
    public void setPin(int pin) { this.pin = pin; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // === Transaction Methods ===
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            String entry = timeNow() + " - Deposited ₹" + amount;
            addToHistory(entry);
            logToFile(entry);
            System.out.println("Deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            String entry = timeNow() + " - Withdrawn ₹" + amount;
            addToHistory(entry);
            logToFile(entry);
            System.out.println("Withdrawn ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void changePin(int newPin) {
        this.pin = newPin;
        String entry = timeNow() + " - PIN Changed";
        addToHistory(entry);
        logToFile(entry);
        System.out.println("PIN changed successfully.");
    }

    // === History Methods ===
    private void addToHistory(String entry) {
        if (historyIndex < history.length) {
            history[historyIndex++] = entry;
        }
    }

    private String timeNow() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    private void logToFile(String entry) {
        try (FileWriter writer = new FileWriter("transaction_log.txt", true)) {
            writer.write(entry + "\n");
        } catch (IOException e) {
            System.out.println("Error logging transaction.");
        }
    }

    public void printHistory() {
        System.out.println("\n+-----+---------------------+----------------------------+");
        System.out.printf("| %-3s | %-19s | %-26s |\n", "No", "Date & Time", "Transaction");
        System.out.println("+-----+---------------------+----------------------------+");

        if (historyIndex == 0) {
            System.out.printf("| %-59s |\n", "No transactions yet.");
        } else {
            for (int i = 0; i < historyIndex; i++) {
                String[] parts = history[i].split(" - ", 2);
                String dateTime = parts[0];
                String detail = parts.length > 1 ? parts[1] : "";
                if (detail.length() > 26) detail = detail.substring(0, 23) + "...";
                System.out.printf("| %-3d | %-19s | %-26s |\n", i + 1, dateTime, detail);
            }
        }
        System.out.println("+-----+---------------------+----------------------------+");
    }

    // === Menu Methods ===
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n==== Welcome to the Bank ====");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> createAccount(sc);
                case 2 -> login(sc);
                case 3 -> System.out.println("Thank you for visiting!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 3);
        sc.close();
    }

    public static void createAccount(Scanner sc) {
        if (userCount >= MAX_USERS) {
            System.out.println("Account limit reached.");
            return;
        }

        Bank b = new Bank();

        System.out.print("Enter Account Number: ");
        b.setAccNo(sc.nextDouble());
        sc.nextLine();  // clear newline

        System.out.print("Enter Account Name: ");
        b.setAccName(sc.nextLine());

        System.out.print("Enter Email: ");
        b.setEmail(sc.nextLine());

        System.out.print("Enter Initial Balance: ");
        b.setBalance(sc.nextDouble());

        System.out.print("Set 4-digit PIN: ");
        b.setPin(sc.nextInt());

        users[userCount++] = b;
        System.out.println("Account created successfully!");
    }

    public static void login(Scanner sc) {
        System.out.print("Enter Account Number: ");
        double accNo = sc.nextDouble();

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        Bank user = null;
        for (int i = 0; i < userCount; i++) {
            if (users[i].getAccNo() == accNo && users[i].getPin() == pin) {
                user = users[i];
                break;
            }
        }

        if (user != null) {
            System.out.println("Login successful!");
            userMenu(sc, user);
        } else {
            System.out.println("Invalid account number or PIN.");
        }
    }

    public static void userMenu(Scanner sc, Bank b) {
        int choice;
        do {
            System.out.println("\n==== Account Menu ====");
            System.out.println("1. View Account Details");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Change PIN");
            System.out.println("6. View Transaction History");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Account Number: " + b.getAccNo());
                    System.out.println("Account Name: " + b.getAccName());
                    System.out.println("Email: " + b.getEmail());
                }
                case 2 -> {
                    System.out.print("Enter amount to deposit: ");
                    b.deposit(sc.nextDouble());
                }
                case 3 -> {
                    System.out.print("Enter amount to withdraw: ");
                    b.withdraw(sc.nextDouble());
                }
                case 4 -> System.out.println("Current Balance: ₹" + b.getBalance());
                case 5 -> {
                    System.out.print("Enter new 4-digit PIN: ");
                    b.changePin(sc.nextInt());
                }
                case 6 -> b.printHistory();
                case 7 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 7);
    }
}
