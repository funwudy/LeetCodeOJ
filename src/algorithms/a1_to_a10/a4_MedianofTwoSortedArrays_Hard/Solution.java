package algorithms.a1_to_a10.a4_MedianofTwoSortedArrays_Hard;

import java.util.Arrays;

public class Solution {
	public static double findKth(int[] nums1, int m, int[] nums2, int n, int k) {
		if (m > n) {
			return findKth(nums2, n, nums1, m, k);
		}
		if (m == 0) {
			return nums2[k - 1];
		}
		if (k == 1) {
			return Math.min(nums1[0], nums2[0]);
		}
		
		int l1 = Math.min(m, k / 2);
		int l2 = k - l1;
		if (nums1[l1 - 1] < nums2[l2 - 1]) {
			return findKth(Arrays.copyOfRange(nums1, l1, m), m - l1, nums2, n, k - l1);
		}
		else if (nums1[l1 - 1] > nums2[l2 - 1]) {
			return findKth(nums1, m, Arrays.copyOfRange(nums2, l2 , n), n - l2, k - l2);
		}
		else {
			return nums2[l2 - 1];
		}
	}
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int total = nums1.length + nums2.length;
        if((total & 0x1) == 1) {
        	return findKth(nums1, nums1.length, nums2, nums2.length, (total >>> 1) + 1);
        }
        else {
        	return (findKth(nums1, nums1.length, nums2, nums2.length, total >>> 1) +
        			findKth(nums1, nums1.length, nums2, nums2.length, (total >>> 1) + 1)) / 2; 
        }
        
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[] nums1 = {1,3}, nums2 = {};
    	System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}