package algorithms.a1_to_a50.a25_ReverseNodesInKGroup_Hard;

/**
 * Created by 31798 on 2016/10/16.
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k - 1; i++) {
            tail = tail.next;
            if (tail == null) {
                return head;
            }
        }
        ListNode nextHead = tail.next;
        reverseHelper(head, tail);
        head.next = reverseKGroup(nextHead, k);
        return tail;
    }

    private void reverseHelper(ListNode head, ListNode tail) {
        ListNode now = head.next;
        ListNode pre = head;
        while (now != tail) {
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        now.next = pre;
    }
}