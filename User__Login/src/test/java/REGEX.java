import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class REGEX {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for the path of the source file
        System.out.print("Enter the path of the source file: ");
        String sourceFilePath = scanner.nextLine();

        // Define the fixed path for the target file
        String targetFilePath = "/Users/kavana/eclipse-workspace/User__Login/src/test/java/Text2.txt";

        // Read regex pattern from the source file
        String regexPattern = readRegexPattern(sourceFilePath);

        if (regexPattern == null) {
            System.out.println("Unable to read regex pattern from source file.");
            return;
        }

        // Read contents of the source and target files
        String sourceFileContents = readFileContents(sourceFilePath);
        String targetFileContents = readFileContents(targetFilePath);

        if (sourceFileContents == null || targetFileContents == null) {
            System.out.println("Unable to read files.");
            return;
        }

        // Compare the files
        compareFiles(sourceFilePath, targetFilePath, sourceFileContents, targetFileContents, regexPattern);
    }

    // Method to read contents of a file
    private static String readFileContents(String filePath) {
        Path path = Paths.get(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            return stringBuilder.toString().trim(); // Trimming to remove extra new line at the end
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to read regex pattern from source file
    private static String readRegexPattern(String filePath) {
        Path path = Paths.get(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.matches("\\d{10}")) { // Matches a line with exactly 10 digits
                    return "\\d{10}";
                } else if (line.matches("\\s*\\S+\\s*")) { // Matches a line with non-space characters
                    return line.trim(); // Return trimmed regex pattern\\b\\d{10}\\b
                }
            }
            return null; // Regex pattern not found
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to compare contents of two files
    private static void compareFiles(String sourceFilePath, String targetFilePath, String sourceFileContents, String targetFileContents, String regexPattern) {
        String[] sourceLines = sourceFileContents.split("\n");
        String[] targetLines = targetFileContents.split("\n");

        int minLength = Math.min(sourceLines.length, targetLines.length);
        boolean mismatchFound = false;

        for (int i = 0; i < minLength; i++) {
            // Check if the line matches the regex pattern
            if (isRegexMatch(targetLines[i], regexPattern)) {
                if (!isRegexMatch(sourceLines[i], regexPattern)) {
                    System.out.println("Regex pattern mismatch at line " + (i + 1) + " in files:");
                    System.out.println("Source File: " + sourceLines[i]);
                    System.out.println("Target File: " + targetLines[i]);
                    mismatchFound = true;
                }
            } else {
                // If the line doesn't match the regex pattern, compare the lines
                if (!sourceLines[i].equals(targetLines[i])) {
                    System.out.println("Mismatch found at line " + (i + 1) + " in files:");
                    System.out.println("Source File: " + sourceLines[i]);
                    System.out.println("Target File: " + targetLines[i]);
                    mismatchFound = true;
                }
            }
        }

        if (!mismatchFound) {
            System.out.println("The contents of the files are identical.");
        }
    }

    // Method to check if the line matches the regex pattern
    private static boolean isRegexMatch(String line, String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }
}
