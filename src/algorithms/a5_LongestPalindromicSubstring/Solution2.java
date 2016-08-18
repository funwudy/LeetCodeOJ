package algorithms.a5_LongestPalindromicSubstring;

public class Solution2 {

	public String longestPalindrome(String s) {
		if (s == null || s.equals(""))
			return null;
		int length = s.length();
		int maxLen = 1;
		String longest = s.substring(0, 1);
        for (int i = 0; i < length; i++) {
        	int tmpMax = 1;
        	int from = i, to = i + 1;
        	for (int j = 1; i - j >= 0 && i + j < length; j++) {
        		if (s.charAt(i - j) == s.charAt(i + j)) {
        			tmpMax = 2 * j + 1;
        			from = i - j;
        			to = i + j + 1;
        		} else {
        			break;
        		}
        	}
        	for (int j = 0; i - j >= 0 && i + 1 + j < length; j++) {
        		if (s.charAt(i - j) == s.charAt(i + 1 + j)) {
        			if (tmpMax < 2 * j + 2) {
        				tmpMax = 2 * j + 2;
        				from = i - j;
        				to = i + 2 + j;
        			}
        		} else {
        			break;
        		}
        	}
        	if (maxLen < tmpMax) {
        		maxLen = tmpMax;
        		longest = s.substring(from, to);
        	}
        }
        return longest;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Solution2 solution = new Solution2();
//    	System.out.println(solution.longestPalindrome("aaaa"));
	}

}
