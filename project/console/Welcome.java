import java.util.Scanner;

public class Welcome {

    
public static void main(String[] args) {
    boolean exit = false;
    int option;
    Scanner sc=new Scanner(System.in);
    CreateAcc acc=new CreateAcc();
    Login l=new Login();

    while (!exit) {
            System.out.println("Welcome");
            System.out.println("1]Create Account");
            System.out.println("2]login");
            System.out.println("3]exit");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();

            switch (option) {
                case 1:  // create account 
                    System.out.println("enter ur name ");
                    String name=sc.nextLine();
                    acc.setName(name);
                    System.out.println("enter ur email");
                    String email=sc.nextLine();
                    acc.setEmail(email);
                    System.out.println("enter ur phone");
                    long ph=sc.nextInt();
                    acc.setPhone(ph);
                    // System.out.println("enter ur balance");
                    // acc.setBalance(sc.nextInt());
                    System.out.println("enter ur password");
                    String pass=sc.nextLine();
                    acc.setPassword(pass);
                    break;

                case 2:  // login
                    System.out.println("enter ur email and password");
                    if(sc.nextLine()==acc.getEmail() && sc.nextLine()== acc.getPassword()){
                    l.login();
                    }
                    else{
                        System.out.println("email and pass word doesnot matches ");
                    }
                    break;

                case 3:  // Exit
                    exit = true;
                    System.out.println("Thank you for using our bank services.");
                    break;

                default:  // Invalid Option
                    System.out.println("Invalid option. Please try again.");
            }



}
}
}