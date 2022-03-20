package com.tct.list;

public class MainLinked {

    /**
     *  解决链表相交的问题
     *  给你两个链表，可能有环和无环 求相交的节点。
     *
     *  四种情况， 首先确定两个俩表是否有环，假如：
     *   A     B
     *   1     1  都有环
     *   0     1  其中一个有环
     *   1     0  其中一个有环
     *   0     0  都无环
     *
     *   无环链表
     *
     *    情况一                     情况 二
     *    |                           |
     *    |                           |
     *    |                           |
     *    |                           |——————————
     *    |                           |
     *    |                           |
     *    |                           |
     *
     *    有环链表
     *
     *    情况一                     情况 二
     *
     *    
     *
     *  换链表 一定只有一个环，不可能有多个环，做不到。
     *
     *  入环节点， 通过hashset
     *  1. 方案一
     *   遍历节点是否可以走到 null 则 无环
     *   hashset 存入集合中，当发现集合中有 则找到了入环节点。
     *
     *  2、 快慢指针
     *
     *  S 指针一次走一步，快指针一次走两步 当快慢指针第一次相遇的时候，快指针一次走一步，慢指针一次走一步，当两个在相遇的时候，一定是入环节点
     *
     * */
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        for (int i = 0 ; i <= 10; i++) {
            singleLinkedList.addTail(i);
        }

//        System.out.println(singleLinkedList.locate(9));
        System.out.println(singleLinkedList.getSize());
        singleLinkedList.__print(singleLinkedList.getHead());
//        System.out.println(singleLinkedList.index(0));
//        singleLinkedList.deleteAtIndex(2);
//        singleLinkedList.deleteAtIndex(4);
//        singleLinkedList.deleteAtIndex(6);
//        singleLinkedList.__print();

        // 翻转俩表
        Node tmp = singleLinkedList.reversetLinked(singleLinkedList.getHead());
        singleLinkedList.__print(tmp);

    }
}
