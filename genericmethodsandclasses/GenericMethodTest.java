package genericmethodsandclasses;
// printing array elements using generic method printArray
public class GenericMethodTest {
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
    // generic method printArray
    public static <T> void printArray(T[] inputArray) {
        for (T element: inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
}
