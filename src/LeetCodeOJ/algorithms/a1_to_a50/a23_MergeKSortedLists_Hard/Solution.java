package algorithms.a1_to_a50.a23_MergeKSortedLists_Hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by 31798 on 2016/10/9.
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                ListNode n1 = (ListNode) o1, n2 = (ListNode) o2;
                return n1.val - n2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode ans = heap.poll(), tail = ans;
        if (tail.next != null) {
            heap.add(tail.next);
        }
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null) {
                heap.add(tail.next);
            }
        }
        return ans;
    }
}