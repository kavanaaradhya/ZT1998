import java.util.Scanner;
import java.util.regex.*;
import java.io.*;

public class R2 {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path of the source file: ");
        String sourceFilePath = scanner.nextLine(); // Read the path of the source file from the user

        System.out.print("Enter the path of the target file: ");
        String targetFilePath = scanner.nextLine(); // Read the path of the target file from the user

        // Read input from the specified source file
        String sourceInput = readInputFromFile(sourceFilePath);

        // Read the pattern from the specified target file
        String targetPattern = readPatternFromFile(targetFilePath);

        // Check if reading either input or pattern failed
        if (sourceInput == null || targetPattern == null) {
            System.out.println("Error: Could not read input or pattern from the file(s).");
            return;
        }

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(targetPattern);

        // Match the input string against the regex pattern
        Matcher matcher = pattern.matcher(sourceInput);

        // Check if the input string matches the regex pattern
        if (matcher.matches()) {
            System.out.println("Input string matches the pattern extracted from the target file.");
        } else {
            System.out.println("Input string does not match the pattern extracted from the target file.");
        }

        // Close the Scanner object
        scanner.close();
    }

    // Method to read input from a file, extract digits from each line, and concatenate them
    private static String readInputFromFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(extractDigits(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return stringBuilder.toString();
    }

    // Method to extract digits from a string
    private static String extractDigits(String input) {
        StringBuilder digitsBuilder = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                digitsBuilder.append(c);
            }
        }
        return digitsBuilder.toString();
    }

    // Method to read pattern from a file
    private static String readPatternFromFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return stringBuilder.toString();
    }
}
