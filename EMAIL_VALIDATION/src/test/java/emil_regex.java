import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class emil_regex {
    public static void main(String[] args) {
        // File path where the text is stored
        String filePath = "/Users/kavana/eclipse-workspace/EMAIL_VALIDATION/src/test/java/email_target.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the line of text from the file
            String lineOfText = br.readLine();

            // Define a regex pattern to match email addresses
            String regexPattern = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";

            // Create a Pattern object
            Pattern pattern = Pattern.compile(regexPattern);

            // Create a Matcher object
            Matcher matcher = pattern.matcher(lineOfText);

            // Find the regex pattern in the line of text
            if (matcher.find()) {
                // Extract the regex pattern
                String extractedEmail = matcher.group();
                System.out.println("Extracted email address: " + extractedEmail);
            } else {
                System.out.println("No email address found in the line of text.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
