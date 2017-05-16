package sword;

import java.util.HashMap;

/**
 * author: cshuo
 * date: 2017/5/6
 * version: 1.0
 * description:
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class CopyLinkNodes {
    public static void main(String[] args) {
    }

    public RandomListNode Clone(RandomListNode pHead){
        RandomListNode nHead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode p = pHead;
        if(p == null) return null;

        nHead = new RandomListNode(p.label);
        map.put(p, nHead);
        RandomListNode n = nHead;
        while(p.next != null){
            RandomListNode node = new RandomListNode(p.next.label);
            map.put(p.next, node);
            n.next = node;
            n = node;
            p = p.next;
        }
        n = nHead;
        p = pHead;
        while(n!=null){
            n.random = map.get(p.random);
            n = n.next;
            p = p.next;
        }
        return nHead;
    }
}
