import java.util.Scanner;

public class binary {
public static void main(String[] args) {
    
    int i,left,right,mid,key;
    System.out.println("enter the size of an array");
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] a=new int[n];
    System.out.println("enter the values for an array in sorted format");
    for(i=0;i<n;i++)
    {
        a[i]=sc.nextInt();
    }
    System.out.println("enter the element to search");
    key=sc.nextInt();
    left=a[0];
    right=a.length-1;
    while (left<=right) 
    {
       mid=(left+right)/2; 

       if (key==a[mid]) 
       {
        System.out.println("element found at "+mid);
        return;
       }
       else if (key>a[mid]) 
       {
        left=mid+1;
        
       }
       else{
        right=mid-1;
       }
    }
    System.out.println(" element not found ");
}
    
}