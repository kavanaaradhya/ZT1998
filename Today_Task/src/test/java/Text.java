import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Text{
    public static void main(String[] args) {
        String file1Path = "/Users/kavana/eclipse-workspace/Today_Task/src/test/java/text1.txt";
        String file2Path ="/Users/kavana/eclipse-workspace/Today_Task/src/test/java/text2ß.txt";

        try {
            List<MismatchedLine> mismatchedLines = compareFiles(file1Path, file2Path);
            if (mismatchedLines.isEmpty()) {
                System.out.println("Files are identical.");
            } else {
                System.out.println("Mismatched lines:");
                for (MismatchedLine line : mismatchedLines) {
                    System.out.println("Line " + line.getLineNumber() + ":");
                    System.out.println("File 1: " + line.getLineFromFile1());
                    System.out.println("File 2: " + line.getLineFromFile2());
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }

    public static List<MismatchedLine> compareFiles(String filePath1, String filePath2) throws IOException {
        List<String> lines1 = readTrimmedLines(filePath1);
        List<String> lines2 = readTrimmedLines(filePath2);

        int maxLength = Math.max(lines1.size(), lines2.size());
        List<MismatchedLine> mismatchedLines = new ArrayList<>();

        for (int i = 0; i < maxLength; i++) {
            String line1 = i < lines1.size() ? lines1.get(i) : "";
            String line2 = i < lines2.size() ? lines2.get(i) : "";

            if (!line1.equals(line2)) {
                mismatchedLines.add(new MismatchedLine(i + 1, line1, line2));
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

class MismatchedLine {
    private int lineNumber;
    private String lineFromFile1;
    private String lineFromFile2;

    public MismatchedLine(int lineNumber, String lineFromFile1, String lineFromFile2) {
        this.lineNumber = lineNumber;
        this.lineFromFile1 = lineFromFile1;
        this.lineFromFile2 = lineFromFile2;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getLineFromFile1() {
        return lineFromFile1;
    }

    public String getLineFromFile2() {
        return lineFromFile2;
    }
}
