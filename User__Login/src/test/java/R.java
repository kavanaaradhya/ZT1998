import java.util.Scanner;
import java.util.regex.*;
import java.nio.file.*;
import java.io.*;

public class R {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);
        
        // Read the regex pattern from the target file
        String regexFromFile = readRegexFromFile("/Users/kavana/eclipse-workspace/User__Login/src/test/java/Text2.txt");

        if (regexFromFile == null) {
            System.out.println("Error: Could not read the regex pattern from the file.");
            return;
        }

        System.out.print("Enter a string: ");
        String input = scanner.nextLine(); // Read input from the user
        
        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regexFromFile);
        
        // Match the input string against the regex pattern
        Matcher matcher = pattern.matcher(input);
        
        // Check if the input string matches the regex pattern
        if (matcher.matches()) {
            System.out.println("Input string matches the regex pattern.");
        } else {
            System.out.println("Input string does not match the regex pattern.");
        }
        
        // Close the Scanner object
        scanner.close();
    }

    // Method to read the regex pattern from a file
    private static String readRegexFromFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
