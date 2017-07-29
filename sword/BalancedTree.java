package sword;

import java.util.*;

/**
 * Created by cshuo on 2017/7/21
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class BalancedTree {
    private boolean isBalanced = true;

    /**
     * 思路和求解二叉树高度类似，在求高度过程中顺便判断是否存在一个节点是不平衡的。
     */
    public static void main(String[] args) {
        List<List<Integer>> rs = new ArrayList<>();
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }

    public int getDepth(TreeNode root) {
        // isBalanced 是 false时没必要在继续向下探索了。
        if(root == null || !isBalanced) return 0;
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        if(Math.abs(l-r) > 1) isBalanced = false;
        return Math.max(l, r) + 1;
    }
}
