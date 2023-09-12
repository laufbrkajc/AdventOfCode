import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.io.BufferedReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;

public class Day4 {
    public static void main(String[] args) {
        int containedAssignments = 0;

        try (BufferedReader input = Files.newBufferedReader(Paths.get(args[0]), Charset.forName("UTF-8"))) {
            String line = null;
            while ((line = input.readLine()) != null) {
                line = line.replace(',', '-');
                int[] sections = new int[4];
                int i = 0;
                for (String sec : line.split("-")) {
                    sections[i] = Integer.parseInt(sec);
                    i++;
                }

                if ((sections[0] <= sections[2] && sections[1] >= sections[3]) ||
                    (sections[0] >= sections[2] && sections[1] <= sections[3])) {
                    containedAssignments++;
                }
            }

        } catch (IOException problem) {
            //TODO: handle exception
        }

        System.out.println(containedAssignments);
    }
}
