/**
* interval tree, 插入过程中检查是否有重叠, 最终得到的是节点区间中无重叠的 interval tree.
*/
class MyCalendar729 {
    
    class Node {
        int start;
        int end;
        Node left;
        Node right;
        public Node (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    Node root;

    public MyCalendar729() {
    }
    
    public boolean book(int start, int end) {
        if (root == null) {
            root = new Node(start, end);
            return true;
        }
        return insert(root, start, end);
    }

    public boolean insert(Node node, int start, int end) {
        if (!(start >= node.end || end <= node.start)) {
            return false;
        }
        if (node.start >= end) {
            if (node.left == null) {
                node.left = new Node(start, end);
                return true;
            } else {
                return insert(node.left, start, end);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(start, end);
                return true;
            } else {
                return insert(node.right, start, end);
            }
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
