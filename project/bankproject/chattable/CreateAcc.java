// package chattable;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;


public class CreateAcc {
    private String name;
    private String email;
    private long phone;

    private static int nextAccountNumber = 100001; // starting account number
    private String accountNumber;
    private static final String IFSC_CODE = "GPTB0001234";

    public CreateAcc() {
    this.accountNumber = "GPT" + nextAccountNumber++;
    }

    public String getAccountNumber() {
    return accountNumber;
    }

    public String getIfscCode() {
    return IFSC_CODE;
    }


    private int balance = 0;
    private String password;
    private List<String> transactionHistory = new ArrayList<>();

    private String getCurrentTime() {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return now.format(formatter);
}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public long getPhone() { return phone; }
    public void setPhone(long phone) { this.phone = phone; }

    public int getBalance() { return balance; }
    public void setBalance(int balance) { this.balance = balance; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    // public void setDeposit(int amt) {
    //     this.balance += amt;
    //     transactionHistory.add("Deposited | " + amt + " | " + balance);
    // }
    public void setDeposit(int amt) {
    this.balance += amt;
    String time = getCurrentTime();
    transactionHistory.add("Deposited | " + amt + " | " + balance + " | " + time);
}

    // public void setWithdraw(int amt) {
    //     this.balance -= amt;
    //     transactionHistory.add("Withdrew   | " + amt + " | " + balance);
    // }
    public void setWithdraw(int amt) {
    this.balance -= amt;
    String time = getCurrentTime();
    transactionHistory.add("Withdrew   | " + amt + " | " + balance + " | " + time);
}

    public void displayAllTransactions() {
        // System.out.println("+------------+--------+---------+");
        // System.out.println("| Type       | Amount | Balance |");
        // System.out.println("+------------+--------+---------+");
        System.out.println("+------------+--------+---------+---------------------+");
        System.out.println("| Type       | Amount | Balance | Time                |");
        System.out.println("+------------+--------+---------+---------------------+");
        for (String entry : transactionHistory) {
            // String[] parts = entry.split("\\|");
            // System.out.printf("| %-10s | %6s | %7s |\n", parts[0].trim(), parts[1].trim(), parts[2].trim());
            String[] parts = entry.split("\\|");
            System.out.printf("| %-10s | %6s | %7s | %-19s |\n",
                  parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim());
        }
        if (transactionHistory.isEmpty()) {
            System.out.println("|      No transactions yet.      |");
        }
        System.out.println("+------------+--------+---------+---------------------+");
    }

    public void displayRecentTransactions(int recent) {
        // System.out.println("+------------+--------+---------+");
        // System.out.println("| Type       | Amount | Balance |");
        // System.out.println("+------------+--------+---------+");
        System.out.println("+------------+--------+---------+---------------------+");
        System.out.println("| Type       | Amount | Balance | Time                |");
        System.out.println("+------------+--------+---------+---------------------+");
        int start = Math.max(0, transactionHistory.size() - recent);
        for (int i = start; i < transactionHistory.size(); i++) {
            String[] parts = transactionHistory.get(i).split("\\|");
            // System.out.printf("| %-10s | %6s | %7s |\n", parts[0].trim(), parts[1].trim(), parts[2].trim());
            // String[] parts = entry.split("\\|");
            System.out.printf("| %-10s | %6s | %7s | %-19s |\n", parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim());
        }
        if (transactionHistory.isEmpty()) {
            System.out.println("|      No transactions yet.      |");
        }
        System.out.println("+------------+--------+---------+---------------------+");
    }



//     public void displayTransactionsByDateRange(String startDate, String endDate) {
//     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

//     try {
//         LocalDateTime start = LocalDateTime.parse(startDate + " 00:00:00", formatter);
//         LocalDateTime end = LocalDateTime.parse(endDate + " 23:59:59", formatter);

//         System.out.println("+------------+--------+---------+---------------------+");
//         System.out.println("| Type       | Amount | Balance | Time                |");
//         System.out.println("+------------+--------+---------+---------------------+");

//         boolean found = false;

//         for (String entry : transactionHistory) {
//             String[] parts = entry.split("\\|");
//             if (parts.length < 4) continue;

//             LocalDateTime txTime = LocalDateTime.parse(parts[3].trim(), formatter);

//             if (!txTime.isBefore(start) && !txTime.isAfter(end)) {
//                 found = true;
//                 System.out.printf("| %-10s | %6s | %7s | %-19s |\n",
//                         parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim());
//             }
//         }

//         if (!found) {
//             System.out.println("|    No transactions in this date range.           |");
//         }

//         System.out.println("+------------+--------+---------+---------------------+");

//     } catch (DateTimeParseException e) {
//         System.out.println("❌ Invalid date format. Use yyyy-MM-dd.");
//     }
// }

private void saveToFile(List<String> transactions) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Save Transaction History");
    fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

    int userSelection = fileChooser.showSaveDialog(null);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();

        // Add .txt extension if not provided
        if (!fileToSave.getName().endsWith(".txt")) {
            fileToSave = new File(fileToSave.getAbsolutePath() + ".txt");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
            // ✅ Write account holder's name and account number first
            writer.write("Account Holder : " + name + "\n");
            writer.write("Account Number : " + accountNumber + "\n");
            writer.write("IFSC Code      : " + IFSC_CODE + "\n");
            writer.write("\n");

            // 🧾 Write transaction history table
            writer.write("+------------+--------+---------+---------------------+\n");
            writer.write("| Type       | Amount | Balance | Time                |\n");
            writer.write("+------------+--------+---------+---------------------+\n");

            for (String entry : transactions) {
                String[] parts = entry.split("\\|");
                writer.write(String.format("| %-10s | %6s | %7s | %-19s |\n",
                        parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim()));
            }

            writer.write("+------------+--------+---------+---------------------+\n");
            System.out.println("✅ File saved successfully to: " + fileToSave.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("❌ Error saving file: " + e.getMessage());
        }
    } else {
        System.out.println("⚠️ File save cancelled by user.");
    }
}







public void displayTransactionsByDateRange(String startDate, String endDate) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    List<String> filteredTransactions = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    try {
        LocalDateTime start = LocalDateTime.parse(startDate + " 00:00:00", formatter);
        LocalDateTime end = LocalDateTime.parse(endDate + " 23:59:59", formatter);

        System.out.println("+------------+--------+---------+---------------------+");
        System.out.println("| Type       | Amount | Balance | Time                |");
        System.out.println("+------------+--------+---------+---------------------+");

        boolean found = false;

        for (String entry : transactionHistory) {
            String[] parts = entry.split("\\|");
            if (parts.length < 4) continue;

            LocalDateTime txTime = LocalDateTime.parse(parts[3].trim(), formatter);

            if (!txTime.isBefore(start) && !txTime.isAfter(end)) {
                found = true;
                filteredTransactions.add(entry);
                System.out.printf("| %-10s | %6s | %7s | %-19s |\n",
                        parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim());
            }
        }

        if (!found) {
            System.out.println("|    No transactions in this date range.           |");
        }

        System.out.println("+------------+--------+---------+---------------------+");

        if (found) {
            System.out.print("Do you want to save this history to a file? (yes/no): ");
            String response = sc.nextLine().trim().toLowerCase();
            if (response.equals("yes") || response.equals("y")) {
                saveToFile(filteredTransactions);
            }
        }

    } catch (DateTimeParseException e) {
        System.out.println("❌ Invalid date format. Use yyyy-MM-dd.");
    }
}

}
