package algorithms.a201_to_a250.a213_HouseRobberII_Medium;

/**
 * Created by 31798 on 2016/9/12.
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    public int robHelper(int[] nums, int start, int end) {
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        if (dp.length > 1) {
            dp[1] = Math.max(nums[start], nums[start + 1]);
            for (int i = 2; i <= end - start; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
            }
        }
        return dp[dp.length - 1];
    }
}