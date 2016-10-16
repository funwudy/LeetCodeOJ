package algorithms.a1_to_a50.a23_MergeKSortedLists_Hard;

/**
 * Created by 31798 on 2016/10/9.
 */
public class SolutionWithOwnHeap {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        MyHeap heap = new MyHeap(lists.length);
        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }
        if (heap.size() == 0) {
            return null;
        }
        ListNode ans = heap.poll(), tail = ans;
        if (ans.next != null) {
            heap.add(ans.next);
        }
        while (heap.size() > 0) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null) {
                heap.add(tail.next);
                tail.next = null;
            }
        }
        return ans;
    }

    private class MyHeap {
        ListNode[] mHeap;
        int n = -1;

        public MyHeap(int size) {
            mHeap = new ListNode[size];
        }

        public int size() {
            return n + 1;
        }

        public void add(ListNode node) {
            mHeap[++n] = node;
            if (n > 0) {
                siftUp(n);
            }
        }

        public ListNode poll() {
            ListNode ret = new ListNode(mHeap[0].val);
            ret.next = mHeap[0].next;
            mHeap[0].val = mHeap[n].val;
            mHeap[n--] = null;
            siftDown(0, n);
            return ret;
        }

        private void siftUp(int idx) {
            int val = mHeap[idx].val;
            ListNode next = mHeap[idx].next;
            int parent = (idx - 1) >> 1;
            while (parent >= 0 && mHeap[parent].val > mHeap[idx].val) {
                mHeap[idx].val = mHeap[parent].val;
                mHeap[idx].next = mHeap[parent].next;
                idx = parent;
                parent = (parent - 1) >> 1;
            }
            mHeap[idx].val = val;
            mHeap[idx].next = next;
        }

        private void siftDown(int idx, int end) {
            int val = mHeap[idx].val;
            ListNode next = mHeap[idx].next;
            int child = (idx << 1) + 1;
            while (child <= end) {
                if (child + 1 <= end && mHeap[child].val < mHeap[child + 1].val) {
                    child++;
                }
                if (child <= end && mHeap[child].val < val) {
                    mHeap[idx].val = mHeap[child].val;
                    mHeap[idx].next = mHeap[child].next;
                    idx = child;
                    child = (child << 1) + 1;
                } else {
                    break;
                }
            }
            mHeap[idx].val = val;
            mHeap[idx].next = next;
        }
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[2];
        ListNode tmp;
        lists[0] = new ListNode(1);
        tmp = lists[0].next = new ListNode(2);
        tmp.next = new ListNode(2);
        lists[1] = new ListNode(1);
        tmp = lists[1].next = new ListNode(1);
        tmp.next = new ListNode(2);
        new SolutionWithOwnHeap().mergeKLists(lists);
    }
}