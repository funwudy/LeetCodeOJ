package algorithms.a1_to_a50.a8_StringToInteger_Easy;

/**
 * Created by 31798 on 2016/10/7.
 */
public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        int idx = 0, sign = 1;
        if (str.charAt(0) == '-') {
            sign = -1;
            idx++;
        } else if (str.charAt(0) == '+') {
            idx++;
        }
        long ans = 0;
        while (idx < str.length() && ans < Integer.MAX_VALUE) {
            char ch = str.charAt(idx++);
            if (ch < '0' || ch > '9') {
                break;
            }
            ans = ans * 10 + (ch - '0');
        }
        ans *= sign;
        if (ans >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (ans <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) ans;
    }
}