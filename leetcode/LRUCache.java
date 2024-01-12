class LRUCache {
    private final int capacity;
    private final Node pHead, pTail;
    private Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        pHead = new Node(-1, -1);
        pTail = new Node(-1, -1);
        pHead.next = pTail;
        pTail.prev = pHead;
    }

    public int get(int key) {
        Node ptr = map.get(key);
        if (ptr == null) {
            return -1;
        }
        Node curPrev = ptr.prev;
        Node curNext = ptr.next;

        // update ptr prev/next
        curPrev.next = curNext;
        curNext.prev = curPrev;

        // put ptr as head;
        putAhead(ptr);
        return ptr.val;
    }
    
    private void putAhead(Node node) {
        Node curHead = pHead.next;
        pHead.next = node ;
        node.prev = pHead;
        node.next = curHead;
        curHead.prev = node;
    }

    public void put(int key, int value) {
        int val = get(key);
        if (val != -1) {
            map.get(key).val = value;
            return;
        }
        // full, remove last
        if (map.size() == capacity) {
            // remove last
            Node tail = pTail.prev;
            Node tailPrev = tail.prev;
            tailPrev.next = pTail;
            pTail.prev = tailPrev;
            map.remove(tail.key);
        }
        // add in head
        Node newNode = new Node(key, value);
        putAhead(newNode);
        map.put(key, newNode);
    }

    private static class Node {
        Node prev;
        Node next;
        int key;
        int val;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
