package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueueTest {
    private Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue();
    }

    @Test
    void testEnqueue() {
        assertEquals(0, queue.size());
        queue.enqueue(1);
        assertEquals(1, queue.size());
    }

    @Test
    void testDequeue(){
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    void testDequeueN() {
        assertEquals(0, queue.size());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());
        assertArrayEquals(new int[]{1,2}, queue.dequeue(2));
        assertEquals(1, queue.size());
    }

    @Test
    void testDequeueOnEmptyQueue() {
        assertThrows(EmptyStackException.class, () -> queue.dequeue());
    }

    @Test
    void testDequeueNOnEmptyQueue() {
        assertThrows(EmptyStackException.class, () -> queue.dequeue(5));
    }

}
