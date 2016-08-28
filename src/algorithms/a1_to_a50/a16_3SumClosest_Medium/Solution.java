package algorithms.a1_to_a50.a16_3SumClosest_Medium;

import java.util.Arrays;

/**
 * Created by 31798 on 2016/8/21.
 */
// #Array#, #Two Pointers#
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int l = i + 1, r = nums.length - 1; l < r; ) {
                int tmpSum = nums[i] + nums[l] + nums[r];
                if (tmpSum < target) {
                    if (target - tmpSum < minDiff) {
                        minDiff = target - tmpSum;
                        sum = tmpSum;
                    }
                    do {
                        l++;
                    } while (l < r && nums[l] == nums[l - 1]);
                } else if (tmpSum > target) {
                    if (tmpSum - target < minDiff) {
                        minDiff = tmpSum - target;
                        sum = tmpSum;
                    }
                    do {
                        r--;
                    } while (l < r && nums[r] == nums[r + 1]);
                } else {
                    return tmpSum;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0, 0, 0};
        int target = 1;
        System.out.print(solution.threeSumClosest(arr, target));
    }
}