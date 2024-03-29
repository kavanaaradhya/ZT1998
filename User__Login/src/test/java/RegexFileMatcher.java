import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFileMatcher {
    public static void main(String[] args) {
        // Define the regular expression
        String regex = "\\d{10}"; // Example: Social Security Number pattern

        // Compile the regular expression
        Pattern pattern = Pattern.compile(regex);

        // Files to be matched
        String file1Path = "/Users/kavana/Documents/Text1.txt";
        String file2Path = "/Users/kavana/eclipse-workspace/User__Login/src/test/java/Text2.txt";

        try {
            // Read and match content of file1
            ArrayList<String> matchesFile1 = matchFile(file1Path, pattern);

            // Read and match content of file2
            ArrayList<String> matchesFile2 = matchFile(file2Path, pattern);

            // Compare matches from both files
            System.out.println("Matches in File 1:");
            for (String match : matchesFile1) {
                System.out.println(match);
            }

            //System.out.println("\nMatches in File 2:");
            for (String match : matchesFile2) {
                System.out.println(match);
            }

            // Perform comparison
            for (String match1 : matchesFile1) {
                if (matchesFile2.contains(match1)) {
                    System.out.println("Match found in both files: " + match1);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to match content of a file with a given pattern
    private static ArrayList<String> matchFile(String filePath, Pattern pattern) throws IOException {
        ArrayList<String> matches = new ArrayList<>();

        // Read the file line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Match the line against the pattern
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    // Add the matched string to the list of matches
                    matches.add(matcher.group());
                }
            }
        }

        return matches;
    }
}
