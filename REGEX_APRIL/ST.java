package Regex_Part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ST{
    public static void main(String[] args) {
        String sourceFilePath = "/Users/kavana/Documents/Workspace1/Regex_validation/src/test/java/Regex_Part2/Source_file.txt";
        String[] targetFilePaths = {
            "/Users/kavana/Documents/Workspace1/Regex_validation/src/test/java/Regex_Part2/Target_Given_File.txt",
            "/Users/kavana/Documents/Workspace1/Regex_validation/src/test/java/Regex_Part2/Target_Then_File.txt",
            "/Users/kavana/Documents/Workspace1/Regex_validation/src/test/java/Regex_Part2/Target_When_file.txt"
        };

        Set<String> matchedLines = new HashSet<>();

        try {
            Set<String>[] targetLines = new HashSet[targetFilePaths.length];
            String[] targetFileNames = new String[targetFilePaths.length];
            for (int i = 0; i < targetFilePaths.length; i++) {
                targetLines[i] = readLinesFromFile(targetFilePaths[i]);
                targetFileNames[i] = getFileName(targetFilePaths[i]); // Extract file name from the path
            }

            try (BufferedReader br = new BufferedReader(new FileReader(sourceFilePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.replaceAll("(?i)\\b(given|when|then)\\b", ""); // Replace Given, When, Then with empty string
                    boolean matched = false;
                    for (int i = 0; i < targetFilePaths.length; i++) {
                        for (String targetLine : targetLines[i]) {
                            if (targetLine.replaceAll("(?i)\\b(given|when|then)\\b", "").equals(line)) {
                              System.out.println("Match found in " + targetFileNames[i] + ": " + line);
                                matchedLines.add(line);
                                matched = true;
                                break;
                            }
                        }
                        if (matched) {
                            break;
                        }
                    }
                    if (!matched) {
                        System.out.println("Not matched: " + line);
                    }
                }
            }

            
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
                lines.add(line.replaceAll("(?i)\\b(given|when|then)\\b", "")); // Replace Given, When, Then with empty string
            }
        }
        return lines;
    }
}
