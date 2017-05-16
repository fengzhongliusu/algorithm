package leetcode;
import java.util.*;

/**
 * author: cshuo
 * date: 2017/4/20
 * version: 1.0
 * description:
 */
public class LC94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        if(root == null) return rs;
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        while(p != null || !st.isEmpty()){
            while(p != null){
                st.push(p);
                p = p.left;
            }
            if(!st.empty()){
                p = st.pop();
                rs.add(p.val);
                p = p.right;
            }
        }
        return rs;
    }
}
