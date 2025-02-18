
/* this code gives mismatched line number along with contents if contents mismatch
 * else gives files are identical
 * in this file target file is fixed
 * source file taken by user
 * 
 */






package File_Comparision;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FINAL_MISMATCH_CONTENTS_LINENUM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the path of the file to be compared: ");
        String filePath = scanner.nextLine();

        
        String fileContents = readFileContents(filePath);
        if (fileContents == null) {
            System.out.println("Unable to read the specified file: " + filePath);
            return;
        }

        
        String existingFilePath = "/Users/kavana/eclipse-workspace/User__Login/src/test/java/Text2.txt";

        
        String existingFileContents = readFileContents(existingFilePath);
        if (existingFileContents == null) {
            System.out.println("Unable to read the existing file: " + existingFilePath);
            return;
        }

        
        compareFiles(filePath, existingFilePath, fileContents, existingFileContents);
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

    
    private static void compareFiles(String filePath1, String filePath2, String fileContents1, String fileContents2) {
        String[] lines1 = fileContents1.split("\n");
        String[] lines2 = fileContents2.split("\n");

        int maxLength = Math.max(lines1.length, lines2.length);
        boolean mismatchFound = false;

        for (int i = 0; i < maxLength; i++) {
            if (i < lines1.length && i < lines2.length) {
                if (!lines1[i].equals(lines2[i])) {
                    System.out.println("Mismatch found at line " + (i + 1) + " in files:");
                    System.out.println("File 1 : " + lines1[i]);
                    System.out.println("File 2 : " + lines2[i]);
                    mismatchFound = true;
                }
            } else if (i < lines1.length) {
                System.out.println("File 2 (" + filePath2 + ") is shorter than File 1 (" + filePath1 + "). Additional content in File 1:");
                System.out.println("Line " + (i + 1) + ": " + lines1[i]);
                mismatchFound = true;
            } else {
                System.out.println("File 1 (" + filePath1 + ") is shorter than File 2 (" + filePath2 + "). Additional content in File 2:");
                System.out.println("Line " + (i + 1) + ": " + lines2[i]);
                mismatchFound = true;
            }
        }

        if (!mismatchFound) {
            System.out.println("The contents of the files are identical.");
        }
            else
            {
            	 System.out.println("The contents of the files are not identical.");
            }
        }
    }

