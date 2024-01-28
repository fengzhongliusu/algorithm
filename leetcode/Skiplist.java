public class Skiplist {
    static class Node {
        int val;
        Node next;
        Node down;
        public Node(int val) {
            this.val = val;
        }
    }

    Node sHead = new Node(-1);

    public Skiplist() {
    }

    public boolean search(int target) {
        return doSearch(target) != null;
    }

    public void add(int num) {
        if (sHead == null) {
            sHead = new Node(-1);
        }
        Node node = add(sHead, num);
        if (node == null) {
            return;
        }
        // add new level
        Node newShead = new Node(-1);
        Node insertNode = new Node(num);
        insertNode.down = node;
        newShead.next = insertNode;
        newShead.down = sHead;
        sHead = newShead;
    }

    public Node add(Node node, int num) {
        while (node.next != null && node.next.val < num) {
            node = node.next;
        }

        Node newNode = new Node(num);
        if (node.down != null) {
            Node bottomNode = add(node.down, num);
            if (bottomNode == null) {
                return null;
            }
            newNode.down = bottomNode;
        }
        newNode.next = node.next;
        node.next = newNode;
        if (Math.random() < 0.5) {
            return newNode;
        }
        return null;
    }

    public boolean erase(int target) {
        // prev Node of the target.
        Node node = doSearch(target);
        if (node == null) {
            return false;
        }
        while (node != null) {
            Node cur = node;
            while (cur.next.val != target) {
                cur = cur.next;
            }
            // remove the target node.
            cur.next = cur.next.next;
            // remove sentinel if necessary
            if (cur.val == -1 && cur.next == null) {
                sHead = cur.down;
            }
            node = node.down;
        }
        return true;
    }

    public Node doSearch(int target) {
        Node curNode = sHead;
        Node prev = null;
        while (curNode != null) {
            if (curNode.val == target) {
                return prev;
            } else if (curNode.val < target) {
                prev = curNode;
                curNode = curNode.next;
                // end of level
                if (curNode == null && prev.down != null) {
                    curNode = prev.down;
                }
            } else if (prev != null) {
                curNode = prev.down;
            } else {
                return null;
            }
        }
        return null;
    }
}
