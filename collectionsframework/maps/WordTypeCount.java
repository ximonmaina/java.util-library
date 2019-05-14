package collectionsframework.maps;

import java.util.*;

// Program counts the number of occurrences of each word in a string
public class WordTypeCount {

    public static void main(String [] args) {
        // HashMap to store String keys and Integer values
        Map<String, Integer> myMap = new HashMap<>();

        createMap(myMap); //create map based on user input
        displayMap(myMap); // display map content

    }

    private static void createMap(Map<String,Integer> map) {
        Scanner scanner = new Scanner(System.in); // create scanner
        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        // tokenize the input
        String [] tokens = input.split(" ");


        // processing input text
        for (String token: tokens) {
            String word = token.toLowerCase();

            if (map.containsKey(word)) { // is word in string
                int count = map.get(word); // get current count
                System.out.println(count);
                map.put(word, count + 1); // increment count
            } else {
                map.put(word, 1); // add new word with a count of 1 to map
            }
        }


    }

    private static void displayMap(Map<String,Integer> map) {
        Set<String> keys = map.keySet(); //get keys

        // sort keys
        TreeSet<String> sortedKeys = new TreeSet<>(keys);

        System.out.printf("%nMap contains:%nKey\t\tValue%n");

        //generate output for each key in map
        for (String key: sortedKeys) {
            System.out.printf("%-10s%10s%n", key, map.get(key));
        }

        System.out.printf("%nsize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
    }
}
