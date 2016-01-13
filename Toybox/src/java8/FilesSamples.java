package java8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesSamples {
    public static void main(String[] args) throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get(""))) {
            String joined = stream.map(String::valueOf)
                    .filter(path -> !path.startsWith("."))
                    .sorted()
                    .collect(Collectors.joining("; "));
            System.out.println("List: " + joined);
        }

        Path start = Paths.get("");
        int maxDepth = 5;
        try (Stream<Path> stream = Files.find(start, maxDepth, (path, attr) ->
                String.valueOf(path).endsWith(".java"))) {
            String joined = stream.sorted().map(String::valueOf)
                    .collect(Collectors.joining("; "));
            System.out.println("Found: " + joined);
        }

        try(Stream<Path> stream = Files.walk(start, maxDepth)){
            String joined = stream.map(String::valueOf).filter(path -> path.endsWith(".java"))
                    .sorted()
                    .collect(Collectors.joining("; "));
            System.out.println("walk(): " + joined);
        }

        List<String> lines = Files.readAllLines(Paths.get("src/golf.sh"));
        lines.add("puts 'foobar'");
        Path path = Paths.get("src/golf-modified.sh");
        Files.write(path, lines);

        try(Stream<String> stream = Files.lines(path)){
            stream.filter(line -> line.contains("puts"))
                    .map(String::trim)
                    .forEach(System.out::println);
        }

        System.out.println("a" == "a");
        System.out.println("a" != new String("a"));
        System.out.println(null != "a");
        System.out.println("a".equals("a"));

        try(BufferedReader reader = Files.newBufferedReader(path)){
            while(reader.ready())
                System.out.println(reader.readLine());
        }

        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("hello-world.sh"))){
            writer.write("puts 'Hello world'");
        }

        try(BufferedReader reader = Files.newBufferedReader(path)){
            long countPuts = reader.lines()
                    .filter(line -> line.contains("put"))
                    .count();
            System.out.println(countPuts);
        }

    }
}
