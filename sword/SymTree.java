package sword;

/**
 * author: cshuo
 * date: 2017/5/1
 * version: 1.0
 * description:
 */
public class SymTree {
    public static void main(String[] args) {
    }

    public static boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        return checkSym(root.left, root.right);
    }
    public static boolean checkSym(TreeNode l, TreeNode r){
        if(l == null && r == null) return true;
        if(l != null && r != null)  return l.val == r.val && checkSym(l.left, r.right) && checkSym(l.right, r.left);
        return false;
    }
}
