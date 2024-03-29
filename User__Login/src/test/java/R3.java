import java.util.Scanner;
import java.util.regex.*;
import java.io.*;

public class R3 {
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

        // Compare the contents of both files line by line
        compareFiles(sourceInput, targetPattern);

        // Close the Scanner object
        scanner.close();
    }

    // Method to read input from a file, extract digits from each line, and concatenate them
    private static String readInputFromFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return stringBuilder.toString();
    }

    // Method to compare the contents of both files line by line
    private static void compareFiles(String sourceInput, String targetPattern) {
        String[] sourceLines = sourceInput.split("\n");
        String[] targetLines = targetPattern.split("\n");

        int maxLength = Math.max(sourceLines.length, targetLines.length);

        System.out.println("Mismatched contents:");
        for (int i = 0; i < maxLength; i++) {
            String sourceLine = (i < sourceLines.length) ? sourceLines[i] : "";
            String targetLine = (i < targetLines.length) ? targetLines[i] : "";

            if (!sourceLine.equals(targetLine)) {
                System.out.println("Line " + (i + 1) + ":");
                System.out.println("Source: " + sourceLine);
                System.out.println("Target: " + targetLine);
                System.out.println();
            }
        }
    }

    // Method to read pattern from a file
    private static String readPatternFromFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return stringBuilder.toString();
    }
}
