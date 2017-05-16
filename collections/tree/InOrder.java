package collections.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * author: cshuo
 * date: 2017/4/21
 * version: 1.0
 * description:
 */
public class InOrder {
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
//        inTrav(l, t1);
        inTrav2(l, t1);
        System.out.println(l);
    }

    /**
     * @param l
     * @param root
     * 递归实现
     */
    public static void inTrav(ArrayList<Integer> l, TreeNode root){
        if(root != null){
            inTrav(l, root.left);
            l.add(root.val);
            inTrav(l, root.right);
        }
    }

    public static void inTrav2(ArrayList<Integer> l, TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        while(p != null || !st.isEmpty()){
            // 一路向左到底
            while(p!=null){
                st.push(p);
                p = p.left;
            }
            if(!st.isEmpty()){
                p = st.pop();
                l.add(p.val);
                // 取右孩子, 进行下一轮的一路向左
                p = p.right;
            }
        }
    }
}
