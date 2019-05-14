package collectionsframework.list;

import java.util.Arrays;
import java.util.LinkedList;

// Viewing arrays as Lists and converting Lists to arrays
public class UsingToArray {
    public static void main(String args[]) {
        String[] colors = {"black", "blue","yellow"};
        LinkedList<String> links = new LinkedList<>(Arrays.asList(colors));
        links.addLast("red");
        links.add(3,"green");
        links.addFirst("cyan");

        colors = links.toArray(new String[links.size()]);

        System.out.println("colors: ");

        for (String color: colors) {
            System.out.println(color);
        }
    }
}
