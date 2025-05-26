import java.util.Scanner;

interface Calculator {
    void add();
    void sub();
}

class MyCalculator1 implements Calculator {
    @Override
    public void add() {
        int a = 200;
        int b = 100;
        System.out.println(a+b);
    }

    @Override
    public void sub() {
        int a = 200;
        int b = 100;
        System.out.println(a-b);
    }
}

class MyCalculator2 implements Calculator {
    @Override
    public void add() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first number");
        int a = scan.nextInt();
        System.out.println("Enter the second number");
        int b = scan.nextInt();
        System.out.println(a+b);
    }

    @Override
    public void sub() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first number");
        int a = scan.nextInt();
        System.out.println("Enter the second number");
        int b = scan.nextInt();
        System.out.println(a-b);
    }
}



class MyCalculator3 implements Calculator {
    @Override
    public void add() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first number");
        int a = scan.nextInt();
        System.out.println("Enter the second number");
        int b = scan.nextInt();
        if (a == 0 || b == 0) {
            System.out.println("Invalid Input");
        } else {
            System.out.println(a + b);
        }
    }

    @Override
    public void sub() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first number");
        int a = scan.nextInt();
        System.out.println("Enter the second number");
        int b = scan.nextInt();
        if (a == 0 || b == 0) {
            System.out.println("Invalid Input");
        } else {
            System.out.println(a - b);
        }
    }
}
class Checking{
    Calculator c;
    Checking(Calculator obj){
        c=obj;
    }
    public void printing(){
        c.add();
        c.sub();
    }
}

public class Mani {
    public static void main(String[] args) {
        MyCalculator1 mc1 = new MyCalculator1();
        MyCalculator2 mc2 = new MyCalculator2();
        MyCalculator3 mc3 = new MyCalculator3();

       Checking chk=new Checking(mc3
       );
       chk.printing();
    }
}