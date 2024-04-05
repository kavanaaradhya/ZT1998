package REGEX_APRIL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class April_5{
    
    public static boolean match(String input, String pattern) {
        return input.matches(pattern);
    }

    public static void main(String[] args) {
        String srcFilePath = "/Users/kavana/Documents/Workspace1/Regex_validation/src/test/java/APRIL_3RD/SRC.txt"; 
        String tgtFilePath = "/Users/kavana/Documents/Workspace1/Regex_validation/src/test/java/APRIL_3RD/TGT.txt";
        
        try {
            StringBuilder srcStringBuilder = new StringBuilder();
            BufferedReader srcBufferedReader = new BufferedReader(new FileReader(srcFilePath));
            String srcLine;
            
            
            while ((srcLine = srcBufferedReader.readLine()) != null) {
                
                srcStringBuilder.append(srcLine).append("\n");
            }
            srcBufferedReader.close();
            String srcText = srcStringBuilder.toString();

            StringBuilder tgtStringBuilder = new StringBuilder();
            BufferedReader tgtBufferedReader = new BufferedReader(new FileReader(tgtFilePath));
            String tgtLine;
            
            
            while ((tgtLine = tgtBufferedReader.readLine()) != null) {
                
                tgtStringBuilder.append(tgtLine).append("\n");
            }
            tgtBufferedReader.close();
            String tgtText = tgtStringBuilder.toString();

            Pattern inputPattern = Pattern.compile("\"(.*?)\"");
            Matcher inputMatcher = inputPattern.matcher(srcText);
            
            Pattern patternPattern = Pattern.compile("\"(.*?)\"");
            Matcher patternMatcher = patternPattern.matcher(tgtText);
            
            ArrayList<Boolean> trueResults = new ArrayList<>();
            int lineCounter = 0; 
            
            while (inputMatcher.find() && patternMatcher.find()) {
                lineCounter++;
                
                String input = inputMatcher.group(1);
                String pattern = patternMatcher.group(1);
                boolean isMatch = match(input, pattern);
                
                System.out.println("Line: " + lineCounter);
                System.out.println("Input: " + input);
                System.out.println("Pattern: " + pattern);
                System.out.println("Match: " + isMatch);
                System.out.println();
                
                if (!isMatch) {
                	
                    System.out.println("Mismatch found in line number " + lineCounter);
                    System.out.println("Mismatched input from source file : "+input);
                    System.out.println("Mismatched pattern from target file : "+pattern);
                    System.out.println();
                }
                
                trueResults.add(isMatch);
            }
            
            System.out.println("Results: " + trueResults.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
