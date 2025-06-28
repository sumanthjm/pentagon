package HospitalManagementSystem;
// Patient class using encapsulation
class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;

    // Constructor
    public Patient(String patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        setAge(age);                 // apply validation
        setDiagnosis(diagnosis);     // apply validation
    }

    // Getters
    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    // Setters with validation
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age for patient: " + name);
        }
    }

    public void setDiagnosis(String diagnosis) {
        if (diagnosis != null && !diagnosis.trim().isEmpty()) {
            this.diagnosis = diagnosis;
        } else {
            System.out.println("Diagnosis cannot be empty for patient: " + name);
        }
    }

    // Method to display patient information
    public void displayPatientInfo() {
        System.out.println("Patient ID : " + patientId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Diagnosis  : " + diagnosis);
        System.out.println("-----------------------------");
    }
}
public class HospitalManagementSystem{
    public static void main(String[] args) {
        // Creating patient objects
        Patient p1 = new Patient("H001", "Ravi Kumar", 30, "Fever");
        Patient p2 = new Patient("H002", "Sita Verma", 45, "Diabetes");
        Patient p3 = new Patient("H003", "Aman Joshi", 0, ""); // Invalid data

        // Updating records with setters
        p3.setAge(28);               // corrected age
        p3.setDiagnosis("Cold");     // corrected diagnosis

        // Display patient info
        System.out.println("Hospital Patient Records:\n");
        p1.displayPatientInfo();
        p2.displayPatientInfo();
        p3.displayPatientInfo();
    }
}
