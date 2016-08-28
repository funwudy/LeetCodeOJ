package algorithms.a51_to_a100.a53_MaximumSubarray_Medium;

public class Solution {
//	public int maxSubArray(int[] nums) {
//		if (nums == null || nums.length == 0)
//			return 0;
//		int max = Integer.MIN_VALUE;
//		int cur = 0;
//		for (int i = 0; i < nums.length; i++) {
//			cur += nums[i];
//			max = Math.max(cur, max);
//			cur = cur < 0 ? 0 : cur;
//		}
//		return max;
//	}

	public int maxSubArrayWithDivideAndConquer(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		return divideAndConquerHelper(nums, 0, nums.length - 1);
	}

	public int divideAndConquerHelper(int[] nums, int left, int right) {
		if (left == right)
			return nums[left];
		int mid = (left + right) / 2;
		int leftAns = divideAndConquerHelper(nums, left, mid);
		int rightAns = divideAndConquerHelper(nums, mid + 1, right);
		int tmp = 0;
		int leftSuffixMax = Integer.MIN_VALUE, rightPrefixMax = Integer.MIN_VALUE;
		for (int i = mid; i >= left; i--) {
			tmp += nums[i];
			leftSuffixMax = Math.max(leftSuffixMax, tmp);
		}
		tmp = 0;
		for (int i = mid + 1; i <= right; i++) {
			tmp += nums[i];
			rightPrefixMax = Math.max(rightPrefixMax, tmp);
		}
		int midAns = leftSuffixMax + rightPrefixMax;
		return Math.max(Math.max(leftAns, rightAns), midAns);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(solution.maxSubArrayWithDivideAndConquer(nums));
	}
}