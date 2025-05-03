// class bank{
//     private double ac_no;
//     String acc_name;
//     private double initball;
//     private int pin;
//     String mail;

//     public double getac_no()
//     {
//         return ac_no;
//     }
//     public void setac_no(double acc_no)
//     {
//         ac_no=acc_no;
//     }
//     public void setinitbal(double initbal)
//     {
//         this.initball=initbal;
//     }
//     public double getinitbal()
//     {
//         return initball;
//     }
//     public int getpin()
//     {
//         return pin;
//     }
//     public void setpin(int pinn)
//     {
//         this.pin=pinn;
//     }
//     public double deposit(double amt_cr)
//     {
//         double a=getinitbal();
//         initball+=a;
//         return a;
//     }
//     public double withdraw(double amt_db)
//     {
//         if (amt_db<=initball) 
//         {
//           initball-=amt_db;  
//         }
//         return initball;
//     }
//     public void change_pin(int new_pin)
//     {
//         int pin=new_pin;
        
//     }
    
// }
// public class Bank_main{

//     public static void main(String[] args) 
//     {
//         bank b=new bank();

//     }
// }


public class BankAccount {
    // Private data members
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String name, String accNumber, double initialBalance) {
        this.accountHolderName = name;
        this.accountNumber = accNumber;
        this.balance = initialBalance;
    }

    // Public getter and setter methods
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String name) {
        this.accountHolderName = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
