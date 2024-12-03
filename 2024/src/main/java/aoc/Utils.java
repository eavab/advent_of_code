package aoc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static List<String> splitLines(String input) {
        return Arrays.asList(input.split(System.lineSeparator()));
    }

    public void getInputLinesByLine(Consumer<String> reader, String filePath) {
        try(BufferedReader br = new BufferedReader(new FileReader(getInput(filePath)))) {
            String line;
            while((line = br.readLine()) != null) {
                reader.accept(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public File getInput(String filePath) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resources = classLoader.getResource(filePath);

        assert resources != null;
        return new File(resources.getFile());
    }

    public int[] tokenize(String line) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(line);
        List<Integer> tokenList = new ArrayList<>();

        while (matcher.find()) {
            tokenList.add(Integer.parseInt(matcher.group()));
        }

        // Convert the list to an array
        return tokenList.stream().mapToInt(Integer::intValue).toArray();
    }
}