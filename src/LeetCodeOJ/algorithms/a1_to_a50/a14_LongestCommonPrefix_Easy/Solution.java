package algorithms.a1_to_a50.a14_LongestCommonPrefix_Easy;

/**
 * Created by 31798 on 2016/9/26.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestPrefix(prefix, strs[i]);
        }
        return prefix;
    }

    public String longestPrefix(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return null;
        }
        int l = Math.min(str1.length(), str2.length());
        int i = 0;
        for (; i < l; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
        }
        return str1.substring(0, i);
    }
}