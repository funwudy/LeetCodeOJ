package algorithms.a51_to_a100.a56_MergeIntervals_Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 31798 on 2016/8/31.
 */
public class SolutionWithOwnSort {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) {
            return null;
        }
        List<Interval> ans = new ArrayList<>();
        Interval[] ints = new Interval[intervals.size()];
        intervals.toArray(ints);
        quickSort(ints, 0, ints.length - 1);
        for (int i = 0, j; i < ints.length; i = j) {
            j = i;
            while (j < ints.length && ints[j].start <= ints[i].end) {
                ints[i].end = Math.max(ints[i].end, ints[j++].end);
            }
            ans.add(ints[i]);
        }
        return ans;
    }

    private void quickSort(Interval[] ints, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = partition(ints, start, end);
        quickSort(ints, start, mid - 1);
        quickSort(ints, mid + 1, end);
    }

    private int partition(Interval[] ints, int start, int end) {
        int idx = start;
        swap(ints[idx], ints[end]);
        int small = start - 1;
        while (idx < end) {
            if (ints[idx].start < ints[end].start) {
                small++;
                if (idx != small) {
                    swap(ints[idx], ints[small]);
                }
            }
            idx++;
        }
        swap(ints[++small], ints[end]);
        return small;
    }

    private void swap(Interval int1, Interval int2) {
        Interval tmp = new Interval(int1.start, int1.end);
        int1.start = int2.start;
        int1.end = int2.end;
        int2.start = tmp.start;
        int2.end = tmp.end;
    }

    public static void main(String[] args) {
        SolutionWithOwnSort solution = new SolutionWithOwnSort();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        List<Interval> ans = solution.merge(intervals);
    }
}
