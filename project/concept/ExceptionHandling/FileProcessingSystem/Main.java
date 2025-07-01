import java.io.*;

// Custom exception must be declared FIRST
class EmptyFileException extends Exception {
    
    public EmptyFileException(String message) {
        super(message);
    }
}

// FileProcessor class
class FileProcessor {

    public void writeToFile(String filename, String data) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(data);
        writer.close();
        System.out.println("Data written successfully to " + filename);
    }

    public void readFromFile(String filename) throws IOException, EmptyFileException {
        File file = new File(filename);

        if (!file.exists()) {
            throw new FileNotFoundException("File " + filename + " not found.");
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder content = new StringBuilder();
        String line;
        boolean isEmpty = true;

        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
            isEmpty = false;
        }

        reader.close();

        if (isEmpty) {
            throw new EmptyFileException("File " + filename + " is empty.");
        }

        System.out.println("Content of " + filename + ":\n" + content);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        FileProcessor processor = new FileProcessor();

        String validFile = "sample.txt";
        String emptyFile = "empty.txt";
        String missingFile = "nofile.txt";

        System.out.println("---- File Processing System ----\n");

        // Writing to file
        try {
            processor.writeToFile(validFile, "Hello, this is a file processing system demo!");
        } catch (IOException e) {
            System.out.println("Write Error: " + e.getMessage());
        }

        // Reading valid file
        try {
            processor.readFromFile(validFile);
        } catch (FileNotFoundException e) {
            System.out.println("Read Error: " + e.getMessage());
        } catch (EmptyFileException e) {
            System.out.println("Empty File Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }

        // Reading missing file
        try {
            processor.readFromFile(missingFile);
        } catch (Exception e) {
            System.out.println("Missing File Error: " + e.getMessage());
        }

        // Creating and reading empty file
        try {
            processor.writeToFile(emptyFile, ""); // Write nothing
            processor.readFromFile(emptyFile);    // Should throw EmptyFileException
        } catch (Exception e) {
            System.out.println("Empty File Handling: " + e.getMessage());
        }
    }
}
