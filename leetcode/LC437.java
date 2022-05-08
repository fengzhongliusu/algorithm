package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cshuo on 2021/10/10
 */
public class LC437 {
    public static void main(String[] args) {
    }
    public static int pathSum(TreeNode root, int sum) {
        List<Integer> stack = new LinkedList<>();
        return helper(root, stack, sum);
    }
    public static int helper(TreeNode root, List<Integer> stack, int target) {
        if (root == null) return 0;
        int curSum = root.val;
        int res = curSum == target ? 1 : 0;
        for (int i = stack.size() - 1; i >= 0; i--) {
            curSum += stack.get(i);
            if (curSum == target) {
                res += 1;
            }
        }
        stack.add(root.val);
        res += helper(root.left, stack, target) + helper(root.right, stack, target);
        stack.remove(stack.size()-1);
        return res;
    }
}
