package exer;

import java.util.*;

/**
 * Created by cshuo on 2021/8/28
 */
public class NumFromNList {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1,2,3));
        list.add(Arrays.asList(4,6));
        list.add(Arrays.asList(8,9));
        List<List<Integer>> rs = permu(list);
        System.out.println(rs.size());
        System.out.println(rs);
    }

    public static List<List<Integer>> permu(List<List<Integer>> nums) {
        List<List<Integer>> q = new LinkedList<>();
        for (List<Integer> l: nums) {
            if (q.isEmpty()) {
                for (Integer e: l) {
                    q.add(Arrays.asList(e));
                }
                continue;
            }
            int curSize = q.size();
            while (curSize-- > 0) {
                List<Integer> top = ((LinkedList<List<Integer>>) q).pop();
                for (Integer e : l) {
                    List<Integer> newList = new ArrayList<>(top);
                    newList.add(e);
                    q.add(newList);
                }
            }
        }
        return q;
    }
}
