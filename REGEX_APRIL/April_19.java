package Regex_Part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class April_19 {
    public static void main(String[] args) {
        String sourceFilePath = "/Users/kavana/Documents/Workspace1/Regex_validation/src/test/java/Regex_Part2/Source_file.txt";
        String[] targetFilePaths = {
                "/Users/kavana/Documents/Workspace1/Regex_validation/src/test/java/Regex_Part2/Target_Given_File.txt",
                "/Users/kavana/Documents/Workspace1/Regex_validation/src/test/java/Regex_Part2/Target_Then_File.txt",
                "/Users/kavana/Documents/Workspace1/Regex_validation/src/test/java/Regex_Part2/Target_When_file.txt"
        };

        boolean allMatched = true; // Flag to track if all lines from the source file are matched

        try {
            // Read lines from target files and store them in sets for fast lookup
            Set<String>[] targetLines = new HashSet[targetFilePaths.length];
            for (int i = 0; i < targetFilePaths.length; i++) {
                targetLines[i] = readLinesFromFile(targetFilePaths[i]);
            }

            // Read lines from source file and compare with lines from target files
            try (BufferedReader br = new BufferedReader(new FileReader(sourceFilePath))) {
                String line;
                int lineNumber = 0;
                while ((line = br.readLine()) != null) {
                    lineNumber++;
                    // Replace specific keywords with spaces
                    line = line.replaceAll("(?i)\\b(given|then|when|and)\\b", " ");

                    boolean matched = false;
                    for (int i = 0; i < targetFilePaths.length; i++) {
                        // Replace specific keywords with spaces in target lines
                        Set<String> modifiedTargetLines = new HashSet<>();
                        for (String targetLine : targetLines[i]) {
                            modifiedTargetLines.add(targetLine.replaceAll("(?i)\\b(given|then|when|and)\\b", " "));
                        }

                        if (modifiedTargetLines.contains(line)) {
                            matched = true;
                            break; // Move to the next line in source file
                        }
                    }
                    if (!matched) {
                        allMatched = false;
                        System.out.println("Source file is not matching with predefined lines at line " + lineNumber + ": " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the final result based on allMatched flag
        if (allMatched) {
            System.out.println("Source file matching with predefined lines");
        } 
        
    }

    private static Set<String> readLinesFromFile(String filePath) throws IOException {
        Set<String> lines = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
}
