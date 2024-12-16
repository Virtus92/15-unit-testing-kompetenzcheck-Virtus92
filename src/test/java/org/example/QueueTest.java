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
    void testDequeueOnEmptyQueue() {
        assertThrows(EmptyStackException.class, () -> queue.dequeue());
    }

    @Test
    void testDequeueNOnEmptyQueue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertThrows(EmptyStackException.class, () -> queue.dequeue(5));
    }

    @Test
    void testQueue() {
        assertEquals(0, queue.size());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());
        assertEquals(1, queue.dequeue());
        assertArrayEquals(new int[]{2,3}, queue.dequeue(2));
    }
}
