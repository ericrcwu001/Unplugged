import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class FileReader {
    // Variable Declaration
    private String filePath;
    private ArrayList<String> words;

    /**
     * turns filePath into an ArrayList of each .next()
     * @return ArrayList of Strings
     */
    private ArrayList<String> separateText() {
        ArrayList<String> wordsT = new ArrayList<>();
        try {
            File f = new File(filePath);
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String str = s.next();
                wordsT.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return wordsT;
    }
    public FileReader(String filePath) {
        this.filePath = filePath;
        words = separateText();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<String> getWords() {
        return words;
    }
}
