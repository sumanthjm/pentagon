// Custom exception for invalid marks
class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}
class Student {
    private int studentId;
    private String name;
    private int marks;

    // Constructor
    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    // Assign marks with validation
    public void assignMarks(int marks) throws InvalidMarksException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100. You entered: " + marks);
        }
        this.marks = marks;
        System.out.println("Marks assigned to " + name + ": " + marks);
    }

    // Display student details
    public void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("------------------------");
    }
}
public class Main{
    public static void main(String[] args) {
        System.out.println("---- Student Grading System ----\n");

        // Create students
        Student s1 = new Student(101, "Rahul");
        Student s2 = new Student(102, "Sneha");

        // Try assigning valid and invalid marks
        try {
            s1.assignMarks(85); // Valid
        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            s2.assignMarks(120); // Invalid
        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Display student data
        s1.displayStudent();
        s2.displayStudent(); // Will show 0 marks if assignment failed
    }
}
