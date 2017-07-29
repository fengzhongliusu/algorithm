package leetcode;

/**
 * Created by cshuo on 2017/7/25
 *
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

 The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

 Example 1:
 Input: Binary tree: [1,2,3,4]
    1
  /  \
 2   3
 /
 4

 Output: "1(2(4))(3)"

 Explanation: Originallay it needs to be "1(2(4)())(3()())",
 but you need to omit all the unnecessary empty parenthesis pairs.
 And it will be "1(2(4))(3)".

 */
public class LC606 {
    private StringBuilder rs = new StringBuilder();

    public String tree2str(TreeNode t) {
        traverse(t);
        return rs.toString();
    }

    public void traverse(TreeNode t) {
        if(t != null) {
            rs.append(t.val);
            if(t.left != null) {
                rs.append('(');
                traverse(t.left);
                rs.append(')');
            }
            if(t.right != null) {
                if(t.left == null) rs.append("()");
                rs.append('(');
                traverse(t.right);
                rs.append(')');
            }
        }
    }
}
