package leetcode;
import java.util.*;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 Note:
 You may assume that duplicates do not exist in the tree.

 思路：递归解法，优化：使用map记录迭代中根节点对应的下表位置，避免loop查找.
 */
public class LC105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length < 1) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) map.put(inorder[i], i);
        return recursive(preorder, map, 0, 0, inorder.length-1);
    }

    /**
     * @param preL 根节点的index.
     * @param inL 子树开始下表
     * @param inR 子树结束下表
     */
    public TreeNode recursive(int[] pre, Map<Integer, Integer> map, int preL, int inL, int inR) {
        if(inL > inR) return null;
        TreeNode root = new TreeNode(pre[preL]);
        root.left = recursive(pre, map, preL+1, inL, map.get(pre[preL])-1);
        // 左子树的长度.
        int lLen = map.get(pre[preL]) - inL + 1;
        root.right = recursive(pre, map, preL + lLen, map.get(pre[preL])+1, inR);
        return root;
    }

    /**
     * 非递归写法 (直接从递归解法获得...)
     */
    public TreeNode buildBT(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length < 1) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) map.put(inorder[i], i);

        // 存储递归解法中的context;
        Stack<Integer> st = new Stack<>();
        Stack<TreeNode> node = new Stack<>();

        // 初始化.
        st.push(inorder.length-1); st.push(0); st.push(0);
        TreeNode root = new TreeNode(preorder[0]);
        node.push(root);

        int preL, inL, inR;
        while(!st.isEmpty()) {
            int newpL, newinL, newinR;
            TreeNode tmp = node.pop();
            preL = st.pop();
            inL = st.pop();
            inR = st.pop();
            // 计算左子树的context;
            newpL = preL + 1; newinL = inL; newinR = map.get(preorder[preL]) - 1;
            if(inL <= inR) {
                TreeNode left = new TreeNode(preorder[newpL]);
                tmp.left = left;
                node.push(left);
                st.push(newinR); st.push(newinL); st.push(newpL);
            }
            // 计算右子树的context;
            newpL = preL + map.get(preorder[preL])-inL+1; newinL = map.get(preorder[preL])+1; newinR = inR;
            if(inL <= inR) {
                TreeNode right= new TreeNode(preorder[newpL]);
                tmp.right= right;
                node.push(right);
                st.push(newinR); st.push(newinL); st.push(newpL);
            }
        }
        return root;
    }
}
