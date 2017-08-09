package leetcode;

/**
 * Created by cshuo on 2017/8/9
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w
 as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 */
public class LC235 {
    /**
     * 递归判断p,q是否在一个节点的左右子中.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if(l != null && r != null) return root;
        if(l == null) return r;
        return l; // r == null || l == null && r == null.
    }

    /**
     * 对于BST的解法.
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor1(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor1(root.right, p, q);
        }else{
            return root;
        }
    }
}
