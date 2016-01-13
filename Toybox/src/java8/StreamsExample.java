package java8;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class StreamsExample {
    public static void main(String... args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        List<Integer> result = forkJoinPool.submit(() ->
                range(1, 1_000_000).parallel().filter(PrimesPrint::isPrime).boxed().collect(toList())
        ).get();

        range(1, 10).mapToObj(result::get).forEach(System.out::println);
    }
}

class PrimesPrint {
    static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}