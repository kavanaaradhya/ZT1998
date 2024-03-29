import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextExtractor {
    public static void main(String[] args) {
        // File paths where the text is stored
        String filePath = "/Users/kavana/eclipse-workspace/EMAIL_VALIDATION/src/test/java/single.txt";

        // Extract phone numbers
        extractPhoneNumber(filePath);

        // Extract email addresses
        extractEmail(filePath);

        // Extract URLs
        extractURL(filePath);
    }

    public static void extractPhoneNumber(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String lineOfText;
            // Define a regex pattern to match a 10-digit phone number
            String regexPattern = "\\b\\d{3}-\\d{3}-\\d{4}\\b";
            // Create a Pattern object
            Pattern pattern = Pattern.compile(regexPattern);

            while ((lineOfText = br.readLine()) != null) {
                // Trim extra spaces from the line
                lineOfText = lineOfText.trim();

                // Create a Matcher object
                Matcher matcher = pattern.matcher(lineOfText);

                // Find the regex pattern in the line of text
                if (matcher.find()) {
                    // Extract the regex pattern
                    String extractedPhoneNumber = matcher.group();
                    System.out.println("Extracted phone number: " + extractedPhoneNumber);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void extractEmail(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String lineOfText;
            // Define a regex pattern to match email addresses
            String regexPattern = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
            // Create a Pattern object
            Pattern pattern = Pattern.compile(regexPattern);

            while ((lineOfText = br.readLine()) != null) {
                // Trim extra spaces from the line
                lineOfText = lineOfText.trim();

                // Create a Matcher object
                Matcher matcher = pattern.matcher(lineOfText);

                // Find the regex pattern in the line of text
                if (matcher.find()) {
                    // Extract the regex pattern
                    String extractedEmail = matcher.group();
                    System.out.println("Extracted email address: " + extractedEmail);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void extractURL(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String lineOfText;
            // Define a regex pattern to match URLs
            String regexPattern = "\\b(?:https?://)?(?:www\\.)?[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}(?:/\\S*)?\\b";
            // Create a Pattern object
            Pattern pattern = Pattern.compile(regexPattern);

            while ((lineOfText = br.readLine()) != null) {
                // Trim extra spaces from the line
                lineOfText = lineOfText.trim();

                // Create a Matcher object
                Matcher matcher = pattern.matcher(lineOfText);

                // Find the regex pattern in the line of text
                if (matcher.find()) {
                    // Extract the regex pattern
                    String extractedUrl = matcher.group();
                    System.out.println("Extracted URL: " + extractedUrl);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
