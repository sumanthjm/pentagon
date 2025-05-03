//*********using only return of remender only by line by line */

// import java.util.Scanner;
// public class reverce
// {
// public static void main(String[] args) {
//     int n,reverce=0,rem=0;
//     Scanner sc=new Scanner(System.in);
//     System.out.println("enter a number to exatract");
//     n=sc.nextInt();
//     while (n!=0)
//     {
//         rem=n%10;
//         n=n/10;
//         System.out.println(rem);
//     }
          
// }   
// }


//********  using method og genisis (soket & placement ) */

// import java.util.Scanner;
// public class reverce
// {
// public static void main(String[] args) {
//     int n,reverce=0,rem=0;
//     Scanner sc=new Scanner(System.in);
//     System.out.println("enter a number to exatract");
//     n=sc.nextInt();
//     while (n!=0)
//     {
//         rem=n%10;
//         reverce=reverce*10;
//         reverce=reverce+rem;
//         n=n/10;
        
//     }
//     System.out.println(reverce);      
// }   
// }



//******** palindrom   */

import java.util.Scanner;
public class reverce
{
public static void main(String[] args) {
    long n,reverce=0,rem=0;
    Scanner sc=new Scanner(System.in);
    System.out.println("enter a number to check palindrome");
    n=sc.nextLong();
    long check=n;
    while (n!=0)
    {
        rem=n%10;
        reverce=reverce*10;
        reverce=reverce+rem;
        n=n/10;
        
    }
    System.out.println("reverece of a number "+reverce); 
    if (reverce==check) 
    {
        System.out.println("given number "+check+" is a palindrome");
    }   
    else
    {
        System.out.println("given number "+check+" is !-NOT-! palindrome");
    }
}   
}
