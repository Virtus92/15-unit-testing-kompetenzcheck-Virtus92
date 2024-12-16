package org.example;

import java.util.EmptyStackException;

public class Stack {
    private int size = 0;
    private final DoubleLinkedList<Integer> stack;

    public Stack() {
        stack = new DoubleLinkedList<>();
    }

    public void push(int newElement) {
        stack.add(newElement);
        size++;
    }

    public int size() {
        return size;
    }

    public int pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        int temp = stack.getTail();
        stack.remove(size - 1);
        --size;
        return temp;
    }

    public int peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return stack.get(size-1);
    }

    public int[] pop(int n) {
        if (n > size) {
            throw new EmptyStackException();
        }
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = stack.get(size - 1);
            stack.remove(size - 1);
            size--;
        }
        return temp;
    }
}