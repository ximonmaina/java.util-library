package lambdasandstreams;
// Demonstrating lambdas and streams with an array of Strings

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStringStreams {
    public static void main(String[] args) {
        String[] strings = {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};

        System.out.printf("Original Strings: %s%n", Arrays.asList(strings));

        //strings in uppercase
        System.out.printf("strings in uppercase: %s%n",
                Arrays.stream(strings)
                .map(String::toUpperCase)
                .collect(Collectors.toList()));

        // strings less than "n" (case insensitive) sorted ascending
        System.out.printf("Strings less than n sorted ascending: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("n") < 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER)
                        .collect(Collectors.toList()));

        // strings less than "n" (case insensitive) sorted descnending
        System.out.printf("strings less than n sorted descending: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("n") < 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                        .collect(Collectors.toList()));


    }
}
