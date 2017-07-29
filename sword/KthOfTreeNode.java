package sword;

/**
 * Created by cshuo on 2017/7/24
 */
public class KthOfTreeNode {
    private int counter;
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if(node != null) return node;
            if(++counter == k) return pRoot;
            node = KthNode(pRoot.right, k);
            if(node != null) return node;
        }
        return null;
    }
}
