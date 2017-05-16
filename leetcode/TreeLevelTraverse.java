package leetcode;


import java.util.ArrayDeque;
import java.util.Queue;


/**
 * author: cshuo
 * date: 2017/4/24
 * version: 1.0
 * description:
 */
public class TreeLevelTraverse {
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
        t3.right = t6;
        t5.left = t8;
        t5.right = t9;

        levelTraverse(t9);
        levelTraverse2(t1);
    }


    /**
     * @param root
     * 使用两个队列打印
     */
    public static void levelTraverse(TreeNode root){
        Queue<TreeNode> tmp, q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();
        q1.add(root);
        TreeNode pt;
        while(!q1.isEmpty()){
            while(!q1.isEmpty()){
                pt = q1.poll();
                System.out.print(pt.val);
                if(!q1.isEmpty()) System.out.print(" ");
                if(pt.left != null) q2.add(pt.left);
                if(pt.right != null) q2.add(pt.right);
            }
            System.out.println();
            tmp = q1; q1 = q2; q2 = tmp;  //交换q1, q2
        }
    }


    /**
     * @param root
     * 使用一个队列打印, 使用一个特殊的标记节点
     */
    public static void levelTraverse2(TreeNode root){
        Queue<TreeNode> q1 = new ArrayDeque<>();
        TreeNode nullNode = new TreeNode(Integer.MAX_VALUE);
        q1.add(root);
        q1.add(nullNode);
        TreeNode pt;
        while(!q1.isEmpty()){
            while((pt = q1.poll()) != nullNode){
                System.out.print(pt.val);
                if(q1.peek() != nullNode) System.out.print(" ");
                if(pt.left != null) q1.add(pt.left);
                if(pt.right != null) q1.add(pt.right);
            }
            System.out.println();
            if(!q1.isEmpty()) q1.add(nullNode);
        }
    }

}
