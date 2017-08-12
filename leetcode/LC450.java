package leetcode;

/**
 * Created by cshuo on 2017/8/11
 * 删除BST中的一个节点.
 * 要点：匹配到对应节点时要处理的情况如下：
 * 1) l和r都是null, 返回null
 * 2) l或r是null, 返回l或r.
 * 3) l和r都不为null, 处理情况可分为两种，I:使用左子树的最大节点替代目标节点，II:使用右子树的最小节点来替代目标节点.
 */
public class LC450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val > key) root.left = deleteNode(root.left, key);
        else if(root.val < key) root.right = deleteNode(root.right, key);
        else {
            if(root.left == null) root = root.right;
            else if(root.right == null) root = root.left;
            else {
                TreeNode maxNode = findMax(root.left);
                root.val = maxNode.val;
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    public TreeNode findMax(TreeNode root) {
        while(root.right != null) root = root.right;
        return root;
    }
}
