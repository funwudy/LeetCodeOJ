package algorithms.a5_LongestPalindromicSubstring;

public class Solution {
	public boolean isPalindromic(String s, int start, int end) {//end is the last + 1
		for (int i = start, j = end - 1; i <= j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}
	
    public String longestPalindrome(String s) {
        for (int l = s.length(); l > 1; l--) {
        	for (int i = 0; i + l <= s.length(); i++) {
        		if (isPalindromic(s, i, i + l)) {
        			return s.substring(i, i + l);
        		}
        	}
        }
        return s.substring(0, 1);
    }
}