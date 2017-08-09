package leetcode;
import java.util.*;

/**
 * author: cshuo
 * date: 2017/8/9
 * version: 1.0
 * description:
 */
public class LC437 {
    int counts = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode tmp = st.pop();
            counts += countPath(tmp, sum);
            if(tmp.left != null) st.push(tmp.left);
            if(tmp.right != null) st.push(tmp.right);
        }
        return counts;
    }
    public int countPath(TreeNode root, int sum) {
        if(root == null) return 0;
        return countPath(root.left, sum-root.val) + countPath(root.right, sum-root.val) + root.val == sum?1:0;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(-3);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(11);
        TreeNode t7 = new TreeNode(3);
        TreeNode t8 = new TreeNode(-2);
        TreeNode t9 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        t4.left = t7;
        t4.right = t8;
        t5.right = t9;
        LC437 t = new LC437();
        System.out.println(t.pathSum(t1, 8));
    }
}
