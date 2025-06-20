import java.util.*;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class CartItem {
    Product product;
    int quantity;

    CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    double getTotalPrice() {
        return product.price * quantity;
    }
}

class Customer {
    String username;
    String password;
    List<CartItem> cart;

    Customer(String username, String password) {
        this.username = username;
        this.password = password;
        this.cart = new ArrayList<>();
    }
}

public class EcommerceSystem {
    static Scanner sc = new Scanner(System.in);
    static Map<String, Customer> customers = new HashMap<>();
    static List<Product> storeProducts = new ArrayList<>();
    static Customer loggedInUser = null;

    public static void main(String[] args) {
        initializeProducts();
        int choice;

        while (true) { 
            System.out.println("\n🔐 1. Register\n🔑 2. Login\n❌ 3. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> register();
                case 2 -> login();
                case 3 -> {
                    System.out.println("🚪 Thank you for using the E-Commerce System!");
                    return;
                }
                default -> System.out.println("❌ Invalid option.");
            }
        }
    }

    static void initializeProducts() {
        storeProducts.add(new Product("Laptop", 50000));
        storeProducts.add(new Product("Mobile", 20000));
        storeProducts.add(new Product("Headphones", 1500));
        storeProducts.add(new Product("Charger", 500));
    }

    static void register() {
        System.out.print("Enter new username: ");
        String username = sc.nextLine();
        if (customers.containsKey(username)) {
            System.out.println("❌ Username already exists.");
            return;
        }
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        customers.put(username, new Customer(username, password));
        System.out.println("✅ Registration successful!");
    }

    static void login() {
        if (loggedInUser != null) {
            System.out.println("⚠️ Already logged in as " + loggedInUser.username);
            return;
        }

        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        Customer customer = customers.get(username);
        if (customer != null && customer.password.equals(password)) {
            loggedInUser = customer;
            System.out.println("✅ Login successful! Welcome " + username);

            // Shopping menu loop
            boolean shopping = true;
            while (shopping) {
                System.out.println("\n🛒 1. Add to Cart\n📦 2. View Cart & Place Order\n🚪 3. Logout\n🔙 4. Exit to Main Menu");
                System.out.print("Choose an option: ");
                int shopChoice = sc.nextInt();

                switch (shopChoice) {
                    case 1 -> addToCart();
                    case 2 -> viewCartAndPlaceOrder();
                    case 3 -> {
                        logout();
                        shopping = false;
                    }
                    case 4 -> {
                        System.out.println("🔙 Returning to Main Menu...");
                        shopping = false;
                    }
                    default -> System.out.println("❌ Invalid choice.");
                }
            }

        } else {
            System.out.println("❌ Invalid username or password.");
        }
    }

    static void logout() {
        if (loggedInUser == null) {
            System.out.println("⚠️ No user is logged in.");
        } else {
            System.out.println("✅ Logged out " + loggedInUser.username);
            loggedInUser = null;
        }
    }

    static void addToCart() {
        if (loggedInUser == null) {
            System.out.println("⚠️ You must login first.");
            return;
        }

        System.out.println("\nAvailable Products:");
        for (int i = 0; i < storeProducts.size(); i++) {
            Product p = storeProducts.get(i);
            System.out.println((i + 1) + ". " + p.name + " - ₹" + p.price);
        }

        System.out.print("Enter product number: ");
        int productNo = sc.nextInt();
        if (productNo < 1 || productNo > storeProducts.size()) {
            System.out.println("❌ Invalid product.");
            return;
        }

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        Product selected = storeProducts.get(productNo - 1);
        loggedInUser.cart.add(new CartItem(selected, quantity));
        System.out.println("✅ Added to cart: " + selected.name + " x" + quantity);
    }

    static void viewCartAndPlaceOrder() {
        if (loggedInUser == null) {
            System.out.println("⚠️ You must login first.");
            return;
        }

        List<CartItem> cart = loggedInUser.cart;
        if (cart.isEmpty()) {
            System.out.println("🛒 Cart is empty.");
            return;
        }

        System.out.println("\n🧾 Cart for: " + loggedInUser.username);
        System.out.println("------------------------------------------------");
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Product", "Quantity", "Price", "Total");
        System.out.println("------------------------------------------------");

        double grandTotal = 0;
        for (CartItem item : cart) {
            double totalPrice = item.getTotalPrice();
            System.out.printf("%-15s %-10d ₹%-9.2f ₹%-9.2f\n",
                    item.product.name, item.quantity, item.product.price, totalPrice);
            grandTotal += totalPrice;
        }

        System.out.println("------------------------------------------------");
        System.out.printf("Grand Total: ₹%.2f\n", grandTotal);
        System.out.println("✅ Order placed successfully!");

        cart.clear(); // Clear cart after placing order
    }
}






// import java.util.Scanner;

// class Product {
//     String name;
//     double price;

//     Product(String name, double price) {
//         this.name = name;
//         this.price = price;
//     }
// }

// class CartItem {
//     Product product;
//     int quantity;

//     CartItem(Product product, int quantity) {
//         this.product = product;
//         this.quantity = quantity;
//     }

//     double getTotalPrice() {
//         return product.price * quantity;
//     }
// }

// public class ShoppingCartWithoutCollections {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         // Store products
//         Product[] storeProducts = {
//             new Product("Laptop", 50000),
//             new Product("Mobile", 20000),
//             new Product("Headphones", 1500),
//             new Product("Charger", 500)
//         };

//         // Cart storage (fixed size array)
//         CartItem[] cart = new CartItem[100];
//         int cartIndex = 0;

//         System.out.println("🛒 Welcome to the Online Store 🛒");

//         while (true) {
//             System.out.println("\nAvailable Products:");
//             for (int i = 0; i < storeProducts.length; i++) {
//                 System.out.println((i + 1) + ". " + storeProducts[i].name + " - ₹" + storeProducts[i].price);
//             }

//             System.out.print("Enter product number to add to cart (0 to checkout): ");
//             int choice = sc.nextInt();

//             if (choice == 0) {
//                 break;
//             }

//             if (choice < 1 || choice > storeProducts.length) {
//                 System.out.println("❌ Invalid product number.");
//                 continue;
//             }

//             System.out.print("Enter quantity: ");
//             int qty = sc.nextInt();

//             cart[cartIndex++] = new CartItem(storeProducts[choice - 1], qty);
//             System.out.println("✅ Added to cart: " + storeProducts[choice - 1].name + " x" + qty);
//         }

//         // Print cart summary
//         if (cartIndex == 0) {
//             System.out.println("🛒 Your cart is empty. Thank you for visiting!");
//             return;
//         }

//         System.out.println("\n🧾 Your Order Summary:");
//         System.out.println("----------------------------------------------");
//         System.out.printf("%-15s %-10s %-10s %-10s\n", "Product", "Quantity", "Price", "Total");
//         System.out.println("----------------------------------------------");

//         double grandTotal = 0;

//         for (int i = 0; i < cartIndex; i++) {
//             CartItem item = cart[i];
//             double totalPrice = item.getTotalPrice();
//             System.out.printf("%-15s %-10d ₹%-9.2f ₹%-9.2f\n",
//                 item.product.name, item.quantity, item.product.price, totalPrice);
//             grandTotal += totalPrice;
//         }

//         System.out.println("----------------------------------------------");
//         System.out.printf("Grand Total: ₹%.2f\n", grandTotal);
//         System.out.println("✅ Order placed successfully! Thank you for shopping.");
//     }
// }
