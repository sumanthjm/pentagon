package stars;

import java.util.Scanner;
public class square {
    public static void main(String[] args) {
        int i ,j,n;
        System.out.println("enter the size ");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                if (i==1||i==n||j==1||j==n||(i+j)==n+1) 
                {
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
    }
}
}