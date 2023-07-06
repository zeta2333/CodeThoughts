package usts.pycro.chapter04_linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-14 7:17 PM
 * Leetcode：707
 */
public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtTail(1);
        list.addAtTail(1);
        list.addAtTail(1);
        list.addAtTail(1);
        list.addAtTail(1);
        Set<Node> visited = new HashSet<>();
        Node cur = list.dummyHead;
        while (cur.next != null) {
            cur = cur.next;
            visited.add(cur);
        }
        System.out.println(visited.size());
    }
}

class Node {
    int val;
    Node next;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

// 练习链表的基本操作
class MyLinkedList {
    int size; // 链表长度
    Node dummyHead;// 虚拟头结点

    public MyLinkedList() {
        dummyHead = new Node(0);
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node cur = dummyHead.next;
        while (index-- > 0) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        Node item = new Node(val);
        item.next = dummyHead.next;
        dummyHead.next = item;
        size++;
    }

    public void addAtTail(int val) {
        Node item = new Node(val);
        Node cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = item;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        Node item = new Node(val);
        Node cur = dummyHead;
        while (index-- > 0) {
            cur = cur.next;
        }
        item.next = cur.next;
        cur.next = item;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node cur = dummyHead;
        while (index-- > 0) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */