package algorithms.a1_to_a10.a5_LongestPalindromicSubstring_Medium;

public class Solution {
	
    public String longestPalindrome(String s) {
    	int length = s.length();
    	boolean[][] dp = new boolean[length][length];
    	dp[0][0] = true;
    	for (int i = 1; i < length; i++) {
    		dp[i][i] = true;
    		dp[i][i - 1] = true;
    	}
    	int maxLen = 1;
    	String longest = s.substring(0, 1);
    	for (int len = 2; len <= length; len++) {
    		for (int i = 0; i + len <= length; i++) {
    			dp[i][i + len - 1] = (dp[i + 1][i + len - 2] 
    					&& s.charAt(i) == s.charAt(i + len - 1));
    			if (dp[i][i + len - 1] && len > maxLen) {
    				maxLen = len;
    				longest = s.substring(i, i + len);
    			}
    		}
    	}
    	return longest;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.longestPalindrome("ccccfefc"));
    }
}