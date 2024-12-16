package org.example;

public class DoubleNode<T> {
    private T value;
    private DoubleNode<T> before;
    private DoubleNode<T> after;

    public DoubleNode(T value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoubleNode<T> getAfter() {
        return after;
    }

    public DoubleNode<T> getBefore() {
        return before;
    }

    public void setAfter(DoubleNode<T> after) {
        this.after = after;
    }

    public void setBefore(DoubleNode<T> before) {
        this.before = before;
    }
}
