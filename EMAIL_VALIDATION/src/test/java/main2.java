import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main2 {

    // Function to match a URL regex pattern against a URL value
    public static boolean matchUrlRegex(String patternString, String url) {
        // Compile the regex pattern
        Pattern pattern = Pattern.compile(patternString);

        // Create a matcher for the URL
        Matcher matcher = pattern.matcher(url);

        // Check if the URL matches the pattern
        return matcher.matches();
    }

    // Function to read content from a file
    public static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath))).trim();
    }

    // Function to perform URL regex matching
    public static void matchUrlWithRegex(String sourceFilePath, String targetFilePath) {
        try {
            // Read the URL from the source file
            String url = readFile(sourceFilePath);

            // Read the regex pattern from the target file
            String patternString = readFile(targetFilePath);

            // Call the matchUrlRegex function and print the result
            boolean isMatch = matchUrlRegex(patternString, url);
            if (isMatch) {
                System.out.println("The URL matches the pattern.");
            } else {
                System.out.println("The URL does not match the pattern.");
            }

        } catch (IOException e) {
            System.err.println("An error occurred while reading the files: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example usage:
        String sourceFilePath = "/Users/kavana/eclipse-workspace/EMAIL_VALIDATION/src/test/java/SRC.txt"; // Update this to your actual source file path
        String targetFilePath = "/Users/kavana/eclipse-workspace/EMAIL_VALIDATION/src/test/java/TGT.txt"; // Update this to your actual target file path

        // Call the matchUrlWithRegex function with the file paths
        matchUrlWithRegex(sourceFilePath, targetFilePath);
    }
}
