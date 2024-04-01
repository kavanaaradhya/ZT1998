package APRIL_1ST;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class R_C {

    public static List<String> splitWords(String scenario) {
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b(?:\\[.+?\\]|\\S+)\\b"); 
        Matcher matcher = pattern.matcher(scenario);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    public static void main(String[] args) {
        String sourceFilePath = "/Users/kavana/Documents/Workspace1/Regex_validation/src/test/java/Regex_with_contents/URL_EMAIL_PHONE_SRC.txt";
        String targetFilePath = "/Users/kavana/Documents/Workspace1/Regex_validation/src/test/java/Regex_with_contents/URL_EMAIL_PHONE_TGT.txt";

        
        List<List<String>> sourceLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sourceLines.add(splitWords(line));
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the source file: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        
        List<List<String>> targetLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(targetFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                targetLines.add(splitWords(line));
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the target file: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        
        for (int i = 0; i < sourceLines.size() && i < targetLines.size(); i++) {
            List<String> sourceWords = sourceLines.get(i);
            List<String> targetWords = targetLines.get(i);

            
            if (sourceWords.size() == 1 && sourceWords.get(0).startsWith("[") && sourceWords.get(0).endsWith("]") &&
                targetWords.size() == 1 && targetWords.get(0).startsWith("[") && targetWords.get(0).endsWith("]")) {
                continue;
            }

            if (!sourceWords.equals(targetWords)) {
                System.out.println("Mismatch at line " + (i + 1)); // Print line number with mismatched words

                
                System.out.println("Source: " + sourceWords);
                System.out.println("Target: " + targetWords);
                System.out.println();
            }else
            {
            	
            }
        }

        
       try (BufferedReader srcBufferedReader = new BufferedReader(new FileReader(sourceFilePath))) {
            StringBuilder srcStringBuilder = new StringBuilder();
            String srcLine;
            while ((srcLine = srcBufferedReader.readLine()) != null) {
                srcStringBuilder.append(srcLine).append("\n");
            }
            String srcText = srcStringBuilder.toString();

            
            try (BufferedReader tgtBufferedReader = new BufferedReader(new FileReader(targetFilePath))) {
                StringBuilder tgtStringBuilder = new StringBuilder();
                String tgtLine;
                while ((tgtLine = tgtBufferedReader.readLine()) != null) {
                    tgtStringBuilder.append(tgtLine).append("\n");
                }
                String tgtText = tgtStringBuilder.toString();

                
                Pattern inputPattern = Pattern.compile("\"(.*?)\"");
                Matcher inputMatcher = inputPattern.matcher(srcText);

                Pattern patternPattern = Pattern.compile("\"(.*?)\"");
                Matcher patternMatcher = patternPattern.matcher(tgtText);

                while (inputMatcher.find() && patternMatcher.find()) {
                    String input = inputMatcher.group(1);
                    String pattern = patternMatcher.group(1);
                    System.out.println("Input: " + input);
                    System.out.println("Pattern: " + pattern);
                    if (input.matches(pattern)) {
                        System.out.println("Matched!");
                    } else {
                        System.out.println("Not Matched!");
                    }
                    System.out.println();
                }

                
                if (srcText.equals(tgtText)) {
                    System.out.println("Files are identical.");
                } else {
                    System.out.println("Files are not identical.");
                    System.out.println();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
