package leetcode;
import java.util.*;

/**
 * author: cshuo
 * date: 2017/4/20
 * version: 1.0
 * description: postorder traversal of bst
 */
public class LC145 {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        while(p != null || !st.empty()){
            while(p != null){
                st.push(p);
                p = p.left;
            }
            if(!st.isEmpty()){
                p = st.peek();
                if(p.right == null || (visited.get(p.right) !=null && visited.get(p.right))){
                    st.pop();
                    rs.add(p.val);
                    visited.put(p, true);
                    p = null;
                } else {
                    p = p.right;
                }
            }
        }
        return rs;
    }

    /**
     * @param root 树的根节点
     * @return
     *
     * 简洁的解法,反过来想后序遍历,类似一种前序遍历,每次在数组的首部插入遍历元素
     */
    public static List<Integer> postOrder(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        if(root == null) return rs;
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        st.push(p);
        while(!st.isEmpty()){
            p = st.pop();
            rs.add(0, p.val);
            if(p.left != null) st.push(p.left);
            if(p.right != null) st.push(p.right);
        }
        return rs;
    }

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
        t3.right = t6;
        t5.left = t8;
        t5.right = t9;

        List<Integer> rs = postOrder(t1);
        for(int e: rs)
            System.out.print(e + " ");
        System.out.println();
    }
}
