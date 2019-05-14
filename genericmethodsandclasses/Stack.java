package genericmethodsandclasses;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Stack<E> {

    private final ArrayList<E> elements; //ArrayList stores stack elements

    // no-argument constructor creates a stack of the default size
    public Stack() {
        this(10);
    }

    // constructor creates a stack of the specified number of elements
    public Stack(int capacity) {
        int initCapacity = capacity > 0 ? capacity : 10;
        elements = new ArrayList<>(initCapacity);
    }

    // push element onto stack
    public void push(E pushValue) {
        elements.add(pushValue);
    }

    public  E pop() {
        if (elements.isEmpty()) {
            throw  new NoSuchElementException("Stack is empty, cannot pop");
        }

        return elements.remove(elements.size()-1);
    }
}
