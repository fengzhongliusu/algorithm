package collections.tree;

import java.util.ArrayList;

/**
 * author: cshuo
 * date: 2017/5/17
 * version: 1.0
 * description:
 */
public class DeleletNode {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);

        t4.left = t2;
        t4.right = t5;
        t2.left = t1;
        t2.right = t3;
        t5.right = t6;

        t4 = deleteNode(2, t4);
        ArrayList<Integer> l = new ArrayList<>();
        PreOrder.preTrav(l, t4);
        System.out.println(l);
    }


    /**
     * 删除二叉查找树的一个节点
     * 三种情况: 左右子树不空, 一个为空, 叶子节点
     * @param val
     * @param node
     * @return
     */
    public static TreeNode deleteNode(int val, TreeNode node){
        if(node == null) return node;
        if(val > node.val)
            node.right = deleteNode(val, node.right);
        else if(val < node.val)
            node.left = deleteNode(val, node.left);
        // 左右子树都不空
        else if(node.left != null && node.right != null){
            node.val = findMin(node.right).val;
            node.right = deleteNode(node.val, node.right);
        }
        // 子树全空, 或有一个为空
        else {
            node = node.left != null?node.left:node.right;
        }
        return node;
    }

    /**
     * 找到最小的节点
     * @param node
     * @return
     */
    public static TreeNode findMin(TreeNode node){
        if(node == null) return null;
        if(node.left == null) return node;
        return findMin(node.left);
    }
}
