package lambdasandstreams;
// Sum the integers from 1 through to 10 with IntStream

import java.util.stream.IntStream;

public class StreamReduce {
    public static void main(String [] args) {
        System.out.printf("Sum of 1 to 10 is: %d%n", IntStream.rangeClosed(1,10)
                                                                         .sum());

    }
}
