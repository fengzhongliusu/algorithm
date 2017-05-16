package leetcode;

/**
 * minimum depth of binary tree
 */

public class MinDepth {
    public int run(TreeNode root){
        return traverse(root, 0);
    }
    public int traverse(TreeNode node, int depth){
        if(node == null) return depth + 1;
        if(node.left!=null && node.right != null){
            return Math.min(traverse(node.left, depth+1), traverse(node.right, depth+1));
        } else if(node.left == null){
            return traverse(node.right, depth + 1);
        } else if(node.right == null){
            return traverse(node.left, depth + 1);
        } else {
            return depth + 1;
        }
    }

    public static void main(String[] args) {
    }
}

