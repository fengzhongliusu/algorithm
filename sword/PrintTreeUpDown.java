package sword;
import java.util.*;

/**
 * author: cshuo
 * date: 2017/5/6
 * version: 1.0
 * description:
 */
public class PrintTreeUpDown {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> rs = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root == null) return rs;
        q.add(root);
        TreeNode tmp;
        while(!q.isEmpty()){
            tmp = q.remove();
            rs.add(tmp.val);
            if(tmp.left != null) q.add(tmp.left);
            if(tmp.right != null) q.add(tmp.right);
        }
        return rs;
    }
}
