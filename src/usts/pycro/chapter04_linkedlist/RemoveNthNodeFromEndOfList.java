package usts.pycro.chapter04_linkedlist;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-18 5:09 PM
 * Leetcode：19
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    // 解法1：遍历得出链表长度，然后删除指定位置的元素
    class Solution1 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int size = sizeof(head);
            int idx = size - n;
            ListNode cur = head;
            if (idx == 0) return head.next;

            while (idx-- > 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            return head;
        }

        public int sizeof(ListNode head) {
            int size = 0;
            ListNode cur = head;
            while (cur != null) {
                size++;
                cur = cur.next;
            }
            return size;
        }
    }

    // 解法2：双指针，快指针先往后移n+1位，之后快慢指针一起移动，
    // 当快指针移动到null值时，慢指针即指向待删除元素的前一个元素
    class Solution2 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 双指针，虚拟头结点
            ListNode dummyHead = new ListNode(0, head);
            ListNode fast = dummyHead, slow = dummyHead;
            int i = 0;
            // fast指针先向后移动n个位置
            while (n-- > 0) {
                fast = fast.next;
            }
            // 再移动一步
            fast = fast.next;
            // 同时移动
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            // 删除
            slow.next = slow.next.next;
            return dummyHead.next;
        }
    }
}

class ListNode {
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