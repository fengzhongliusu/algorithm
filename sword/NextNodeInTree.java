package sword;

/**
 * Created by cshuo on 2017/8/14
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class NextNodeInTree {

    /**
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     * 思路：分成三种情况:
     * 1) 该节点有右子树，那么返回右子树的最左下的节点;
     * 2) 该节点是父节点的左孩子，直接返回父节点;
     * 3) 一直向上寻找节点，直到该节点是其父节点的左孩子.
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null) return null;
        if(pNode.right != null) {
            TreeLinkNode tmp = pNode.right;
            while(tmp.left != null) tmp = tmp.left;
            return tmp;
        }
        while(pNode.next != null) {
            if(pNode.next.left == pNode) return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }
}
