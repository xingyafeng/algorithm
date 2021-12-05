package com.tct.list;

import java.util.LinkedList;

public class SingleLinkedList {

    public Node getHead() {
        return head;
    }

    private Node head = null;
    private int size = 0;

    public SingleLinkedList() {
    }

    public SingleLinkedList(Node node) {
        this.head = node;
    }

    public int getSize() {
        return size;
    }

    /**
     * pre insert
     * | x | 1 2 4
     * 理解方法： head 指向 数据 1，想要把 x 数字插入进链表。
     * 方法： 因head指针需要偏移，故需要先保存 head指针，用什么保存呢？ 新加入的节点的 next 即 newNode.next = head
     * 居然head值已存储，就可以开始移动head值至新增的节点上，即 head = newNode; 注意size++ 因为新增了一个节点
     *
     * @param vaule
     */
    public void addFrist(Object vaule) {
        Node newNode = new Node(vaule, null);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        // add one node
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * tail add
     * 1  2  3  | x |
     * ^
     * 理解：尾部插入的方法：
     * 因记录了head的指针，此事需要找到尾部的指针，判断方法 在下一个next == null的时候,就是尾部指针了。 这里用到了while (last.netxt =!null) 一直偏移
     * 尾部插入节点，直接加入last->next = newNode ; newNode.next = null
     *
     * @param value
     */
    public void addTail(int value) {
        Node newNode = new Node(value);
        Node last;

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        newNode.next = null;
        size++;
    }

    /**
     * 定位节点的位置
     *
     * @param value
     * @return
     */
    public Object locate(Object value) {

        int postion = 0;
        Node tmp = head;

        while (tmp != null && tmp.value != value) {
            tmp = tmp.next;
            postion++;
        }

        if (tmp == null) return -1;
        return postion;
    }

    public Object index(int pos) {
        if (pos <0 || pos > getSize()) throw new IndexOutOfBoundsException("over bound ...");

        Node tmp = head;
        if (head == null) return null;

        int j=0; //记录索引，head 开始设置0
        while (tmp!=null && pos !=j){
            j++;
            tmp=tmp.next;
        }

        return tmp.value;
    }

    public void deleteAtIndex(int index) {

        if (index<0 || index > getSize()) throw new IndexOutOfBoundsException("over bound ...");
        if (index ==0) {
            head = head.next;
            size--;
            return;
        }

        Node cur = head;
        Node per = null;

        if (cur == null) return;

        int postion=0;
        while (cur!=null) {
            if (index == postion) { //删除节点，记得size--;
                per.next = cur.next;
                cur.next = null;
                cur = null;
                size--;
                return;
            }

            per = cur;
            cur = cur.next;
            postion++;
        }
    }

    public static void main(String[] args) {
        System.out.println("print list");

        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        System.out.println(linkedList.size());
    }

    void __print(Node node) {

        Node tmp = node;

        if (tmp == null) {
            System.out.println("this linked is null");
        } else {
            while (tmp != null) {
                System.out.print(tmp.value + " ");
                tmp = tmp.next;
            }
            System.out.println();
        }
    }

    public Node reversetLinked(Node head) {
        Node pre = null;
        Node cur = null;

        // 三个指针，最先动的是最前面的指针，依次往前 cur pre head
        while (head!=null) {
            cur = head.next;
            head.next = pre;
            pre  = head;
            head = cur;
        }

        return pre;
    }
}

