package Regex_Part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class April_18 {
    // ANSI color codes
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        String sourceFilePath = "/Users/kavana/Documents/Workspace1/Regex_validation/src/test/java/Regex_Part2/Source_file.txt";
        String[] targetFilePaths = {
                "/Users/kavana/Documents/Workspace1/Regex_validation/src/test/java/Regex_Part2/Target_Given_File.txt",
                "/Users/kavana/Documents/Workspace1/Regex_validation/src/test/java/Regex_Part2/Target_Then_File.txt",
                "/Users/kavana/Documents/Workspace1/Regex_validation/src/test/java/Regex_Part2/Target_When_file.txt"
        };
        Set<String> matchedLines = new HashSet<>();


        try {
            // Read lines from target files and store them in sets
            Set<String>[] targetLines = new HashSet[targetFilePaths.length];
            String[] targetFileNames = new String[targetFilePaths.length];
            boolean[] matchedTargets = new boolean[targetFilePaths.length]; // To track which targets are matched
            for (int i = 0; i < targetFilePaths.length; i++) {
                targetLines[i] = readLinesFromFile(targetFilePaths[i]);
                targetFileNames[i] = getFileName(targetFilePaths[i]);
            }

            // Output table header
            System.out.println("+---------------------------------------------------------------------------------------------------------------------+");
            System.out.printf("| %-65s | %-30s | %-15s |%n", "Source Line", "Target File", "Status");
            System.out.println("+---------------------------------------------------------------------------------------------------------------------+");

            // Process the source file
            try (BufferedReader br = new BufferedReader(new FileReader(sourceFilePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    // Replace specific keywords with spaces
                    line = line.replaceAll("(?i)\\b(given|then|when|and)\\b", " ");
                    // Compare the modified line with lines from each target file
                    for (int i = 0; i < targetFilePaths.length; i++) {
                        for (String targetLine : targetLines[i]) {
                            if (targetLine.replaceAll("(?i)\\b(given|then|when|and)\\b", " ").equals(line)) {
                                // Output matching line with green color
                                System.out.printf("| %s%-65s%s | %s%-30s%s | %s%-15s%s |%n", ANSI_GREEN, line, ANSI_RESET, ANSI_GREEN, targetFileNames[i], ANSI_RESET, ANSI_GREEN, "Match found", ANSI_RESET);
                                matchedLines.add(line);
                                matchedTargets[i] = true; // Mark this target as matched
                            }
                        }
                    }
                }
            }

            // Print mismatched lines and target files
            for (int i = 0; i < targetFilePaths.length; i++) {
                for (String line : targetLines[i]) {
                    if (!matchedLines.contains(line)) {
                        // Output non-matching line with red color
                        System.out.printf("| %s%-65s%s | %s%-30s%s | %s%-15s%s |%n", ANSI_RED, line, ANSI_RESET, ANSI_RED, targetFileNames[i], ANSI_RESET, ANSI_RED, "Not matched", ANSI_RESET);
                    }
                }
            }
            System.out.println("+---------------------------------------------------------------------------------------------------------------------+");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFileName(String filePath) {
        return filePath.substring(filePath.lastIndexOf("/") + 1);
    }

    private static Set<String> readLinesFromFile(String filePath) throws IOException {
        Set<String> lines = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line.replaceAll("(?i)\\b(given|then|when|and)\\b", " "));
            }
        }
        return lines;
    }
}
