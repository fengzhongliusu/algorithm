package leetcode;

import apple.laf.JRSUIUtils;

import java.util.Stack;

/**
 * author: cshuo
 * date: 2017/4/17
 * version: 1.0
 * description:
 */
public class LC226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return root;
        Stack<TreeNode> st = new Stack();
        st.push(root);
        TreeNode itr, tmp;
        while(!st.isEmpty()){
            itr = st.pop();
            if(itr.left != null) st.push(itr.left);
            if(itr.right != null) st.push(itr.right);
            tmp = itr.left;
            itr.left = itr.right;
            itr.right = tmp;
        }
        return root;
    }

    public TreeNode invertTree2(TreeNode root){
        if(root==null || (root.left==null && root.right==null)) return root;
        TreeNode tmp = root.right;
        root.right = root.left == null ? null:invertTree(root.left);
        root.left = tmp == null ? null:invertTree(tmp);
        return root;
    }
}
