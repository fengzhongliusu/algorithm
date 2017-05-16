package leetcode;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/4/20
 * version: 1.0
 * description: 非递归前序遍历
 */
public class LC144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        if(root == null) return rs;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode tmp;
        while(!st.isEmpty()){
            tmp = st.pop();
            rs.add(tmp.val);
            if(tmp.right != null) st.push(tmp.right);
            if(tmp.left != null) st.push(tmp.left);
        }
        return rs;
    }
}
