package sword;

/**
 * Created by cshuo on 2017/7/24
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
import java.util.*;

public class ZhiPrintTree {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> rs = new ArrayList<>();
        if(pRoot == null) return rs;
        int levelSum, h=0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(pRoot);

        while(!q.isEmpty()) {
            levelSum = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i=0; i<levelSum; i++) {
                TreeNode ptr = q.poll();
                if((h&1) == 0) level.add(ptr.val);
                else level.add(0, ptr.val);
                if(ptr.left != null) q.offer(ptr.left);
                if(ptr.right != null) q.offer(ptr.right);
            }
            rs.add(level);
            h++;
        }
        return rs;
    }
}
