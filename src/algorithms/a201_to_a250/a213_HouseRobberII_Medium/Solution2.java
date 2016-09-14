package algorithms.a201_to_a250.a213_HouseRobberII_Medium;

/**
 * Created by 31798 on 2016/9/12.
 */
public class Solution2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    public int robHelper(int[] nums, int start, int end) {
        int even = 0, odd = 0;
        for (int i = 0; i <= end - start; i++) {
            if ((i & 1) == 0) {
                even = Math.max(even + nums[start + i], odd);
            } else {
                odd = Math.max(odd + nums[start + i], even);
            }
        }
        return Math.max(even, odd);
    }
}