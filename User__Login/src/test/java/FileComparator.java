import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileComparator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the path of the file to be compared: ");
        String filePath = scanner.nextLine();

        
        String fileContents = readFileContents(filePath);
        if (fileContents == null) {
            System.out.println("Unable to read the specified file.");
            return;
        }
        fileContents = fileContents.trim();

        
        
       
        String existingFilePath ="/Users/kavana/eclipse-workspace/KAVANA/src/test/java/Text2.txt";

        
        String existingFileContents = readFileContents(existingFilePath);
        if (existingFileContents == null) {
            System.out.println("Unable to read the existing file.");
            return;
        }
        existingFileContents = existingFileContents.trim();

        
        if (fileContents.equals(existingFileContents)) {
            System.out.println("The contents of the files are identical.");
        } else {
            System.out.println("The contents of the files are different.");
        }
    }

    
    private static String readFileContents(String filePath) {
        Path path = Paths.get(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
