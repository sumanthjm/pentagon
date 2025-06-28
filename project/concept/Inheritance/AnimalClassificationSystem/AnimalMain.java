// Superclass
class Animal {
    String name;
    String habitat;

    // Constructor
    Animal(String name, String habitat) {
        this.name = name;
        this.habitat = habitat;
    }

    // Method to display animal details
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Habitat: " + habitat);
    }
}

// Mammal subclass
class Mammal extends Animal {
    boolean isDomestic;

    // Constructor
    Mammal(String name, String habitat, boolean isDomestic) {
        super(name, habitat);
        this.isDomestic = isDomestic;
    }

    // Overridden method
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Domestic: " + (isDomestic ? "Yes" : "No"));
        System.out.println("Type: Mammal");
        System.out.println("----------------------------");
    }
}

// Bird subclass
class Bird extends Animal {
    boolean canFly;

    // Constructor
    Bird(String name, String habitat, boolean canFly) {
        super(name, habitat);
        this.canFly = canFly;
    }

    // Overridden method
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Can Fly: " + (canFly ? "Yes" : "No"));
        System.out.println("Type: Bird");
        System.out.println("----------------------------");
    }
}

// Main class
public class AnimalMain{
    public static void main(String[] args) {
        Mammal dog = new Mammal("Dog", "Domestic", true);
        Bird penguin = new Bird("Penguin", "Antarctica", false);

        System.out.println("Animal Classification:\n");

        dog.displayInfo();
        penguin.displayInfo();
    }
}
