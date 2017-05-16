package sword;

import java.util.Stack;

/**
 * author: cshuo
 * date: 2017/5/2
 * version: 1.0
 * description:
 */
public class TreeMirror {
    public static void main(String[] args) {
    }
    public void mirrorTree(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode itr, tmp;
        while(!st.isEmpty()){
            itr = st.pop();
            tmp = itr.left;
            itr.left = itr.right;
            itr.right = tmp;
            if(itr.left != null) st.push(itr.left);
            if(itr.right != null) st.push(itr.right);
        }
    }
}
