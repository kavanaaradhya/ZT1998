import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ok {

    private static String file1Path;
	private static String file2Path;

	public static void main(String[] args) {
        // Provide the paths to the two files for comparison
        String filePath1 = "/Users/kavana/eclipse-workspace/KAVANA/src/test/java/Check.feature";
        String filePath2 = "/Users/kavana/eclipse-workspace/KAVANA/src/test/java/Target.feature";

        try {
            if (compareFilesWithoutSpaces(filePath1, filePath2)) {
                System.out.println("Files are identical without spaces.");
            } else {
                System.out.println("Files are not identical without spaces.");
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
       
        
    }

    public static boolean compareFilesWithoutSpaces(String filePath1, String filePath2) throws IOException {
        String content1 = readFileWithoutSpaces(filePath1);
        String content2 = readFileWithoutSpaces(filePath2);

        // Compare the contents without spaces
        return content1.equals(content2);
    }

    public static String readFileWithoutSpaces(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Remove all spaces from the line
                line = line.replaceAll("\\s+", "");
                contentBuilder.append(line);
            }
        }

      return contentBuilder.toString();
      
       }
    
    
}
