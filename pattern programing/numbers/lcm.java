import java.util.Scanner;
public class lcm 
{
    public static void main(String[] args) 
    {
        int i,a,b,hcf=0;
        Scanner sc= new Scanner(System.in);
        System.out.println("enter 2 numbers");
        a=sc.nextInt();
        b=sc.nextInt();
        System.out.println("the common factors are");
        for(i=1;i<=a;i++)
        {
            if(a%i==0 && b%i==0){
                System.out.print(i+" ");
                hcf=i;
            }
        }
        System.out.println();
        System.out.println("HCF : "+hcf);
        System.out.println();
        int lcm=0;
        lcm=(a*b)/hcf;
        System.out.println("LCM : "+lcm);

    }
}