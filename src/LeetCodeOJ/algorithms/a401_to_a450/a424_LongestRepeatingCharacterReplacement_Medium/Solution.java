package algorithms.a401_to_a450.a424_LongestRepeatingCharacterReplacement_Medium;

/**
 * Created by 31798 on 2016/10/17.
 */
public class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int ans = 0;
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            ans = Math.max(ans, helper(arr, k, letter));
        }
        return ans;
    }

    private int helper(char[] arr, int k, char letter) {
        int replaced = 0, max = 0;
        int start = 0;
        for (int i = 0; i < arr.length; ) {
            if (arr[i] == letter) {
                max = Math.max(max, i++ - start + 1);
            } else if (replaced < k) {
                replaced++;
                max = Math.max(max, i++ - start + 1);
            } else {
                if (arr[start] != letter) {
                    replaced--;
                }
                start++;
            }
        }
        return max;
    }
}