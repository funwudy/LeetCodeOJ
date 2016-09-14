package algorithms.a301_to_a350.a337_HouseRobberIII_Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 31798 on 2016/9/14.
 */
// #Tree#, #DP#, #DFS#
public class Solution {
    Map<TreeNode, Integer> robThis, leaveThis;

    public int rob(TreeNode root) {
        robThis = new HashMap<>();
        robThis.put(null, 0);
        leaveThis = new HashMap<>();
        leaveThis.put(null, 0);
        dfs(root);
        return Math.max(robThis.get(root), leaveThis.get(root));
    }

    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        robThis.put(node, node.val + leaveThis.get(node.left) + leaveThis.get(node.right));
        leaveThis.put(node, Math.max(
                Math.max(leaveThis.get(node.left) + leaveThis.get(node.right),
                leaveThis.get(node.left) + robThis.get(node.right)),
                Math.max(robThis.get(node.left) + robThis.get(node.right),
                robThis.get(node.left) + leaveThis.get(node.right))
        ));
    }
}