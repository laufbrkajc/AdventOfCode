import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

public class Day6 {
    public static void main(String[] args) {
        try (BufferedReader input = Files.newBufferedReader(Paths.get(args[0]), Charset.forName("UTF-8"))) {
            var candidateMarker = new ArrayList<Character>();
            for (int i = 0; i < 14; i++)
                candidateMarker.add('#');

            int chars = 0;

            int nextChar;
            do {
                nextChar = input.read();
                candidateMarker.set(chars%14, (char)nextChar);
                chars++;

                if (chars >= 14) {
                    var noDups = new LinkedHashSet<Character>(candidateMarker);

                    if (noDups.size() != 14) {
                        continue;
                    }

                    System.out.println("First marker after character " + chars);
                    return;
                }
            } while (nextChar != -1);
        } catch (IOException problem) {
            //TODO: handle exception
        }
    }
}
