
import java.util.Scanner;
public class prime 
{
    public static void main(String[] args) {
        int i,n,sum=0,check;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a number");
        n=sc.nextInt();
         System.out.println("the factors are ");
        check=n+1;
        for(i=1;i<=n;i++)
        {
            if(n%i==0)
            {
                sum=sum+i;
                System.out.print(i+" ");
            }
        }
        
        System.out.println();
        if(sum==check)
        {
            System.out.println(n+" is prime number");
        }
        else{
            System.out.println(n+" is not a prime number");
        }
    }
}






// import java.util.Scanner;
// public class prime 
// {
//     public static void main(String[] args) {
//         int i,n,sum=0,count=0;
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter a number");
//         n=sc.nextInt();
//          System.out.println("the factors are ");
//         for(i=1;i<=n;i++)
//         {
//             if(n%i==0)
//             {
//                 sum=sum+i;
//                 System.out.print(i+" ");
//                 count++;
//             }
//         }
//         System.out.println();
//         if(count==2)
//         {
//             System.out.println(n+" is prime number");
//         }
//         else{
//             System.out.println(n+" is not a prime number");
//         }
        
//     }
    
// }