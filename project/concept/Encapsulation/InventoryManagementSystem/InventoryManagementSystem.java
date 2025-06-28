
// Product class using encapsulation
class Product {
    private String productId;
    private String name;
    private int quantity;
    private double price;

    // Constructor
    public Product(String productId, String name, int quantity, double price) {
        this.productId = productId;
        this.name = name;
        setQuantity(quantity); // validation applied
        setPrice(price);       // validation applied
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // Setters with validation
    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantity cannot be negative for product: " + name);
        }
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Price must be greater than 0 for product: " + name);
        }
    }

    // Method to display product details
    public void displayProductDetails() {
        System.out.println("Product ID : " + productId);
        System.out.println("Name       : " + name);
        System.out.println("Quantity   : " + quantity);
        System.out.println("Price/unit : ₹" + price);
        System.out.println("---------------------------");
    }
}
public class InventoryManagementSystem{
    public static void main(String[] args) {
        // Creating product objects
        Product p1 = new Product("P001", "Laptop", 10, 55000);
        Product p2 = new Product("P002", "Smartphone", 25, 18000);
        Product p3 = new Product("P003", "Headphones", 50, 1200);

        // Updating quantity and price using setters
        p1.setQuantity(12);
        p1.setPrice(54000);

        p2.setQuantity(-5);  // Invalid - should trigger warning
        p2.setPrice(0);      // Invalid - should trigger warning

        p3.setQuantity(60);
        p3.setPrice(1000);

        // Display all product details
        System.out.println("Inventory Details:\n");
        p1.displayProductDetails();
        p2.displayProductDetails();
        p3.displayProductDetails();
    }
}
