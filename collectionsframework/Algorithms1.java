package collectionsframework;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Collections methods reverse, fill, copy, max and min
public class Algorithms1 {

    public static void main(String[] args) {
        Character[] letters = {'P','C','M'};
        List<Character> list = Arrays.asList(letters);
        System.out.println("list contains: ");
        output(list);
        Collections.reverse(list);
        System.out.printf("%nAfter calling reverse, list contains:%n");
        output(list);
        // create copyList from an array of 3 characters
        Character[] lettersCopy = new Character[3];
        List<Character> copyList = Arrays.asList(lettersCopy);

        Collections.copy(copyList,list);
        System.out.printf("%nAfter copying, copyList contains:%n");
        output(copyList);

        Collections.fill(list, 'R');
        System.out.printf("%nAfter calling fill, list contains:%n");
        output(list);
    }

    public static void output(List<Character> listRef) {
        System.out.print("The list is: ");
        for (Character element: listRef) {
            System.out.printf("%s ", element);
        }
        System.out.printf("%nMax: %s", Collections.max(listRef));
        System.out.printf(" Min: %s%n", Collections.min(listRef));
    }

}
