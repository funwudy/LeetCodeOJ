package algorithms.a101_to_a150.a128_LongestConsecutiveSequence_Hard;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 31798 on 2016/10/5.
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int max = 0;
        for (int i : nums) {
            if (set.contains(i)) {
                int cnt = 1;
                set.remove(i);
                for (int tmp = i - 1; set.contains(tmp); tmp--) {
                    cnt++;
                    set.remove(tmp);
                }
                for (int tmp = i + 1; set.contains(tmp); tmp++) {
                    cnt++;
                    set.remove(tmp);
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}