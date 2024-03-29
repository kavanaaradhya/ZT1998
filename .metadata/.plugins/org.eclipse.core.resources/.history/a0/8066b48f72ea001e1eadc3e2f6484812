import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main1 {

    // Function to match a URL regex pattern against a URL value
    public static boolean matchUrlRegex(String patternString, String url) {
        // Compile the regex pattern
        Pattern pattern = Pattern.compile(patternString);

        // Create a matcher for the URL
        Matcher matcher = pattern.matcher(url);

        // Check if the URL matches the pattern
        return matcher.matches();
    }

    public static void main(String[] args) {
        // File path for the source file containing the URL
        String sourceFilePath = "/Users/kavana/eclipse-workspace/EMAIL_VALIDATION/src/test/java/SRC.txt"; // Update this to your actual file path

        try {
            // Read the URL from the source file
            String url = new String(Files.readAllBytes(Paths.get(sourceFilePath))).trim();

            // Example usage:
            String patternString = "^(https?:\\/\\/)?(www\\.)?[a-zA-Z0-9-]+(\\.[a-z]{2,6}){1,2}(\\/[a-zA-Z0-9-]*)*(\\?[a-zA-Z0-9-]+=[a-zA-Z0-9-%]+(&[a-zA-Z0-9-]+=[a-zA-Z0-9-%]+)*)?$"; // Example regex pattern for URL matching

            // Call the matchUrlRegex function and print the result
            boolean isMatch = matchUrlRegex(patternString, url);
            if (isMatch) {
                System.out.println("The URL matches the pattern.");
            } else {
                System.out.println("The URL does not match the pattern.");
            }

        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
