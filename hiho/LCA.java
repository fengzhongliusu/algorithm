package hiho;

import leetcode.LC225;

/**
 * author: cshuo
 * date: 2017/3/21
 * version: 1.0
 * description:
 */
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
}

public class LCA{
    public static TreeNode getLCA(TreeNode root, TreeNode node1, TreeNode node2){
        if(root == null)
            return null;
        if(root == node1 || root == node2)
            return root;

        TreeNode left = getLCA(root.left, node1, node2);
        TreeNode right = getLCA(root.right, node1, node2);

        if(left != null && right != null)
            return root;
        else if(left != null)
            return left;
        else if(right != null)
            return right;
        else
            return null;
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(); t1.val = 1;
        TreeNode t2 = new TreeNode(); t2.val = 2;
        TreeNode t3 = new TreeNode(); t3.val = 3;
        TreeNode t4 = new TreeNode(); t4.val = 4;

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        TreeNode t = LCA.getLCA(t1, t3, t4);
        System.out.println(t.val);
    }
}

