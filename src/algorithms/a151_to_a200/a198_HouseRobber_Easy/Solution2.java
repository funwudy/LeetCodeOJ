package algorithms.a151_to_a200.a198_HouseRobber_Easy;

/**
 * Created by 31798 on 2016/9/12.
 */
// #DP#
public class Solution2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int even = 0, odd = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                even = Math.max(odd, even + nums[i]);
            } else {
                odd = Math.max(even, odd + nums[i]);
            }
        }
        return Math.max(even, odd);
    }
}
