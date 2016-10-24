package algorithms.a1_to_a50.a28_ImplementStrStr_Easy;

/**
 * Created by 31798 on 2016/10/24.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
            if (j >= needle.length()) {
                return i;
            }
        }
        return -1;
    }
}