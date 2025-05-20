class Ok{
    double add(double a,double b){
        return a+b;
    }
}
public class demo {

    public static void main(String[] args) {
        Double p1=new Double(10.0);//wrapped calss object
        Double p2=new Double(20.0);//wrapped calss object

        Ok k=new Ok(); //instance object
        System.out.println(k.add(19, 56));
        System.out.println(k.add(p1, p2));

        double x1=10.0;
        System.out.println(p1==x1);//true
    }
}