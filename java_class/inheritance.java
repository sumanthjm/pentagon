class food{

}
class dosa extends food{

}
class biriyani extends food{

}
class masaladosa extends food{

}
class chic_biri extends biriyani{

}

public class inheritance {

    public static void main(String[] args) 
    {
    food f=new food();
    food f1=new dosa();
    food f2=new masaladosa();
    food f3=new biriyani();
    food f4=new chic_biri();
    // if (f instanceof food) 
    // {
    // System.out.println("true");    
    // }
    // else{
    //     System.out.println("false");///true
    // }
    
    // if (f1 instanceof food) 
    // {
    // System.out.println("true");    
    // }
    // else{
    //     System.out.println("false");
    // }//true

    // if (f2 instanceof chic_biri) 
    // {
    // System.out.println("true");    
    // }
    // else{
    //     System.out.println("false");
// }
}
}