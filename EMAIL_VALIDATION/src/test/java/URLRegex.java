import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLRegex {
    public static void main(String[] args) {
        // File path where the text is stored
        String filePath = "/Users/kavana/eclipse-workspace/EMAIL_VALIDATION/src/test/java/url_source.txt";
        // File path where regex pattern is stored
        String regexFilePath = "/Users/kavana/eclipse-workspace/EMAIL_VALIDATION/src/test/java/url_target.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             BufferedReader regexReader = new BufferedReader(new FileReader(regexFilePath))) {

            // Read the regex pattern from the file
            String regexPattern = regexReader.readLine();

            String lineOfText;
            // Read each line of text from the file
            while ((lineOfText = br.readLine()) != null) {
                // Create a Pattern object
                Pattern pattern = Pattern.compile(regexPattern);

                // Create a Matcher object
                Matcher matcher = pattern.matcher(lineOfText);

                // Check if the regex pattern matches the line of text
                if (matcher.find()) {
                    // If matched, print matched
                    System.out.println("Matched: " + lineOfText);
                } else {
                    // If not matched, print not matched
                    System.out.println("Not matched: " + lineOfText);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
