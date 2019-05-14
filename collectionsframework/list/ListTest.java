package collectionsframework.list;

// Lists, LinkedLists and ListIterators

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListTest {
    public static void main(String [] args) {
        String[] colors = {"black", "yellow", "green", "blue", "violet", "silver"};
        List<String> list1 = new LinkedList<>();

        for (String color: colors) {
            list1.add(color);
        }

        String[] colors2 = {"gold", "white","brown","blue","gray","silver"};
        List<String> list2 = new LinkedList<>();

        for (String color : colors2) {
            list2.add(color);
        }

        list1.addAll(list2); //concatenate lists
        list2 = null; //release resources

        convertToUpperaseStrings(list1);
        printList(list1);

        System.out.printf("%nDeleting elements 4 to 6...");
        removeItems(list1,4,7);
        printList(list1);
        printReversedList(list1);


    }

    private static void printList(List<String> list) {
        System.out.printf("%nlist:%n",list);

        for (String color: list) {
            System.out.printf("%s ", color);
        }
        System.out.println();
    }

    //locate string objects and convert to uppercase
    private static void convertToUpperaseStrings(List<String> list) {
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {

            String color = listIterator.next().toUpperCase();
            listIterator.set(color);
        }
    }

    //obtain sublist and use clear method to delete sublist items
    private static void removeItems(List<String> list, int start, int end) {
        list.subList(start,end).clear();
    }

    private static void printReversedList(List<String> list) {
        ListIterator<String> listIterator = list.listIterator(list.size());


        System.out.printf("%nReversed List: %n");

        while (listIterator.hasPrevious()) {
            System.out.printf("%s ", listIterator.previous() );
        }
    }
}
