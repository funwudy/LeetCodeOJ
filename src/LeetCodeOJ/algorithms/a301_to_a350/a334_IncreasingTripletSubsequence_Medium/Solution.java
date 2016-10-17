package algorithms.a301_to_a350.a334_IncreasingTripletSubsequence_Medium;

/**
 * Created by 31798 on 2016/10/17.
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int min = nums[0], sec = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            } else if (nums[i] > min){
                sec = Math.min(sec, nums[i]);
                if (sec < nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}