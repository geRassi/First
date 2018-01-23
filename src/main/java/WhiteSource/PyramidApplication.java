package WhiteSource;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class PyramidApplication {

    public static void main(String[] args) {

        final String fileName = "C:\\Users\\Rami\\IdeaProjects\\Sandbox\\src\\main\\java\\WhiteSource\\Pyramid.txt";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            Node node = new Node();
            stream.forEach(s -> addNodes(node, s));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addNodes(Node node, String s) {
//        List<Integer>  integers = new ArrayList<>();
//                Arrays.stream(s.split(" ")).map(i-> );

//        for (String number : numbers) {
//
//        }

    }

}
