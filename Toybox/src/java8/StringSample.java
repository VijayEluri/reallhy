package java8;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringSample {
    public static void main(String[] args) {
        String join = String.join(":", "foobar", "foo", "bar");
        System.out.println(join);
        String str1 = join.chars().distinct().mapToObj(c -> String.valueOf((char) c))
                .sorted().collect(Collectors.joining());
        System.out.println(str1);
        String str2 = Pattern.compile(":").splitAsStream(join)
                .map(s -> {
                    System.out.printf("==%s==\n",s);
                    return s;
                })
                .filter(s -> s.contains("bar"))
                .sorted()
                .collect(Collectors.joining(":"));
        System.out.println(str2);
        Pattern pattern = Pattern.compile(".*@gmail\\.com");
        long count = Stream.of("bob@gmail.com", "alice@hotmail.com")
                .filter(pattern.asPredicate())
                .count();
        System.out.println(count);
    }
}
