package org.example;

import java.util.EmptyStackException;

public class Queue {
    private DoubleLinkedList list;
    private int size;

    public Queue() {
        list = new DoubleLinkedList();
        size = 0;
    }

    public void enqueue(int newElement) {
        list.add(newElement);
        size++;
    }

    public int size() {
        return size;
    }

    public int dequeue() {
        if (size==0) {
            throw new EmptyStackException();
        }
        int temp = (int) list.getHead();
        list.remove(0);
        size--;
        return temp;
    }

    public int[] dequeue(int n) {
        if (n>size) {
            throw new EmptyStackException();
        }
        int[] temp = new int[n];
        for (int i=0; i<n; i++) {
            temp[i] = (int) list.getHead();
            list.remove(0);
            size--;
        }
        return temp;
    }
}
