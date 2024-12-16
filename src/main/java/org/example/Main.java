package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nStack:");
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.peek());
        System.out.println(Arrays.toString(stack.pop(2)));
        stack.push(40);
        System.out.println(Arrays.toString(stack.pop(2)));

        System.out.println("\nQueue:");
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Size: " + queue.size());
        System.out.println(queue.dequeue());
        System.out.println(Arrays.toString(queue.dequeue(2)));
    }
}