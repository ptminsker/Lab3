
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class class1 {

    public static void main(String[] args) {
        String hamlet = urlToString("http://erdani.com/tdpl/hamlet.txt");
        int wordCount = 0;
        boolean word = false;
        int endOfString = hamlet.length() - 1;
        String lastWord = "";
        String findWord = "prince";
        for (int i = 0; i < hamlet.length(); i++) {
            if (Character.isLetter(hamlet.charAt(i)) && i != endOfString) {
                word = true;
                lastWord = lastWord + hamlet.charAt(i);
            }
            else if (!Character.isLetter(hamlet.charAt(i)) && word) {
                word = false;
                lastWord = lastWord.toLowerCase();
                if (lastWord.compareTo(findWord) == 0) {
                    wordCount++;
                }
                lastWord = "";
            }
            else if (Character.isLetter(hamlet.charAt(i)) && i == endOfString) {
                lastWord = lastWord.toLowerCase();
                if (lastWord.compareTo(findWord) == 0) {
                    wordCount++;
                }
                lastWord = "";
            }
        }
        System.out.println(wordCount);
    }
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
