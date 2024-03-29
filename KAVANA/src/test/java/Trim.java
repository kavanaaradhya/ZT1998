import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Trim{

    public static void main(String[] args) {
        String file1Path = "/Users/kavana/eclipse-workspace/KAVANA/src/test/java/Check.feature";
        String file2Path = "/Users/kavana/eclipse-workspace/KAVANA/src/test/java/Target.feature";
        
        try {
            removeExtraSpacesFromFile(file1Path);
            System.out.println("Extra spaces removed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeExtraSpacesFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + "_temp"));

        String line;

        while ((line = reader.readLine()) != null) {
            // Remove extra spaces using regex
            line = line.replaceAll("\\s+", " ").trim();
            writer.write(line);
            writer.newLine();
        }

        reader.close();
        writer.close();

        // Rename the temporary file to the original file
       // renameFile(filePath + "_temp", filePath);
    
    
    BufferedReader file1Path=reader;
	BufferedReader file2Path=reader;
	compareFiles(file1Path, file2Path);
    }
        private static void compareFiles(BufferedReader file1Path, BufferedReader file2Path) {
		// TODO Auto-generated method stub
		
	}

		public static void compareFiles(String file1Path, String file2Path) throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader(file1Path));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2Path));
        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
        int lineNumber = 1;

        while (line1 != null || line2 != null) {
            if (line1 == null || line2 == null || !line1.equals(line2)) {
                System.out.println("Mismatch at line " + lineNumber + ":");
                if (line1 != null) {
                    System.out.println("Check-file------> " + line1);
                }
                if (line2 != null) {
                    System.out.println("Target-file------> " + line2);
                }
                
            }

            line1 = reader1.readLine();
            line2 = reader2.readLine();
            lineNumber++;
        }

        reader1.close();
        reader2.close();
    }
}
