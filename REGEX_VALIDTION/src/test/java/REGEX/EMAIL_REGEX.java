package REGEX;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EMAIL_REGEX {
    public static void main(String[] args) {
        String srcFilePath = "/Users/kavana/eclipse-workspace/REGEX_VALIDTION/src/test/java/URL_REGEX/Url_src.txt"; 
        String tgtFilePath = "/Users/kavana/eclipse-workspace/REGEX_VALIDTION/src/test/java/URL_REGEX/Url_tgt.txt";

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
