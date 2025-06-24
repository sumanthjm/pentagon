// Step 1: Create an interface

import java.util.Scanner;

interface Shape {
    void draw();
}

// Step 2: Implement the interface with concrete classes
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Step 3: Create the Factory class
class ShapeFactory {
    // Factory method
    public Shape getShape(String shapeType) {
        if (shapeType == null) return null;
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;
    }
}

// Step 4: Use the factory in the main class
public class demo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Scanner sc=new Scanner(System.in);
             System.out.println("enter which class obj get creted and display drawing");
        String name=sc.next();
   
        Shape shape1 = factory.getShape(name);
        shape1.draw();  // Output: Drawing a Circle

        // Shape shape2 = factory.getShape("RECTANGLE");
        // shape2.draw();  // Output: Drawing a Rectangle
    }
}
