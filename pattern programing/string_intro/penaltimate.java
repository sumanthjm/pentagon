// import java.util.Scanner;
// public class penaltimate {
//    public static void main(String[] args) {
//     Scanner sc=new Scanner(System.in);
//     System.out.println("enter a string ");
//     String sample=sc.nextLine();
//     char[] arra=sample.toCharArray();
//     int word=1;
//     for(char i:arra)
//     {
//         if (i==' ') {
//         word++; 
//         }
//     }
//     System.out.println(" there are :"+word+" words ");  
//     if (word==1) 
//     {
//         System.out.println(" Not penaltimates ");
//     }  
//     
//     else
//     {
//         int count=0;
//         for(char i:arra)
//         {
//             if(i!=' ')
//             {
                
//                 if (count>=word-1) {
//                     break;
//                 }
//                 else
//                 {
//                     System.out.print(i);
//                 }
//             }
//             else if (i==' ') {
                
            
//                 System.out.print(i);
//                 count++;
//                 }
//             }
//         }
        

//     }
//     }

    

import java.util.Scanner;
public class penaltimate{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a string ");
        String sample = sc.nextLine();
        char[] arra = sample.toCharArray();
        int word = 1;

        for (char i : arra) {
            if (i == ' ') {
                word++;
            }
        }

        System.out.println(" there are :" + word + " words ");
        
        if (word == 1) {
            System.out.println(" Not penaltimates ");
        } 
        
        else {
            int count = 0;
            for (int i = 0; i < arra.length; i++) {
                if (arra[i] == ' ') 
                {
                    count++;
                    if (count == word - 1) {
                        break; // stop before the last word
                    }
                }
                System.out.print(arra[i]);
            }
        }
    }
}
