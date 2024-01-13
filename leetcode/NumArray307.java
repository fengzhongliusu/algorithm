// use segment tree to arrange range sum of an array.

class NumArray307 {
    static Node root;
    static class Node {
        int begin, end, sum;
        Node left, right;
        public Node(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
    public NumArray307(int[] nums) {
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

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
