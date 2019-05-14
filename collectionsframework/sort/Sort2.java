package collectionsframework.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Using comparator object with method sort
public class Sort2 {
    public static void  main(String [] args) {
        String suits[] = {"Hearts","Diamonds","Clubs","Spades"};

        List<String> list = Arrays.asList(suits);

        // sort in descending order using a comparator
        Collections.sort(list,Collections.reverseOrder());

        System.out.printf("sorted list elements: %s%n", list);

    }
}
