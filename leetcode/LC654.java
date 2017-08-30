package leetcode;

/**
 * Maximum Binary Tree
 * iven an integer array with no duplicates. A maximum tree building on this array is defined as follow:

 The root is the maximum number in the array.
 The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 Construct the maximum tree by the given array and output the root node of this tree.

 Example 1:
 Input: [3,2,1,6,0,5]
 Output: return the tree root node representing the following tree:

   6
 /   \
 3   5
 \  /
 2 0
 \
 1

 */
public class LC654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length < 1) return null;
        return buildTree(nums, 0, nums.length-1);
    }

    public TreeNode buildTree(int[] nums, int l, int r) {
        if(l == r) return new TreeNode(nums[l]);
        if(l > r) return null;
        int maxIdx = l;
        for(int i=l; i<=r; i++)
            if(nums[i] > nums[maxIdx]) maxIdx = i;
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = buildTree(nums, l, maxIdx-1);
        root.right = buildTree(nums, maxIdx+1, r);
        return root;
    }
}
