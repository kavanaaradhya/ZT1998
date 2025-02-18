import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number_Regex {
    public static void main(String[] args) {
        // File path where the numbers are stored
        String sourceFilePath = "/Users/kavana/eclipse-workspace/EMAIL_VALIDATION/src/test/java/Source.txt";
        // File path where regex pattern is stored
        String targetFilePath = "/Users/kavana/eclipse-workspace/EMAIL_VALIDATION/src/test/java/Target.txt";

        try (BufferedReader sourceReader = new BufferedReader(new FileReader(sourceFilePath));
             BufferedReader targetReader = new BufferedReader(new FileReader(targetFilePath))) {

            // Read the regex pattern from the target file
            String regexPattern = targetReader.readLine();
            // Compile the regex pattern
            Pattern pattern = Pattern.compile(regexPattern);

            String number;
            // Read each number from the source file
            while ((number = sourceReader.readLine()) != null) {
                // Create a Matcher object
                Matcher matcher = pattern.matcher(number);

                // Check if the regex pattern matches the number
                if (matcher.matches()) {
                    // If matched, print matched
                    System.out.println("Matched: " + number);
                } else {
                    // If not matched, print not matched
                    System.out.println("Not matched: " + number);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
