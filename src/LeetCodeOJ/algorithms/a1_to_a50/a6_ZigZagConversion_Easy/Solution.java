package algorithms.a1_to_a50.a6_ZigZagConversion_Easy;

/**
 * Created by 31798 on 2016/10/7.
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        int step = (numRows - 1) * 2;
        StringBuilder ans = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            for (int i = row; i < s.length(); i += step) {
                ans.append(s.charAt(i));
                if (row > 0 && row < numRows - 1) {
                    int idx = i + (numRows - row - 1) * 2;
                    if (idx < s.length()) {
                        ans.append(s.charAt(idx));
                    }
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }
}