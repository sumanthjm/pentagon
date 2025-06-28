// Superclass
class Vehicle {
    String brand;
    String model;
    int year;

    // Constructor
    Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Method to display vehicle details
    void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}

// Car subclass
class Car extends Vehicle {
    int numberOfDoors;

    // Constructor
    Car(String brand, String model, int year, int numberOfDoors) {
        super(brand, model, year);
        this.numberOfDoors = numberOfDoors;
    }

    // Overridden method
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Type: Car");
        System.out.println("----------------------------");
    }
}

// Truck subclass
class Truck extends Vehicle {
    double payloadCapacity;

    // Constructor
    Truck(String brand, String model, int year, double payloadCapacity) {
        super(brand, model, year);
        this.payloadCapacity = payloadCapacity;
    }

    // Overridden method
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Payload Capacity: " + payloadCapacity + " tons");
        System.out.println("Type: Truck");
        System.out.println("----------------------------");
    }
}

// Main class
public class Demo{
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2020, 4);
        Truck truck1 = new Truck("Volvo", "FH16", 2018, 18.5);

        System.out.println("Vehicle Details:\n");
        car1.displayDetails();
        truck1.displayDetails();
    }
}
