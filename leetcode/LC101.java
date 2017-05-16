package leetcode;

/**
 * author: cshuo
 * date: 2017/3/23
 * version: 1.0
 * description: Symmetric Tree
 */

public class LC101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSym(root.left, root.right);
    }
    public boolean isSym(TreeNode l, TreeNode r){
        if(l == null || r == null)
            return l == r;
        return l.val == r.val && isSym(l.left, r.right) && isSym(l.right, r.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(3);
        root.left = t1;root.right=t2;
        t1.right = t3;
        t2.right = t4;
        LC101 t = new LC101();
        System.out.println(t.isSymmetric(root));
    }
}
