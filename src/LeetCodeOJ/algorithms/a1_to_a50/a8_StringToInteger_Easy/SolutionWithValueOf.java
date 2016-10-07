package algorithms.a1_to_a50.a8_StringToInteger_Easy;

/**
 * Created by 31798 on 2016/10/7.
 */
public class SolutionWithValueOf {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        String trimmed = str.trim();
        StringBuilder sb = new StringBuilder();
        char c = trimmed.charAt(0);
        if (c >= '0' && c <= '9' || c == '+' || c == '-') {
            sb.append(c);
        } else {
            return 0;
        }
        int bound = Math.min(12, trimmed.length());
        for (int i = 1; i < bound; i++) {
            char ch = trimmed.charAt(i);
            if (ch >= '0' && ch <= '9') {
                sb.append(ch);
            } else {
                break;
            }
        }
        return myAtoiHelper(sb.toString());
    }

    private int myAtoiHelper(String str) {
        if (str.equals("+") || str.equals("-")) {
            return 0;
        }
        long tmp = Long.valueOf(str);
        if (tmp > 0) {
            return tmp > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) tmp;
        } else {
            return tmp < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) tmp;
        }

    }
}