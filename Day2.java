import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.io.BufferedReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;

public class Day2 {
    public static void main(String[] args) {
        int totalScore = 0;
        var shapeScores = new LinkedHashMap<String, Integer>();
        shapeScores.put("A", 1);
        shapeScores.put("B", 2);
        shapeScores.put("C", 3);
        shapeScores.put("X", 1);
        shapeScores.put("Y", 2);
        shapeScores.put("Z", 3);
        var victoryCombinations = new ArrayList<String>();
        victoryCombinations.add("AY");
        victoryCombinations.add("BZ");
        victoryCombinations.add("CX");

        Path pathToInput = Paths.get(args[0]);
        try (BufferedReader input = Files.newBufferedReader(pathToInput, Charset.forName("UTF-8"))) {
            String line = null;
            var games = new ArrayList<Integer>();
            while ((line = input.readLine()) != null) {
                String[] shapes = line.split(" ");
                int gameScore = 0;

                if (shapeScores.get(shapes[0]) == shapeScores.get(shapes[1])) {
                    gameScore = 3 + shapeScores.get(shapes[0]);
                } else if (victoryCombinations.contains(shapes[0] + shapes[1])) {
                    gameScore = 6 + shapeScores.get(shapes[1]);
                } else {
                    gameScore = 0 + shapeScores.get(shapes[1]);
                }

                games.add(gameScore);
            }

            totalScore = games.stream()
                .mapToInt(e -> e)
                .sum();
        } catch (IOException problem) {
            //TODO: handle exception
        }

        System.out.println(totalScore);
    }
}
