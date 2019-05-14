package genericmethodsandclasses;

import java.util.ArrayList;
import java.util.List;

public class TotalNumbers {
    public static void main(String[] args) {
        // create, initialize and output List of Numbers containing
        // both Integers and Doubles, then display total of the elements
        Integer[] integers = {1,2,3,4,5};
        List<Integer> integerList = new ArrayList<>();

        for (Integer element : integers) {
            integerList.add(element);
        }

        System.out.printf("integerList contains: %s%n", integerList);
        System.out.printf("Total of the elements in integerList: %.0f%n%n",
                sum(integerList));

        Double[] doubles = {1.1,3.3,5.5};
        List<Double> doubleList = new ArrayList<>();

        for (Double element: doubles) {
            doubleList.add(element);
        }

        System.out.printf("doubleList contains: %s%n", doubleList);
        System.out.printf("Total of the elements in doubleList: %.1f%n%n", sum(doubleList));
        Number[] numbers = {1,2.4,3,4.1}; // Integers and Doubles
        List<Number> numberList = new ArrayList<>();

        for (Number number : numbers) {
            numberList.add(number);
        }

        System.out.printf("numberList contains: %s%n", numberList);
        System.out.printf("Total of the elements in numberList: %.1f%n",
                sum(numberList));
    }

    public static double sum(List<? extends Number> list) {
        double total = 0;

        for (Number element: list) {
            total += element.doubleValue();
        }
        return total;
    }
}
