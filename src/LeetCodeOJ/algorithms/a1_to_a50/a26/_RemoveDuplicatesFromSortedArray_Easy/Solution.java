package algorithms.a1_to_a50.a26._RemoveDuplicatesFromSortedArray_Easy;

/**
 * Created by 31798 on 2016/10/17.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int idx = 0, newLen = 0;
        for (; idx < nums.length; idx++) {
            while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]) {
                idx++;
            }
            nums[newLen++] = nums[idx];
        }
        return newLen;
    }
}