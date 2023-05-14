package pycro.usts.chapter04_linkedlist;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-14 6:27 PM
 * Leetcode：203
 */
public class RemoveLinkedListElements {
    class ListNode {
        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            // 虚拟头结点 virtual head
            ListNode vh = new ListNode(0, head);
            ListNode cur = vh;
            while (cur.next != null) {
                if (cur.next.val == val) {
                    // 删除之后不着急指针往后移，因为删掉节点的后一个节点可能val值也为目标值
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            return vh.next;
        }
    }
}

