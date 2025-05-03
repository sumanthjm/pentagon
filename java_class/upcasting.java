// Parent class
class Animal {
    void eat() {
        System.out.println("Animal is eating...");
    }
}

// Child class 1
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking...");
    }
}

// Child class --2
class Puppy extends Dog {
    void weep() {
        System.out.println("Puppy is weeping...");
    }
}

public class upcasting {
    public static void main(String[] args) {
        // Create Puppy object
        Puppy myPuppy = new Puppy();

        // Upcasting
        Animal myAnimal = myPuppy;  // Puppy → Animal (upcasting automatically)
        myAnimal.eat();             // Only Animal methods are accessible

        // Trying to access Dog or Puppy methods? Not possible directly:
        // myAnimal.bark();   // Error
        // myAnimal.weep();   // Error

        // Downcasting
        if (myAnimal instanceof Puppy) {
            Puppy realPuppy = (Puppy) myAnimal;  // Animal → Puppy (manual casting)
            realPuppy.eat();   // OK (inherited from Animal)
            realPuppy.bark();  // OK (inherited from Dog)
            realPuppy.weep();  // OK (Puppy's own method)
        }
    }
}
