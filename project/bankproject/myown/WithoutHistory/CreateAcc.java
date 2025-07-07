// // package BankGPT;
// import java.util.*;
// import java.sql.*;

// public class CreateAcc {
//     private String name;
//     private String email;
//     private long phone;
//     private java.sql.Date dob;
//     private int balance = 0;
//     private String password;
//     public String getName()
//     { 
//         return name; 
//     }
//     public void setName(String name) { this.name = name; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public long getPhone() { return phone; }
//     public void setPhone(long phone) { this.phone = phone; }

//     public java.sql.Date getDob() 
//     { 
//         return dob; 
//     }

//     public void setDob(java.sql.Date dob) {
//         this.dob = dob;
//     }

//     public int getBalance() { return balance; }
//     public void setBalance(int balance) { this.balance = balance; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }

//     public void setDeposit(int amt) {
//         this.balance += amt;
//     }

//     public void setWithdraw(int amt) {
//         this.balance -= amt;
//     }
// }





import java.sql.Date;

public class CreateAcc {
    private static int accountCounter = 1000; // auto increment base

    private int accountNumber;
    private String name;
    private String email;
    private long phone;
    private Date dob;
    private int balance = 0;
    private String password;

    public CreateAcc() {
        this.accountNumber = ++accountCounter;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public long getPhone() { return phone; }
    public void setPhone(long phone) { this.phone = phone; }

    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }

    public int getBalance() { return balance; }
    public void setBalance(int balance) { this.balance = balance; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public void setDeposit(int amt) {
        this.balance += amt;
    }

    public void setWithdraw(int amt) {
        this.balance -= amt;
    }
}
