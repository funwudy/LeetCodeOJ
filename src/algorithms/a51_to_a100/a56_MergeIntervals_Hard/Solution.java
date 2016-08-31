package algorithms.a51_to_a100.a56_MergeIntervals_Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 31798 on 2016/8/28.
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) {
            return null;
        }
        MyInterval[] myIntervals = new MyInterval[intervals.size()];
        for (int i = 0; i < myIntervals.length; i++) {
            Interval tmp = intervals.get(i);
            myIntervals[i] = new MyInterval(tmp.start, tmp.end);
        }
        Arrays.sort(myIntervals);
        List<Interval> res = new ArrayList<>();
        for (int i = 0, j; i < myIntervals.length; i = j) {
            j = i + 1;
            while (j < myIntervals.length && myIntervals[j].start <= myIntervals[i].end) {
                myIntervals[i].end = Math.max(myIntervals[i].end, myIntervals[j++].end);
            }
            res.add(new Interval(myIntervals[i].start, myIntervals[i].end));
        }
        return res;
    }

    public class MyInterval implements Comparable<MyInterval> {
        int start;
        int end;

        public MyInterval() {
            start = 0;
            end = 0;
        }

        public MyInterval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(MyInterval interval) {
            if (start < interval.start) {
                return -1;
            } else if (start > interval.start) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}