package chapter5.item29.technqiue2;

import java.util.Arrays;

import chapter5.item29.EmptyStackException;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/1 20:06
 * @Description 泛型类
 * Generic stack using Object[] (Pages 130-3)
 * @Version 0.0.1
 */
public class Stack<E> {
    // Object数组
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // Appropriate suppression of unchecked warning
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        // push requires elements to be of type E, so cast is correct
        @SuppressWarnings("unchecked") E result =
                (E) elements[--size];

        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    // Little program to exercise our generic Stack
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String arg : args) {
            stack.push(arg);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().toUpperCase());
        }
    }
}
