package leetcode;
import java.util.*;

/**
 * Created by cshuo on 2017/8/9
 */
public class LC653 {
    /**
     *
     * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

     Example 1:
     Input:
      5
     / \
    3   6
   / \   \
  2  4   7

     Target = 9

     Output: True
     Example 2:
     Input:
      5
     / \
    3  6
   / \  \
  2  4  7

     Target = 28

     Output: False

     思路：中序遍历加两个前后指针搜索.
     Time: O(n), Space: O(n);
     */
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> rs = new ArrayList<>();
        traverse(root, rs);
        int l=0, r=rs.size()-1;
        while(l<r) {
            int lval = rs.get(l), rval = rs.get(r);
            if(lval+rval == k) return true;
            else if(lval + rval > k) r--;
            else l++;
        }
        return false;
    }

    public void traverse(TreeNode root, ArrayList<Integer> rs) {
        if(root == null) return;
        traverse(root.left, rs);
        rs.add(root.val);
        traverse(root.right, rs);
    }


    // 其他解法T: O(n), S:O(n);
    /**
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }
    public boolean dfs(TreeNode root, Set<Integer> set, int k) {
        if(root == null) return false;
        if(set.contains(root.val)) return true;
        else set.add(k-root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }
    */
}
