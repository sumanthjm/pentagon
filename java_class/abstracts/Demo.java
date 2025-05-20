package abstracts;
// abstract class Bird{
//     abstract void canFly();
//     abstract void haveWings();
//     abstract void canEat();
    
// } 
// class Parrot extends Bird{
    
//     void canFly(){
//         System.out.println("parrot can Fly");
//     }
//     void haveWings(){
//         System.out.println("parrot have wing");
//     }
//     void canEat(){
//         System.out.println("parrot can eat");
//     }
// }


// abstract class Eagle extends Bird{
    
    
//     abstract void canEat(); 
// }
// class GoldenEgle extends Eagle{
//     void canFly(){
//         System.out.println("Golden Eagle can Fly");
//     }  
//     void haveWings(){
//         System.out.println("golden Eagle have wing");
//     }
//     void canEat(){
//         System.out.println("Golden egle eats fish ");
//     }
// }


// class Serpentegle extends Eagle{
//     void canFly(){
//         System.out.println(" serpent Eagle can Fly");
//     }  
//     void haveWings(){
//         System.out.println("serpent Eagle have wing");
//     }
//     void canEat(){
//         System.out.println("Serpent egle eats Snake ");
//     }
// }


// class Sparrow extends Bird{
//     void canFly(){
//         System.out.println("Sparrow can Fly");
//     }
//     void haveWings(){
//         System.out.println("Sparrow have wing");
//     }
//     void canEat(){
//         System.out.println("Sparrow can eat");
//     }
// }
// public class Demo {
//     public static void main(String[] args) {
        
    
//     Bird p=new Parrot();
//     Bird s=new Sparrow();
    
//     Bird ge=new GoldenEgle();
//     Bird se=new Serpentegle();


//     se.canEat();

// }
// }



abstract class Bird{
    abstract void canFly();
    abstract void haveWings();
    abstract void canEat();
    // abstract void height(); //yes but must and should be implement in all 
    
} 
class Parrot extends Bird{
    
    void canFly(){
        System.out.println("parrot can Fly");
    }
    void haveWings(){
        System.out.println("parrot have wing");
    }
    void canEat(){
        System.out.println("parrot can eat");
    }
    
}


abstract class Eagle extends Bird{
    
    void canFly(){
        System.out.println(" Eagle can Fly");
    }  
    void haveWings(){
        System.out.println(" Eagle have wing");
    }
    abstract void canEat(); 
    
}

class GoldenEgle extends Eagle{
    
    void canEat(){
        System.out.println("Golden egle eats fish ");
    }
}


class Serpentegle extends Eagle{
    
    void canEat(){
        System.out.println("Serpent egle eats Snake ");
    }
}


class Sparrow extends Bird{
    void canFly(){
        System.out.println("Sparrow can Fly");
    }
    void haveWings(){
        System.out.println("Sparrow have wing");
    }
    void canEat(){
        System.out.println("Sparrow can eat");
    }
}
public class Demo {
    public static void main(String[] args) {
        
    
    Bird p=new Parrot();
    Bird s=new Sparrow();
    
    Bird ge=new GoldenEgle();
    Bird se=new Serpentegle();


    ge.canFly();

}
}