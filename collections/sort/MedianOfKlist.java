package collections.sort;

import java.util.*;

/**
 * Created by cshuo on 2017/8/21
 */

public class MedianOfKlist {
    static class Node {
        int idx1, idx2, val;
        public Node(int idx1, int idx2, int val) {
            this.val = val; this.idx2 = idx2; this.idx1 = idx1;
        }
    }

    /**
     * 思路：取出每个数组的首个元素，构建一个优先级队列(最小堆), 构建完成后，
     * 从队列中取元素，每取出一个元素将其后的元素压入队列，直到取出第n/2个.
     * 复杂度：O(k) + O(nlgK) 即 O(nlgk).
     */
    public static int median(List<List<Integer>> lists)  {
        int count = 0, length = 0, rs = 0;
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for(int i=0; i<lists.size(); i++) {
            q.add(new Node(i, 0 , lists.get(i).get(0)));
            length += lists.get(i).size();
        }
        Node tmp = null;
        while(count++ <= length/2) {
            tmp = q.poll();
            if(tmp.idx2 < lists.get(tmp.idx1).size()-1)  // not the last element in the sublist.
                q.add(new Node(tmp.idx1, tmp.idx2+1, lists.get(tmp.idx1).get(tmp.idx2+1)));
        }
        return tmp == null ? -1 : tmp.val;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1,4));
        lists.add(Arrays.asList(2,5,8,11));
        lists.add(Arrays.asList(3,6,9,12,13));
        System.out.println(median(lists));
    }
}
