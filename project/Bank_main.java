// class classic_pizza
// {
//     double getprice()
//     {
//         return 50;
//     } 
// }

// class onion_pizza extends classic_pizza
// {
    
//     double getprice()
//     {
//         return 80;
//     }
// }
// class capsicum_pizza extends classic_pizza
// {
//     @Override
//     double getprice()
//     {
//         return 90;
//     } 
// }
// class corn_pizza extends classic_pizza
// {
//     @Override
//     double getprice()
//     {
//         return 200;
//     } 
// }
// public class overriding 
// {
//     public static void main(String[] args) {
//         classic_pizza c1=new classic_pizza();
//         System.out.println("classic pizza rate: "+c1.getprice());
//         onion_pizza o1=new onion_pizza();
//         System.out.println("onion pizza rate: "+o1.getprice());
//         capsicum_pizza c2=new capsicum_pizza();
//         System.out.println("capsicum pizza rate: "+c2.getprice());
//         corn_pizza c3=new corn_pizza();
//         System.out.println("corn pizza rate: "+c3.getprice());
//     }
// }


import java.util.Scanner;

// Encapsulated Bank class
class Bank {
    private double accNo;
    private String accName;
    private double balance;
    private int pin;
    private String email;

    public double getAccNo() {
        return accNo;
    }

    public void setAccNo(double accNo) {
        this.accNo = accNo;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void changePin(int newPin) {
        this.pin = newPin;
        System.out.println("PIN changed successfully.");
    }
}

public class Bank_main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank b = new Bank();

        System.out.println("---- Welcome to Bank Setup ----");
        System.out.print("Enter Account Number: ");
        b.setAccNo(sc.nextDouble());

        sc.nextLine();  // consume leftover newline

        System.out.print("Enter Account Name: ");
        b.setAccName(sc.nextLine());

        System.out.print("Enter Email: ");
        b.setEmail(sc.nextLine());

        System.out.print("Enter Initial Balance: ");
        b.setBalance(sc.nextDouble());

        System.out.print("Set 4-digit PIN: ");
        b.setPin(sc.nextInt());

        int choice;
        do {
            System.out.println("\n==== Bank Menu ====");
            System.out.println("1. View Account Details");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Change PIN");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Account Number: " + b.getAccNo());
                    System.out.println("Account Name: " + b.getAccName());
                    System.out.println("Email: " + b.getEmail());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    b.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    b.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Current Balance: " + b.getBalance());
                    break;

                case 5:
                    System.out.print("Enter new 4-digit PIN: ");
                    int newPin = sc.nextInt();
                    b.changePin(newPin);
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
