import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.io.BufferedReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;

public class Day3 {
    public static void main(String[] args) {
        int totalPriority = Integer.MIN_VALUE;

        try (BufferedReader input = Files.newBufferedReader(Paths.get(args[0]), Charset.forName("UTF-8"))) {
            String line = null;
            var commonItems = new ArrayList<Character>();
            while ((line = input.readLine()) != null) {
                commonItems.add(
                    duplicatedItem(
                        line.substring(0, line.length()/2),
                        line.substring(line.length()/2, line.length()))
                    .orElse('!'));
            }

            totalPriority = commonItems.stream()
                .mapToInt(e -> e - ((Character.isUpperCase(e))? 38 : 96))
                .sum();
        } catch (IOException problem) {
            //TODO: handle exception
        }

        System.out.println(totalPriority);
    }

    private static Optional<Character> duplicatedItem(String str0, String str1) {
        for (char ch : str0.toCharArray()) {
            if (str1.indexOf(ch) > -1)
                return Optional.of(ch);
        }

        return Optional.empty();
    }
}
