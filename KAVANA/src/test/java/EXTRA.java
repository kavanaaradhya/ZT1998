import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class EXTRA{

    public static void main(String[] args) {
    	
    	        String inputFilePath = "/Users/kavana/eclipse-workspace/KAVANA/src/test/java/Check.feature";
    	        // Provide the path to the output feature file
    	        String outputFilePath = "/Users/kavana/eclipse-workspace/KAVANA/src/test/java/Target.feature";
    	        
    	        String inputFilePath1 = "/Users/kavana/eclipse-workspace/KAVANA/src/test/java/Target.feature";
    	        // Provide the path to the output feature file
    	        String outputFilePath1 = "/Users/kavana/eclipse-workspace/KAVANA/src/test/java/Check.feature";

    	        try {
    	            deleteSpaces(inputFilePath, outputFilePath);
    	            System.out.println("Spaces deleted successfully.");
    	        } catch (IOException e) {
    	            System.err.println("Error: " + e.getMessage());
    	            e.printStackTrace();
    	        }
    	        try {
    	            deleteSpaces1(inputFilePath1, outputFilePath1);
    	            System.out.println("Spaces deleted successfully.");
    	        } catch (IOException e) {
    	            System.err.println("Error: " + e.getMessage());
    	            e.printStackTrace();
    	        }
    	    }

    	    public static void deleteSpaces(String inputFilePath, String outputFilePath) throws IOException {
    	        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
    	             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

    	            String line;
    	            while ((line = reader.readLine()) != null) {
    	                // Remove all spaces from each line
    	                line = line.replaceAll("\\s+", "");
    	                writer.write(line);
    	                writer.newLine();
    	            }
    	        }
    	    }

        	    public static void deleteSpaces1(String inputFilePath1, String outputFilePath1) throws IOException {
        	        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath1));
        	             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath1))) {

        	            String line;
        	            while ((line = reader.readLine()) != null) {
        	                // Remove all spaces from each line
        	                line = line.replaceAll("\\s+", "");
        	                writer.write(line);
        	                writer.newLine();
        	            }
        	        }
    	    }
        	    }
       
