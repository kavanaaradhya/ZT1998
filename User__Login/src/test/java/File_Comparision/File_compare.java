package File_Comparision;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class File_compare {

    public static void main(String[] args) {
        
        File sourceFile = chooseFile("Choose source file");
        if (sourceFile == null) {
            System.out.println("No source file selected.");
            return;
        }

       
        String targetFilePath = "/Users/kavana/eclipse-workspace/KAVANA/src/test/java/Text2.txt"; 

        try {
            String sourceContent = readAndTrimExtraLines(sourceFile);
            String targetContent = readFile(targetFilePath);

            if (sourceContent.equals(targetContent)) {
                System.out.println("Contents of the files are equal.");
            } else {
                System.out.println("Contents of the files are not equal.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    private static File chooseFile(String dialogTitle) {
    	
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(dialogTitle);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
           
        } else {
        	
            return null;
        }
       
    }

    private static String readAndTrimExtraLines(File file) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isExtraLine = false;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    content.append(line).append("\n");
                    isExtraLine = false;
                } else if (!isExtraLine) {
                    
                    content.append("\n");
                    isExtraLine = true;
                }
            }
        }
        return content.toString().trim(); 
        
        
    }

    private static String readFile(String filePath) throws IOException {
        File file = new File(filePath);
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString().trim(); 
    }
    
    
    
    
}
