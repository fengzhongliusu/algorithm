package collections.tree;

/**
 * author: cshuo
 * date: 2017/4/24
 * version: 1.0
 * description: 判断是不是满二叉树: 所有节点的左右子树等高.
 */
public class FullTree {
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
//        t2.left = t4;
        t2.right = t5;
        t3.left= t6;
        t3.right= t8;

//        t4.right= t9;
        System.out.println(judgeFull(t1));
    }

    public static boolean judgeFull(TreeNode root){
        if(root == null) return false;
        else if(root.left == null && root.right == null) return true;
        else if(root.left == null || root.right == null) return false;
        else return judgeFull(root.left) && judgeFull(root.right);
    }
}
