package algorithms.a101_to_a150.a128_LongestConsecutiveSequence_Hard;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by 31798 on 2016/10/5.
 */
public class SolutionNotEfficientEnough {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new TreeSet<>();
        for (int i : nums) {
            set.add(i);
        }
        Iterator<Integer> iterator = set.iterator();
        int cnt = 1, tmp, pre = iterator.next(), max = 1;
        while (iterator.hasNext()) {
            tmp = iterator.next();
            if (tmp == pre + 1) {
                cnt++;
            } else {
                max = Math.max(cnt, max);
                cnt = 1;
            }
            pre = tmp;
        }
        max = Math.max(cnt, max);
        return max;
    }

}