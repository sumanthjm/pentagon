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
            System.out.println("4] View All Transaction History");
            System.out.println("5] View Transaction History");
            System.out.println("6] Logout");
            System.out.print("Enter your choice: ");
            int option1 = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (option1) {
                case 1:
                    System.out.println("Name   : " + acc.getName());
                    System.out.println("Email  : " + acc.getEmail());
                    System.out.println("Phone  : " + acc.getPhone());
                    System.out.print("Enter password to view balance: ");
                    String pass = sc.nextLine();
                    if (pass.equals(acc.getPassword())) {
                        System.out.println("Balance: ₹" + acc.getBalance());
                    } else {
                        System.out.println("Incorrect password.");
                    }
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    int depositAmt = sc.nextInt();
                    if (depositAmt > 0) {
                        acc.setDeposit(depositAmt);
                        System.out.println("Deposit successful. Updated Balance: ₹" + acc.getBalance());
                    } else {
                        System.out.println("Amount must be greater than 0.");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmt = sc.nextInt();
                    if (withdrawAmt > 0 && withdrawAmt <= acc.getBalance()) {
                        acc.setWithdraw(withdrawAmt);
                        System.out.println("Withdrawal successful. Updated Balance: ₹" + acc.getBalance());
                    } else {
                        System.out.println("Invalid amount or insufficient balance.");
                    }
                    break;

                case 4:
                    System.out.println("--- Transaction History ---");
                    for (String record : acc.getTransactionHistory()) {
                        System.out.println(record);
                    }
                    if (acc.getTransactionHistory().isEmpty()) {
                        System.out.println("No transactions yet.");
                    }
                    break;
                case 5: 
                    System.out.println("Enter num of recent transction to display");
                    int recent=sc.nextInt();
                    System.out.println("--- Transaction History ---");
                    for(String cr:acc.getrecentHistroy(recent)){
                    System.out.println(cr);
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
