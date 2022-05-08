package leetcode;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * Created by cshuo on 2017/3/16.
 */
public class SumLeftLeaf {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if(root == null) return 0;
        if(root.left != null){
            if(root.left.left == null && root.left.right == null) sum += root.left.val;
            else sum += sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        SumLeftLeaf sm = new SumLeftLeaf();
        System.out.print(sm.sumOfLeftLeaves(t1));
    }
}
