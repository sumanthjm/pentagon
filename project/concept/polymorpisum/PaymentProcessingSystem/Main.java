import java.util.ArrayList;

// Abstract superclass
abstract class Payment {
    double amount;

    // Constructor
    Payment(double amount) {
        this.amount = amount;
    }

    // Abstract method to be overridden
    abstract void processPayment();
}

// Credit Card Payment subclass
class CreditCardPayment extends Payment {
    String cardNumber;
    String cardHolderName;

    // Constructor
    CreditCardPayment(double amount, String cardNumber, String cardHolderName) {
        super(amount);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    // Overriding processPayment()
    @Override
    void processPayment() {
        System.out.println("Processing Credit Card Payment:");
        System.out.println("Card Holder: " + cardHolderName);
        System.out.println("Card Number: ****" + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Amount: ₹" + amount);
        System.out.println("-----------------------------");
    }
}

// UPI Payment subclass
class UPIPayment extends Payment {
    String upiId;

    // Constructor
    UPIPayment(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    // Overriding processPayment()
    @Override
    void processPayment() {
        System.out.println("Processing UPI Payment:");
        System.out.println("UPI ID: " + upiId);
        System.out.println("Amount: ₹" + amount);
        System.out.println("-----------------------------");
    }
}

// Main class
public class Main{
    public static void main(String[] args) {
        // Create a list of payments
        ArrayList<Payment> payments = new ArrayList<>();

        // Add different types of payments
        payments.add(new CreditCardPayment(1500, "1234567812345678", "Sumanth J M"));
        payments.add(new UPIPayment(750, "sumanth@upi"));
        payments.add(new CreditCardPayment(3200, "9876543210987654", "Karthik R"));
        payments.add(new UPIPayment(499.99, "karthik@okaxis"));

        // Polymorphic processing of payments
        System.out.println("---- Payment Processing System ----\n");
        for (Payment p : payments) {
            p.processPayment();
        }
    }
}
