package org.example;

import java.util.Arrays;

public class DoubleLinkedList<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public T getHead() {
        return (T) head.getValue();
    }

    public T getTail() {
        return (T) tail.getValue();
    }

    public void add(T o) {
        DoubleNode<T> node = new DoubleNode<>(o);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setAfter(node);
            node.setBefore(tail);
            tail = node;
        }
        size++;
    }

    public void add(int index, T o) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        DoubleNode<T> node = new DoubleNode<>(o);
        if (index == 0) {
            node.setAfter(head);
            if (head != null) {
                head.setBefore(node);
            }
            head = node;
            if (tail == null) { // Wenn Liste leer ist
                tail = node;
            }
        } else if (index == size) {
            add(o);
            return;
        } else {
            DoubleNode<T> temp = iterate(index);
            node.setBefore(temp);
            node.setAfter(temp.getAfter());
            temp.setAfter(node);
            if (node.getAfter() != null) {
                node.getAfter().setBefore(node);
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        DoubleNode<T> temp = iterate(index);
        return (T) temp.getValue();
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        if (head==tail) {
            DoubleNode<T> temp = head;
            head =null;
            tail=null;
            size--;
            return (T) temp.getValue();
        }
        DoubleNode<T> temp;
        if (index==0) {
            temp=head;
            head = head.getAfter();
            head.setBefore(null);
        } else if (index==size-1) {
            temp = tail;
            tail = tail.getBefore();
            tail.setAfter(null);
        } else {
            DoubleNode<T> current = iterate(index);
            temp = current.getAfter();
            current.setAfter(temp.getAfter());
            if (current.getAfter()!=null) {
                current.getAfter().setBefore(current);
            }
        }
        size--;
        return (T) temp.getValue();
    }

    public DoubleNode<T> iterate(int index) {
        if (index<size/2) {
            DoubleNode<T> current = head;
            for (int i = 0; i < index-1; i++) {
                current = current.getAfter();
            }
            return current;
        } else {
            DoubleNode<T> current = tail;
            for (int i = 0; i < size-index-1; i++) {
                current = current.getBefore();
            }
            return current;
        }
    }

    @Override
    public String toString() {
        String[] list = new String[size];
        DoubleNode temp = head;
        int i=0;
        while (temp!=null) {
            list[i] = temp.getValue().toString();
            temp = temp.getAfter();
            i++;
        }
        return Arrays.toString(list);
    }

    public String toReverseString() {
        String[] list = new String[size];
        DoubleNode temp = tail;
        int i=0;
        while (temp!=null) {
            list[i] = temp.getValue().toString();
            temp = temp.getBefore();
            i++;
        }
        return Arrays.toString(list);
    }
}

