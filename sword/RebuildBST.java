package sword;


import java.util.ArrayList;

/**
 * author: cshuo
 * date: 2017/5/1
 * version: 1.0
 * description: 根据二叉树的前序遍历和中序遍历重建二叉树.
 */
public class RebuildBST {
    public static void main(String[] args) {
        int [] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = rebuildBST(pre, in);
        printT(root);
    }

    public static TreeNode rebuildBST(int[] pre, int[] in){
        ArrayList<Integer> preL = new ArrayList<>();
        ArrayList<Integer> inL = new ArrayList<>();
        for(int p: pre) preL.add(p);
        for(int i: in) inL.add(i);
        return recurBuild(preL, inL);
    }

    public static TreeNode recurBuild(ArrayList<Integer> pre, ArrayList<Integer> in){
        if(pre.size() < 1) return null;
        TreeNode root = new TreeNode(pre.get(0));
        int rootIndex = in.indexOf(pre.get(0));
        ArrayList<Integer> lc_in= new ArrayList<>(in.subList(0, rootIndex));
        ArrayList<Integer> rc_in= new ArrayList<>(in.subList(rootIndex+1, in.size()));
        ArrayList<Integer> lc_pre = new ArrayList<>(pre.subList(1, 1+lc_in.size()));
        ArrayList<Integer> rc_pre = new ArrayList<>(pre.subList(1+lc_in.size(), pre.size()));
        root.left = recurBuild(lc_pre, lc_in);
        root.right = recurBuild(rc_pre, rc_in);
        return root;
    }

    public static void printT(TreeNode root){
        if(root != null){
            printT(root.left);
            System.out.println(root.val);
            printT(root.right);
        }
    }
}
