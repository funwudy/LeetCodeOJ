package algorithms.a1_to_a50.a3_LongestSubstringWithoutRepeatingCharacters_Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 31798 on 2016/10/5.
 */
// #Two Pointers#, #Hash Table#, #String#
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> chars = new HashSet<>();
        int l = 0, r = 0;
        int longest = 1;
        while (r < s.length()) {
            if (chars.contains(s.charAt(r))) {
                longest = Math.max(longest, r - l);
                while (s.charAt(l) != s.charAt(r)) {
                    chars.remove(s.charAt(l));
                    l++;
                }
                l++;
            } else {
                chars.add(s.charAt(r));
            }
            r++;
        }
        longest = Math.max(longest, r - l);
        return longest;
    }
}