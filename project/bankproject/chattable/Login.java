// package BankGPT;
import java.util.Scanner;

public class Login {
    public void login(CreateAcc acc) {
        Scanner sc = new Scanner(System.in);
        boolean exit1 = false;

        while (!exit1) {
            System.out.println("\n--- Account Menu ---");
            System.out.println("1] View Account Details");
            System.out.println("2] Deposit");
            System.out.println("3] Withdraw");
            System.out.println("4] View Transaction History");
            System.out.println("5] Change Password");
            System.out.println("6] Logout");
            System.out.println("+----------------------------+");
            System.out.println("+---- Enter your choice -----+");
            System.out.println("+----------------------------+");
            int option1 = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (option1) {
                case 1:
                    // System.out.println("+----------------------------+");
                    System.out.println("+----- Account Details ------+");
                    // System.out.println("+----------------------------+");
                    System.out.println("Name   : " + acc.getName());
                    System.out.println("Email  : " + acc.getEmail());
                    System.out.println("Phone  : " + acc.getPhone());
                    System.out.println("Account Number: " + acc.getAccountNumber());
                    System.out.println("IFSC Code     : " + acc.getIfscCode());
                    System.out.print("Enter password to view balance: ");
                    String pass = sc.nextLine();
                    if (pass.equals(acc.getPassword())) {
                        System.out.println("Balance: ₹" + acc.getBalance());
                    } else {
                        System.out.println("Incorrect password.");
                    }
                    break;

                case 2:
                    // System.out.println("+----------------------------+");
                    System.out.println("+--Enter Amount To Deposit --+");
                    // System.out.println("+----------------------------+");
                    int depositAmt = sc.nextInt();
                    if (depositAmt > 0) {
                        acc.setDeposit(depositAmt);
                        // System.out.println("+----------------------------+");
                        System.out.println("+------Deposit successful ---+");
                        System.out.println("+--Updated Balance: "+"$" + acc.getBalance());
                    } else {
                        System.out.println("!!!!!!-Amount must be greater than 0.-!!!!!");
                    }
                    break;

                case 3:
                    // System.out.println("+----------------------------+");
                    System.out.println("+--Enter Amount To Withdraw -+");
                    // System.out.println("+----------------------------+");
                    int withdrawAmt = sc.nextInt();
                    if (withdrawAmt > 0 && withdrawAmt <= acc.getBalance()) {
                        acc.setWithdraw(withdrawAmt);
                        // System.out.println("+----------------------------+");
                        System.out.println("+------Withdraw successful --+");
                        System.out.println("+--Updated Balance: "+"$" + acc.getBalance());
                    } else {
                        System.out.println("Invalid amount or insufficient balance.");
                    }
                    break;

                case 4:
                    boolean histroyexit = false;
                    while (!histroyexit){
                    System.out.println("1] View All Transaction History");
                    System.out.println("2] Save Transactions by Date Range");
                    System.out.println("3] View Recent Transaction History");
                    System.out.println("4] Back To Account Menu");
                    System.out.println("+---- Enter your choice -----+");
                    
                    int histroyoption1 = sc.nextInt();
                    
                    switch (histroyoption1) {
                        case 1:
                        System.out.println("--- Transaction History ---");
                    // for (String record : acc.getTransactionHistory()) {
                    //     System.out.println(record);
                    // }
                    // if (acc.getTransactionHistory().isEmpty()) {
                    //     System.out.println("No transactions yet.");
                    // }
                    acc.displayAllTransactions();
                    break;

                    case 2:
                        sc.nextLine(); // clear buffer
                    System.out.print("Enter start date (yyyy-MM-dd): ");
                    String start = sc.nextLine();
                    System.out.print("Enter end date (yyyy-MM-dd): ");
                    String end = sc.nextLine();
                    acc.displayTransactionsByDateRange(start, end);
                    break;

                    case 3:
                    System.out.println("Enter num of recent transction to display");
                    int recent=sc.nextInt();
                    System.out.println("--- Transaction History ---");
                    // for(String cr:acc.getrecentHistroy(recent)){
                    // System.out.println(cr);
                    acc.displayRecentTransactions(recent);
                    
                    break;

                    case 4:
                    histroyexit = true;
                    System.out.println("Exit From Transaction. Returning to Account menu.");
                    break;

                    default:
                    System.out.println("Invalid option. Please try again.");
                    }
                    }
                    
                    
              
                    
                
                case 5:
                    System.out.print("Enter current password: ");
                    String oldPass = sc.nextLine();
                    if (oldPass.equals(acc.getPassword())) {
                        System.out.print("Enter new password: ");
                        String newPass1 = sc.nextLine();
                        System.out.print("Confirm new password: ");
                        String newPass2 = sc.nextLine();
                    
                        if (newPass1.equals(newPass2)) {
                            acc.setPassword(newPass1);
                            System.out.println("✅ Password changed successfully.");
                        } else {
                            System.out.println("❌ Passwords do not match.");
                        }
                    } else {
                        System.out.println("❌ Incorrect current password.");
                    }
                    break;
                
                case 6:
                    exit1 = true;
                    System.out.println("Logged out successfully. Returning to main menu.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
