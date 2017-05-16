package collections.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * author: cshuo
 * date: 2017/4/21
 * version: 1.0
 * description:
 */
public class PostOrder {
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
        t3.left = t7;
        t3.right = t6;

        ArrayList<Integer> l = new ArrayList<>();
        postTrav(l, t1);
        System.out.println(l);
    }

    /**
     * @param l
     * @param root
     * 递归实现
     */
    public static void postTrav(ArrayList<Integer> l, TreeNode root){
        if(root != null){
            postTrav(l, root.left);
            postTrav(l, root.right);
            l.add(root.val);
        }
    }

    /**
     * @param l
     * @param root
     * 非递归实现, 基于栈, 反向思考就是变形的前序遍历: 根-右-左
     */
    public static void postTrav2(ArrayList<Integer>l, TreeNode root){
        if(root == null) return;
        Stack<TreeNode> st = new Stack<>();
        TreeNode itr;
        st.push(root);
        while(!st.isEmpty()){
            itr = st.pop();
            l.add(0, itr.val);
            if(itr.left != null) st.push(itr.left);
            if(itr.right != null) st.push(itr.right);
        }
    }
}
