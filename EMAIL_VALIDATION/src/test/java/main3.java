import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main3 {

    // Function to compare content of two files using a regular expression
    public static void compareRegexInFiles(String filePath1, String filePath2) {
        try {
            // Read content from the first file (URL)
            String url = new String(Files.readAllBytes(Paths.get(filePath1))).trim();
            System.out.println("URL from file 1: " + url);

            // Read content from the second file (regex pattern)
            String regexPattern = new String(Files.readAllBytes(Paths.get(filePath2))).trim();
            System.out.println("Regex pattern from file 2: " + regexPattern);

            // Compile the regex pattern
            Pattern pattern = Pattern.compile(regexPattern);

            // Create matcher for the URL
            Matcher matcher = pattern.matcher(url);

            // Perform matching
            boolean match = matcher.matches();

            // Output comparison result
            if (match) {
                System.out.println("The URL matches the regex pattern.");
            } else {
                System.out.println("The URL does not match the regex pattern.");
            }

        } catch (IOException e) {
            System.err.println("An error occurred while reading files: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example usage:
        String filePath1 = "/Users/kavana/eclipse-workspace/EMAIL_VALIDATION/src/test/java/SRC.txt"; // Update this with the actual file path
        String filePath2 = "/Users/kavana/eclipse-workspace/EMAIL_VALIDATION/src/test/java/TGT.txt"; // Update this with the actual file path
        
        // Call the function to compare regex pattern against URL
        compareRegexInFiles(filePath1, filePath2);
    }
}
