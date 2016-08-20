package algorithms.a11_to_a20.a11_ContainerWithMostWater_Medium;

//#Array#, #Two Pointers#
public class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l < r) {
        	max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
        	if (height[l] < height[r]) {
        		do {
        			l++;
        		} while (l < r && height[l] < height[l - 1]);
        	} else {
        		do {
        			r--;
        		} while (l < r && height[r] < height[r + 1]);
        	}
        }
        return max;
    }
}