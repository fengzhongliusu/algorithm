package leetcode;
import java.util.*;

/**
 * Created by cshuo on 2017/8/9
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with
 * a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could
 * also be considered as a subtree of itself.

 Example 1:
 Given tree s:

    3
   / \
  4   5
 / \
1  2
 Given tree t:
  4
 / \
1  2
 Return true, because t has the same structure and node values with a subtree of s.
 Example 2:
 Given tree s:

   3
  / \
 4  5
/ \
1  2
/
0
 Given tree t:
  4
 / \
1  2
 Return false.
 */
public class LC572 {
    /**
     * 遍历树，判断是否存在一个子结构与t相同.
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        Stack<TreeNode> st = new Stack<>();
        st.push(s);
        while(!st.isEmpty()) {
            TreeNode tmp = st.pop();
            if(isSame(tmp, t)) return true;
            if(tmp.left != null) st.push(tmp.left);
            if(tmp.right != null) st.push(tmp.right);
        }
        return false;
    }

    /**
     * 判断两个树子结构是否相同.
     */
    public boolean isSame(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
