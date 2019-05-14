package genericmethodsandclasses;

import java.util.NoSuchElementException;

public class StackTest {
    public static void main(String[] args) {
        Double[] doubleElements = {1.1,2.2,3.3,4.4,5.5};
        Integer[] integerElements = {1,2,3,4,5,6,7,8,9,10};

        Stack<Double> doubleStack = new Stack<>(5);
        Stack<Integer> integerStack = new Stack<>();

        testPush("doubleStack",doubleStack, doubleElements);
        testPop("doubleStack",doubleStack);

        testPush("integerStack",integerStack, integerElements);
        testPop("integerStack",integerStack);
    }

    private static <E> void testPush(String name, Stack<E> stack ,E[] elements) {
        System.out.printf("%nPushing elements onto %s%n", name);

        for (E element: elements) {
            System.out.printf("%.1f ", element);
            stack.push(element);
        }
    }

    private static <E> void testPop(String name, Stack<E> stack) {
        try {
            System.out.printf("%nPopping elements from %s%n",name);
            E popValue;

            while (true) {
                popValue = stack.pop();
                System.out.printf("%.1f ", popValue);
            }
        }catch (NoSuchElementException n) {
            System.err.println();
            n.printStackTrace();
        }
    }


}
