import java.util.Scanner;

public class Login {
    public void login(){

        boolean exit1 = false;
        int option1;
        System.out.println("enter ur option ");
        Scanner sc=new Scanner(System.in);
        CreateAcc acc=new CreateAcc();
        while (!exit1) {
            System.out.println("1]View Acc Details");
            System.out.println("2]Deposits");
            System.out.println("3]Withdraw");
            System.out.println("4]logout");
            System.out.print("Enter your choice: ");
            option1 = sc.nextInt();

            switch (option1) {
                case 1:  // create account 
                    System.out.println("name :"+acc.getName());
                    System.out.println("email"+acc.getEmail());
                    System.out.println("phone"+acc.getPhone());
                    System.out.println("balance"+acc.getBalance());
                    System.out.println("please enter ur old pass to display");
                    
                        if(sc.nextLine()==acc.getPassword()){

                            System.out.println("password: "+acc.getPassword());
                        }
                    break;

                case 2:  // deposits
                    System.out.println("enter amount to deposits");
                    int amt=sc.nextInt();
                    if(amt>0){
                        acc.setDeposit(amt);
                        System.out.println("Deposit Done Successfully");
                        System.out.println("Your updated Balance is ");
                        acc.getBalance();
                    }
                    break;
                
                case 3:  // withdraw
                    System.out.println("Enter withdraw (amount) < Balance amt");
                    int withdrawAmt=sc.nextInt();
                    if((withdrawAmt>0)&&(withdrawAmt<acc.getBalance()))
                    {
                        acc.setWithdraw(withdrawAmt);
                        System.out.println("Your updated Balance is ");
                        acc.getBalance();
                    }
                    else{
                        System.out.println("amount should not be greater than balance");
                    }
                    break;

                case 4:  // lagout
                    exit1 = true;
                    System.out.println("Thank you for using our bank services now u r back to main manu.");
                    break;

                default:  // Invalid Option
                    System.out.println("Invalid option. Please try again.");
            }



}




    }
}
