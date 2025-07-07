// // package BankGPT;
// import java.util.*;

// public class Welcome {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         List<CreateAcc> accountList = new ArrayList<>();
//         boolean exit = false;

//         while (!exit) {
//             System.out.println("\n--- Welcome to GPT Bank ---");
//             System.out.println("1] Create Account");
//             System.out.println("2] Login");
//             System.out.println("3] Exit");
//             System.out.print("Enter your choice: ");
//             int option = sc.nextInt();
//             sc.nextLine(); // clear buffer

//             switch (option) {
//                 //create account
//                 case 1:
//                     CreateAcc newAcc = new CreateAcc();
//                     System.out.print("Enter your name: ");
//                     newAcc.setName(sc.nextLine());

//                     System.out.print("Enter your email: ");
//                     newAcc.setEmail(sc.nextLine());

//                     System.out.print("Enter your phone: ");
//                     newAcc.setPhone(sc.nextLong());

//                     System.out.print("Enter your Date of birth: (format yyyy-mm-dd)");
//                     newAcc.setDob(java.sql.Date.valueOf(sc.next()));

//                     System.out.print("Create your password: ");
//                     sc.nextLine();
//                     newAcc.setPassword(sc.nextLine());


//                     accountList.add(newAcc);
//                     System.out.println("Account created successfully!");
//                     break;

//                 case 2:
//                 //login
//                     System.out.print("Enter your email: ");
//                     String email = sc.nextLine();
//                     System.out.print("Enter your password: ");
//                     String password = sc.nextLine();

//                     CreateAcc foundAcc = null;
//                     for (CreateAcc acc : accountList) {
//                         if (acc.getEmail().equals(email) && acc.getPassword().equals(password)) {
//                             foundAcc = acc;
//                             break;
//                         }
//                     }

//                     if (foundAcc != null) {
//                         System.out.println("------------------------------------------");
//                         System.out.println("Login Successful");
//                         Login l = new Login();
//                         l.login(foundAcc);
//                     } else {
//                         System.out.println("Invalid email or password.");
//                     }
//                     break;

//                 case 3:
//                     exit = true;
//                     System.out.println("------------------------------------------");
//                     System.out.println("<<< Thank you >>> for using our bank services.");
//                     break;

//                 default:
//                     System.out.println("Invalid option. Please try again.");
//             }
//         }
//         sc.close();
//     }
// }


import java.util.*;
import java.sql.Date;

public class Welcome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<CreateAcc> accountList = new ArrayList<>();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Welcome to GPT Bank ---");
            System.out.println("1] Create Account");
            System.out.println("2] Login");
            System.out.println("3] Exit");
            System.out.print("Enter your choice: ");
            int option = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (option) {
                case 1:
                    CreateAcc newAcc = new CreateAcc();

                    System.out.print("Enter your name: ");
                    newAcc.setName(sc.nextLine());

                    System.out.print("Enter your email: ");
                    newAcc.setEmail(sc.nextLine());

                    System.out.print("Enter your phone: ");
                    newAcc.setPhone(sc.nextLong());

                    System.out.print("Enter your Date of birth (yyyy-mm-dd): ");
                    newAcc.setDob(Date.valueOf(sc.next()));

                    sc.nextLine(); // clear newline
                    System.out.print("Create your password: ");
                    newAcc.setPassword(sc.nextLine());

                    accountList.add(newAcc);
                    System.out.println("Account created successfully!");
                    System.out.println("Your Account Number is: " + newAcc.getAccountNumber());
                    break;

                case 2:
                    System.out.print("Enter your email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter your password: ");
                    String password = sc.nextLine();

                    CreateAcc foundAcc = null;
                    for (CreateAcc acc : accountList) {
                        if (acc.getEmail().equals(email) && acc.getPassword().equals(password)) {
                            foundAcc = acc;
                            break;
                        }
                    }

                    if (foundAcc != null) {
                        System.out.println("------------------------------------------");
                        System.out.println("Login Successful");
                        Login l = new Login();
                        l.login(foundAcc);
                    } else {
                        System.out.println("Invalid email or password.");
                    }
                    break;

                case 3:
                    exit = true;
                    System.out.println("------------------------------------------");
                    System.out.println("<<< Thank you >>> for using our bank services.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        sc.close();
    }
}
