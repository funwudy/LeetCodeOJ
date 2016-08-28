package algorithms.a1_to_a50.a42_TrappingRainWater_Hard;

/**
 * Created by 31798 on 2016/8/28.
 */
public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int sum = 0;
        int leftMax = height[l], rightMax = height[r];
        int max = Math.min(leftMax, rightMax);
        while (l < r) {
            if (height[l] < height[r]) {
                int min = height[l++];
                while (l < r && height[l] < min) {
                    sum += min - height[l++];
                }
            } else {
                int min = height[r--];
                while (l < r && height[r] < min) {
                    sum += min - height[r--];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height));
    }
}