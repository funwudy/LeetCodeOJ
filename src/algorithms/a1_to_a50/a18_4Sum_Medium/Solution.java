package algorithms.a1_to_a50.a18_4Sum_Medium;

import java.util.*;

/**
 * Created by 31798 on 2016/9/15.
 */
// #Array#, #Hash Table#, #Two Pointers#
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, List<Pair>> pairs = new HashMap<>();
        for (int i = 2; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (pairs.containsKey(sum)) {
                    List<Pair> list = pairs.get(sum);
                    list.add(new Pair(i, j));
                } else {
                    List<Pair> list = new ArrayList<>();
                    list.add(new Pair(i, j));
                    pairs.put(sum, list);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                List<Pair> list = pairs.get(target - nums[i] - nums[j]);
                if (list != null) {
                    Pair pre = null;
                    for (Pair pair : list) {
                        if (pair.i1 > j) {
                            if (pre == null ||
                                    nums[pre.i1] != nums[pair.i1] && nums[pre.i2] != nums[pair.i2]) {
                                pre = pair;
                                List<Integer> solution = new ArrayList<>();
                                solution.add(nums[i]);
                                solution.add(nums[j]);
                                solution.add(nums[pair.i1]);
                                solution.add(nums[pair.i2]);
                                ans.add(solution);
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    private class Pair {
        Integer i1, i2;

        public Pair(Integer i1, Integer i2) {
            this.i1 = i1;
            this.i2 = i2;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        Solution solution = new Solution();
        System.out.println(solution.fourSum(nums, 0));
    }
}