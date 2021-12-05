package com.tct.list;

public class Node {

    Object value;
    Node next;

    public Node() {
    }

    public Node(int value) {
        this(value, null);
    }

    public Node(Object value, Node node) {
        this.value = value;
        this.next = node;
    }
}
