package com.bankmsys;
import java.sql.Date;

public class CreateAcc {
    private int accountNumber;
    private String name;
    private String email;
    private long phone;
    private Date dob;
    private int balance;
    private String password;

    // Getters & Setters
    public int getAccountNumber() { return accountNumber; }
    public void setAccountNumber(int accountNumber) { this.accountNumber = accountNumber; }

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
}
