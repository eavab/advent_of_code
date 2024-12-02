package aoc;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
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
        // TODO: setup some control values here for if it is a resource file in the project or out in the internet
        //filePath = "data/"+filePath;

        // get file pointer from Resources
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resources = classLoader.getResource(filePath);

        assert resources != null;
        return new File(resources.getFile());
    }

    public int[] tokenize(String line) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(line);
        int[] tokens = new int[2];
        int i = 0;
        while(matcher.find()) {
            tokens[i] = Integer.parseInt(matcher.group());
            i++;
        }

        return tokens;
    }
}