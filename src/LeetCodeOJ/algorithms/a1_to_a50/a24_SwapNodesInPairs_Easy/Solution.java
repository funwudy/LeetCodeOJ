package algorithms.a1_to_a50.a24_SwapNodesInPairs_Easy;

/**
 * Created by 31798 on 2016/10/16.
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = newHead.next;
        newHead.next = head;
        head.next = swapPairs(head.next);
        return newHead;
    }
}