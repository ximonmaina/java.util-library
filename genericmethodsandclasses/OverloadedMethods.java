package genericmethodsandclasses;
// Printing array elements using overloaded methods
public class OverloadedMethods {
    public static void main(String[] args) {
        Integer[] integerArray = {1,2,3,4,5,6};
        Double[] doubleArray = {1.1,2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};

        System.out.printf("Array integerArray  contains: ");
        printArray(integerArray);
        System.out.printf("Array doubleArray contains: ");
        printArray(doubleArray);
        System.out.printf("Array characterArray contains: ");
        printArray(characterArray);
    }

    public static void printArray(Integer[] inputArray) {
        // display array elements
        for (Integer element: inputArray) {
            System.out.printf("%s", element);
        }
        System.out.println();
    }

    // method printArray to print Double array
    public static void printArray(Double[] inputArray) {
        for (Double element: inputArray) {
            System.out.printf("%s ", element);
        }

        System.out.println();
    }

    public static void printArray(Character[] inputArray) {
        for (Character element: inputArray) {
            System.out.printf("%s ", element);
        }
    }
}
