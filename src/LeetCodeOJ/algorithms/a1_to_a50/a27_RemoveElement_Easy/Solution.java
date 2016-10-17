package algorithms.a1_to_a50.a27_RemoveElement_Easy;

/**
 * Created by 31798 on 2016/10/17.
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int newLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[newLen++] = nums[i];
            }
        }
        return newLen;
    }
}