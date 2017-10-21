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

    /**
     * @param pHead
     * @return
     * 使用hashMap记录对应关系.
     */
    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode nHead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode p = pHead;
        if (p == null) return null;

        nHead = new RandomListNode(p.label);
        map.put(p, nHead);
        RandomListNode n = nHead;
        while (p.next != null) {
            RandomListNode node = new RandomListNode(p.next.label);
            map.put(p.next, node);
            n.next = node;
            n = node;
            p = p.next;
        }
        n = nHead;
        p = pHead;
        while (n != null) {
            n.random = map.get(p.random);
            n = n.next;
            p = p.next;
        }
        return nHead;
    }


    /**
     * @param pHead
     * @return
     * 复制和拆分操作.
     */
    public RandomListNode clone1(RandomListNode pHead) {
        if (pHead == null)
            return null;
        RandomListNode pCur = pHead;
        //复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
        while (pCur != null) {
            RandomListNode node = new RandomListNode(pCur.label);
            node.next = pCur.next;
            pCur.next = node;
            pCur = node.next;
        }
        pCur = pHead;
        //复制random pCur是原来链表的结点 pCur.next是复制pCur的结点
        while (pCur != null) {
            if (pCur.random != null)
                pCur.next.random = pCur.random.next;
            pCur = pCur.next.next;
        }
        RandomListNode head = pHead.next;
        RandomListNode cur = head;
        pCur = pHead;
        //拆分链表
        while (pCur != null) {
            pCur.next = pCur.next.next;
            if (cur.next != null)
                cur.next = cur.next.next;
            cur = cur.next;
            pCur = pCur.next;
        }
        return head;
    }

}
