interface PaymentMode {
    public abstract void payment();
    
}
class Credic_Card implements PaymentMode {

    public void payment(){
        System.out.println("payment is done by !!Credit card!!");
    }
}

class Debit_Card implements PaymentMode{

    public void payment(){
        System.out.println("payment is done by !!Debit card!!");
    }
}
class Cod implements PaymentMode{

    public void payment(){
        System.out.println("payment is done in !!CASH ON DELIVERY!!");
    }
}
class Flipcart{
    PaymentMode ref;
        Flipcart(PaymentMode p){
        ref=p;
    }

   public void checkOut(){
        ref.payment();
    }
}



public class Demo {

    public static void main(String[] args) {
        Credic_Card c=new Credic_Card();
        Debit_Card d=new Debit_Card();
        Cod co=new Cod();
        Flipcart f=new Flipcart(c);
        f.checkOut();
    }
}