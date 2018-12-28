import java.util.*;
import java.io.IOException;
import java.io.*;

public class task5 {

    public static ArrayList<String> GetWordsTextFromFile(String filename)throws IOException {
        File file = new File(filename);
        ArrayList<String> text = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while (line!=null) {
            String[] words = line.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                text.add(words[i]);
            }
            line = bufferedReader.readLine();
        }
        return text;
    }
    public static void printText(List<String> text) {
        for(String word : text) {
            System.out.println(word);
        }
    }

    public static void main(String args[]) {
        ArrayList Eng = new ArrayList();
        ArrayList Rus = new ArrayList();
        ArrayList Ukr = new ArrayList();
        try{
            Eng = GetWordsTextFromFile("eng.txt");
            Rus  = GetWordsTextFromFile("rus.txt");
            Ukr = GetWordsTextFromFile("ukr.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(Eng, String.CASE_INSENSITIVE_ORDER);
        Collections.sort(Rus, String.CASE_INSENSITIVE_ORDER);
        Collections.sort(Ukr, String.CASE_INSENSITIVE_ORDER);

        System.out.println("Eng\n");
        printText(Eng);
        System.out.println("\nRus\n");
        printText(Rus);
        System.out.println("\nUkr\n");
        printText(Ukr);

    }
}
