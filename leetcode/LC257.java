package leetcode;

import java.util.*;

/**
 * Created by cshuo on 2017/8/9
 *
 * Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

     1
   /   \
  2     3
   \
    5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 */
public class LC257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rs = new ArrayList<>();
        if(root == null) return rs;
        traverse(root, "", rs);
        return rs;
    }

    public void traverse(TreeNode root, String path, List<String> list) {
        if(root.left == null && root.right == null) list.add(path+root.val);
        if(root.left != null) traverse(root.left, path+root.val+"->", list);
        if(root.right != null) traverse(root.right, path+root.val+"->", list);
    }
}
