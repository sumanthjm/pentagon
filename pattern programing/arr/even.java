// import java.util.Scanner;
// public class even 
// {
//     public static void main(String[] args) {
//         System.out.println("enter the size of an array ");
//         Scanner sc=new Scanner(System.in);
//         int n,i,count=0;
//         n=sc.nextInt();
//         int[] a=new int[n];
//         System.out.println("enter the values for arrays ");
//         for(i=0;i<n;i++)
//         {
//             a[i]=sc.nextInt();
//         }
        
//         for(i=0;i<n;i++)
//         {
//             if (a[i]%2==0)
//             {
//                 count++;
//                 if (count==1) 
//                 {
//                     System.out.println("even numbers are ");
//                 }
//                 System.out.print("_"+a[i]);
//             }
//         }
//         if (count==0) 
//         {
//             System.out.println("there is no evn number exist ");
//         }
        
//     }
    
// }

//-----------------------------------------------------------------------
//prime number 

// import java.util.Scanner;
// public class even 
// {
//     public static void main(String[] args) {
//         System.out.println("enter the size of an array ");
//         Scanner sc=new Scanner(System.in);
//         int n,i,check=0,sum,count=0,che;
//         n=sc.nextInt();
//         int[] a=new int[n];
//         System.out.println("enter the values for arrays ");
//         for(i=0;i<n;i++)
//         {
//             a[i]=sc.nextInt();
//         }

//         for(i=0;i<n;i++)
//         {
//             sum=0;
//             check=a[i]+1;
//             che=a[i];
//         for(i=1;i<=check-1;i++)
//           {
//             if (che%i==0)
//             {
//                 sum=sum+i; 
//             }
//           }
//                 if (sum==check) 
//                {
//                 count++;
//                 System.out.println(" prime number are "+(check-1));
//                }
        
//     }
//         if (count==0) 
//         {
//             System.out.println("there is no prime  number exist ");
//         }
        
//     }
    
// }

//--------------------------------------------------------------------------------------
//sum of digits in array





// import java.util.Scanner;
// public class even 
// {
//    static int  prime(int a)
//     {
//         int sum=0,check=a+1,total=0;
        
//         for(int i=1;i<=a;i++)
//         {
//             if (a%i==0) {
//                 sum=sum+i;
//             }
//           }
//         if (sum==check)
//         {
//             System.out.print("_"+a);
//             return a;
//         }
//         else{
//             return 0;
//         }
//     }



//     public static void main(String[] args) {
//         System.out.println("enter the size of an array ");
//         Scanner sc=new Scanner(System.in);
//         int n,i,check=0,sum=0,count=0,che;
//         n=sc.nextInt();
//         int[] a=new int[n];
//         System.out.println("enter the values for arrays ");
//         for(i=0;i<n;i++)
//         {
//             a[i]=sc.nextInt();
//         }
//         System.out.println("prime numbers are ");
//         for(i=0;i<n;i++)
//         {
//             sum=sum+prime(a[i]);
//         }
//         System.out.println();
//         System.out.println("sum of prime number are ="+sum);
//     }
// }

//--------------------------------------------------------------------------------------
//palinrome  

// import java.util.Scanner;
// public class even 
// {
//    static void  prime(int a)
//     {
//         int rem=0,rev=0,b=a;
        
//         for(int i=1;i<=a;i++)
//           {
//             rem=a%10;
//             rev=rev*10;
//             rev=rev+rem;
//             a=a/10;
//         }
//         if (rev==b) {
//             System.out.print(rev);
//         }
//     }



//     public static void main(String[] args) {
//         System.out.println("enter the size of an array ");
//         Scanner sc=new Scanner(System.in);
//         int n,i;
//         n=sc.nextInt();
//         int[] a=new int[n];
//         System.out.println("enter the values for arrays ");
//         for(i=0;i<n;i++)
//         {
//             a[i]=sc.nextInt();
//         }
//         System.out.println("palindrome are  ");
//         for(i=0;i<n;i++)
//         {
//             prime(a[i]);
//             System.out.println();
//         }
//         System.out.println();
        
//     }
// }

//---------------------------------------------------------------------------------------
// armstrong 

import java.util.Scanner;
import java.math.*;
public class even 
{
   static double  prime(int a)
    {
        int rem,n=a,count=0;
        while (n!=0)
        {
            count++;
            n=n/10;
        }
        int c=a,d=a;
        double pow=0,tol=0,power=0;
        while (c!=0) 
        {
            rem=c%10;
            power=rem;
            for(int i=1;i<=count-1;i++)
            {
                power=power*rem;
            }
            pow=power;
            tol=tol+pow;
            c=c/10;
        }
        if (tol==d) {
            System.out.println(tol);
            return tol;
        }
        else{
            return 0;
        }
    }



    public static void main(String[] args) {
        System.out.println("enter the size of an array ");
        Scanner sc=new Scanner(System.in);
        int n,i;
        double sum=0;
        n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("enter the values for arrays ");
        for(i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        System.out.println("armstrong  are  ");
        for(i=0;i<n;i++)
        {
            sum=sum+prime(a[i]);
        }
        System.out.println(" sum of armstrong number are "+sum);
        
        
    }
}