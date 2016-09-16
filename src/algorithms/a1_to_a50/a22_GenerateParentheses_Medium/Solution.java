package algorithms.a1_to_a50.a22_GenerateParentheses_Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 31798 on 2016/9/16.
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder solution = new StringBuilder();
        helper(ans, solution, 0, 2 * n, n, n);
        return ans;
    }

    private void helper(List<String> ans, StringBuilder solution, int i, int end, int nl, int nr) {
        if (i == end) {
            ans.add(solution.toString());
            return;
        }
        if (nl > 0) {
            solution.append('(');
            helper(ans, solution, i + 1, end, nl - 1, nr);
            solution.deleteCharAt(i);
        }
        if (nl < nr && nr > 0) {
            solution.append(')');
            helper(ans, solution, i + 1, end, nl, nr - 1);
            solution.deleteCharAt(i);
        }
    }
}