import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Set;
import java.io.BufferedReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;

public class Day1 {
    public static void main(String[] args) {
        int maxCalories = 0;
        Path pathToInput = Paths.get("/home/madrad/Projects/Java/AdventOfCode/input_Day1.txt");
        try (BufferedReader input = Files.newBufferedReader(pathToInput, Charset.forName("UTF-8"))) {
            String line = null;
            var calories = new ArrayList<Integer>();
            calories.add(0);
            while ((line = input.readLine()) != null) {
                if (line.equals("")) {
                    calories.add(0);
                } else {
                    calories.set((calories.size() - 1), calories.get(calories.size() - 1) + Integer.parseInt(line));
                }
            }

            maxCalories = calories.stream()
                .max(Integer::compare)
                .orElse(-1);
        } catch (IOException e) {
            //TODO: handle exception
        }

        System.out.println(maxCalories);
    }
}
