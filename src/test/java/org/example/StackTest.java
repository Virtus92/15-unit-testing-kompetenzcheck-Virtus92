package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTest {
    private Stack stack;

    @BeforeEach
    void setUp() {stack = new Stack();}

    @Test
    void testPopOnEmptyStack() {
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    void testPopNWithTooManyElements() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        assertThrows(EmptyStackException.class, () -> stack.pop(5));
    }

    @Test
    void testPeekOnEmptyStack() {
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }

    @Test
    void testPush() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
    }

    @Test
    void testPop() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
        assertEquals(2, stack.pop());
    }

    @Test
    void testPopN() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(4, stack.peek());

        assertArrayEquals(new int[]{4, 3}, stack.pop(2));
        assertEquals(2, stack.size());
    }
}
