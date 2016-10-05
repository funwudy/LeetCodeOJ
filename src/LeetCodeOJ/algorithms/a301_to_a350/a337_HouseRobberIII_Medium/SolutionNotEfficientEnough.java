package algorithms.a301_to_a350.a337_HouseRobberIII_Medium;

/**
 * Created by 31798 on 2016/9/14.
 */
public class SolutionNotEfficientEnough {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int robThis = root.val;
        if (root.left != null) {
            robThis += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            robThis += rob(root.right.left) + rob(root.right.right);
        }
        int leaveThis = rob(root.left) + rob(root.right);
        return Math.max(leaveThis, robThis);
    }
}
