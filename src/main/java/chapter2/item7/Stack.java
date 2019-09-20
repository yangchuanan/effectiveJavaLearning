package chapter2.item7;

import java.util.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/8/25 14:41
 * @Description 消除过期对象的引用，防止内存泄漏
 * Can you spot the "memory leak"?  (Pages 26-27)
 * @Version 0.0.1
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * @Author Chuanan YANG
     * @DateTime 2019/8/25 14:45
     * @Description 出栈时只是将指向的当前位置变了，但元素一直都存在
     */
    public Object pop() {
        if (size == 0) {
            // 空元素异常
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    /**
     * @Author Chuanan YANG
     * @DateTime 2019/8/25 14:46
     * @Description 防止内存泄漏的出栈方法
     * Corrected version of pop method (Page 27)
     */
//    public Object pop() {
//        if (size == 0)
//            throw new EmptyStackException();
//        Object result = elements[--size];
//        // Eliminate obsolete reference
//        elements[size] = null;
//        return result;
//    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (String arg : args) {
            stack.push(arg);
        }

        while (true) {
            System.err.println(stack.pop());
        }
    }
}
