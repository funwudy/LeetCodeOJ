package algorithms.a1_to_a50.a27_RemoveElement_Easy;

/**
 * Created by 31798 on 2016/10/17.
 */
public class SolutionStupid {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < nums.length && nums[left] != val) {
                left++;
            }
            if (left >= nums.length) {
                return nums.length;
            }
            while (right >= 0 && nums[right] == val) {
                right--;
            }
            if (right < 0) {
                return 0;
            }
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        if (left < nums.length && nums[left] != val) {
            left++;
        }
        return left;
    }
}