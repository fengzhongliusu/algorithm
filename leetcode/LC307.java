package leetcode;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 The update(i, val) function modifies nums by updating the element at index i to val.

 Example:
 Given nums = [1, 3, 5]
 sumRange(0, 2) -> 9
 update(1, 2)
 sumRange(0, 2) -> 8

 Note:
 The array is only modifiable by the update function.
 You may assume the number of calls to update and sumRange function is distributed evenly.

 思路: 线段树, 完全二叉树, 每次update一层最多更新一个节点，复杂度O(lgn), 查询也是从根节点沿着一条路径走到叶节点
 复杂度也是O(lgn);
 */

public class LC307 {

    static Node root;

    static class Node {
        int begin, end, sum;
        Node left, right;
        public Node(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }

    public LC307(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }

    public static void update(int i, int val) {
        update(root, i, val);
    }

    public static int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    public static void update(Node root, int i, int val) {
        if(root.begin == root.end) root.sum = val;
        else {
            int mid = root.begin + (root.end-root.begin)/2;
            if(i <= mid) update(root.left, i, val);
            else update(root.right, i, val);
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public static int sumRange(Node root, int l, int r) {
        if(root.end == r && root.begin == l) return root.sum;
        else {
            int mid = root.begin + (root.end-root.begin)/2;
            if(r <= mid) return sumRange(root.left, l, r);
            else if(l >= mid+1) return sumRange(root.right, l, r);
            else return sumRange(root.left, l, mid) + sumRange(root.right, mid+1, r);
        }
    }

    public static Node buildTree(int[] nums, int l, int r) {
        if(l > r) return null;
        else {
            Node node = new Node(l, r);
            if(l == r) node.sum = nums[l];
            else {
                int mid = l + (r-l)/2;
                node.left = buildTree(nums, l, mid);
                node.right = buildTree(nums, mid+1, r);
                node.sum = node.left.sum + node.right.sum;
            }
            return node;
        }
    }
}
