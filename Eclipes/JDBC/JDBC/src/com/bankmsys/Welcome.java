package com.bankmsys;
import java.util.*;
import java.sql.*;
import java.sql.Date;

public class Welcome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
                    try {
                        CreateAcc acc = new CreateAcc();

                        System.out.print("Enter your name: ");
                        acc.setName(sc.nextLine());

                        System.out.print("Enter your email: ");
                        acc.setEmail(sc.nextLine());

                        System.out.print("Enter your phone: ");
                        acc.setPhone(sc.nextLong());

                        System.out.print("Enter your DOB (yyyy-mm-dd): ");
                        acc.setDob(Date.valueOf(sc.next()));

                        sc.nextLine(); // clear newline
                        System.out.print("Create password: ");
                        acc.setPassword(sc.nextLine());

                        Connection con = DbUtil.getConnection();
                        PreparedStatement ps = con.prepareStatement(
                            "INSERT INTO users(name, email, phone, dob, password) VALUES (?, ?, ?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS
                        );
                        ps.setString(1, acc.getName());
                        ps.setString(2, acc.getEmail());
                        ps.setLong(3, acc.getPhone());
                        ps.setDate(4, acc.getDob());
                        ps.setString(5, acc.getPassword());

                        int result = ps.executeUpdate();
                        if (result > 0) {
                            ResultSet rs = ps.getGeneratedKeys();
                            if (rs.next()) {
                                acc.setAccountNumber(rs.getInt(1));
                                System.out.println("Account created successfully!");
                                System.out.println("Your Account Number is: " + acc.getAccountNumber());
                            }
                        }
                        con.close();
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter email: ");
                        String email = sc.nextLine();
                        System.out.print("Enter password: ");
                        String password = sc.nextLine();

                        Connection con = DbUtil.getConnection();
                        PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
                        ps.setString(1, email);
                        ps.setString(2, password);
                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {
                            CreateAcc acc = new CreateAcc();
                            acc.setAccountNumber(rs.getInt("accountNumber"));
                            acc.setName(rs.getString("name"));
                            acc.setEmail(rs.getString("email"));
                            acc.setPhone(rs.getLong("phone"));
                            acc.setDob(rs.getDate("dob"));
                            acc.setBalance(rs.getInt("balance"));
                            acc.setPassword(rs.getString("password"));

                            System.out.println("Login Successful.");
                            new Login().login(acc);
                        } else {
                            System.out.println("Invalid credentials.");
                        }
                        con.close();
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    exit = true;
                    System.out.println("Thanks for using GPT Bank!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
