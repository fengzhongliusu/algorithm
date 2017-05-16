package sword;

import java.util.ArrayList;

/**
 * author: cshuo
 * date: 2017/5/6
 * version: 1.0
 * description: 从根节点到叶节点路径和为指定和的所有路径
 * 回溯:
 */
public class findSumPath {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(12);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        System.out.println(findPath(t1, 22));
    }

    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target){
        ArrayList<ArrayList<Integer>> rs = new ArrayList<>();
        addPath(root, rs, new ArrayList<Integer>(), 0, target, 1);
        return rs;
    }

    public static void addPath(TreeNode node, ArrayList<ArrayList<Integer>> rs, ArrayList<Integer> list, int sum, int target, int l){
        if(node == null){
            // l == 1是为了避免叶子节点的左右子节点都执行该语句,导致结果重复.
            if(sum == target && l==1) rs.add(new ArrayList<>(list));
            return;
        }
        // 回溯过程.
        list.add(node.val);
        addPath(node.left, rs, list, sum+node.val, target, 1);
        addPath(node.right, rs, list, sum+node.val, target, 0);
        list.remove(list.size()-1);
    }
}
