// public class type_casting 
// {
//     void add(int a,int b)
//     {
//         System.out.println("int ");
//     }
//     void add(byte a,byte b)
//     {
//         System.out.println("byte ");
//     }

//     void add(double a,double b)
//     {
//         System.out.println("double ");
//     }
//     void add(long a,long b)
//     {
//         System.out.println("long ");
//     }
//     void add(float a,float b)
//     {
//         System.out.println("float");
//     }

//     void add(char a,char b)
//     {
//         System.out.println(a+" "+b);
//     }

//     public static void main(String[] args) 
    
//     {
//        byte a=10;
//        byte b=20;
//        char c=67;
//        char d=68;

//         type_casting m=new type_casting();
//         m.add(c, d);
//     }
// }

public class type_casting 
{
    
    void add(int a,int b)
    {
        System.out.println("int");
    }
    void add(double a,double b)
    {
        System.out.println("double ");
    }


    void add(float a,float b)
    {
        System.out.println("float"+a);
    }

    public static void main(String[] args) 
    
    {
       

        type_casting m=new type_casting();
        m.add(10.67, 29.0);
    }
}
