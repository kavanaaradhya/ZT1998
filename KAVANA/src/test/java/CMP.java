import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CMP{

    public static void main(String[] args) {
        String file1Path = "/Users/kavana/eclipse-workspace/KAVANA/src/test/java/Check.feature";
        String file2Path = "/Users/kavana/eclipse-workspace/KAVANA/src/test/java/Target.feature";

        try {
            compareFiles(file1Path, file2Path);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                System.out.println();
            }

            line1 = reader1.readLine();
            line2 = reader2.readLine();
            lineNumber++;
        }

        reader1.close();
        reader2.close();
    }
}
