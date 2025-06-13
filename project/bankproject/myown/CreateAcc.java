// package BankGPT;
import java.util.*;

public class CreateAcc {
    private String name;
    private String email;
    private long phone;
    private int balance = 0;
    private String password;
    private List<String> transactionHistory = new ArrayList<>();
    private List<String> transactionHistory2 = new ArrayList<>();

    public String getName() 
    { 
        return name; 
    }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public long getPhone() { return phone; }
    public void setPhone(long phone) { this.phone = phone; }

    public int getBalance() { return balance; }
    public void setBalance(int balance) { this.balance = balance; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public void setDeposit(int amt) {
        this.balance += amt;
        transactionHistory.add("Deposited: $" + amt + " | Balance: $" + balance);
    }

    public void setWithdraw(int amt) {
        this.balance -= amt;
        transactionHistory.add("Withdrew: $" + amt + " | Balance: $" + balance);
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public List<String> getrecentHistroy(int recent){
         for(int i=(transactionHistory.size()-recent);i<transactionHistory.size();i++){
            transactionHistory2.add(transactionHistory.get(i));
         }
         return transactionHistory2;
    }
}



