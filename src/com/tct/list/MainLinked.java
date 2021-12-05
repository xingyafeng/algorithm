package com.tct.list;

public class MainLinked {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        for (int i = 0 ; i <= 10; i++) {
            singleLinkedList. addTail(i);
        }

        System.out.println(singleLinkedList.locate(9));
        System.out.println(singleLinkedList.getSize());
        singleLinkedList.__print();
        System.out.println(singleLinkedList.index(0));
        singleLinkedList.deleteAtIndex(2);
        singleLinkedList.deleteAtIndex(4);
        singleLinkedList.deleteAtIndex(6);
        singleLinkedList.__print();

//        revertLinked(singleLinkedList);
    }
}
