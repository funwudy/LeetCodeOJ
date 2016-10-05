package algorithms.a1_to_a50.a42_TrappingRainWater_Hard;

/**
 * Created by 31798 on 2016/8/28.
 */
public class Solution_O2n {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        int leftMax = height[0];
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int max = Math.min(leftMax, rightMax[i]);
            sum += Math.max(max - height[i], 0);
            leftMax = Math.max(height[i], leftMax);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution_O2n solution = new Solution_O2n();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height));
    }
}