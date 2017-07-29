package leetcode;
import java.util.*;

/**
 * Created by cshuo on 2017/7/26
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right
 * to left for the next level and alternate between).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
     3
    / \
   9  20
   /  \
  15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]
 */
public class LC103 {

    /**
     * levelSum记录每一层的节点数目； level记录层高, 偶数时节点从左到右添加，奇数时从右向左;
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int level = 0, levelSum = 1;
        List<List<Integer>> rs = new ArrayList<>();
        if(root == null) return rs;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            levelSum = q.size();
            List<Integer> lSet = new ArrayList<>();
            for(int i=0; i<levelSum; i++) {
                TreeNode ptr = q.poll();
                if((level&1) == 0) lSet.add(ptr.val);
                else lSet.add(0, ptr.val);
                if(ptr.left != null) q.offer(ptr.left);
                if(ptr.right != null) q.offer(ptr.right);
            }
            level++;
            rs.add(lSet);
        }
        return rs;
    }
}
