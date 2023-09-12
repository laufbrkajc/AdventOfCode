import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Stack;
import java.io.BufferedReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

public class Day5 {
    public static void main(String[] args) {
        try (BufferedReader input = Files.newBufferedReader(Paths.get(args[0]), Charset.forName("UTF-8"))) {
            int maxHeight = 0;
            var crates = new ArrayList<Stack<String>>();
            var buffer = new ArrayList<String>();
            String topology = "";

            String line = input.readLine();
            do {
                buffer.add("");
                for (int i = 1; i < line.length(); i += 4) {
                    String ch = line.substring(i, i + 1);
                    buffer.set(maxHeight, buffer.get(maxHeight) + ch);
                }

                if (!line.equals("")) {
                    maxHeight++;
                }

                line = input.readLine();
            } while (!line.equals(""));

            for (int y = (maxHeight - 1); y >= 0; y--) {
                for (int i = 0; i < buffer.get(y).length(); i++) {
                    if (y == (maxHeight - 1)) {
                        crates.add(new Stack<String>());
                    }
                    String ch = buffer.get(y).substring(i, i + 1);
                    if (ch.matches("\\p{javaUpperCase}"))
                        crates.get(i).add(ch);
                }
            }
            maxHeight--;


            while ((line = input.readLine()) != null) {
                String[] orders = line.split(" ");
                moveCrates(crates, Integer.parseInt(orders[1]), (Integer.parseInt(orders[3]) - 1), (Integer.parseInt(orders[5]) - 1));
            }

            for (Stack<String> ss : crates) {
                topology += ss.peek();

                for (String cc : ss)
                    System.out.print(cc + " ");
                System.out.println("");
            }

            System.out.println("The top crates are " + topology);
        } catch (IOException problem) {
            //TODO: handle exception
        }
    }

    public static void moveCrates(ArrayList<Stack<String>> ss, int units, int stackFrom, int stackTo) {
        for (int i = 0; i < units; i++) {
            String cc = ss.get(stackFrom).pop();
            // System.out.println(cc);
            ss.get(stackTo).add(cc);
        }
    }
}
