// import java.util.Scanner;
// public class up_to_low {

//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         String str=sc.next();
//         char [] a=str.toCharArray();
//         String sum="";
//         for(int i=0;i<=a.length-1;i++)
//         {
//             char c=a[i];
//             if(c>=65&&c<91)
//             {
//                 sum=sum+(char)(c+32);
//             }
//             else{
//                 sum=sum+c;
//             }
//         }
//         System.out.println(sum);

//     }
// }

import java.util.Scanner;
public class up_to_low {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        char [] a=str.toCharArray();
        String sum="";
        for(int i=0;i<=a.length-1;i++)
        {
            char c=a[i];
            if(c>=97&&c<123)
            {
                sum=sum+(char)(c-32);
            }
            else if(c>=65&&c<91)
            {
                sum=sum+(char)(c+32);
            }
        }
        System.out.println(sum);
    }
}