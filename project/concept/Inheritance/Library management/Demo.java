// Superclass
class Book {
    String title;
    String author;
    String ISBN;

    // Constructor
    Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    // Method to display basic book details
    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
    }
}

// Fiction subclass
class Fiction extends Book {
    String genre;

    // Constructor
    Fiction(String title, String author, String ISBN, String genre) {
        super(title, author, ISBN);
        this.genre = genre;
    }

    // Overridden method
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Genre: " + genre);
        System.out.println("Type: Fiction");
        System.out.println("-------------------------");
    }
}

// NonFiction subclass
class NonFiction extends Book {
    String subject;

    // Constructor
    NonFiction(String title, String author, String ISBN, String subject) {
        super(title, author, ISBN);
        this.subject = subject;
    }

    // Overridden method
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Subject: " + subject);
        System.out.println("Type: Non-Fiction");
        System.out.println("-------------------------");
    }
}

// Main class
public class Demo {
    public static void main(String[] args) {
        Fiction f1 = new Fiction("The Alchemist", "Paulo Coelho", "123456789", "Fantasy");
        NonFiction nf1 = new NonFiction("Brief History of Time", "Stephen Hawking", "987654321", "Science");

        System.out.println("Library Book Details:\n");

        f1.displayDetails();
        nf1.displayDetails();
    }
}
