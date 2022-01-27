package utilities;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputUtility {
    // List<String> inputlines ;
    
    public static  List<String> readInputLines(String fileName) throws IOException {
        List<String> inputlines = new ArrayList<>();
        File file = new File(fileName); // creates a new file instance
        // System.out.println(file.getAbsolutePath()+ "ABSOLUTE PATH");
        FileReader fr = new FileReader(file); // reads the file
        BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
        String line;
        while ((line = br.readLine()) != null) {
            inputlines.add(line);
        }
        fr.close(); // closes the stream and release the resources
        return inputlines;
    }

}
