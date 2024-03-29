import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ABC {
    public static void main(String[] args) {
        String file1Path = "/Users/kavana/eclipse-workspace/KAVANA/src/test/java/Check.feature";
        String file2Path = "/Users/kavana/eclipse-workspace/KAVANA/src/test/java/Target.feature";

        try {
            int mismatchedLines = compareFiles(file1Path, file2Path);
            if (mismatchedLines == 0) {
                System.out.println("Files are identical.");
            } else {
                System.out.println("Number of mismatched lines: " + mismatchedLines);
            }
        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }

    public static int compareFiles(String filePath1, String filePath2) throws IOException {
        List<String> lines1 = readTrimmedLines(filePath1);
        List<String> lines2 = readTrimmedLines(filePath2);

        int maxLength = Math.max(lines1.size(), lines2.size());
        int mismatchedLines = 0;

        for (int i = 0; i < maxLength; i++) {
            String line1 = i < lines1.size() ? lines1.get(i) : "";
            String line2 = i < lines2.size() ? lines2.get(i) : "";

            if (!line1.equals(line2)) {
                System.out.println("Mismatch at line " + (i + 1));
                mismatchedLines++;
            }
        }

        return mismatchedLines;
    }

    private static List<String> readTrimmedLines(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    lines.add(line);
                }
            }
        }

        return lines;
    }
}
