package algorithms.a1_to_a50.a23_MergeKSortedLists_Hard;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by 31798 on 2016/10/7.
 */
public class SolutionWithRBTree {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Set<ListNode> nodes = new TreeSet<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                ListNode node1 = (ListNode) o1, node2 = (ListNode) o2;
                if (node1.val != node2.val) {
                    return node1.val - node2.val;
                }
                return 1;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                nodes.add(lists[i]);
            }
        }
        Iterator<ListNode> iterator = nodes.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        ListNode ans = iterator.next(), tail = ans;
        iterator.remove();
        if (ans.next != null) {
            nodes.add(ans.next);
        }
        while (!nodes.isEmpty()) {
            iterator = nodes.iterator();
            tail.next = iterator.next();
            tail = tail.next;
            iterator.remove();
            if (tail.next != null) {
                nodes.add(tail.next);
            }
        }
        return ans;
    }

//    public static void main(String[] args) {
//        ListNode[] lists = new ListNode[2];
//        ListNode tmp;
//        lists[0] = new ListNode(1);
//        tmp = lists[0].next = new ListNode(2);
//        tmp.next = new ListNode(2);
//        lists[1] = new ListNode(1);
//        tmp = lists[1].next = new ListNode(1);
//        tmp.next = new ListNode(2);
//        new Solution().mergeKLists(lists);
//    }
}