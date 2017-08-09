package leetcode;

/**
 * Created by cshuo on 2017/8/9
 * 找树的最小深度.
 */
public class LC111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        return (l==0 || r==0)?l+r+1:Math.min(l,r)+1;
    }
}
