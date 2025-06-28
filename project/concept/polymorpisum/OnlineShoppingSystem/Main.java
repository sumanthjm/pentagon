import java.util.ArrayList;

// Superclass
class Customer {
    String name;
    double purchaseAmount;

    // Constructor
    Customer(String name, double purchaseAmount) {
        this.name = name;
        this.purchaseAmount = purchaseAmount;
    }

    // Method to be overridden
    double calculateDiscount() {
        return 0; // Base class returns no discount
    }

    // Method to display details
    void displayDetails() {
        System.out.println("Customer: " + name);
        System.out.println("Purchase Amount: ₹" + purchaseAmount);
        System.out.println("Discount: ₹" + calculateDiscount());
        System.out.println("----------------------------");
    }
}

// Regular customer with 5% discount
class RegularCustomer extends Customer {

    RegularCustomer(String name, double purchaseAmount) {
        super(name, purchaseAmount);
    }

    @Override
    double calculateDiscount() {
        return purchaseAmount * 0.05;
    }
}

// Premium customer with 10% discount
class PremiumCustomer extends Customer {

    PremiumCustomer(String name, double purchaseAmount) {
        super(name, purchaseAmount);
    }

    @Override
    double calculateDiscount() {
        return purchaseAmount * 0.10;
    }
}

// Main class
public class Main{
    public static void main(String[] args) {
        // List of customers
        ArrayList<Customer> customers = new ArrayList<>();

        // Adding customers
        customers.add(new RegularCustomer("Ravi", 5000));
        customers.add(new PremiumCustomer("Sita", 8000));
        customers.add(new RegularCustomer("Aman", 1200));
        customers.add(new PremiumCustomer("Divya", 10000));

        // Processing all customers (polymorphism)
        System.out.println("---- Online Shopping Discount Summary ----\n");
        for (Customer customer : customers) {
            customer.displayDetails(); // polymorphic call
        }
    }
}
