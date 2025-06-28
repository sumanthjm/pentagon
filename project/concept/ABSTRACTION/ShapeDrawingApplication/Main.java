// Abstract Shape class
abstract class Shape {
    String name;

    Shape(String name) {
        this.name = name;
    }

    // Abstract method
    abstract void draw();

    // Abstract method for area calculation
    abstract double calculateArea();
}

// Circle class
class Circle extends Shape {
    double radius;

    Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    void draw() {
        System.out.println("Drawing a Circle with radius: " + radius);
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Rectangle class
class Rectangle extends Shape {
    double length, width;

    Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
    }

    @Override
    void draw() {
        System.out.println("Drawing a Rectangle with length " + length + " and width " + width);
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create shapes
        Shape circle = new Circle(5.5);
        Shape rectangle = new Rectangle(4.0, 6.0);

        // Use draw() and calculateArea() methods
        System.out.println("---- Shape Drawing Application ----\n");

        circle.draw();
        System.out.println("Area of Circle: " + circle.calculateArea() + "\n");

        rectangle.draw();
        System.out.println("Area of Rectangle: " + rectangle.calculateArea());
    }
}
