// // package BankGPT;
// import java.util.Scanner;

// public class Login {
//     public void login(CreateAcc acc) {
//         Scanner sc = new Scanner(System.in);
//         boolean exit1 = false;

//         while (!exit1) {
//             System.out.println("\n--- Account Menu ---");
//             System.out.println("1] View Account Details");
//             System.out.println("2] Deposit");
//             System.out.println("3] Withdraw");
//             System.out.println("4] Update Phone Number");
//             System.out.println("5] Update Password");
//             System.out.println("6] Logout");
//             System.out.print("Enter your choice: ");
//             int option1 = sc.nextInt();
//             sc.nextLine(); // clear buffer

//             switch (option1) {
//                 case 1:
//                     System.out.println("Name   : " + acc.getName());
//                     System.out.println("Email  : " + acc.getEmail());
//                     System.out.println("Phone  : " + acc.getPhone());
//                     System.out.println("Date Of Birth  : " + acc.getDob());
//                     System.out.println("Balance: ₹" + acc.getBalance());
                    
//                     break;

//                 case 2:
//                     System.out.print("Enter amount to deposit: ");
//                     int depositAmt = sc.nextInt();
//                     if (depositAmt > 0) {
//                         acc.setDeposit(depositAmt);
//                         System.out.println("Deposit successful. Updated Balance: ₹" + acc.getBalance());
//                     } else {
//                         System.out.println("Amount must be greater than 0.");
//                     }
//                     break;

//                 case 3:
//                     System.out.print("Enter amount to withdraw: ");
//                     int withdrawAmt = sc.nextInt();
//                     if (withdrawAmt > 0 && withdrawAmt <= acc.getBalance()) {
//                         acc.setWithdraw(withdrawAmt);
//                         System.out.println("Withdrawal successful. Updated Balance: ₹" + acc.getBalance());
//                     } else {
//                         System.out.println("Invalid amount or insufficient balance.");
//                     }
//                     break;

//                 case 4:
//                     System.out.print("Enter new phone number: ");
//                     long newPhone = sc.nextLong();
//                     acc.setPhone(newPhone);
//                     System.out.println("Phone number updated successfully.");
//                     break;
                                
//                 case 5:
//                     System.out.print("Enter current password: ");
//                     String currentPwd = sc.next();
//                     if (acc.getPassword().equals(currentPwd)) {
//                         System.out.print("Enter new password: ");
//                         sc.nextLine(); // clear buffer
//                         String newPwd = sc.nextLine();
//                         acc.setPassword(newPwd);
//                         System.out.println("Password updated successfully.");
//                     } else {
//                         System.out.println("Incorrect current password.");
//                     }
//                     break;


//                 case 6:
//                     exit1 = true;
//                     System.out.println("Logged out successfully. Returning to main menu.");
//                     break;

//                 default:
//                     System.out.println("Invalid option. Please try again.");
//             }
//         }
//     }
// }


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
            System.out.println("4] Update Phone Number");
            System.out.println("5] Update Password");
            System.out.println("6] Logout");
            System.out.print("Enter your choice: ");
            int option1 = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (option1) {
                case 1:
                    System.out.println("Account Number : " + acc.getAccountNumber());
                    System.out.println("Name           : " + acc.getName());
                    System.out.println("Email          : " + acc.getEmail());
                    System.out.println("Phone          : " + acc.getPhone());
                    System.out.println("Date Of Birth  : " + acc.getDob());
                    System.out.println("Balance        : ₹" + acc.getBalance());
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
                    System.out.print("Enter new phone number: ");
                    long newPhone = sc.nextLong();
                    acc.setPhone(newPhone);
                    System.out.println("Phone number updated successfully.");
                    break;

                case 5:
                    System.out.print("Enter current password: ");
                    String currentPwd = sc.next();
                    if (acc.getPassword().equals(currentPwd)) {
                        sc.nextLine(); // clear newline
                        System.out.print("Enter new password: ");
                        String newPwd = sc.nextLine();
                        acc.setPassword(newPwd);
                        System.out.println("Password updated successfully.");
                    } else {
                        System.out.println("Incorrect current password.");
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
