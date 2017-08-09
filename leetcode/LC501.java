package leetcode;
import java.util.*;

/**
 * Created by cshuo on 2017/8/9
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.
 For example:
 Given BST [1,null,2,2],
 1
  \
 2
/
2
 return [2].
 Note: If a tree has more than one mode, you can return them in any order.
 */

public class LC501 {
    int count=1, max=0;
    Integer prev = null;

    /**
     * 利用二叉树的中序遍历，记录前一个元素，统计每个元素出现次数，大于max则清空list，添加当前的元素，等于max，直接添加当前元素;
     */
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> rs = new ArrayList<>();
        traverse(root, rs);
        int[] ans = new int[rs.size()];
        for(int i=0; i<rs.size(); i++) ans[i] = rs.get(i);
        return ans;
    }

    public void traverse(TreeNode root, ArrayList<Integer> rs) {
        if(root == null) return;
        traverse(root.left, rs);
        if(prev != null) {
            if(root.val == prev) count++;
            else count = 1;
        }
        if(count > max) {
            max = count;
            rs.clear();
            rs.add(root.val);
        } else if(count == max) {
            rs.add(root.val);
        }
        prev = root.val;
        traverse(root.right, rs);
    }
}
