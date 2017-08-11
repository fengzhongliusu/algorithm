package leetcode;
import java.util.*;

/**
 * author: cshuo
 * date: 2017/8/9
 * version: 1.0
 * description:
 * You are given a binary tree in which each node contains an integer value.

 Find the number of paths that sum to a given value.
 The path does not need to start or end at the root or a leaf, but it must go downwards
 (traveling only from parent nodes to child nodes).
 The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

 */
public class LC437 {
    int counts = 0;

    /**
     * Time: O(n), Space: O(n)
     * 遍历树节点，对每个节点求解路径条数.
     */
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
    /**
     * 从root开始的路径有多少条和为sum;
     */
    public int countPath(TreeNode root, int sum) {
        if(root == null) return 0;
        return countPath(root.left, sum-root.val) + countPath(root.right, sum-root.val) + (root.val == sum?1:0);
    }

    // O(n) 解法: 利用前缀和形式(从根节点到当前节点的总和)，key：前缀和, val: 路径和为该key的路径数
    public int pathSum1(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, 0, sum, map);
    }

    public int helper(TreeNode root, int sum, int target, Map<Integer, Integer>map) {
        if(root == null) return 0;
        sum += root.val;
        int rs = map.getOrDefault(sum-target, 0);   //map里面是否有路径和为sum-target的路径.
        map.put(sum, map.getOrDefault(sum, 0) + 1);      //将路径和为sum的条数+1
        rs += helper(root.left, sum, target, map) + helper(root.right, sum, target, map);   //递归处理左右子节点
        map.put(sum, map.get(sum)-1);   //处理完该节点后，将路径和为sum的条数减一, 以防影响sibling节点的处理.
        return rs;
    }

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(-1);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(3);
        t2.left = t3; t3.left = t4; t4.left = t5;
        LC437 t = new LC437();
        System.out.println(t.pathSum1(t2, 3));
    }
}
