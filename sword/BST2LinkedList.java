package sword;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/7/6
 * version: 1.0
 * description: 将二叉搜索树转换成双向链表(除了头结点与为节点, 其他节点都有两个指针指向前一个节点与后一个节点);
 */
public class BST2LinkedList {

    private static TreeNode lastNode = null;

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t5.left = t4;
        t4.left = t3;
        t3.left = t2;
        t2.left = t1;

        TreeNode h = convert(t5);
        while(h != null){
            System.out.println(h.val);
            h = h.right;
        }
        HashMap<Integer, Integer> nums = new HashMap<>();
        Iterator itr = nums.entrySet().iterator();
    }

    /**
     * 中序遍历存入数组, 遍历数组整理指针指向;
     */
    public static TreeNode Convert(TreeNode pRootOfTree) {
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        getMidTraverse(nodes, pRootOfTree);
        if(nodes.size() < 1) return pRootOfTree;

        for(int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).right = nodes.get(i+1);
            nodes.get(i+1).left = nodes.get(i);
        }
        return nodes.get(0);
    }

    public static void getMidTraverse(List<TreeNode> result, TreeNode root){
        if(root == null) return;
        getMidTraverse(result, root.left);
        result.add(root);
        getMidTraverse(result, root.right);
    }


    /**
     * 递归解法, 中序遍历改造; 全局指针指向已排序链表最后一个节点
     * 左子树处理完毕, 遍历到root节点, 做如下处理: root->left = last; last->right = root; last = root; 再递归处理右子树;
     */
    public static TreeNode convert(TreeNode root){
        convertTreeNode(root);
        while(lastNode.left != null) lastNode = lastNode.left;
        return lastNode;
    }

    public static void convertTreeNode(TreeNode root){
        if(root == null) return;
        convertTreeNode(root.left);
        root.left = lastNode;
        if(lastNode != null)
            lastNode.right = root;
        lastNode = root;
        convertTreeNode(root.right);
    }

}
