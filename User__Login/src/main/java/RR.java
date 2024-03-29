import java.util.Scanner;
import java.util.regex.*;
import java.io.*;

public class RR {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path of the file: ");
        String filePath = scanner.nextLine(); // Read the path of the file from the user
        
        // Read input from the specified file
        String input = readInputFromFile(filePath);

        if (input == null) {
            System.out.println("Error: Could not read input from the file.");
            return;
        }

        // Regular expression pattern for exactly 10 digits
        String regex = "\\d{10}";
        
        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);
        
        // Match the input string against the regex pattern
        Matcher matcher = pattern.matcher(input);
        
        // Check if the input string matches the regex pattern
        if (matcher.matches()) {
            System.out.println("Input string contains exactly 10 digits.");
        } else {
            // Check if the input string is not exactly 10 digits
            if (input.length() != 10) {
                System.out.println("Input string does not contain exactly 10 digits.");
            } else {
                // Check if the input string contains non-digit characters
                if (!input.matches("\\d+")) {
                    System.out.println("Input string contains non-digit characters.");
                } else {
                    System.out.println("Invalid input.");
                }
            }
        }
        
        // Close the Scanner object
        scanner.close();
    }

    // Method to read input from a file
    private static String readInputFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
