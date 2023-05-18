package pycro.usts.chapter04_linkedlist;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-18 5:44 PM
 */
public class LinkedListCycleII {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 解法1：双指针法
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    ListNode idx1 = fast, idx2 = head;
                    while (idx1 != idx2) {
                        idx1 = idx1.next;
                        idx2 = idx2.next;
                    }
                    return idx1;
                }
            }
            return null;
        }
    }
}
