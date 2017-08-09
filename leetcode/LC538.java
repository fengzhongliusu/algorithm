package leetcode;

/**
 * Created by cshuo on 2017/8/9
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to
 * the original key plus sum of all keys greater than the original key in BST.

 Example:

 Input: The root of a Binary Search Tree like this:
   5
 /   \
 2     13

 Output: The root of a Greater Tree like this:
   18
 /   \
 20     13
 */
public class LC538 {
    int sum = 0;

    /**
     * bst的中序遍历是有序数组，利用中序遍历的逆过程来从大到小遍历节点，并用sum记录前缀和，累加到各个节点上即可。
     */
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
    public void traverse(TreeNode root) {
        if(root == null) return;
        traverse(root.right);
        root.val += sum;
        sum = root.val;
        traverse(root.left);
    }
}
