package pycro.usts.chapter04_linkedlist;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-14 7:33 PM
 * Leetcode：206
 */
public class ReverseLinkedList {

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

    // 解法1：额外空间
    class Solution1 {
        public  ListNode reverseList(ListNode head) {
            // 判断单节点和空节点直接返回
            if (head.next == null || head == null) return head;
            // 定义一个反转后的虚拟头结点
            ListNode reverseDummyHead = new ListNode();
            ListNode cur = head;
            while (cur != null) {
                cur.next = reverseDummyHead.next;
                reverseDummyHead.next = cur;
                cur = cur.next;
            }
            return reverseDummyHead.next;
        }
    }

    // 解法2：双指针
    class Solution2 {
        public ListNode reverseList(ListNode head) {
            // 双指针
            ListNode cur = head; // 当前节点
            ListNode pre = null; // 当前节点的前一个节点
            ListNode next; // 当前节点的后一个节点
            while (cur != null) {
                // 保存当前节点的后一个节点
                next = cur.next;
                // 反转
                cur.next = pre;
                // 移动
                pre = cur;
                cur = next;
            }
            // 循环结束后，pre指向最后一个节点，而cur为指向null
            return pre;
        }
    }

    // 解法3：递归反转
    class Solution3 {
        public ListNode reverseList(ListNode head) {
            return reverse(null, head);
        }
        ListNode reverse(ListNode pre, ListNode cur){
            // 反转完成则直接返回
            if (cur == null) return pre;
            // 保存当前节点的下一个节点
            ListNode next = cur.next;
            cur.next = pre;
            // 递归反转，当前的cur为pre参数，而next为cur参数
            return reverse(cur, next);
        }
    }
}
