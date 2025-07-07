package com.bankmsys;
import java.util.*;
import java.sql.*;

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
            int choice = sc.nextInt();
            sc.nextLine();

            try (Connection con = DbUtil.getConnection()) {
                switch (choice) {
                    case 1:
                        System.out.println("Account No     : " + acc.getAccountNumber());
                        System.out.println("Name           : " + acc.getName());
                        System.out.println("Email          : " + acc.getEmail());
                        System.out.println("Phone          : " + acc.getPhone());
                        System.out.println("DOB            : " + acc.getDob());
                        System.out.println("Balance        : ₹" + acc.getBalance());
                        break;

                    case 2:
                        System.out.print("Enter deposit amount: ");
                        int depAmt = sc.nextInt();
                        acc.setBalance(acc.getBalance() + depAmt);
                        updateBalance(con, acc);
                        System.out.println("Deposited. New Balance: ₹" + acc.getBalance());
                        break;

                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        int wdAmt = sc.nextInt();
                        if (wdAmt <= acc.getBalance()) {
                            acc.setBalance(acc.getBalance() - wdAmt);
                            updateBalance(con, acc);
                            System.out.println("Withdrawn. New Balance: ₹" + acc.getBalance());
                        } else {
                            System.out.println("Insufficient funds.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter new phone: ");
                        long newPhone = sc.nextLong();
                        acc.setPhone(newPhone);
                        PreparedStatement ps1 = con.prepareStatement("UPDATE users SET phone=? WHERE accountNumber=?");
                        ps1.setLong(1, newPhone);
                        ps1.setInt(2, acc.getAccountNumber());
                        ps1.executeUpdate();
                        System.out.println("Phone updated.");
                        break;

                    case 5:
                        System.out.print("Enter current password: ");
                        String current = sc.nextLine();
                        if (acc.getPassword().equals(current)) {
                            System.out.print("Enter new password: ");
                            String newPwd = sc.nextLine();
                            acc.setPassword(newPwd);
                            PreparedStatement ps2 = con.prepareStatement("UPDATE users SET password=? WHERE accountNumber=?");
                            ps2.setString(1, newPwd);
                            ps2.setInt(2, acc.getAccountNumber());
                            ps2.executeUpdate();
                            System.out.println("Password updated.");
                        } else {
                            System.out.println("Incorrect password.");
                        }
                        break;

                    case 6:
                        exit1 = true;
                        System.out.println("Logged out.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void updateBalance(Connection con, CreateAcc acc) throws SQLException {
        PreparedStatement ps = con.prepareStatement("UPDATE users SET balance=? WHERE accountNumber=?");
        ps.setInt(1, acc.getBalance());
        ps.setInt(2, acc.getAccountNumber());
        ps.executeUpdate();
    }
}
