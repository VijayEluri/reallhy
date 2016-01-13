package java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FileWalker {
    public static void main(String[] args) {
        // clean target folder
        boolean clean = Boolean.getBoolean(args[0]);
        // find source files
        Path start = Paths.get("/");
        try (Stream<Path> stream = Files.find(start, 10,
                (path, attr) ->
                        Stream.of(".pptx", ".pdf").anyMatch(String.valueOf(path)::endsWith))) {
            stream
                    .map(p -> p.toAbsolutePath())
                    .parallel().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // target folder

    }
}
