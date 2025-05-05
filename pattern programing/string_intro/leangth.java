
import java.util.Scanner;
public class leangth {
    public static void main(String[] args) {
        System.out.println("enter a string");
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        char arra[]=a.toCharArray();
        int j,k,count=0;

        for(j=65,k=97;j<91;j++,k++)
        {
        for(char c:arra)
        {
            if(c==j||c==k)
            {
                count++;
                break;
            }
        }
        }
        if(count==26)
        {
            System.out.println(" panagram ");
        }
        else{
            System.out.println("not a panagram ");
        }
}
}
