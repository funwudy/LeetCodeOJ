package algorithms.a1_to_a50.a17_LetterCombinationsOfAPhoneNumber_Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 31798 on 2016/8/22.
 */
// #Backtracking#, #String#
public class Solution {

    public List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == "") {
            return null;
        }
        dfs(digits, 0, "");
        return ans;
    }

    public void dfs(String digits, int pos, String tmp) {
        if (pos == digits.length() ) {
            if (tmp != "") {
                ans.add(tmp);
            }
            return;
        }
        List<Character> all = allLetters(digits.charAt(pos));
        if (all.size() == 0) {
            dfs(digits, pos + 1, tmp);
        } else for (Character c : all) {
            dfs(digits, pos + 1, tmp + c);
        }
    }

    public List<Character> allLetters(char digit) {
        List<Character> characters = new ArrayList<>();
        if (digit >= '2' && digit <= '7') {
            for (int i = 0; i < 3; i++) {
                characters.add((char) ((digit - '2') * 3 + 'a' + i));
            }
        }
        if (digit == '7') {
            characters.add('s');
        } else if (digit == '8') {
            for (char c = 't'; c <= 'v'; c++) {
                characters.add(c);
            }
        } else if (digit == '9') {
            for (char c = 'w'; c <= 'z'; c++) {
                characters.add(c);
            }
        }
        return characters;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        for (int i = 0; i < 10; i++) {
//            List<Character> characters = solution.allLetters((char) ('1' + i));
//            System.out.print(i + ":");
//            for (Character c : characters) {
//                System.out.print(c);
//            }
//            System.out.println();
//        }
        for (String str : solution.letterCombinations("23")) {
            System.out.println(str);
        }
    }
}