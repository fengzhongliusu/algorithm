package sword;

/**
 * author: cshuo
 * date: 2017/5/2
 * version: 1.0
 * description: 判断一颗树是不是另一棵树的子结构 (子树只要能完全贴合母树的一部分即可..)
 */
public class SubTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(2);
        t8.left = t9;
        t8.right = t10;

        System.out.println(hasSubTree(t1, t8));

    }
    public static boolean hasSubTree(TreeNode root1, TreeNode root2) {
        if(root2 == null || root1 == null) return false;
        return recurSame(root1, root2) || recurSame(root1.left, root2) || recurSame(root1.right, root2);
    }

    public static boolean recurSame(TreeNode root1, TreeNode root2){
        if (root2 == null) return true;
        else if(root1 == null) return false;
        return root1.val == root2.val && recurSame(root1.left, root2.left) && recurSame(root1.right, root2.right);
    }
}
