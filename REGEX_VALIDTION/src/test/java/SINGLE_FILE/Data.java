package SINGLE_FILE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Data {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/kavana/eclipse-workspace/REGEX_VALIDTION/src/test/java/SINGLE_FILE/DATA.txt"))) {
            String patternString = reader.readLine(); 
            Pattern compiledPattern = Pattern.compile(patternString); 

            
           // System.out.println(compiledPattern.getClass().getName());
            System.out.println(compiledPattern.getClass().getTypeName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
