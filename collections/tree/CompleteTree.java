package collections.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * author: cshuo
 * date: 2017/4/24
 * version: 1.0
 * description: 判断一棵树是不是完全二叉树: 用队列对二叉树广度遍历, 一个结点子结点为空的话,放入一个特殊标记结点,
 * 然后看队列中该特殊结点, 后面是不是还有正常结点, 有的话非完全二叉树, 否则是完全二叉树.
 */
public class CompleteTree {

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

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left= t6;
        t3.right= t8;

        t4.right= t9;

        System.out.println(judgeComplete(t1));
    }

    public static boolean judgeComplete(TreeNode root){
        if(root == null) return false;
        TreeNode nullNode = new TreeNode(Integer.MAX_VALUE), pt;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while((pt = q.poll()) != nullNode){
            if(pt.left == null) q.offer(nullNode);
            else q.offer(pt.left);
            if(pt.right == null) q.offer(nullNode);
            else q.offer(pt.right);
        }

        while(!q.isEmpty()){
            if((pt=q.poll()) != nullNode)
                return false;
        }
        return true;
    }
}
