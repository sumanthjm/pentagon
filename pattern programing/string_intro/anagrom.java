// package string;
// import java.util.Scanner;
// public class anagrom {

//     public static void main(String[] args) {
//         System.out.println("enter two strings ");
//         String a,b;
//         Scanner sc=new Scanner(System.in);
//         a=sc.next();
//         b=sc.next();
//         char ara[]=a.toCharArray();
//         char arb[]=b.toCharArray();
//         Check  ck=new Check();
//         if (ara.length==arb.length) 
//         {
//         ck.check_anagram(ara, arb);
//         }
//         else{
//             System.out.println("not anagram ");
//         }

        

//     }
// }
// class Check{

//         void check_anagram(char ara[],char arb[])
//         {
//             char b;
//             for(int i=0;i<ara.length;i++)
//             {
//                 for(int j=0;j<ara.length-1;j++)
//                 {
//                     if(ara[j]>ara[j+1])
//                     {
//                         b=ara[j];
//                         ara[j]=ara[j+1];
//                         ara[j+1]=b;
//                     }

//                     if(arb[j]>arb[j+1])
//                     {
//                         b=arb[j];
//                         arb[j]=arb[j+1];
//                         arb[j+1]=b;
//                     }
//                 }

//             }
//             for(int i=0;i<ara.length;i++)
//             {
//                 if (ara[i]!=arb[i]) 
//                 {
//                     System.out.println("not anagram");
//                     return;
//                 }
//             }
//             System.out.println("anagram ");
//         }
//     }
    


import java.util.Scanner;
public class anagrom {

    public static void main(String[] args) {
        System.out.println("enter two strings ");
        String a,b;
        Scanner sc=new Scanner(System.in);
        a=sc.next();
        b=sc.next();
        char ara[]=a.toCharArray();
        char arb[]=b.toCharArray();
        Check  ck=new Check();
        if (ara.length==arb.length) 
        {
        ck.check_anagram(ara, arb);
        }
        else{
            System.out.println("not anagram ");
        }

        

    }
}
class Check{

        void check_anagram(char ara[],char arb[])
        {
            char b;
            for(int i=0;i<ara.length;i++)
            {
                for(int j=0;j<ara.length-1;j++)
                {
                    if(ara[j]>ara[j+1])
                    {
                        b=ara[j];
                        ara[j]=ara[j+1];
                        ara[j+1]=b;
                    }

                    if(arb[j]>arb[j+1])
                    {
                        b=arb[j];
                        arb[j]=arb[j+1];
                        arb[j+1]=b;
                    }
                }

            }
          
            String lastaa=new String();
            String lastab=new String();
            lastaa=ara.toString();
            lastab=arb.toString();
            if (lastaa.equals(lastab)) {
            System.out.println("anagram ");
                
            }
            else{
            System.out.println(" not anagram ");

            }
        }
    }
    
