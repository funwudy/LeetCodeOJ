package algorithms.a251_to_a300.a300_LongestIncreasingSubsequence_Medium;

/**
 * Created by 31798 on 2016/10/17.
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            ans = Math.max(ans, max);
        }
        return ans;
    }
}