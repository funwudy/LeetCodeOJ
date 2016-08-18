package algorithms.a1_to_a10.a10_RegularExpressionMatching;

public class Solution {
    public boolean isMatch(String s, String p) {
    	return helper(s, 0, p, 0);
    }
    
    public boolean helper(String s, int s1, String p, int s2) {
    	if (s1 >= s.length() || s2 >= p.length()) {
    		//TODO
    	}
    	if (s2 + 1 >= p.length() || (s2 + 1 < p.length() && p.charAt(s2 + 1) != '*')) {
    		return s.charAt(s1) == p.charAt(s2) || p.charAt(s2) == '.' ? helper(s, s1 + 1, p, s2 + 1) : false;
    	} else { //p.charAt(s2 + 1) == '*'
    		if (p.charAt(s2) != '.' && p.charAt(s2) != s.charAt(s1)) {
    			return helper(s, s1, p, s2 + 2);
    		} else {
    			if (helper(s, s1, p, s2 + 2) == true) {
    				return true;
    			} 
    			while (s1 < s.length() && (p.charAt(s2) == '.' || p.charAt(s2) == s.charAt(s1))) {
    				if (helper(s, s1 + 1, p, s2 + 2)) {
    					return true;
    				}
    				s1++;
    			}
    			return false;
    		}
    	}
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.isMatch("aa","a"));//false
    	System.out.println(solution.isMatch("aa","aa"));//true
    	System.out.println(solution.isMatch("aaa","aa"));//false
    	System.out.println(solution.isMatch("aa", "a*"));//true
    	System.out.println(solution.isMatch("aa", ".*"));//true
    	System.out.println(solution.isMatch("ab", ".*"));//true
    	System.out.println(solution.isMatch("aab", "c*a*b"));//true
    	System.out.println(solution.isMatch("ab", ".*c"));//false
    	System.out.println(solution.isMatch("aaa", "a.a"));//true
    	System.out.println(solution.isMatch("a", "ab*"));//true
    }
}