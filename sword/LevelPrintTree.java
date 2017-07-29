package sword;

/**
 * Created by cshuo on 2017/7/24
 * 层次打印二叉树.
 */
import java.util.*;

public class LevelPrintTree {
    /**
     * 遍历当前层之前，可以获知当前层节点个数sum，把队列中前sum个节点取出，即当前层的所有节点；
     */
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> rs = new ArrayList<>();
        if(pRoot == null) return rs;
        int levelSum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(pRoot);

        while(!q.isEmpty()) {
            levelSum = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i=0; i<levelSum; i++) {
                TreeNode ptr = q.poll();
                level.add(ptr.val);
                if(ptr.left != null) q.offer(ptr.left);
                if(ptr.right != null) q.offer(ptr.right);
            }
            rs.add(level);
        }
        return rs;
    }
}
