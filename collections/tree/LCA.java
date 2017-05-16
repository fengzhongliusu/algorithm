package collections.tree;

/**
 * author: cshuo
 * date: 2017/5/16
 * version: 1.0
 * description:
 */
public class LCA {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        t5.left = t8;
        t5.right = t9;

        System.out.println(getLCA(t1, t8, t6).val);
    }

    public static TreeNode getLCA(TreeNode root, TreeNode n1, TreeNode n2){
        if(root == null) return null;
        if(root == n1 || root == n2) return root;

        TreeNode l = getLCA(root.left, n1, n2);
        TreeNode r = getLCA(root.right, n1, n2);

        if(l !=null && r != null) return root;
        if(l != null) return l;
        if(r != null) return r;
        return null;
    }
}
