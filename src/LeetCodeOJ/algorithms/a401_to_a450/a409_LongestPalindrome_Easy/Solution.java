package algorithms.a401_to_a450.a409_LongestPalindrome_Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 31798 on 2016/10/17.
 */
public class Solution {
    int max = 0;
    boolean odd = false;
    int[] count = new int[Math.max('z', 'Z') + 1];

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        helper('a', 'z');
        helper('A', 'Z');
        return max;
    }

    private void helper(int start, int end) {
        for (int i = start; i <= end; i++) {
            if ((count[i] & 1) == 0) {
                max += count[i];
            } else if (!odd) {
                max += count[i];
                odd = true;
            } else {
                max += count[i] - 1;
            }
        }
    }
}