package lambdasandstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Demonstrating lambdas and streams with an array of integers
public class ArraysAndStreams {
    public static void main(String[] args) {
        Integer[] values = {2,9,5,0,3,7,1,4,8,6};

        System.out.printf("Original values: %s%n", Arrays.asList(values));

        //sort vales in ascending order
        System.out.printf("Sorted values: %s%n",
                Arrays.stream(values)
                            .sorted()
                            .collect(Collectors.toList()));

        // values greater than 4
        List<Integer> greaterThan4 =
                Arrays.stream(values)
                            .filter(value -> value > 4)
                            .collect(Collectors.toList());

        System.out.printf("Values greater than 4: %s%n", greaterThan4);

        //filter values greater than 4 then sort the results
        System.out.printf("Sorted values greater than 4: %s%n",
                Arrays.stream(values)
                            .sorted()
                            .filter(value -> value > 4)
                            .collect(Collectors.toList()));

        System.out.printf("Values greateer than 4 (ascending with streams): %s%n",
                greaterThan4.stream()
                            .sorted()
                            .collect(Collectors.toList()));


    }


}
